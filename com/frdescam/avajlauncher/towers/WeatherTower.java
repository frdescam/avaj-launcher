package com.frdescam.avajlauncher.towers;

import com.frdescam.avajlauncher.Coordinates;
import com.frdescam.avajlauncher.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public Weather getEnumWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentEnumWeather(p_coordinates);
    }

    public void changeWeather() {
        WeatherProvider.getInstance().changeWeather();
        this.conditionChanged();
    }
}
