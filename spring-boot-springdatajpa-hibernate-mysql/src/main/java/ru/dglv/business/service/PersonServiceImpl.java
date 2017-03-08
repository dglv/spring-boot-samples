package ru.dglv.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.dglv.business.model.Person;
import ru.dglv.business.repository.PersonRepository;

public class PersonServiceImpl extends CrudServiceImpl<Person, Long> implements PersonService
{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonById(final Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Person getPersonByUsername(final String username)
    {
        // TODO 
        return null;
    }

    @Override
    public List<Person> getAllPersons()
    {
        // TODO 
        return null;
    }
}
