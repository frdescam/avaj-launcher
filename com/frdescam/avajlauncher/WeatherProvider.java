package com.frdescam.avajlauncher;

public class WeatherProvider {

    private static WeatherProvider INSTANCE;

    private String[] weather;

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
        return null;
    }
}
