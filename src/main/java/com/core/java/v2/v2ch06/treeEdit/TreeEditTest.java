package com.core.java.v2.v2ch06. treeEdit;

import javax.swing.*;
import java.awt.*;

/**
 * The type Tree edit test.
 */
public class TreeEditTest
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
               JFrame frame = new TreeEditFrame();
               frame.setTitle("TreeEditTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}