package com.core.java.v2.v2ch06. tableCellRender;

import javax.swing.*;
import java.awt.*;

/**
 * The type Table cell render test.
 */
public class TableCellRenderTest
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

               JFrame frame = new TableCellRenderFrame();
               frame.setTitle("TableCellRenderTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}