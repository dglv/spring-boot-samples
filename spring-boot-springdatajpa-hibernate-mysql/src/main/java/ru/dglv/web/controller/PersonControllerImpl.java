package ru.dglv.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.dglv.business.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonControllerImpl implements PersonController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonControllerImpl.class);
    
    @Autowired
    private PersonService personService;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPersonForm(final ModelAndView modelAndView)
    {
        LOGGER.debug("GET /person request");
        modelAndView.setViewName("login");
        
        return modelAndView;
    }
    
    @Override
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(final ModelAndView modelAndView)
    {
        LOGGER.debug("GET /person/signup request");
        modelAndView.setViewName("signup");
        
        return modelAndView;
    }
    
    @Override
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "username") final String username,
            @RequestParam(value = "password") final String password,
            final ModelAndView modelAndView)
    {
        LOGGER.debug("POST /person/login request");
/*        personService.savePerson(username, password, name, age);
        */
        modelAndView.addObject("username", username);
        modelAndView.setViewName("save_success");
        
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(value = "username") final String username, 
            @RequestParam(value = "password") final String password,
            @RequestParam(value = "email") final String email, 
            @RequestParam(value = "name") final String name, 
            @RequestParam(value = "age") final Integer age,
            final ModelAndView modelAndView)
    {
        LOGGER.debug("POST /person/save request");
        personService.savePerson(username, password, email, name, age);
        
        modelAndView.addObject("username", username);
        modelAndView.setViewName("save_success");
        
        return modelAndView;
    }

}
