package com.frdescam.avajlauncher.towers;

public enum Weather {
    RAIN,
    FOG,
    SUN,
    SNOW;

    public static Weather fromString(String string)
    {
        for (Weather weather : Weather.values()) {
            if (weather.name().equalsIgnoreCase(string)) {
                return weather;
            }
        }
        throw new IllegalArgumentException("Unknown weather : " + string);
    }

    // public static Weather toString(Weather weatherEnum)
    // {
    //     for (Weather weather : Weather.values()) {
    //         if (weather.name().equalsIgnoreCase(weatherEnum.toString())) {
    //             return weather;
    //         }
    //     }
    //     throw new IllegalArgumentException("Unknown weather : " + weatherEnum);
    // }
}
