package com.core.java.v1.v1ch14.synch2;

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
    * @throws InterruptedException the interrupted exception
    */
   public synchronized void transfer(int from, int to, double amount) throws InterruptedException
   {
      while (accounts[from] < amount)
         wait();
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.printf(" %10.2f from %d to %d", amount, from, to);
      accounts[to] += amount;
      System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
      notifyAll();
   }

   /**
    * Gets total balance.
    *
    * @return the total balance
    */
   public synchronized double getTotalBalance()
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
