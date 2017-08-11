package com.core.java.v1.v1ch09. toolBar;

import javax.swing.*;
import java.awt.*;

/**
 * The type Tool bar test.
 */
public class ToolBarTest
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
               ToolBarFrame frame = new ToolBarFrame();
               frame.setTitle("ToolBarTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}