package com.core.java.v2.v2ch07. book;

import javax.swing.*;
import java.awt.*;

/**
 * The type Book test.
 */
public class BookTest
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
               JFrame frame = new BookTestFrame();
               frame.setTitle("BookTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}