package ru.dglv.restapp.business.service;

import java.util.List;

import ru.dglv.restapp.business.model.Person;

public interface PersonService
{
    Person updatePerson(Person fromWeb);
    
    Person getPersonById(Long id);
    
    List<Person> getPersonsByLastName(String lastName);
    
    List<Person> getAllPersons();
    
    void deletePersonById(Long id);
    
    void deleteAllPersons();
}
