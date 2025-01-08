package com.frdescam.avajlauncher.towers;

import com.frdescam.avajlauncher.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates) {
        return "";
    }

    public Weather getEnumWeather(Coordinates p_coordinates) {
        return Weather.FOG;
    }

    public void changeWeather() {

    }
}
