package com.core.java.v1.v1ch08. action;

import javax.swing.*;
import java.awt.*;

/**
 * The type Action test.
 */
public class ActionTest
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
               JFrame frame = new ActionFrame();
               frame.setTitle("ActionTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}