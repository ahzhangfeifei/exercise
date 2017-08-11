package com.design.mode.prototype;

import java.util.*;

/**
 *  A Symbol Loader to register all prototype instance
 */
public class SymbolLoader  {
    private Hashtable symbols = new Hashtable();

    /**
     * Instantiates a new Symbol loader.
     */
    public SymbolLoader() {
           symbols.put("Line", new LineSymbol());
           symbols.put("Note", new NoteSymbol());
    }

    /**
     * Gets symbols.
     *
     * @return the symbols
     */
    public Hashtable getSymbols() {
        return symbols;
    }
}