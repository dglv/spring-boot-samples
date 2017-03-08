package ru.dglv.business.service;

import java.util.List;

import ru.dglv.business.model.Person;

public interface PersonService
{
    Person savePerson(Person person);
    Person savePerson(String username, String password, String name, Integer age);
    void deletePerson(Person person);
    void deletePersonById(Long id);
    void deleteAllPersons();
    Person getPersonById(Long id);
    Person getPersonByUsername(String username);
    List<Person> getPersonsByName(String name);
    List<Person> getAllPersons();
}
