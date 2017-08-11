package com.core.java.v1.v1ch09. circleLayout;

import javax.swing.*;

/**
 * The type Circle layout frame.
 */
public class CircleLayoutFrame extends JFrame
{
   /**
    * Instantiates a new Circle layout frame.
    */
   public CircleLayoutFrame()
   {
      setLayout(new CircleLayout());
      add(new JButton("Yellow"));
      add(new JButton("Blue"));
      add(new JButton("Red"));
      add(new JButton("Green"));
      add(new JButton("Orange"));
      add(new JButton("Fuchsia"));
      add(new JButton("Indigo"));
      pack();
   }
}
