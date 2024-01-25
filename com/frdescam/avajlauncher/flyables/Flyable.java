package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.towers.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
    }
}