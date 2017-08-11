package com.design.mode.bridge;

/**
 * The ConcreteImplementor
 * Created by zhangfeifei on 2016/12/02.
 */
public class TextImpMac implements TextImp {
    /**
     * Instantiates a new Text imp mac.
     */
    public TextImpMac() {
    }
    public void DrawTextImp() {
        System.out.println("The text has a Mac style !");
    }
}