package com.core.java.v1.v1ch09. checkBox;

import javax.swing.*;
import java.awt.*;

/**
 * The type Check box test.
 */
public class CheckBoxTest
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
               JFrame frame = new CheckBoxFrame();
               frame.setTitle("CheckBoxTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

