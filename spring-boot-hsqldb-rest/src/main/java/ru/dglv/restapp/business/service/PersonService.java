package ru.dglv.restapp.business.service;

import java.util.List;

import ru.dglv.restapp.business.model.Person;

public interface PersonService
{
    Person createPerson(String firstName, String lastName, Integer age);
    
    Person updatePerson(Long id, String firstName, String lastName, Integer age);
    
    Person findPersonById(Long id);
    
    List<Person> findPersonByLastName(String lastName);
    
    void deletePersonById(Long id);
}
