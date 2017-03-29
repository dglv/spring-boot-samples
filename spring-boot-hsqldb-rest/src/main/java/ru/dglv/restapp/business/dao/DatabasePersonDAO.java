package ru.dglv.restapp.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.dglv.restapp.business.model.Person;

@Repository
public class DatabasePersonDAO implements PersonDAO
{
    private final static String CREATE_SQL = "insert into persons(firstName , lastName, age) values(?, ?, ?)";
    private final static String UPDATE_SQL = "update persons set firstName=?, lastName=?, age=? where id=?";
    private final static String FIND_ALL_SQL = "select * from persons";
    private final static String FIND_BY_ID_SQL = "select * from persons where id=?";
    private final static String FIND_BY_LASTNAME_SQL = "select * from persons where lastName=?";
    private final static String DELETE_BY_ID_SQL = "delete from persons where id=?";
    private final static String DELETE_ALL_SQL = "delete from persons";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Person create(final Person fromWeb)
    {
        final KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, fromWeb.getFirstName());
                ps.setString(2, fromWeb.getLastName());
                ps.setInt(3, fromWeb.getAge());
                return ps;
            }
        }, holder);

        final Person person = fromWeb;
        
        final Long id = holder.getKey().longValue();
        person.setId(id);
        
        return person;
    }

    @Override
    @Transactional
    public Person update(final Person fromWeb)
    {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
                ps.setString(1, fromWeb.getFirstName());
                ps.setString(2, fromWeb.getLastName());
                ps.setInt(3, fromWeb.getAge());
                ps.setLong(4, fromWeb.getId());
                return ps;
            }
        });

        final Person person = fromWeb;
        
        return person;
    }

    @Override
    @Transactional(readOnly=true)
    public Person findPersonById(final Long id)
    {
        final List<Person> result = jdbcTemplate.query(FIND_BY_ID_SQL, new Object[]{id}, new PersonRowMapper());
        
        if (result.isEmpty())
        {
            return null;
        }
        
        return result.get(0);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Person> findPersonsByLastName(final String lastName)
    {
        return jdbcTemplate.query(FIND_BY_LASTNAME_SQL, new Object[]{lastName}, new PersonRowMapper());
    }

    @Override
    @Transactional(readOnly=true)
    public List<Person> findAll()
    {
        return jdbcTemplate.query(FIND_ALL_SQL, new PersonRowMapper());
    }

    @Override
    @Transactional
    public void removePersonById(final Long id)
    {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID_SQL);
                ps.setLong(1, id);
                return ps;
            }
        });
    }

    @Override
    @Transactional
    public void removeAllPersons()
    {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement(DELETE_ALL_SQL);
                return ps;
            }
        });
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