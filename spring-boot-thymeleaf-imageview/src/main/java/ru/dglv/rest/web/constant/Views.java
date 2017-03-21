package ru.dglv.rest.web.constant;

public enum Views
{
    IMAGEVIEW("imageview");
    
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
