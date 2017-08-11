package com.core.java.v1.v1ch07. sizedFrame;

import javax.swing.*;
import java.awt.*;

/**
 * The type Sized frame test.
 */
public class SizedFrameTest
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
               JFrame frame = new SizedFrame();
               frame.setTitle("SizedFrame");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Sized frame.
 */
class SizedFrame extends JFrame
{
   /**
    * Instantiates a new Sized frame.
    */
   public SizedFrame()
   {
      // get screen dimensions

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
      int screenHeight = screenSize.height;
      int screenWidth = screenSize.width;

      // set frame width, height and let platform pick screen location

      setSize(screenWidth / 2, screenHeight / 2);
      setLocationByPlatform(true);

      // set frame icon

      Image img = new ImageIcon("icon.gif").getImage();
      setIconImage(img);      
   }
}
