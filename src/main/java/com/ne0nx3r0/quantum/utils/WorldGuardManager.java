package com.ne0nx3r0.quantum.utils;

import com.ne0nx3r0.quantum.nmswrapper.ClassRegistry;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;
/*
 * Checks WorldGuard.
 * If Plugin is available, WorldGuard regions are supported.
 * Plugin will check if player can build, where he wants so create a circuit.
 */
public class WorldGuardManager {
    ClassRegistry classRegistry;
    Plugin worldGuardPlugin;

    public WorldGuardManager(ClassRegistry classRegistry, Plugin worldGuardPlugin) {
        this.classRegistry = classRegistry;
        this.worldGuardPlugin = worldGuardPlugin;
    }

    public boolean playerCanBuild(Player player, Location loc) {
        Object result = false;
        try {
            System.out.println("Objekt: " + worldGuardPlugin.toString() + " Methode: " + classRegistry.getWorldGuardCanBuild());
            result = classRegistry.getWorldGuardCanBuild().invoke(worldGuardPlugin, player, loc);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return (boolean) result;
    }
}
