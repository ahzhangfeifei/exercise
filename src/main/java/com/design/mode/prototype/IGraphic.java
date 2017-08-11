package com.design.mode.prototype;

import java.io.*;

/**
 * The interface Graphic.
 *
 */
public interface IGraphic extends Cloneable, Serializable {
    /**
     * Gets name.
     *
     * @return the name
     */
    String getName() ;

    /**
     * Sets name.
     *
     * @param gName the g name
     */
    void setName(String gName);
}