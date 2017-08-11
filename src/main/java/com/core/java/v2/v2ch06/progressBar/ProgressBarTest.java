package com.core.java.v2.v2ch06. progressBar;

import javax.swing.*;
import java.awt.*;

/**
 * The type Progress bar test.
 */
public class ProgressBarTest
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
               JFrame frame = new ProgressBarFrame();
               frame.setTitle("ProgressBarTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
