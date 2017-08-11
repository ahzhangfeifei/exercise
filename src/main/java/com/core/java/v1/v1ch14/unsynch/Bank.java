package com.core.java.v1.v1ch14.unsynch;

/**
 * The type Bank.
 */
public class Bank
{
   private final double[] accounts;

   /**
    * Instantiates a new Bank.
    *
    * @param n              the n
    * @param initialBalance the initial balance
    */
   public Bank(int n, double initialBalance)
   {
      accounts = new double[n];
      for (int i = 0; i < accounts.length; i++)
         accounts[i] = initialBalance;
   }

   /**
    * Transfer.
    *
    * @param from   the from
    * @param to     the to
    * @param amount the amount
    */
   public void transfer(int from, int to, double amount)
   {
      if (accounts[from] < amount) return;
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(" %10.2f from %d to %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
   }

   /**
    * Gets total balance.
    *
    * @return the total balance
    */
   public double getTotalBalance()
   {
      double sum = 0;

      for (double a : accounts)
         sum += a;

      return sum;
   }

   /**
    * Size int.
    *
    * @return the int
    */
   public int size()
   {
      return accounts.length;
   }
}
