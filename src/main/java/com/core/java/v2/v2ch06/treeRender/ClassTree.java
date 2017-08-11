package com.core.java.v2.v2ch06. treeRender;

import javax.swing.*;
import java.awt.*;

/**
 * The type Class tree.
 */
public class ClassTree
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
               JFrame frame = new ClassTreeFrame();
               frame.setTitle("ClassTree");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

