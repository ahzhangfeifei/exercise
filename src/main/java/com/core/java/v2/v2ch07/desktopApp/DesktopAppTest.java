package com.core.java.v2.v2ch07. desktopApp;

import javax.swing.*;
import java.awt.*;

/**
 * The type Desktop app test.
 */
public class DesktopAppTest
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
               JFrame frame = new DesktopAppFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}