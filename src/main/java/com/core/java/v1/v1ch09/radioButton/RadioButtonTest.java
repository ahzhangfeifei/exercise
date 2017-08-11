package com.core.java.v1.v1ch09. radioButton;

import javax.swing.*;
import java.awt.*;

/**
 * The type Radio button test.
 */
public class RadioButtonTest
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
               JFrame frame = new RadioButtonFrame();
               frame.setTitle("RadioButtonTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}