package ru.dglv.springboot.constant;

public enum Views
{
    HWVIEW("hwview", "jsp");
    
    public final String name;
    public final String suffix;
    
    private Views(final String name, final String suffix)
    {
        this.name = name;
        this.suffix = suffix;
    }
}
