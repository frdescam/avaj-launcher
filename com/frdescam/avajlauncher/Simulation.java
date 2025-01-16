package com.frdescam.avajlauncher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.frdescam.avajlauncher.exceptions.avajexceptions.CannotWriteSimulationFileException;
import com.frdescam.avajlauncher.exceptions.avajexceptions.ScenarioFileNotFoundException;
import com.frdescam.avajlauncher.exceptions.avajexceptions.InvalidScenarioFileException;
import com.frdescam.avajlauncher.flyables.AircraftFactory;
import com.frdescam.avajlauncher.flyables.AircraftsType;
import com.frdescam.avajlauncher.flyables.Flyable;
import com.frdescam.avajlauncher.towers.WeatherTower;

public class Simulation
{
    public static void main(String[] args)
    {
        Scenario scenario = null;

        List<Flyable> flyables = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();

        if (args.length != 1)
        {
            System.err.println("Error : Invalid number of arguments");
            System.exit(1);
        }

        try
        {
            File scenarioFile = new File(args[0]);
            scenario = new Scenario(scenarioFile);
        }
        catch (ScenarioFileNotFoundException | InvalidScenarioFileException e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Logger.getInstance().log("===== Initializing simulation =====");

        for (Map<String, Object> scenarioAircraft : scenario.getAircrafts())
        {
            AircraftsType aircraftType = (AircraftsType)scenarioAircraft.get("type");
            String aircraftName = (String)scenarioAircraft.get("name");
            int aircraftLongitude = (int)scenarioAircraft.get("longitude");
            int aircraftLatitude = (int)scenarioAircraft.get("latitude");
            int aircraftHeight = (int)scenarioAircraft.get("height");
            Coordinates aircraftCoordinates = new Coordinates(aircraftLongitude, aircraftLatitude, aircraftHeight);

            Flyable newFlyable = AircraftFactory.getInstance().newAircraft(aircraftType, aircraftName, aircraftCoordinates);
            flyables.add(newFlyable);
            newFlyable.registerTower(weatherTower);
        }

        Logger.getInstance().log("===== Starting simulation =====");

        for (int i = 0; i < scenario.getNbSimulationIterations(); i++)
        {
            Logger.getInstance().log("===== Simulation Round " + (i + 1) + " =====");
            weatherTower.changeWeather();
        }

        Logger.getInstance().log("===== End of the simulation =====");


        try
        {
            Logger.getInstance().writeLogFile();
        }
        catch (CannotWriteSimulationFileException e )
        {
            System.err.println(e.getMessage());
            System.out.println("Printing on stdout :\n");

            String logs = Logger.getInstance().getSimulationLogs();
            System.out.println(logs);

            System.exit(1);
        }
    }
}
