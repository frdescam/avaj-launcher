package com.frdescam.avajlauncher.flyables.aircrafts;

import com.frdescam.avajlauncher.Coordinates;
import com.frdescam.avajlauncher.Logger;
import com.frdescam.avajlauncher.Utils;
import com.frdescam.avajlauncher.flyables.Aircraft;
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
                StringBuilder flyablePrefix = Utils.getFlyablePrefix(this);
                StringBuilder broadcastMessage = new StringBuilder();
                broadcastMessage.append(flyablePrefix);
                broadcastMessage.append(": Damn you rain! You messed up my baloon.");
                Logger.getInstance().log(broadcastMessage);

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
                StringBuilder flyablePrefix = Utils.getFlyablePrefix(this);
                StringBuilder broadcastMessage = new StringBuilder();
                broadcastMessage.append(flyablePrefix);
                broadcastMessage.append(": Damn you fog! You messed up my baloon.");
                Logger.getInstance().log(broadcastMessage);

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
                StringBuilder flyablePrefix = Utils.getFlyablePrefix(this);
                StringBuilder broadcastMessage = new StringBuilder();
                broadcastMessage.append(flyablePrefix);
                broadcastMessage.append(": Let's enjoy the good weather and take some pics.");
                Logger.getInstance().log(broadcastMessage);

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
                StringBuilder flyablePrefix = Utils.getFlyablePrefix(this);
                StringBuilder broadcastMessage = new StringBuilder();
                broadcastMessage.append(flyablePrefix);
                broadcastMessage.append(": : It's snowing. We're gonna crash.");
                Logger.getInstance().log(broadcastMessage);
                
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