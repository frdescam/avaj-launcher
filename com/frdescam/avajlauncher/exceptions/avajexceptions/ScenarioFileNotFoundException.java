package com.frdescam.avajlauncher.exceptions.avajexceptions;

import com.frdescam.avajlauncher.exceptions.AvajException;

public class ScenarioFileNotFoundException extends AvajException
{
    public ScenarioFileNotFoundException()
    {
        super("Error: Cannot open scenario file");
    }    
}
