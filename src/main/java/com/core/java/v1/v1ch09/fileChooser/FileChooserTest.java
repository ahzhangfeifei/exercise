package com.core.java.v1.v1ch09. fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * The type File chooser test.
 */
public class FileChooserTest
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
               JFrame frame = new ImageViewerFrame();
               frame.setTitle("FileChooserTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

