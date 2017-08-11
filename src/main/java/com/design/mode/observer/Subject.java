package com.design.mode.observer;

import java.util.*;

/**
 *  Subject interface
 *  In this interface , we can only declare top 3 function,
 *  other function we can define in an abstract class which implements
 *  this interface
 */
public interface Subject  {
    /**
     * Attach.
     *
     * @param o the o
     */
    public abstract void attach(Observer o);

    /**
     * Detach.
     *
     * @param o the o
     */
    public abstract void detach(Observer o);

    /**
     * Send notify.
     */
    public abstract void sendNotify();

    /**
     * Gets state.
     *
     * @return the state
     */
    public abstract Vector getState();

    /**
     * Sets state.
     *
     * @param act the act
     * @param str the str
     */
    public abstract void setState(String act, String str);
}