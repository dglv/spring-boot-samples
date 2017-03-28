package ru.dglv.restapp.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ru.dglv.restapp.business.model.Person;

@Repository()
public class PersonSimpleCacheDAO implements PersonDAO
{
    @Override
    public Person create(final Person person)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Person update(final Person person)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Person findPersonById(final Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Person> findPersonsByLastName(final String lastName)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Person> findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removePersonById(final Long id)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeAllPersons()
    {
        // TODO Auto-generated method stub

    }

}
