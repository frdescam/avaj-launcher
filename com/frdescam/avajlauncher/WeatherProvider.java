package com.frdescam.avajlauncher;

import com.frdescam.avajlauncher.towers.Weather;

public class WeatherProvider {

    private static WeatherProvider INSTANCE;

    private String[] weather;

    private Weather[][][] weatherMap = new Weather[100][100][100];

    private WeatherProvider() {
        updateWeatherMap();
    }

    public static WeatherProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherProvider();
        }
        return INSTANCE;
    }

    private void updateWeatherMap()
    {
     
        java.util.Random random = new java.util.Random();
        double[][][] numericMap = new double[100][100][100];

        for (int x = 0; x < 100; x++)
        {
            for (int y = 0; y < 100; y++)
            {
                for (int z = 0; z < 100; z++)
                {
                    numericMap[x][y][z] = random.nextDouble(0, 1);
                }
            }
        }

        for (int x = 0; x < 100; x++)
        {
            for (int y = 0; y < 100; y++)
            {
                for (int z = 0; z < 100; z++)
                {
                    // Mean
                    int nbMean = 1;
                    if (x - 1 >= 0)
                    {
                        numericMap[x][y][z] += numericMap[x - 1][y][z];
                        nbMean++;
                    }
                    if (x + 1 <= 99)
                    {
                        numericMap[x][y][z] += numericMap[x + 1][y][z];
                        nbMean++;
                    }
                    if (y - 1 >= 0)
                    {
                        numericMap[x][y][z] += numericMap[x][y - 1][z];
                        nbMean++;
                    }
                    if (y + 1 <= 99)
                    {
                        numericMap[x][y][z] += numericMap[x][y + 1][z];
                        nbMean++;
                    }
                    if (z - 1 >= 0)
                    {
                        numericMap[x][y][z] += numericMap[x][y][z - 1];
                        nbMean++;
                    }
                    if (z + 1 <= 99)
                    {
                        numericMap[x][y][z] += numericMap[x][y][z + 1];
                        nbMean++;
                    }
                    numericMap[x][y][z] /= nbMean;

                    // Simulate altitude influence over weather
                    if (z < 25)
                    {
                        numericMap[x][y][z] = Math.max(numericMap[x][y][z] + 0.1, 0);
                    }
                    else if (z > 75)
                    {
                        numericMap[x][y][z] = Math.min(numericMap[x][y][z] - 0.2, 1);
                    }

                    // Convert into real weather
                    if(numericMap[x][y][z] < 0.25)
                    {
                        weatherMap[x][y][z] = Weather.SNOW;
                    }
                    if(numericMap[x][y][z] >= 0.25 && numericMap[x][y][z] < 0.5)
                    {
                        weatherMap[x][y][z] = Weather.FOG;
                    }
                    if(numericMap[x][y][z] >= 0.5 && numericMap[x][y][z] < 0.75)
                    {
                        weatherMap[x][y][z] = Weather.RAIN;
                    }
                    if(numericMap[x][y][z] >= 0.75)
                    {
                        weatherMap[x][y][z] = Weather.SUN;
                    }
                }
            }
        }
    }

    public void changeWeather()
    {
        this.updateWeatherMap();
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Weather enumWeather = getCurrentEnumWeather(coordinates);
        
        return enumWeather.toString();
    }

    public Weather getCurrentEnumWeather(Coordinates coordinates) {
        int x = Math.floorMod(coordinates.getLatitude(), 100);
        int y = Math.floorMod(coordinates.getLongitude(), 100);
        int z = coordinates.getHeight() - 1;
        return weatherMap[x][y][z];
    }
}
