package com.core.java.v1.v1ch08. mouse;

import javax.swing.*;

/**
 * The type Mouse frame.
 */
public class MouseFrame extends JFrame
{
   /**
    * Instantiates a new Mouse frame.
    */
   public MouseFrame()
   {
      add(new MouseComponent());
      pack();
   }
}