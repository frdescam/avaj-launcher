package com.frdescam.avajlauncher.exceptions;

public class AvajException extends Exception
{
    public AvajException()
    {
        super("Unknown error happened");
    }

    public AvajException(String str)
    {
        super(str);
    }
}
