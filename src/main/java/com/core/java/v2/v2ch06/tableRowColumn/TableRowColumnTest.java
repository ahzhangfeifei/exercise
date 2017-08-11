package com.core.java.v2.v2ch06. tableRowColumn;

import javax.swing.*;
import java.awt.*;

/**
 * The type Table row column test.
 */
public class TableRowColumnTest
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
               JFrame frame = new PlanetTableFrame();
               frame.setTitle("TableRowColumnTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}