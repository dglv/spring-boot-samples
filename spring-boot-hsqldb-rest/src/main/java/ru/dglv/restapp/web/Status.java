package ru.dglv.restapp.web;

public class Status
{
    public enum CODE
    {
        OK,
        ERROR
    }
    
    private final CODE code;
    private final String message;
    
    public Status(final CODE code, final String message)
    {
        this.code = code;
        this.message = message;
    }
}
