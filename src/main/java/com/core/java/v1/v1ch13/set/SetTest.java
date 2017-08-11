package com.core.java.v1.v1ch13.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * The type Set test.
 */
public class SetTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      Set<String> words = new HashSet<>(); // HashSet implements Set
      long totalTime = 0;

      Scanner in = new Scanner(System.in);
      while (in.hasNext())
      {
         String word = in.next();
         long callTime = System.currentTimeMillis();
         words.add(word);
         callTime = System.currentTimeMillis() - callTime;
         totalTime += callTime;
      }

      Iterator<String> iter = words.iterator();
      for (int i = 1; i <= 20 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
   }
}
