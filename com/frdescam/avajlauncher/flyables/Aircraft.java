package com.frdescam.avajlauncher.flyables;

import com.frdescam.avajlauncher.Coordinates;

public class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates; 

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;

        if (this.coordinates.getHeight() > 100)
        {
            this.coordinates.setHeight(100);
        }
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void updateConditions() {
        throw new UnsupportedOperationException("Unimplemented method 'updateConditions'");
    }

}