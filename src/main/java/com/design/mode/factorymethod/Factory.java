package com.design.mode.factorymethod;

/**
 * Created by zhangfeifei on 2016/12/08.
 */

public class Factory {
    /**
     * Create window window.
     *
     * @param type the type
     * @return the window
     */
    public Window CreateWindow (String type) {
        if(type.equals("Big")) {
            return new WindowBig();
        } else if(type.equals("Small")) {
            return new WindowSmall();
        } else {
            return new WindowBig();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
// The Main function only for our test
    public static void main(String[] args) {
        Factory myFactory = new Factory();
        Window myBigWindow = myFactory.CreateWindow("Big");
        myBigWindow.func();

        Window mySmallWindow = myFactory.CreateWindow("Small");
        mySmallWindow.func();
    }
}