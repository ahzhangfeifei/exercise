package com.core.java.v2.v2ch06. textChange;

import javax.swing.*;
import java.awt.*;

/**
 * The type Change tracking test.
 */
public class ChangeTrackingTest
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
               JFrame frame = new ColorFrame();
               frame.setTitle("ChangeTrackingTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}