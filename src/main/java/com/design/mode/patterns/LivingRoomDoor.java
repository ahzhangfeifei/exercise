package com.design.mode.patterns;

/**
 * A concrete Door for Living Room
 */
public class LivingRoomDoor extends Door {
    private String doorName;

    /**
     * Instantiates a new Living room door.
     */
    public LivingRoomDoor() {
        doorName = "LivingRoomDoor";
    }
    public String getName() {
        return doorName;
    }
}