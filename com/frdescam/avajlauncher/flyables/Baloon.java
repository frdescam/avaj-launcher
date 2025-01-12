package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.Coordinates;
import com.frdescam.avajlauncher.towers.Weather;

public class Baloon extends Aircraft {

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }
    
    @Override
    public void updateConditions() {
        Weather weather = this.weatherTower.getEnumWeather(this.coordinates);

        switch (weather) {
            case RAIN:
            {
                int height = this.coordinates.getHeight();
                height -= 5;
                height = Math.max(height, 0);
                this.coordinates.setHeight(height);

                if (this.coordinates.getHeight() == 0)
                {
                    this.land();
                    this.unregisterTower();
                }

                break;
            }
            case FOG:
            {
                int height = this.coordinates.getHeight();
                height -= 3;
                height = Math.max(height, 0);
                this.coordinates.setHeight(height);

                if (this.coordinates.getHeight() == 0)
                {
                    this.land();
                    this.unregisterTower();
                }

                break;
            }
            case SUN:
            {
                int height = this.coordinates.getHeight();
                height += 4;
                height = Math.min(height, 100);
                this.coordinates.setHeight(height);

                int longitude = this.coordinates.getLongitude();
                longitude += 2;
                this.coordinates.setLongitude(longitude);

                break;
            }
            case SNOW:
            {
                int height = this.coordinates.getHeight();
                height -= 15;
                height = Math.max(height, 0);
                this.coordinates.setHeight(height);

                if (this.coordinates.getHeight() == 0)
                {
                    this.land();
                    this.unregisterTower();
                }

                break;
            }
        }
    }
}