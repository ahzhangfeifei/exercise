package com.core.java.v1.v1ch13.sieve;

import java.util.BitSet;

/**
 * The type Sieve.
 */
public class Sieve
{
   /**
    * The entry point of application.
    *
    * @param s the input arguments
    */
   public static void main(String[] s)
   {
      int n = 2000000;
      long start = System.currentTimeMillis();
      BitSet b = new BitSet(n + 1);
      int count = 0;
      int i;
      for (i = 2; i <= n; i++)
         b.set(i);
      i = 2;
      while (i * i <= n)
      {
         if (b.get(i))
         {
            count++;
            int k = 2 * i;
            while (k <= n)
            {
               b.clear(k);
               k += i;
            }
         }
         i++;
      }
      while (i <= n)
      {
         if (b.get(i)) count++;
         i++;
      }
      long end = System.currentTimeMillis();
      System.out.println(count + " primes");
      System.out.println((end - start) + " milliseconds");
   }
}
