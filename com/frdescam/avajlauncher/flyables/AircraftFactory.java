package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.Coordinates;

public class AircraftFactory {

    private static AircraftFactory INSTANCE;
    private int aircraftId = 1;

    private AircraftFactory() {
        /* NOP */
    }

    public static AircraftFactory getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new AircraftFactory();
        }
        return INSTANCE;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates)
    {
        AircraftsType aircraftsType = AircraftsType.fromString(type);
        return this.newAircraft(aircraftsType, name, coordinates);
    }

    public Flyable newAircraft(AircraftsType type, String name, Coordinates coordinates)
    {
        Flyable newFlyable = null;

        switch (type)
        {
            case BALOON:
                newFlyable = new Baloon(this.aircraftId, name, coordinates);
                break;
            case JETPLANE:
                newFlyable = new JetPlane(this.aircraftId, name, coordinates);
                break;
            case HELICOPTER:
                newFlyable = new Helicopter(this.aircraftId, name, coordinates);
                break;
        };

        if (newFlyable != null)
        {
            this.aircraftId++;
        }

        return newFlyable;
    }
}