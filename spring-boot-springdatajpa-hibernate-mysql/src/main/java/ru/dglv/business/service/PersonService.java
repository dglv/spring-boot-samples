package ru.dglv.business.service;

import java.util.List;

import ru.dglv.business.model.Person;

public interface PersonService extends CrudService<Person, Long>
{
    Person getPersonById(Long id);
    Person getPersonByUsername(String username);
    List<Person> getAllPersons();
}
