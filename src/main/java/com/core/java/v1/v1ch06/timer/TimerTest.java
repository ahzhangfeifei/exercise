package com.core.java.v1.v1ch06. timer;

/**
   @version 1.00 2000-04-13
   @author Cay Horstmann
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
// to resolve conflict with java.util.Timer

/**
 * The type Timer test.
 */
public class TimerTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {  
      ActionListener listener = new TimePrinter();

      // construct a timer that calls the listener
      // once every 10 seconds
      Timer t = new Timer(10000, listener);
      t.start();

      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * The type Time printer.
 */
class TimePrinter implements ActionListener
{  
   public void actionPerformed(ActionEvent event)
   {  
      Date now = new Date();
      System.out.println("At the tone, the time is " + now);
      Toolkit.getDefaultToolkit().beep();
   }
}
