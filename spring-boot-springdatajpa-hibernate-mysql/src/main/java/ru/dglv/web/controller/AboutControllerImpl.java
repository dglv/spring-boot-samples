package ru.dglv.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/about")
public class AboutControllerImpl implements AboutController
{
    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String about()
    {
        return "redirect:/pages/about.html";
    }
}
