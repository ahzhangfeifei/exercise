package com.core.java.v2.v2ch12.printf2;

/**
 * The type Printf 2 test.
 */
class Printf2Test
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      double price = 44.95;
      double tax = 7.75;
      double amountDue = price * (1 + tax / 100);

      String s = Printf2.sprint("Amount due = %8.2f", amountDue);
      System.out.println(s);
   }
}
