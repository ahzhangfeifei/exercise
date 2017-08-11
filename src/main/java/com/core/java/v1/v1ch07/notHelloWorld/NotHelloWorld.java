package com.core.java.v1.v1ch07. notHelloWorld;

import javax.swing.*;
import java.awt.*;

/**
 * The type Not hello world.
 */
public class NotHelloWorld
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new NotHelloWorldFrame();
               frame.setTitle("NotHelloWorld");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Not hello world frame.
 */
class NotHelloWorldFrame extends JFrame
{
   /**
    * Instantiates a new Not hello world frame.
    */
   public NotHelloWorldFrame()
   {
      add(new NotHelloWorldComponent());
      pack();
   }
}

/**
 * The type Not hello world component.
 */
class NotHelloWorldComponent extends JComponent
{
   /**
    * The constant MESSAGE_X.
    */
   public static final int MESSAGE_X = 75;
   /**
    * The constant MESSAGE_Y.
    */
   public static final int MESSAGE_Y = 100;

   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   public void paintComponent(Graphics g)
   {
      g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
