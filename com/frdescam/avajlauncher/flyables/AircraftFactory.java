package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.Coordinates;

public class AircraftFactory {

    private static AircraftFactory INSTANCE;

    private AircraftFactory() {
        /* NOP */
    }

    public static AircraftFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AircraftFactory();
        }
        return INSTANCE;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        return null;
    }
}
