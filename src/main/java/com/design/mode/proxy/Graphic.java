package com.design.mode.proxy;

/**
 * A graphic interface that proxy and real object should implement
 * so a proxy can proxy several real object
 */
public interface Graphic  {
    /**
     * Draw.
     */
    public abstract void Draw();
    
}