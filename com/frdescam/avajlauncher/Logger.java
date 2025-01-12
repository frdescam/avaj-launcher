package com.frdescam.avajlauncher;

import java.io.FileWriter;
import java.io.IOException;

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

    public void writeLogFile()
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
            System.err.println("Error writing output file");
        }
    }
}
