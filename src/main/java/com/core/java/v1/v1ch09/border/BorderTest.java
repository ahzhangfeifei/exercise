package com.core.java.v1.v1ch09. border;

import javax.swing.*;
import java.awt.*;

/**
 * The type Border test.
 */
public class BorderTest
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
               JFrame frame = new BorderFrame();
               frame.setTitle("BorderTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
