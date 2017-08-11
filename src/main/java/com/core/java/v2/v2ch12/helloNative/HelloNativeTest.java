package com.core.java.v2.v2ch12.helloNative;

/**
 * The type Hello native test.
 */
class HelloNativeTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {  
      HelloNative.greeting();
   }

   static
   {  
      System.loadLibrary("HelloNative");
   }
}
