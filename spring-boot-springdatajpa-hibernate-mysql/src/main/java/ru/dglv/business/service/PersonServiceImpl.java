package ru.dglv.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.ImmutableList;

import ru.dglv.business.model.Person;
import ru.dglv.business.repository.PersonRepository;

public class PersonServiceImpl implements PersonService
{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(final Person person)
    {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(final Person person)
    {
        personRepository.delete(person);
    }

    @Override
    public void deletePersonById(final Long id)
    {
        personRepository.delete(id);
    }

    @Override
    public void deleteAllPersons()
    {
        personRepository.deleteAll();
    }

    @Override
    public Person getPersonById(final Long id)
    {
        return personRepository.findOne(id);
    }

    @Override
    public Person getPersonByUsername(final String username)
    {
        return personRepository.findByUsername(username);
    }
    
    @Override
    public List<Person> getPersonsByName(final String name)
    {
        Iterable<Person> iterator = personRepository.findByName(name);
        
        return ImmutableList.copyOf(iterator);
    }

    @Override
    public List<Person> getAllPersons()
    {
        Iterable<Person> iterator = personRepository.findAll();
        
        return ImmutableList.copyOf(iterator);
    }
}