package com.design.mode.bridge;

/**
 * The ConcreteImplementor
 */
public class TextImpLinux implements TextImp {
    /**
     * Instantiates a new Text imp linux.
     */
    public TextImpLinux() {
    }
    public void DrawTextImp() {
        System.out.println("The text has a Linux style !");
    }
}