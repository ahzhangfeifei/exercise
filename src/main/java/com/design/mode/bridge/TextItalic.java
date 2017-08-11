package com.design.mode.bridge;

/**
 * The RefinedAbstraction
 * Created by zhangfeifei on 2016/12/05.
 */
public class TextItalic extends Text {
    private TextImp imp;

    /**
     * Instantiates a new Text italic.
     *
     * @param type the type
     */
    public TextItalic(String type) {
        imp = GetTextImp(type);
    }
    public void DrawText(String text) {
        System.out.println(text);
        System.out.println("The text is italic text!");
        imp.DrawTextImp();
    }
}