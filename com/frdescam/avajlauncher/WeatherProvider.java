package com.frdescam.avajlauncher;

import com.frdescam.avajlauncher.towers.Weather;

public class WeatherProvider {

    private static WeatherProvider INSTANCE;

    private String[] weather;
    private Weather[] enumWeather;

    private WeatherProvider() {
        /* NOP */
    }

    public static WeatherProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherProvider();
        }
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "";
    }

    public Weather getCurrentEnumWeather(Coordinates coordinates) {
        return Weather.FOG;
    }
}
