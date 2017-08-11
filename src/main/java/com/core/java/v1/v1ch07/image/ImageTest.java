package com.core.java.v1.v1ch07. image;

import javax.swing.*;
import java.awt.*;

/**
 * The type Image test.
 */
public class ImageTest
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
               JFrame frame = new ImageFrame();
               frame.setTitle("ImageTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Image frame.
 */
class ImageFrame extends JFrame
{
   /**
    * Instantiates a new Image frame.
    */
   public ImageFrame()
   {
      add(new ImageComponent());
      pack();
   }
}

/**
 * The type Image component.
 */
class ImageComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   private Image image;

   /**
    * Instantiates a new Image component.
    */
   public ImageComponent()
   {
      image = new ImageIcon("blue-ball.gif").getImage();
   }

   public void paintComponent(Graphics g)
   {
      if (image == null) return;

      int imageWidth = image.getWidth(this);
      int imageHeight = image.getHeight(this);

      // draw the image in the upper-left corner

      g.drawImage(image, 0, 0, null);
      // tile the image across the component

      for (int i = 0; i * imageWidth <= getWidth(); i++)
         for (int j = 0; j * imageHeight <= getHeight(); j++)
            if (i + j > 0) 
               g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
