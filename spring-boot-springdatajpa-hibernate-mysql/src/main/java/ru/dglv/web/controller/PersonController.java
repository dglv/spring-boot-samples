package ru.dglv.web.controller;

import org.springframework.web.servlet.ModelAndView;

public interface PersonController
{
    ModelAndView login(ModelAndView modelAndView);
    ModelAndView login(String username, String password, ModelAndView modelAndView);
    ModelAndView signup(ModelAndView modelAndView);
    ModelAndView signup(String username, String password, String email, String name, Integer age, ModelAndView modelAndView);
}
