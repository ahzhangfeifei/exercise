package com.core.java.v2.v2ch09. verifier;

import java.applet.Applet;
import java.awt.*;

/**
 * The type Verifier test.
 */
public class VerifierTest extends Applet
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      System.out.println("1 + 2 == " + fun());
   }

   /**
    * Fun int.
    *
    * @return the int
    */
   public static int fun()
   {
      int m;
      int n;
      m = 1;
      n = 2;
      // use hex editor to change to "m = 2" in class file
      int r = m + n;
      return r;
   }

   public void paint(Graphics g)
   {
      g.drawString("1 + 2 == " + fun(), 20, 20);
   }
}
