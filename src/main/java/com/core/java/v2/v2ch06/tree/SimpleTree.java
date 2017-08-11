package com.core.java.v2.v2ch06. tree;

import javax.swing.*;
import java.awt.*;

/**
 * The type Simple tree.
 */
public class SimpleTree
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
               JFrame frame = new SimpleTreeFrame();
               frame.setTitle("SimpleTree");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
