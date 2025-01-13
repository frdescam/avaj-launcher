package com.frdescam.avajlauncher.exceptions;

public class ScenarioFileNotFoundException extends AvajException
{
    public ScenarioFileNotFoundException()
    {
        super("Error: Cannot open scenario file");
    }    
}
