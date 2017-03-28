package ru.dglv.restapp.business.dao;

import java.util.List;

import ru.dglv.restapp.business.model.Person;

public interface PersonDAO
{
    Person create(Person person);
    
    Person update(Person person);
    
    Person findPersonById(Long id);
    
    List<Person> findPersonsByLastName(String lastName);
    
    List<Person> findAll();
    
    void removePersonById(Long id);
    
    void removeAllPersons();
}
