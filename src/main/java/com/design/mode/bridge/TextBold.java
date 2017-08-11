package com.design.mode.bridge;

/**
 * The RefinedAbstraction
 * Created by zhangfeifei on 2016/12/03.
 */

public class TextBold extends Text {
    private TextImp imp;

    /**
     * Instantiates a new Text bold.
     *
     * @param type the type
     */
    public TextBold(String type) {
        imp = GetTextImp(type);
    }
    public void DrawText(String text) {
        System.out.println(text);
        System.out.println("The text is bold text!");
        imp.DrawTextImp();
    }
}