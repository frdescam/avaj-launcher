package com.frdescam.avajlauncher;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.frdescam.avajlauncher.flyables.Aircraft;
import com.frdescam.avajlauncher.flyables.Baloon;
import com.frdescam.avajlauncher.flyables.Helicopter;
import com.frdescam.avajlauncher.flyables.JetPlane;

public class Simulation
{
    public static void main(String[] args)
    {
        List<Aircraft> aircrafts = new ArrayList<>();
        Scenario scenario = null;

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

        int aircraftId = 0;
        for (Map<String, Object> scenarioAircraft : scenario.getAircrafts())
        {
            AircraftsType aircraftType = (AircraftsType)scenarioAircraft.get("type");
            String aircraftName = (String)scenarioAircraft.get("name");
            int aircraftLongitude = (int)scenarioAircraft.get("longitude");
            int aircraftLatitude = (int)scenarioAircraft.get("latitude");
            int aircraftHeight = (int)scenarioAircraft.get("height");
            Coordinates aircraftCoordinates = new Coordinates(aircraftLongitude, aircraftLatitude, aircraftHeight);


            switch (aircraftType) {
                case BALOON:
                    Baloon newBaloon = new Baloon(aircraftId, aircraftName, aircraftCoordinates);
                    aircrafts.add(newBaloon);
                    break;
                case JETPLANE:
                    JetPlane newJetPlane = new JetPlane(aircraftId, aircraftName, aircraftCoordinates);
                    aircrafts.add(newJetPlane);
                    break;
                case HELICOPTER:
                Helicopter newHelicopter = new Helicopter(aircraftId, aircraftName, aircraftCoordinates);
                    aircrafts.add(newHelicopter);
                    break;
            }
            aircraftId++;
        }
        System.out.println("Finished");
    }
}
