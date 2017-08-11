package com.design.mode.iterator;

/**
 * Iterator Interface
 */
public interface Iterator {
    /**
     * First.
     */
    public abstract void First();

    /**
     * Next.
     */
    public abstract void Next();

    /**
     * Is done boolean.
     *
     * @return the boolean
     */
    public abstract boolean IsDone();

    /**
     * Current item.
     */
    public abstract void CurrentItem();
}