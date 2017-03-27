package ru.dglv.restapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.dglv.restapp.web.constant.Views;

@Controller
@RequestMapping("/")
public class MainControllerImpl implements MainController
{
    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage()
    {
        return Views.INDEX.getName();
    }
}
