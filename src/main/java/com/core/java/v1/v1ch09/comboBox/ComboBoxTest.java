package com.core.java.v1.v1ch09. comboBox;

import javax.swing.*;
import java.awt.*;

/**
 * The type Combo box test.
 */
public class ComboBoxTest
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
               JFrame frame = new ComboBoxFrame();
               frame.setTitle("ComboBoxTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}