package com.frdescam.avajlauncher.exceptions;

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
