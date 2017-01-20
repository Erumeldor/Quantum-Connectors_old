package com.ne0nx3r0.quantum.receiver;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.material.PistonBaseMaterial;
import org.bukkit.material.PistonExtensionMaterial;

/*
 * Unused!
 * Todo: Fix it!
 */

public class PistonReceiver extends Receiver {
    public PistonReceiver(Location location, int type) {
        super(location, type);
    }

    public PistonReceiver(Location location, int type, int delay) {
        super(location, type, delay);
    }

    @Override
    public void setActive(boolean powerOn) {
        //Block b = location.getBlock();
        PistonBaseMaterial pistonBase = (PistonBaseMaterial) location.getBlock().getState().getData();
        //b.setData(pistonBase.getData());
/*
        pistonBase.setPowered(powerOn);
        //b.setType(Material.PISTON_EXTENSION);
        ((PistonBaseMaterial) location.getBlock().getState().getData()).setPowered(powerOn);
        location.getBlock().getState().update();*/



        Block l = location.getBlock();//Basically, you are getting the block in front of the piston end.
        Block b = l.getRelative(pistonBase.getFacing());//Or whatever direction is to the piston
        if(b.getType()== Material.PISTON_BASE){
            PistonBaseMaterial piston = (PistonBaseMaterial) b.getState().getData();
            if(!piston.isPowered()){
                piston.setPowered(true);
                b.setData(piston.getData());
                l.setType(Material.PISTON_EXTENSION);
                PistonExtensionMaterial pe = (PistonExtensionMaterial) l.getState().getData();
                l.setData(pe.getData());
                l.getState().update();
                b.getState().update();
            }
        }
    }
}
