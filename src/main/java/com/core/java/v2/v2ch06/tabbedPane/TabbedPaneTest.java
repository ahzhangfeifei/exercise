package com.core.java.v2.v2ch06. tabbedPane;

import javax.swing.*;
import java.awt.*;

/**
 * The type Tabbed pane test.
 */
public class TabbedPaneTest
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

               JFrame frame = new TabbedPaneFrame();
               frame.setTitle("TabbedPaneTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

