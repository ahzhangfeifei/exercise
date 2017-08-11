package com.design.mode.adapter;

/**
 * The Adaptee in this sample
 * Text 对象
 * Created by zhangfeifei on 2016/12/02.
 */
public class Text  {
    private String content;

    /**
     * Instantiates a new Text.
     */
    public Text() {
        
    }

    /**
     * Set content.
     *
     * @param str the str
     */
    public void SetContent(String str) {
        content = str;
    }

    /**
     * Get content string.
     *
     * @return the string
     */
    public String GetContent() {
        return content;
    }
}