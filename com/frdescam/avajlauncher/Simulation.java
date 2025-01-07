package com.frdescam.avajlauncher;

import java.io.File;

public class Simulation {
    
    private static boolean checkScenarioFile(File scenarioFile) {
        return true;
    }

    public static void main(String[] args) {
        File scenarioFile;
        Scenario scenario;

        if (args.length != 1) {
            System.err.println("Error : Invalid number of arguments");
        }

        scenarioFile = new File(args[0]);
        
        scenario.loadScenarioFile(scenarioFile);

        if (!checkScenarioFile(scenarioFile)) {
            System.err.println("Error : Invalid file");
        }
    }
}
