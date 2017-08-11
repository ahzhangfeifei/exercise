package com.design.mode.singleton;

/**
 * A user defined exception
 */
public class SingletonException extends RuntimeException {
    /**
     * Instantiates a new Singleton exception.
     */
    public SingletonException() {
        super();
    }

    /**
     * Instantiates a new Singleton exception.
     *
     * @param s the s
     */
    public SingletonException(String s) {
        super(s);
    }
    
}