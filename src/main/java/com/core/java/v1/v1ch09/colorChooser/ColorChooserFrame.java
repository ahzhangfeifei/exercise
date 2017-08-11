package com.core.java.v1.v1ch09. colorChooser;

import javax.swing.*;

/**
 * The type Color chooser frame.
 */
public class ColorChooserFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   /**
    * Instantiates a new Color chooser frame.
    */
   public ColorChooserFrame()
   {      
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add color chooser panel to frame

      ColorChooserPanel panel = new ColorChooserPanel();
      add(panel);
   }
}