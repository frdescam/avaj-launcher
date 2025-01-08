package com.frdescam.avajlauncher.flyables;

public enum AircraftsType {
    HELICOPTER,
    JETPLANE,
    BALOON;

    public static AircraftsType fromString(String string)
    {
        for (AircraftsType aircraftsType : AircraftsType.values()) {
            if (aircraftsType.name().equalsIgnoreCase(string)) {
                return aircraftsType;
            }
        }
        throw new IllegalArgumentException("Unknown aircraft type : " + string);
    }
}