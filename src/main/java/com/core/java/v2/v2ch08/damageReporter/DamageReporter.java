package com.core.java.v2.v2ch08. damageReporter;

import javax.swing.*;

/**
 * The type Damage reporter.
 */
public class DamageReporter extends JFrame
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      JFrame frame = new DamageReporterFrame();
      frame.setTitle("DamageReporter");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
