package com.design.mode.proxy;
import javax.swing.*;

/**
 * The type Page proxy.
 */
public class PageProxy extends JPanel  {
    /**
     * Instantiates a new Page proxy.
     */
    public PageProxy() {
        label = new JLabel("Loading web page !!!!!");
        this.add(label);
    }

    /**
     * The Label.
     */
    public JLabel label;
}