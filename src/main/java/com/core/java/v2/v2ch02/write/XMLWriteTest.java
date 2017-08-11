package com.core.java.v2.v2ch02. write;

import javax.swing.*;
import java.awt.*;

/**
 * The type Xml write test.
 */
public class XMLWriteTest
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
               JFrame frame = new XMLWriteFrame();
               frame.setTitle("XMLWriteTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}