package ru.dglv.business.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ru.dglv.business.model.Person;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long>
{
    Iterable<Person> findByName(String name);
    Person findByUsername(String username);
}
