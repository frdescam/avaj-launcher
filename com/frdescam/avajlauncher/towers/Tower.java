package com.frdescam.avajlauncher.towers;

import java.util.LinkedList;
import java.util.List;

import com.frdescam.avajlauncher.Utils;
import com.frdescam.avajlauncher.flyables.Flyable;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        observers = new LinkedList<>();
    }

    private StringBuilder getBroadcastMessagePrefix(Flyable flyable)
    {
        StringBuilder broadcastMessage = new StringBuilder("Tower says: ");

        StringBuilder flyablePrefix = Utils.getFlyablePrefix(flyable);
        broadcastMessage.append(flyablePrefix);
        return broadcastMessage;
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);

            StringBuilder broadcastMessage = getBroadcastMessagePrefix(flyable);
            broadcastMessage.append(" registered to weather tower.");

            System.out.println(broadcastMessage);
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);

        StringBuilder broadcastMessage = getBroadcastMessagePrefix(flyable);
        broadcastMessage.append(" unregistered from weather tower.");

        System.out.println(broadcastMessage);
    }

    protected void conditionChanged() {

    }
}