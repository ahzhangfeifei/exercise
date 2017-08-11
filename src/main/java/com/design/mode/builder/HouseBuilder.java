package com.design.mode.builder;

/**
 * The type House builder.
 */
/*
 *  An abstract Builder
 */
public abstract class HouseBuilder  {
    /**
     * Build room.
     *
     * @param roomNo the room no
     */
    public abstract void BuildRoom(int roomNo);

    /**
     * Build door.
     *
     * @param room1 the room 1
     * @param room2 the room 2
     */
    public abstract void BuildDoor(int room1, int room2);

    /**
     * Gets house.
     *
     * @return the house
     */
    public abstract House getHouse();
}