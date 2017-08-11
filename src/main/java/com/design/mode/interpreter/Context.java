package com.design.mode.interpreter;

import java.util.*;

/**
 *  A Context to record variable value
 */
public class Context  {
    private Hashtable context = new Hashtable();

    /**
     * Assign.
     *
     * @param name the name
     * @param val  the val
     */
    public void Assign(String name, boolean val) {
        context.put(name, new Boolean(val));
    }

    /**
     * Look up boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean LookUp(String name) {
        return ((Boolean)context.get(name)).booleanValue();
    }

    /**
     * Instantiates a new Context.
     */
    public Context() {
    }
}