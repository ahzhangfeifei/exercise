package com.core.java.v1.v1ch09. slider;

import javax.swing.*;
import java.awt.*;

/**
 * The type Slider test.
 */
public class SliderTest
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
               SliderFrame frame = new SliderFrame();
               frame.setTitle("SliderTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}