package com.core.java.v1.v1ch09. dialog;

import javax.swing.*;
import java.awt.*;

/**
 * The type Dialog test.
 */
public class DialogTest
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
               JFrame frame = new DialogFrame();
               frame.setTitle("DialogTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}