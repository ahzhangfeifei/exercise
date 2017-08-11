package com.core.java.v2.v2ch06. progressMonitorInputStream;

import javax.swing.*;
import java.awt.*;

/**
 * The type Progress monitor input stream test.
 */
public class ProgressMonitorInputStreamTest
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
               JFrame frame = new TextFrame();
               frame.setTitle("ProgressMonitorInputStreamTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}