package com.core.java.v2.v2ch06. progressMonitor;

import javax.swing.*;
import java.awt.*;

/**
 * The type Progress monitor test.
 */
public class ProgressMonitorTest
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
               JFrame frame = new ProgressMonitorFrame();
               frame.setTitle("ProgressMonitorTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}