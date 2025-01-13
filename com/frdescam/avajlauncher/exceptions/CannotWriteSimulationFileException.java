package com.frdescam.avajlauncher.exceptions;

public class CannotWriteSimulationFileException extends AvajException
{
    public CannotWriteSimulationFileException()
    {
        super("Error: Cannot write to simulation output file");
    }
}
