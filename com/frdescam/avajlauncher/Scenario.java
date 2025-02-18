package com.frdescam.avajlauncher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.frdescam.avajlauncher.exceptions.avajexceptions.ScenarioFileNotFoundException;
import com.frdescam.avajlauncher.exceptions.avajexceptions.InvalidScenarioFileException;
import com.frdescam.avajlauncher.flyables.AircraftsType;

public class Scenario
{
    private int nbSimulationIterations = -1;
    private List<Map<String, Object>> aircrafts = new ArrayList<>();

    public Scenario(File scenarioFile) throws ScenarioFileNotFoundException, InvalidScenarioFileException
    {
        Scanner fileReader;

        try
        {
            fileReader = new Scanner(scenarioFile);
        }
        catch (FileNotFoundException e)
        {
            throw new ScenarioFileNotFoundException();
        }

        int lineNb = 0;
        while (fileReader.hasNextLine())
        {
            String line = fileReader.nextLine();
            lineNb++;

            if (line.isEmpty() || line.isBlank())
            {
                continue;
            }

            String[] tokens = line.split("\\s+");

            if (this.nbSimulationIterations == -1)
            {
                this.handleNbSimulationIterations(fileReader, line, tokens, lineNb);
                continue;
            }

            if (tokens.length != 5 || tokens[0].isEmpty())
            {
                fileReader.close();
                throw new InvalidScenarioFileException("Wrong number of tokens on line " + lineNb + ": " + String.format("%.50s", line));
            }

            Map<String, Object> aircraft = new HashMap<>();

            aircraft.put("type", AircraftsType.fromString(tokens[0]));
            aircraft.put("name", tokens[1]);
            try
            {
                int longitude = Integer.parseInt(tokens[2]);
                int latitude = Integer.parseInt(tokens[3]);
                int height = Integer.parseInt(tokens[4]);

                aircraft.put("longitude", longitude);
                aircraft.put("latitude", latitude);
                aircraft.put("height", height);
            }
            catch (NumberFormatException e)
            {
                fileReader.close();
                throw new InvalidScenarioFileException("Expected an interger on line " + lineNb + ": " + String.format("%.50s", line));
            }

            this.aircrafts.add(aircraft);
        }

        fileReader.close();
    }

    private void handleNbSimulationIterations(Scanner fileReader, String line, String[] tokens, int lineNb) throws InvalidScenarioFileException
    {
        if (tokens.length != 1 || tokens[0].isEmpty())
        {
            fileReader.close();
            throw new InvalidScenarioFileException("Wrong number of tokens on line " + lineNb + ": " + String.format("%.50s", line));
        }

        try
        {
            this.nbSimulationIterations = Integer.parseInt(tokens[0]);
            if (this.nbSimulationIterations < 0)
            {
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e)
        {
            fileReader.close();
            throw new InvalidScenarioFileException("Expected a positive interger on line " + lineNb + ": " + String.format("%.50s", line));
        }
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
