package com.core.java.v2.v2ch07. print;

import javax.swing.*;
import java.awt.*;

/**
 * The type Print test.
 */
public class PrintTest
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
               JFrame frame = new PrintTestFrame();
               frame.setTitle("PrintTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}