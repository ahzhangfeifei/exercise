package com.design.mode.singleton;

import java.util.*;

/**
 *  A new Singleton use registry
 */
public class SingletonB  {
    static private Hashtable registry = new Hashtable();
    //static private SingletonB instance;

    /**
     * Register.
     *
     * @param name      the name
     * @param aInstance the a instance
     */
    public static void Register(String name, SingletonB aInstance) {
        registry.put(name, aInstance);
    }

    /**
     * Get instance singleton b.
     *
     * @param name the name
     * @return the singleton b
     */
    public static SingletonB GetInstance(String name) {
        return LookUp(name);
    }

    /**
     * Look up singleton b.
     *
     * @param name the name
     * @return the singleton b
     */
    protected static SingletonB LookUp(String name) {
        return (SingletonB)registry.get(name);
    }
}