package com.core.java.v1.v1ch14.threadPool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * The type Thread pool test.
 */
public class ThreadPoolTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws Exception the exception
    */
   public static void main(String[] args) throws Exception
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
      String directory = in.nextLine();
      System.out.print("Enter keyword (e.g. volatile): ");
      String keyword = in.nextLine();

      ExecutorService pool = Executors.newCachedThreadPool();

      MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
      Future<Integer> result = pool.submit(counter);

      try
      {
         System.out.println(result.get() + " matching files.");
      }
      catch (ExecutionException e)
      {
         e.printStackTrace();
      }
      catch (InterruptedException e)
      {
      }
      pool.shutdown();

      int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
      System.out.println("largest pool size=" + largestPoolSize);
   }
}

/**
 * The type Match counter.
 */
class MatchCounter implements Callable<Integer>
{
   private File directory;
   private String keyword;
   private ExecutorService pool;
   private int count;

   /**
    * Instantiates a new Match counter.
    *
    * @param directory the directory
    * @param keyword   the keyword
    * @param pool      the pool
    */
   public MatchCounter(File directory, String keyword, ExecutorService pool)
   {
      this.directory = directory;
      this.keyword = keyword;
      this.pool = pool;
   }

   public Integer call()
   {
      count = 0;
      try
      {
         File[] files = directory.listFiles();
         List<Future<Integer>> results = new ArrayList<>();

         for (File file : files)
            if (file.isDirectory())
            {
               MatchCounter counter = new MatchCounter(file, keyword, pool);
               Future<Integer> result = pool.submit(counter);
               results.add(result);
            }
            else
            {
               if (search(file)) count++;
            }

         for (Future<Integer> result : results)
            try
            {
               count += result.get();
            }
            catch (ExecutionException e)
            {
               e.printStackTrace();
            }
      }
      catch (InterruptedException e)
      {
      }
      return count;
   }

   /**
    * Search boolean.
    *
    * @param file the file
    * @return the boolean
    */
   public boolean search(File file)
   {
      try
      {
         try (Scanner in = new Scanner(file))
         {
            boolean found = false;
            while (!found && in.hasNextLine())
            {
               String line = in.nextLine();
               if (line.contains(keyword)) found = true;
            }         
            return found;
         }
      }
      catch (IOException e)
      {
         return false;
      }
   }
}
