package com.core.java.v1.v1ch06. anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * The type Anonymous inner class test.
 */
public class AnonymousInnerClassTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock();
      clock.start(1000, true);

      // keep program running until user selects "Ok"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * The type Talking clock.
 */
class TalkingClock
{
   /**
    * Start.
    *
    * @param interval the interval
    * @param beep     the beep
    */
   public void start(int interval, final boolean beep)
   {
      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               Date now = new Date();
               System.out.println("At the tone, the time is " + now);
               if (beep) Toolkit.getDefaultToolkit().beep();
            }
         };
      Timer t = new Timer(interval, listener);
      t.start();
   }
}
