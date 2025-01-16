package com.frdescam.avajlauncher.exceptions.avajexceptions;

import com.frdescam.avajlauncher.exceptions.AvajException;

public class CannotWriteSimulationFileException extends AvajException
{
    public CannotWriteSimulationFileException()
    {
        super("Error: Cannot write to simulation output file");
    }
}
