package com.ne0nx3r0.quantum.nmswrapper;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class will import specific Minecraft-Version dependent things.
 */
public class ClassRegistry {


    private Class<?> craftWorldClass;
    private Class<?> nmsWorldClass;
    private Method nmsWorldHandle;
    private Field isClientSide;
    private Class<?> worldGuardClass;
    private Method worldGuardCanBuild;


    public ClassRegistry(String version, boolean worldGuardEnabled) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        this.craftWorldClass = Class.forName("org.bukkit.craftbukkit." + version + ".CraftWorld");
        this.nmsWorldClass = Class.forName("net.minecraft.server." + version + ".World");
        this.nmsWorldHandle = craftWorldClass.getDeclaredMethod("getHandle");
        this.isClientSide = nmsWorldClass.getDeclaredField("isClientSide");
        if (worldGuardEnabled) {
            this.worldGuardClass = Class.forName("com.sk89q.worldguard.bukkit.WorldGuardPlugin");
            this.worldGuardCanBuild = worldGuardClass.getDeclaredMethod("canBuild", Player.class, Location.class);
        }
    }

    public Method getWorldGuardCanBuild() {
        return worldGuardCanBuild;
    }

    public Method getNmsWorldField() {
        return nmsWorldHandle;
    }

    public Field getIsClientSide() {
        return isClientSide;
    }
}
