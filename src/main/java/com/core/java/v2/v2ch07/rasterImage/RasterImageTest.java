package com.core.java.v2.v2ch07. rasterImage;

import javax.swing.*;
import java.awt.*;

/**
 * The type Raster image test.
 */
public class RasterImageTest
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
               JFrame frame = new RasterImageFrame();
               frame.setTitle("RasterImageTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}