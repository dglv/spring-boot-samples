package ru.dglv.restapp.web;

import java.util.List;

import ru.dglv.restapp.business.model.Person;

public interface PersonController
{
    Status createPerson(String firstName, String lastName, Integer age);
    
    Status updatePerson(Long id, String firstName, String lastName, Integer age);
    
    Person getPerson(Long id);
    
    List<Person> getPersonsByLastName(String lastName);
    
    List<Person> getAllPersons();
    
    Status deletePerson(Long id);
    
    Status deleteAllPersons();

}
