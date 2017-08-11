package com.core.java.v2.v2ch09. jaas;

import javax.swing.*;
import java.awt.*;

/**
 * The type Jaas test.
 */
public class JAASTest
{
   /**
    * Main.
    *
    * @param args the args
    */
   public static void main(final String[] args)
   {
      System.setSecurityManager(new SecurityManager());
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new JAASFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setTitle("JAASTest");
               frame.setVisible(true);
            }
         });
   }
}
