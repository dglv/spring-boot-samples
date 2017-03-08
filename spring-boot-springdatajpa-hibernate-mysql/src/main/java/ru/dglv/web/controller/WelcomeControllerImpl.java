package ru.dglv.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeControllerImpl implements WelcomeController
{
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String welcome(final Map<String, Object> model)
    {
        model.put("message", message);

        return "welcome";
    }
}
