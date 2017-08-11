package com.core.java.v2.v2ch12.printf4;
import java.io.PrintWriter;

/**
 * The type Printf 4.
 */
class Printf4
{
   /**
    * Fprint.
    *
    * @param ps     the ps
    * @param format the format
    * @param x      the x
    */
   public static native void fprint(PrintWriter ps, String format, double x);

   static
   {
      System.loadLibrary("Printf4");
   }
}
