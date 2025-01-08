package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.Coordinates;
import com.frdescam.avajlauncher.towers.Weather;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }
    
    public void updateConditions() {
        Weather weather = this.weatherTower.getEnumWeather(this.coordinates);

        switch (weather) {
            case RAIN:
            {
                int longitude = this.coordinates.getLongitude();
                longitude += 5;
                longitude = Math.min(longitude, 100);
                this.coordinates.setLongitude(longitude);

                break;
            }
            case FOG:
            {
                int latitude = this.coordinates.getLatitude();
                latitude += 1;
                latitude = Math.min(latitude, 100);
                this.coordinates.setLatitude(latitude);

                break;
            }
            case SUN:
            {
                int height = this.coordinates.getHeight();
                height += 2;
                height = Math.min(height, 100);
                this.coordinates.setHeight(height);

                int latitude = this.coordinates.getLatitude();
                latitude += 10;
                this.coordinates.setLatitude(latitude);

                break;
            }
            case SNOW:
            {
                int height = this.coordinates.getHeight();
                height -= 7;
                height = Math.max(height, 0);
                this.coordinates.setHeight(height);

                if (this.coordinates.getHeight() == 0)
                {
                    // TODO
                }

                break;
            }
        }
    }
}