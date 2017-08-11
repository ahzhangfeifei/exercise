package com.design.mode.decorator;
/**
 *  A Concrete Component
 *  Created by zhangfeifei on 2016/12/08.
 */
public class ConcreteComponent implements Component {
    /**
     * Instantiates a new Concrete component.
     */
    public ConcreteComponent() {
    }
    public void PrintString(String s) {
        System.out.println("Input String is:" + s);
    }
}