package ru.dglv.springboot.constant;

public enum Views
{
    HWVIEW("hwview");
    
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
