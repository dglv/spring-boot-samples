package ru.dglv.springboot.web.controller;

import java.util.Map;

public interface HelloWorldController
{
    String  getResponse(Map<String, Object> model);
}
