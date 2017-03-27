package ru.dglv.restapp.web.constant;

public enum Views
{
    INDEX("index");
    
    private final String name;
    
    private Views(final String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return  name;
    }
    
}
