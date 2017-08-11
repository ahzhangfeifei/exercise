package com.core.java.v2.v2ch07. imageTransfer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Image transfer test.
 */
public class ImageTransferTest
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
               JFrame frame = new ImageTransferFrame();
               frame.setTitle("ImageTransferTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

