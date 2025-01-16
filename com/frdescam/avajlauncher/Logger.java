package com.frdescam.avajlauncher;

import java.io.FileWriter;
import java.io.IOException;

import com.frdescam.avajlauncher.exceptions.avajexceptions.CannotWriteSimulationFileException;

public class Logger {

    private static Logger INSTANCE;
    StringBuilder simulationLogs = new StringBuilder();

    private Logger()
    {
        /* NOP */
    }

    public static Logger getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new Logger();
        }

        return INSTANCE;
    }
    
    public void log(String string)
    {
        simulationLogs.append(string);
        simulationLogs.append("\n");
    }

    public void log(StringBuilder stringBuilder)
    {
        simulationLogs.append(stringBuilder);
        simulationLogs.append("\n");
    }

    public void writeLogFile() throws CannotWriteSimulationFileException
    {
        FileWriter logFile;

        try
        {
            logFile = new FileWriter("simulation.txt");
            logFile.write(this.simulationLogs.toString());
            logFile.close();
        }
        catch (IOException e)
        {
            throw new CannotWriteSimulationFileException();
        }
    }

    public String getSimulationLogs()
    {
        return this.simulationLogs.toString();
    }
}
