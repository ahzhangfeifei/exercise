package com.core.java.v1.v1ch08. plaf;

import javax.swing.*;
import java.awt.*;

/**
 * The type Plaf test.
 */
public class PlafTest
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
               JFrame frame = new PlafFrame();
               frame.setTitle("PlafTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}