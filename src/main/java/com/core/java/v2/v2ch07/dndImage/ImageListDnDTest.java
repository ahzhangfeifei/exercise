package com.core.java.v2.v2ch07. dndImage;

import javax.swing.*;
import java.awt.*;

/**
 * The type Image list dn d test.
 */
public class ImageListDnDTest
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
               JFrame frame = new ImageListDnDFrame();
               frame.setTitle("ImageListDnDTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
