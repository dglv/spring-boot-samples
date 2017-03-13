package ru.dglv.business.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

import ru.dglv.business.model.Person;
import ru.dglv.business.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(final Person person)
    {
        final Person personFromDb = personRepository.save(person);
        LOGGER.info("Person {} saved successfully", personFromDb);

        return personFromDb;
    }

    @Override
    public Person savePerson(final String username, final String password, 
            final String email, final String name, final Integer age)
    {
        final Person person = new Person(username, password, email, name, age);

        return savePerson(person);
    }

    @Override
    public void deletePerson(final Person person)
    {
        personRepository.delete(person);
        LOGGER.info("Person {} removed successfully", person);
    }

    @Override
    public void deletePersonById(final Long id)
    {
        personRepository.delete(id);
        LOGGER.info("Person with id {} removed successfully", id);
    }

    @Override
    public void deleteAllPersons()
    {
        personRepository.deleteAll();
        LOGGER.info("All persons were removed successfully");
    }

    @Override
    public Person getPersonById(final Long id)
    {
        final Person personFromDb = personRepository.findOne(id);
        LOGGER.debug("Fetched Person {} by id {}", personFromDb, id);

        return personFromDb;
    }

    @Override
    public Person getPersonByUsername(final String username)
    {
        final Person personFromDb = personRepository.findByUsername(username);
        LOGGER.debug("Fetched Person {} by username {}", personFromDb, username);

        return personFromDb;
    }

    @Override
    public List<Person> getPersonsByName(final String name)
    {
        Iterable<Person> iterator = personRepository.findByName(name);
        List<Person> persons = ImmutableList.copyOf(iterator);

        if (LOGGER.isDebugEnabled())
        {
            LOGGER.debug("The following persons were fetched by name {}:", name);
            persons.forEach(person -> LOGGER.debug(person.toString()));
        }

        return persons;
    }

    @Override
    public List<Person> getAllPersons()
    {
        Iterable<Person> iterator = personRepository.findAll();
        List<Person> persons = ImmutableList.copyOf(iterator);

        if (LOGGER.isDebugEnabled())
        {
            LOGGER.debug("The following persons were fetched:");
            persons.forEach(person -> LOGGER.debug(person.toString()));
        }

        return persons;
    }
}