package ru.dglv.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StarterWebApp extends SpringBootServletInitializer
{
    public static void main(final String[] args)
    {
        SpringApplication.run(StarterWebApp.class, args);
    }
}