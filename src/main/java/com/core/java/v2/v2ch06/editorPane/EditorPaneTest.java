package com.core.java.v2.v2ch06. editorPane;

import javax.swing.*;
import java.awt.*;

/**
 * The type Editor pane test.
 */
public class EditorPaneTest
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
               JFrame frame = new EditorPaneFrame();
               frame.setTitle("EditorPaneTest");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
