package ru.dglv.restapp.web;

import java.util.List;
import java.util.Optional;

import ru.dglv.restapp.business.model.Person;

public interface PersonController
{
    Status updatePerson(Person person);
    
    List<Person> getPersons(Optional<Long> id, Optional<String> lastName);
    
    Status deletePersons(Optional<Long> id);

}
