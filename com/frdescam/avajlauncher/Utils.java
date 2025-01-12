package com.frdescam.avajlauncher;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.frdescam.avajlauncher.flyables.Baloon;
import com.frdescam.avajlauncher.flyables.Flyable;
import com.frdescam.avajlauncher.flyables.Helicopter;
import com.frdescam.avajlauncher.flyables.JetPlane;

public class Utils {
    public static StringBuilder getFlyablePrefix(Flyable flyable)
    {
        StringBuilder broadcastMessage = new StringBuilder();

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

        return broadcastMessage;
    }
}
