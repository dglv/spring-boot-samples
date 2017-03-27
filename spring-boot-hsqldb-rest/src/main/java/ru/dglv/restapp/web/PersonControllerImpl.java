package ru.dglv.restapp.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.dglv.restapp.business.model.Person;
import ru.dglv.restapp.business.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonControllerImpl implements PersonController
{

    @Autowired
    private PersonService personService;
    
    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Status updatePerson(@RequestBody Person person)
    {
        Status status = new Status(Status.CODE.OK);
        
        try
        {
            personService.updatePerson(person);
        }
        catch(final Exception e)
        {
            status = new Status(Status.CODE.ERROR, e.getMessage());
        }
        
        return status;
    }
    
    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersons(@RequestParam(value = "id") final Optional<Long> id,
            @RequestParam(value = "lastName") final Optional<String> lastName)
    {
       List<Person> persons = null;
        
       if (id.isPresent())
       {
           persons = new ArrayList<Person>();
           persons.add(personService.getPersonById(id.get()));
       }
       else if (lastName.isPresent())
       {
           persons = personService.getPersonsByLastName(lastName.get());
       }
       else 
       {
           persons = personService.getAllPersons();
       }
       
       return persons;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public Status deletePersons(@RequestParam(value = "id") final Optional<Long> id)
    {
        Status status = new Status(Status.CODE.OK);

        try
        {

            if (id.isPresent())
            {
                personService.deletePersonById(id.get());
            }
            else
            {
                personService.deleteAllPersons();
            }
        }
        catch(final Exception e)
        {
            status = new Status(Status.CODE.ERROR, e.getMessage());
        }

        return status;
    }
}
