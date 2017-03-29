package ru.dglv.restapp.business.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import ru.dglv.restapp.business.model.Person;

@Repository
public class InMemoryPersonDAO implements PersonDAO
{
    ConcurrentMap<Long, Person> tempCache;
    AtomicLong idGenerator;
    
    public InMemoryPersonDAO()
    {
        tempCache = new ConcurrentHashMap<Long, Person>();
        idGenerator = new AtomicLong();
    }
    
    @Override
    public Person create(final Person fromWeb)
    {
        final Person person = new Person();
        final Long id = idGenerator.incrementAndGet();
        
        person.setId(id);
        person.setFirstName(fromWeb.getFirstName());
        person.setLastName(fromWeb.getLastName());
        person.setAge(fromWeb.getAge());

        tempCache.put(person.getId(), person);
        
        return person;
    }

    @Override
    public Person update(final Person fromWeb)
    {
        final Person person = tempCache.get(fromWeb.getId());
        
        if (person == null)
        {
            throw new IllegalArgumentException("Person with id:" + fromWeb.getId() + " is NOT found");
        }

        person.setFirstName(fromWeb.getFirstName());
        person.setLastName(fromWeb.getLastName());
        person.setAge(fromWeb.getAge());

        tempCache.put(person.getId(), person);
        
        return person;
    }

    @Override
    public Person findPersonById(final Long id)
    {
        return tempCache.get(id);
    }

    @Override
    public List<Person> findPersonsByLastName(final String lastName)
    {
        final List<Person> persons = new ArrayList<Person>();

        for (Entry<Long, Person> nextEntry : tempCache.entrySet())
        {
            final Person nextPerson = nextEntry.getValue();
            if (lastName.equalsIgnoreCase(nextPerson.getLastName()))
            {
                persons.add(nextPerson);
            }
        }
        
        return persons;
    }

    @Override
    public List<Person> findAll()
    {
        final List<Person> persons = new ArrayList<Person>();

        for (Entry<Long, Person> nextEntry : tempCache.entrySet())
        {
            final Person nextPerson = nextEntry.getValue();

            persons.add(nextPerson);
        }
        
        return persons;
    }

    @Override
    public void removePersonById(final Long id)
    {
        tempCache.remove(id);
    }

    @Override
    public void removeAllPersons()
    {
        tempCache.clear();
    }
}
