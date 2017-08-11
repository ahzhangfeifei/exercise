package com.core.java.v2.v2ch06. treeModel;

import javax.swing.*;
import java.awt.*;

/**
 * The type Object inspector test.
 */
public class ObjectInspectorTest
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
               JFrame frame = new ObjectInspectorFrame();
               frame.setTitle("ObjectInspectorTest");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}



