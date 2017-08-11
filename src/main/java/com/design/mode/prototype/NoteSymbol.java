package com.design.mode.prototype;


/**
 *  A concrete prototype to draw a note
 */
public class NoteSymbol extends Graphic {
    /**
     * Instantiates a new Note symbol.
     */
    public NoteSymbol() {
    }

    public void DoSomething() {
        System.out.println("I am used to draw a note !");
    }
}