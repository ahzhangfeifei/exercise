package com.core.java.v2.v2ch06. internalFrame;

import javax.swing.*;
import java.awt.*;

/**
 * The type Internal frame test.
 */
public class InternalFrameTest
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
               JFrame frame = new DesktopFrame();
               frame.setTitle("InternalFrameTest");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}