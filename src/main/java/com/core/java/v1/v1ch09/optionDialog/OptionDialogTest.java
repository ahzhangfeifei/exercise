package com.core.java.v1.v1ch09. optionDialog;

import javax.swing.*;
import java.awt.*;

/**
 * The type Option dialog test.
 */
public class OptionDialogTest
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
               JFrame frame = new OptionDialogFrame();
               frame.setTitle("OptionDialogTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

