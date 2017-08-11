package com.design.mode.decorator;

/**
 * The Concrete Decorator
 * Created by zhangfeifei on 2016/12/08.
 */

public class ConcreteDecoratorA extends Decorator {
    /**
     * Instantiates a new Concrete decorator a.
     *
     * @param c the c
     */
    public ConcreteDecoratorA(Component c) {
        super(c);
    }
    public void PrintString(String s) {
        super.PrintString(s);
        PrintStringLen(s);
    }

    /**
     * Print string len.
     *
     * @param s the s
     */
    public void PrintStringLen(String s) {
        System.out.println("The length of string is:" + s.length());
    }
}