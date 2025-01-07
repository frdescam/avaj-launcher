package com.frdescam.avajlauncher;

import java.io.File;
import java.util.Map;

public class Simulation
{
    
    public static void main(String[] args)
    {
        Scenario scenario;

        if (args.length != 1)
        {
            System.err.println("Error : Invalid number of arguments");
        }

        File scenarioFile = new File(args[0]);
        
        try
        {
            scenario = new Scenario(scenarioFile);
        }
        catch (Exception e)
        {
            System.out.print("Error : ");
            System.out.println(e);
            System.exit(1);
        }

        for (Map<String, Object> aircraft : scenario.getAircrafts())
        {

        }
    }
}
