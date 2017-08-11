package com.core.java.v2.v2ch06. longList;

import javax.swing.*;
import java.awt.*;

/**
 * The type Long list test.
 */
public class LongListTest
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
               JFrame frame = new LongListFrame();
               frame.setTitle("LongListTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}


