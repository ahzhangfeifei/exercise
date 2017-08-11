package com.core.java.v2.v2ch06. tableSelection;

/**
 @version 1.03 2007-08-01
 @author Cay Horstmann
 */

import javax.swing.*;
import java.awt.*;

/**
 * The type Table selection test.
 */
public class TableSelectionTest
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
            JFrame frame = new TableSelectionFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         }
      });
   }
}