package com.design.mode.mediator;

/**
 * An abstract Mediator
 */
public interface Mediator  {
    /**
     * Register.
     *
     * @param c    the c
     * @param type the type
     */
    void Register(Colleague c, String type);

    /**
     * Changed.
     *
     * @param type the type
     */
    void Changed(String type);
}