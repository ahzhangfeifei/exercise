package com.core.java.v1.v1ch09. dataExchange;

import javax.swing.*;
import java.awt.*;

/**
 * The type Data exchange test.
 */
public class DataExchangeTest
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
               JFrame frame = new DataExchangeFrame();
               frame.setTitle("DataExchangeTest");      
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

