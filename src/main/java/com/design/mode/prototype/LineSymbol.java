package com.design.mode.prototype;

/**
 *  A concrete prototype to draw a line
 */
public class LineSymbol extends Graphic {
    /**
     * Instantiates a new Line symbol.
     */
    public LineSymbol() {
    }

    public void DoSomething() {
        System.out.println("I am used to draw a line !");
    }
}