package com.core.java.v2.v2ch07. renderQuality;

import javax.swing.*;
import java.awt.*;

/**
 * The type Render quality test.
 */
public class RenderQualityTest
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
               JFrame frame = new RenderQualityTestFrame();
               frame.setTitle("RenderQualityTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}