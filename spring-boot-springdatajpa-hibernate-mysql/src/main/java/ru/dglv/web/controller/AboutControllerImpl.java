package ru.dglv.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/about")
public class AboutControllerImpl implements AboutController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AboutControllerImpl.class);
    
    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String about()
    {
        LOGGER.debug("GET /about request");
        return "redirect:/pages/about.html";
    }
}
