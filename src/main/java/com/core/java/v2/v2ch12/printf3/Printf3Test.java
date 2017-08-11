package com.core.java.v2.v2ch12.printf3;
import java.io.PrintWriter;

/**
 * The type Printf 3 test.
 */
class Printf3Test
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
      PrintWriter out = new PrintWriter(System.out);
      Printf3.fprint(out, "Amount due = %8.2f\n", amountDue);
      out.flush();
   }
}
