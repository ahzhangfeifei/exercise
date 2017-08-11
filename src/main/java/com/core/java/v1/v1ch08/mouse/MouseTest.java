package com.core.java.v1.v1ch08. mouse;

import javax.swing.*;
import java.awt.*;

/**
 * The type Mouse test.
 */
public class MouseTest
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
               JFrame frame = new MouseFrame();
               frame.setTitle("MouseTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}