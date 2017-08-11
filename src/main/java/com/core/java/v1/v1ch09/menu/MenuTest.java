package com.core.java.v1.v1ch09. menu;

import javax.swing.*;
import java.awt.*;

/**
 * The type Menu test.
 */
public class MenuTest
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
               JFrame frame = new MenuFrame();
               frame.setTitle("MenuTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}