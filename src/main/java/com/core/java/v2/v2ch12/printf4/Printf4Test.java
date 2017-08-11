package com.core.java.v2.v2ch12.printf4;
import java.io.PrintWriter;

/**
 * The type Printf 4 test.
 */
class Printf4Test
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
      /* This call will throw an exception--note the %% */
      Printf4.fprint(out, "Amount due = %%8.2f\n", amountDue);
      out.flush();
   }
}
