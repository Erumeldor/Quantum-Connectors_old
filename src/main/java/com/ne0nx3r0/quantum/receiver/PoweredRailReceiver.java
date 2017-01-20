package com.ne0nx3r0.quantum.receiver;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.material.PoweredRail;

/*
 * Class unused!
 * TODO: Delete, or fix.
 */
public class PoweredRailReceiver extends Receiver {
    public PoweredRailReceiver(Location location, int type) {
        super(location, type);
    }

    public PoweredRailReceiver(Location location, int type, int delay) {
        super(location, type, delay);
    }

    @Override
    public void setActive(boolean powerOn) {

        BlockState state = location.getBlock().getState();
        PoweredRail poweredRail = (PoweredRail) state.getData();
        poweredRail.setPowered(powerOn);
        System.out.println("Schiene ist gepowered: " + poweredRail.isPowered());
        poweredRail.setData(poweredRail.getData());
        state.setData(poweredRail);
        state.update(true);

    }
}
