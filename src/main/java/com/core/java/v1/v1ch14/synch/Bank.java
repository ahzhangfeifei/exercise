package com.core.java.v1.v1ch14.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The type Bank.
 */
public class Bank
{
   private final double[] accounts;
   private Lock bankLock;
   private Condition sufficientFunds;

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
      bankLock = new ReentrantLock();
      sufficientFunds = bankLock.newCondition();
   }

   /**
    * Transfer.
    *
    * @param from   the from
    * @param to     the to
    * @param amount the amount
    * @throws InterruptedException the interrupted exception
    */
   public void transfer(int from, int to, double amount) throws InterruptedException
   {
      bankLock.lock();
      try
      {
         while (accounts[from] < amount)
            sufficientFunds.await();
         System.out.print(Thread.currentThread());
         accounts[from] -= amount;
         System.out.printf(" %10.2f from %d to %d", amount, from, to);
         accounts[to] += amount;
         System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
         sufficientFunds.signalAll();
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
    * Gets total balance.
    *
    * @return the total balance
    */
   public double getTotalBalance()
   {
      bankLock.lock();
      try
      {
         double sum = 0;

         for (double a : accounts)
            sum += a;

         return sum;
      }
      finally
      {
         bankLock.unlock();
      }
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
