package com.design.mode.patterns;

/**
 * A concrete Wall for Living Room
 */
public class BedRoomWall extends Wall {
    private String wallName;

    /**
     * Instantiates a new Bed room wall.
     */
    public BedRoomWall() {
        wallName = "BedRoomWall";
    }
    public String getName() {
        return wallName;
    }
}