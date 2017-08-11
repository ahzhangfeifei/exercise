package com.core.java.v1.v1ch09. calculator;

import javax.swing.*;

/**
 * The type Calculator frame.
 */
public class CalculatorFrame extends JFrame
{
   /**
    * Instantiates a new Calculator frame.
    */
   public CalculatorFrame()
   {
      add(new CalculatorPanel());
      pack();
   }
}
