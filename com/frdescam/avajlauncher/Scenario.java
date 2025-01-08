package com.frdescam.avajlauncher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Scenario
{
    int nbSimulationIterations;
    List<Map<String, Object>> aircrafts = new ArrayList<>();

    // TODO : Handle errors in constuctor
    public Scenario(File scenarioFile) throws FileNotFoundException, NumberFormatException
    {
        Scanner fileReader = new Scanner(scenarioFile);

        if (fileReader.hasNextLine())
        {
            String line = fileReader.nextLine();
            this.nbSimulationIterations = Integer.parseInt(line);
        }

        while (fileReader.hasNextLine())
        {
            String line = fileReader.nextLine();
            String[] tokens = line.split(" ");

            Map<String, Object> aircraft = new HashMap<>();
            switch (tokens[0]) {
                case "Baloon":
                    aircraft.put("type", AircraftsType.BALOON);
                    break;
                case "JetPlane":
                    aircraft.put("type", AircraftsType.JETPLANE);
                    break;
                case "Helicopter":
                    aircraft.put("type", AircraftsType.HELICOPTER);
                    break;
                default:
                    break;
            }

            aircraft.put("name", tokens[1]);
            aircraft.put("longitude", Integer.parseInt(tokens[2]));
            aircraft.put("latitude", Integer.parseInt(tokens[3]));
            aircraft.put("height", Integer.parseInt(tokens[4]));

            this.aircrafts.add(aircraft);
        }

        fileReader.close();
    }

    public List<Map<String, Object>> getAircrafts()
    {
        return this.aircrafts;
    }

    public int getNbSimulationIterations()
    {
        return this.nbSimulationIterations;
    }
}
