package com.core.java.v1.v1ch09. text;

import javax.swing.*;
import java.awt.*;

/**
 * The type Text component test.
 */
public class TextComponentTest
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
               JFrame frame = new TextComponentFrame();
               frame.setTitle("TextComponentTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

