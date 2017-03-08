package ru.dglv.web.controller;

import org.springframework.web.servlet.ModelAndView;

public interface PersonController
{
    ModelAndView showPersonForm(ModelAndView modelAndView);
    ModelAndView save(String username, String password, String name, Integer age, ModelAndView modelAndView);
}
