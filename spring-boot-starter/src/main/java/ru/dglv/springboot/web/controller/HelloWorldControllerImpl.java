package ru.dglv.springboot.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.dglv.springboot.constant.Views;

@Controller
@RequestMapping("/")
public class HelloWorldControllerImpl implements HelloWorldController
{
    @Value("${message.helloworld}")
    private String message;

    @RequestMapping(method = RequestMethod.GET)
    public String  getResponse(final Map<String, Object> model)
    {
        model.put("message", message);

        return Views.HWVIEW.name;
    }
}
