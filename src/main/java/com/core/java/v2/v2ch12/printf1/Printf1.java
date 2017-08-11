package com.core.java.v2.v2ch12.printf1;

/**
 * The type Printf 1.
 */
class Printf1
{
   /**
    * Print int.
    *
    * @param width     the width
    * @param precision the precision
    * @param x         the x
    * @return the int
    */
   public static native int print(int width, int precision, double x);

   static
   {
      System.loadLibrary("Printf1");
   }
}
