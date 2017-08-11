package com.core.java.v2.v2ch12.printf3;
import java.io.PrintWriter;

/**
 * The type Printf 3.
 */
class Printf3
{
   /**
    * Fprint.
    *
    * @param out    the out
    * @param format the format
    * @param x      the x
    */
   public static native void fprint(PrintWriter out, String format, double x);

   static
   {
      System.loadLibrary("Printf3");
   }
}
