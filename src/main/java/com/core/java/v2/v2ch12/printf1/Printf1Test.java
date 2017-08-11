package com.core.java.v2.v2ch12.printf1;

/**
 * The type Printf 1 test.
 */
class Printf1Test
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      int count = Printf1.print(8, 4, 3.14);
      count += Printf1.print(8, 4, count);
      System.out.println();
      for (int i = 0; i < count; i++)
         System.out.print("-");
      System.out.println();
   }
}
