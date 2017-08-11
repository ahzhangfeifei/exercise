package com.core.java.v1.v1ch09. colorChooser;

import javax.swing.*;
import java.awt.*;

/**
 * The type Color chooser test.
 */
public class ColorChooserTest
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
               JFrame frame = new ColorChooserFrame();
               frame.setTitle("ColorChooserTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}



