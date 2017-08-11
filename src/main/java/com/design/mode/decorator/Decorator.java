package com.design.mode.decorator;

/**
 * The Decorator
 * Created by zhangfeifei on 2016/12/08.
 */
public class Decorator implements Component {
    private Component component;

    /**
     * Instantiates a new Decorator.
     *
     * @param c the c
     */
    public Decorator(Component c) {
        component = c;
    }
    public void PrintString(String s) {
        component.PrintString(s);
    }
}