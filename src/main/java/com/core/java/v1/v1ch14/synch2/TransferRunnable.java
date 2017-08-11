package com.core.java.v1.v1ch14.synch2;

/**
 * The type Transfer runnable.
 */
public class TransferRunnable implements Runnable
{
   private Bank bank;
   private int fromAccount;
   private double maxAmount;
   private int DELAY = 10;

   /**
    * Instantiates a new Transfer runnable.
    *
    * @param b    the b
    * @param from the from
    * @param max  the max
    */
   public TransferRunnable(Bank b, int from, double max)
   {
      bank = b;
      fromAccount = from;
      maxAmount = max;
   }

   public void run()
   {
      try
      {
         while (true)
         {
            int toAccount = (int) (bank.size() * Math.random());
            double amount = maxAmount * Math.random();
            bank.transfer(fromAccount, toAccount, amount);
            Thread.sleep((int) (DELAY * Math.random()));
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}
