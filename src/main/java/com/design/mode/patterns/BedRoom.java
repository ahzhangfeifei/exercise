package com.design.mode.patterns;

/**
 * The type Bed room.
 */
public class BedRoom  extends Room {
    /**
     * Instantiates a new Bed room.
     */
    public BedRoom() {
        System.out.println("Initiated a bedroom !");
    }
    public Door makeDoor() {
        return new BedRoomDoor();
    }
    public Wall makeWall() {
        return new BedRoomWall();
    }
}