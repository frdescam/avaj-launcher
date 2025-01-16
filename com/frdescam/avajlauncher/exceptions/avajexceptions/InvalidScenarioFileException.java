package com.frdescam.avajlauncher.exceptions.avajexceptions;

import com.frdescam.avajlauncher.exceptions.AvajException;

public class InvalidScenarioFileException extends AvajException
{
    public InvalidScenarioFileException()
    {
        super("Error: Invalid syntax in scenario file");
    }

    public InvalidScenarioFileException(String str)
    {
        super("Error: Invalid syntax in scenario file: " + str);
    }
}
