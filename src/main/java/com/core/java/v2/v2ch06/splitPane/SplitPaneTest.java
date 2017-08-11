package com.core.java.v2.v2ch06. splitPane;

import javax.swing.*;
import java.awt.*;

/**
 * The type Split pane test.
 */
public class SplitPaneTest
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
               JFrame frame = new SplitPaneFrame();
               frame.setTitle("SplitPaneTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}