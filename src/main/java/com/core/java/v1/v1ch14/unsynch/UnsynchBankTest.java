package com.core.java.v1.v1ch14.unsynch;

/**
 * The type Unsynch bank test.
 */
public class UnsynchBankTest
{
   /**
    * The constant NACCOUNTS.
    */
   public static final int NACCOUNTS = 100;
   /**
    * The constant INITIAL_BALANCE.
    */
   public static final double INITIAL_BALANCE = 1000;

   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
      int i;
      for (i = 0; i < NACCOUNTS; i++)
      {
         TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
         Thread t = new Thread(r);
         t.start();
      }
   }
}
