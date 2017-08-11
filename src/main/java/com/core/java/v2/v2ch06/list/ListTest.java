package com.core.java.v2.v2ch06. list;

import javax.swing.*;
import java.awt.*;

/**
 * The type List test.
 */
public class ListTest
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
               JFrame frame = new ListFrame();
               frame.setTitle("ListTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}