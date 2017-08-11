package com.core.java.v1.v1ch10. applet;

import javax.swing.*;
import java.awt.*;

/**
 * The type Not hello world.
 */
public class NotHelloWorld extends JApplet
{
   public void init()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
               add(label);
            }
         });
   }
}