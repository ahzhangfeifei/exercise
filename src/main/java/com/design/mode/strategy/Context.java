package com.design.mode.strategy;

/**
 *  The context user used
 */
public class Context  {
    private Strategy strategy = null;
    private int lineWidth;
    private int lineCount;
    private String text;

    /**
     * Instantiates a new Context.
     */
    public Context() {
        lineWidth = 10;
        lineCount = 0;
    }

    /**
     * Sets strategy.
     *
     * @param s the s
     */
    public void setStrategy(Strategy s) {
        if(s != null) {
            strategy = s;
        }
    }

    /**
     * Draw text.
     */
    public void drawText() {
        strategy.drawText(text, lineWidth, lineCount);
    }

    /**
     * Sets text.
     *
     * @param str the str
     */
    public void setText(String str) {
        text = str;
    }

    /**
     * Sets line width.
     *
     * @param width the width
     */
    public void setLineWidth(int width) {
        lineWidth = width;
    }

    /**
     * Sets line count.
     *
     * @param count the count
     */
    public void setLineCount(int count) {
        lineCount = count;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }
}