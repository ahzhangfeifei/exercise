package com.design.mode.patterns;


/**
 * A concrete Wall for Living Room
 */
public class LivingRoomWall  extends Wall {
    private String wallName;

    /**
     * Instantiates a new Living room wall.
     */
    public LivingRoomWall() {
        wallName = "LivingRoomWall";
    }
    public String getName() {
        return wallName;
    }
}