package com.frdescam.avajlauncher.towers;

import java.util.LinkedList;
import java.util.List;

import com.frdescam.avajlauncher.Logger;
import com.frdescam.avajlauncher.Utils;
import com.frdescam.avajlauncher.flyables.Flyable;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        this.observers = new LinkedList<>();
    }

    private StringBuilder getBroadcastMessagePrefix(Flyable flyable)
    {
        StringBuilder broadcastMessage = new StringBuilder("Tower says: ");

        StringBuilder flyablePrefix = Utils.getFlyablePrefix(flyable);
        broadcastMessage.append(flyablePrefix);
        return broadcastMessage;
    }

    public void register(Flyable flyable) {
        if (!this.observers.contains(flyable)) {
            this.observers.add(flyable);

            StringBuilder broadcastMessage = getBroadcastMessagePrefix(flyable);
            broadcastMessage.append(" registered to weather tower.");

            Logger.getInstance().log(broadcastMessage);
        }
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);

        StringBuilder broadcastMessage = getBroadcastMessagePrefix(flyable);
        broadcastMessage.append(" unregistered from weather tower.");

        Logger.getInstance().log(broadcastMessage);
    }

    protected void conditionChanged() {
        for (int i = 0; i < this.observers.size(); i++)
        {
            Flyable flyable = this.observers.get(i);
            flyable.updateConditions();
        }
    }
}