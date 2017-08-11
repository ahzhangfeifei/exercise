package com.core.java.v2.v2ch07. dnd;

import javax.swing.*;
import java.awt.*;

/**
 * The type Swing dn d test.
 */
public class SwingDnDTest
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
               JFrame frame = new SwingDnDFrame();
               frame.setTitle("SwingDnDTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}