package ru.dglv.restapp.business.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import ru.dglv.restapp.business.model.Person;

@Service
public class PersonServiceImpl implements PersonService
{
    ConcurrentMap<Long, Person> tempCache;
    AtomicLong idGenerator;
    
    public PersonServiceImpl()
    {
        tempCache = new ConcurrentHashMap<Long, Person>();
        idGenerator = new AtomicLong();
    }

    @Override
    public Person updatePerson(final Person fromWeb)
    {
        Person person = null;
        
        if (fromWeb.getId() == null)
        {
            person = new Person();
            final Long id = idGenerator.incrementAndGet();
            person.setId(id);
        }
        else
        {
            final Person fromDb = tempCache.get(fromWeb.getId());
            
            if (fromDb == null)
            {
                throw new IllegalArgumentException("Person with id:" + fromWeb.getId() + " is NOT found");
            }
            
            person = fromDb;
        }

        person.setFirstName(fromWeb.getFirstName());
        person.setLastName(fromWeb.getLastName());
        person.setAge(fromWeb.getAge());

        tempCache.put(person.getId(), person);

        return person;
    }

    @Override
    public Person getPersonById(final Long id)
    {
        return tempCache.get(id);
    }

    @Override
    public List<Person> getPersonsByLastName(final String lastName)
    {
        final List<Person> persons = new ArrayList<Person>();
        
        if (lastName != null)
        {
            for (Entry<Long, Person> nextEntry : tempCache.entrySet())
            {
                final Person nextPerson = nextEntry.getValue();
                if (lastName.equalsIgnoreCase(nextPerson.getLastName()))
                {
                    persons.add(nextPerson);
                }
            }
        }
        
        return Collections.unmodifiableList(persons);
    }
    
    @Override
    public List<Person> getAllPersons()
    {
        final List<Person> persons = new ArrayList<Person>();

        for (Entry<Long, Person> nextEntry : tempCache.entrySet())
        {
            final Person nextPerson = nextEntry.getValue();

            persons.add(nextPerson);
        }

        return Collections.unmodifiableList(persons);
    }

    @Override
    public void deletePersonById(final Long id)
    {
        tempCache.remove(id);
    }
    
    @Override
    public void deleteAllPersons()
    {
        tempCache.clear();
    }
}
