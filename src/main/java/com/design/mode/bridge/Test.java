package com.design.mode.bridge;

/**
 * A test client
 * 桥接模式
 * Created by zhangfeifei on 2016/12/03.
 */
public class Test  {
    /**
     * Instantiates a new Test.
     */
    public Test() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Text myText = new TextBold("Mac");
        myText.DrawText("=== A test String ===");

        myText =  new TextBold("Linux");
        myText.DrawText("=== A test String ===");

        System.out.println("------------------------------------------");
        
        myText =  new TextItalic("Mac");
        myText.DrawText("=== A test String ===");

        myText =  new TextItalic("Linux");
        myText.DrawText("=== A test String ===");        
    }
}