package com.design.mode.strategy;

/**
 * The public interface to support varies arithmetic
 */
public interface Strategy {
    /**
     * Draw text.
     *
     * @param s         the s
     * @param lineWidth the line width
     * @param lineCount the line count
     */
    public void drawText(String s, int lineWidth, int lineCount);
}