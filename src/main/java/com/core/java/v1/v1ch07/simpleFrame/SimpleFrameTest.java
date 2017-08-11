package com.core.java.v1.v1ch07. simpleFrame;

import javax.swing.*;
import java.awt.*;

/**
 * The type Simple frame test.
 */
public class SimpleFrameTest
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
               SimpleFrame frame = new SimpleFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Simple frame.
 */
class SimpleFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   /**
    * Instantiates a new Simple frame.
    */
   public SimpleFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
   }
}
