package ru.dglv.restapp.business.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ru.dglv.restapp.business.dao.PersonDAO;
import ru.dglv.restapp.business.model.Person;

@Service
public class PersonServiceImpl implements PersonService
{
    @Autowired
    //@Qualifier(value = "inMemoryPersonDAO")
    @Qualifier(value = "databasePersonDAO")
    private PersonDAO personDAO;

    @Override
    public Person updatePerson(final Person fromWeb)
    {
        Validate.notNull(fromWeb, "Person must not be null");
        
        final Person person = fromWeb.getId() == null ? 
                personDAO.create(fromWeb) :  personDAO.update(fromWeb);
        
        return person;
    }

    @Override
    public Person getPersonById(final Long id)
    {
        Validate.notNull(id, "ID must not be null");

        return personDAO.findPersonById(id);
    }

    @Override
    public List<Person> getPersonsByLastName(final String lastName)
    {
        Validate.notNull(lastName, "Last name must not be null");
        
        final List<Person> persons = personDAO.findPersonsByLastName(lastName);

        return Collections.unmodifiableList(persons);
    }
    
    @Override
    public List<Person> getAllPersons()
    {
        final List<Person> persons = personDAO.findAll(); 

        return Collections.unmodifiableList(persons);
    }

    @Override
    public void deletePersonById(final Long id)
    {
        Validate.notNull(id, "ID must not be null");
        
        personDAO.removePersonById(id);
    }
    
    @Override
    public void deleteAllPersons()
    {
        personDAO.removeAllPersons();
    }
}
