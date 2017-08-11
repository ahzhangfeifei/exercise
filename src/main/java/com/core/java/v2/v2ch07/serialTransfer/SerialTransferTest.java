package com.core.java.v2.v2ch07. serialTransfer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Serial transfer test.
 */
public class SerialTransferTest
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
               JFrame frame = new SerialTransferFrame();
               frame.setTitle("SerialTransferTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}