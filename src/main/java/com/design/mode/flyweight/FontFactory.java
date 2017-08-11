package com.design.mode.flyweight;

import java.util.*;

/**
 *  A Flyweight Factory
 */
public class FontFactory  {
    private Hashtable charHashTable = new Hashtable();

    /**
     * Instantiates a new Font factory.
     */
    public FontFactory() {
    }

    /**
     * Get fly weight font.
     *
     * @param s the s
     * @return the font
     */
    public Font GetFlyWeight(String s) {
        if(charHashTable.get(s) != null) {
            return (Font)charHashTable.get(s);
        } else {
            Font tmp = new ConcreteFont(s);
            charHashTable.put(s, tmp);
            return tmp;
        }
    }

    /**
     * Get factory hashtable.
     *
     * @return the hashtable
     */
    public Hashtable GetFactory() {
        return charHashTable;
    }
}