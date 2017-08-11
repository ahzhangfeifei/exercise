package com.core.java.v1.v1ch09. calculator;

import javax.swing.*;
import java.awt.*;

/**
 * The type Calculator.
 */
public class Calculator
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
               CalculatorFrame frame = new CalculatorFrame();
               frame.setTitle("Calculator");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}
