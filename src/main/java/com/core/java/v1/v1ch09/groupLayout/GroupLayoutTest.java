package com.core.java.v1.v1ch09. groupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The type Group layout test.
 */
public class GroupLayoutTest
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
               JFrame frame = new FontFrame();
               frame.setTitle("GroupLayoutTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}