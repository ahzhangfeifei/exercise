package com.design.mode.flyweight;

/**
 * A FlyWeight
 */
public interface Font  {
    /**
     * Set font.
     *
     * @param color the color
     * @param size  the size
     */
    public abstract void SetFont(String color, int size);

    /**
     * Get font.
     */
    public abstract void GetFont();
}