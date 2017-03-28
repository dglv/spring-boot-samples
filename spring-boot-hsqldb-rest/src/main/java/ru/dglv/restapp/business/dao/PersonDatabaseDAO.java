package ru.dglv.restapp.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.dglv.restapp.business.model.Person;

@Repository
public class PersonDatabaseDAO implements PersonDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    class PersonRowMapper implements RowMapper<Person>
    {
        @Override
        public Person mapRow(final ResultSet rs, final int rowNum) throws SQLException
        {
            final Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setFirstName(rs.getString("firstName"));
            person.setLastName(rs.getString("lastName"));
            person.setAge(rs.getInt("age"));
            
            return person;
        }
    }

}