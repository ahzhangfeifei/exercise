package com.core.java.v2.v2ch12.printf2;

/**
 * The type Printf 2.
 */
class Printf2
{
   /**
    * Sprint string.
    *
    * @param format the format
    * @param x      the x
    * @return the string
    */
   public static native String sprint(String format, double x);

   static
   {
      System.loadLibrary("Printf2");
   }
}
