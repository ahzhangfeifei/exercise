package com.core.java.v1.v1ch09. gridbag;

import javax.swing.*;
import java.awt.*;

/**
 * The type Grid bag layout test.
 */
public class GridBagLayoutTest
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
               frame.setTitle("GridBagLayoutTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}