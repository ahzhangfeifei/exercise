package com.design.mode.patterns;


/**
 * AbstractFactory
 */
public abstract  class Room  {
    /**
     * Make wall wall.
     *
     * @return the wall
     */
    public abstract Wall makeWall();

    /**
     * Make door door.
     *
     * @return the door
     */
    public abstract Door makeDoor();
}