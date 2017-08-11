package com.core.java.v1.v1ch09. circleLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The type Circle layout test.
 */
public class CircleLayoutTest
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
               JFrame frame = new CircleLayoutFrame();
               frame.setTitle("CircleLayoutTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}