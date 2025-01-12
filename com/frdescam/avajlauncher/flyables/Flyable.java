package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.Utils;
import com.frdescam.avajlauncher.towers.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower = null;

    public abstract void updateConditions();

    public void registerTower(WeatherTower tower)
    {
        if (tower != null)
        {
            this.weatherTower = tower;
            this.weatherTower.register(this);
        }
    }

    protected void unregisterTower()
    {
        if (this.weatherTower != null)
        {
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    protected void land()
    {
        StringBuilder broadcastMessage = new StringBuilder();

        StringBuilder flyablePrefix = Utils.getFlyablePrefix(this);
        broadcastMessage.append(flyablePrefix);
        broadcastMessage.append(" landing.");

        System.out.println(broadcastMessage);
    }
}