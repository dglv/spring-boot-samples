package ru.dglv.restapp.business.dao;

import java.util.List;

import ru.dglv.restapp.business.model.Person;

public interface PersonDAO
{
    Person create(Person fromWeb);
    
    Person update(Person fromWeb);
    
    Person findPersonById(Long id);
    
    List<Person> findPersonsByLastName(String lastName);
    
    List<Person> findAll();
    
    void removePersonById(Long id);
    
    void removeAllPersons();
}
