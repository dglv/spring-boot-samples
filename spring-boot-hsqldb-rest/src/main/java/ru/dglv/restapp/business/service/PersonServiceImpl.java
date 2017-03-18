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
    
    public Person createPerson(final String firstName, final String lastName, final Integer age)
    {
        final Long id = idGenerator.incrementAndGet();
        final Person person = new Person(id, firstName, lastName, age);
        
        tempCache.put(id, person);
        
        return person;
    }

    public Person updatePerson(final Long id, final String firstName, 
            final String lastName, final Integer age)
    {
        final Person person = tempCache.get(id);
        
        if (person != null)
        {
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setAge(age);
            
            tempCache.put(id, person);
        }
        
        return person;
    }

    public Person findPersonById(final Long id)
    {
        return tempCache.get(id);
    }

    public List<Person> findPersonByLastName(final String lastName)
    {
        final List<Person> persons = new ArrayList<Person>();
        
        if (lastName != null)
        {
            for (Entry<Long, Person> nextEntry : tempCache.entrySet())
            {
                final Person nextPerson = nextEntry.getValue();
                if (lastName.equals(nextPerson.getLastName()))
                {
                    persons.add(nextPerson);
                }
            }
        }
        
        return Collections.unmodifiableList(persons);
    }

    public void deletePersonById(final Long id)
    {
        tempCache.remove(id);
    }

}
