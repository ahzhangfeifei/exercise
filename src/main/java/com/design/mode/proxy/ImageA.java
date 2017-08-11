package com.design.mode.proxy;

import java.awt.*;

/**
 * The type Image a.
 */
public class ImageA implements Graphic {
    /**
     * Instantiates a new Image a.
     *
     * @param _fileName the file name
     */
    public ImageA(String _fileName) {
        fileName = _fileName;
        
    }
    public void Draw() {
        

    }

    /**
     * The Tracker.
     */
    public MediaTracker tracker;
    private int height, width;
    private String fileName;
    
}