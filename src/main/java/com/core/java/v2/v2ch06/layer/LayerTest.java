package com.core.java.v2.v2ch06. layer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Layer test.
 */
public class LayerTest
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
               JFrame frame = new ColorFrame();
               frame.setTitle("LayerTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}