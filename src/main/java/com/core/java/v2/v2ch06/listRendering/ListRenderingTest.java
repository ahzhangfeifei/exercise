package com.core.java.v2.v2ch06. listRendering;

import javax.swing.*;
import java.awt.*;

/**
 * The type List rendering test.
 */
public class ListRenderingTest
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
               JFrame frame = new ListRenderingFrame();
               frame.setTitle("ListRenderingTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}