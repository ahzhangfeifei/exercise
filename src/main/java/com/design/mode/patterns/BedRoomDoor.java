package com.design.mode.patterns;

/**
 * A concrete Door for Bed Room
 */
public class BedRoomDoor extends Door {
    private String doorName;

    /**
     * Instantiates a new Bed room door.
     */
    public BedRoomDoor() {
        doorName = "BedRoomDoor";
    }
    public String getName() {
        return doorName;
    }
}