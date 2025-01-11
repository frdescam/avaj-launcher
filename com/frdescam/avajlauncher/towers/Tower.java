package com.frdescam.avajlauncher.towers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import com.frdescam.avajlauncher.flyables.Baloon;
import com.frdescam.avajlauncher.flyables.Flyable;
import com.frdescam.avajlauncher.flyables.Helicopter;
import com.frdescam.avajlauncher.flyables.JetPlane;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        observers = new LinkedList<>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);

            StringBuilder broadcastMessage = new StringBuilder("Tower says: ");

            if (flyable instanceof Baloon)
            {
                broadcastMessage.append("Baloon");
            }
            else if (flyable instanceof Helicopter)
            {
                broadcastMessage.append("Helicoper");
            }
            else if (flyable instanceof JetPlane)
            {
                broadcastMessage.append("JetPlane");
            }
            else
            {
                broadcastMessage.append("Unknown type");
            }

            broadcastMessage.append("#");
            try {
                Method getName = flyable.getClass().getMethod("getName");
                String flyableName = (String)getName.invoke(flyable);

                broadcastMessage.append(flyableName);
            }
            catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e)
            {
                broadcastMessage.append("unknown name");
            }

            broadcastMessage.append("(");
            try {
                Method getId = flyable.getClass().getMethod("getId");
                long flyableId = (long)getId.invoke(flyable);
                
                broadcastMessage.append(flyableId);
            }
            catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e)
            {
                broadcastMessage.append("unknown id");
            }
            broadcastMessage.append(")");

            broadcastMessage.append(" registered to weather tower.");

            System.out.println(broadcastMessage);
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionChanged() {

    }
}