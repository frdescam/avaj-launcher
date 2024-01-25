package com.frdescam.avajlauncher.towers;

import java.util.LinkedList;
import java.util.List;

import com.frdescam.avajlauncher.flyables.Flyable;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        observers = new LinkedList<>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionChanged() {

    }
}