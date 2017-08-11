package com.core.java.v2.v2ch06. textFormat;

import javax.swing.*;
import java.awt.*;

/**
 * The type Format test.
 */
public class FormatTest
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
               JFrame frame = new FormatTestFrame();
               frame.setTitle("FormatTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

