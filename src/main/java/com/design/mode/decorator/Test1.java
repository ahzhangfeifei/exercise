package com.design.mode.decorator;

/**
 * A simple test
 * Created by zhangfeifei on 2016/12/08.
 */
public class Test1  {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Component myComponent = new ConcreteComponent();
        myComponent.PrintString("A test String");
        Decorator myDecorator = new ConcreteDecoratorA(myComponent);
        myDecorator.PrintString("A test String");
    }
}