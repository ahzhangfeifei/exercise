package com.design.mode.builder;

/**
 * A house as a concrete product we got finally
 * Created by zhangfeifei on 2016/12/05.
 */
public class House  {
    /**
     * The Room number.
     */
    int roomNumber;
    /**
     * The Door number.
     */
    int doorNumber;

    /**
     * Instantiates a new House.
     */
    public House() {
        roomNumber = 0;
        doorNumber = 0;
    }

    /**
     * Gets room number.
     *
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Gets door number.
     *
     * @return the door number
     */
    public int getDoorNumber() {
        return doorNumber;
    }
}