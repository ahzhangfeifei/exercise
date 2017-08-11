package com.core.java.v1.v1ch08. button;

import javax.swing.*;
import java.awt.*;

/**
 * The type Button test.
 */
public class ButtonTest
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
               JFrame frame = new ButtonFrame();
               frame.setTitle("ButtonTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}