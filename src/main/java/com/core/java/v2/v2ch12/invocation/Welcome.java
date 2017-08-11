package com.core.java.v2.v2ch12.invocation;

/**
 * The type Welcome.
 */
public class Welcome
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      String[] greeting = new String[3];
      greeting[0] = "Welcome to Core Java";
      greeting[1] = "by Cay Horstmann";
      greeting[2] = "and Gary Cornell";

      for (String g : greeting)
         System.out.println(g);
   }
}
