package com.design.mode.bridge;

/**
 * The Abstract of Text
 * Created by zhangfeifei on 2016/12/03.
 */
public abstract class Text  {
    /**
     * Draw text.
     *
     * @param text the text
     */
    public abstract void DrawText(String text);

    /**
     * Get text imp text imp.
     *
     * @param type the type
     * @return the text imp
     */
    protected TextImp GetTextImp(String type) {
        if(type.equals("Mac")) {
            return new TextImpMac();
        } else if(type.equals("Linux")) {
            return new TextImpLinux();
        } else {
            return new TextImpMac();
        }
    }
}