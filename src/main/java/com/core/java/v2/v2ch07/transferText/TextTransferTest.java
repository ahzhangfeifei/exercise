package com.core.java.v2.v2ch07. transferText;

import javax.swing.*;
import java.awt.*;

/**
 * The type Text transfer test.
 */
public class TextTransferTest
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
               JFrame frame = new TextTransferFrame();
               frame.setTitle("TextTransferTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}