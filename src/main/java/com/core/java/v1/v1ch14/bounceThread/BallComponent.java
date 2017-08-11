package com.core.java.v1.v1ch14.bounceThread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The type Ball component.
 */
public class BallComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 450;
   private static final int DEFAULT_HEIGHT = 350;

   private java.util.List<Ball> balls = new ArrayList<>();

   /**
    * Add.
    *
    * @param b the b
    */
   public void add(Ball b)
   {
      balls.add(b);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (Ball b : balls)
      {
         g2.fill(b.getShape());
      }
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
