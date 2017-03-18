package ru.dglv.restapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;

import ru.dglv.restapp.business.model.Person;

@Controller
public class PersonControllerImpl implements PersonController
{

    @Override
    public Status createPerson(final String firstName, final String lastName, final Integer age)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status updatePerson(final Long id, final String firstName, final String lastName, final Integer age)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Person getPerson(final Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<Person> getPersonsByLastName(final String lastName)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Person> getAllPersons()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status deletePerson(final Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status deleteAllPersons()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
