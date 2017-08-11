package com.core.java.v1.v1ch14.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The type Blocking queue test.
 */
public class BlockingQueueTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter base directory (e.g. /usr/local/jdk1.6.0/src): ");
      String directory = in.nextLine();
      System.out.print("Enter keyword (e.g. volatile): ");
      String keyword = in.nextLine();

      final int FILE_QUEUE_SIZE = 10;
      final int SEARCH_THREADS = 100;

      BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

      FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
      new Thread(enumerator).start();
      for (int i = 1; i <= SEARCH_THREADS; i++)
         new Thread(new SearchTask(queue, keyword)).start();
   }
}

/**
 * The type File enumeration task.
 */
class FileEnumerationTask implements Runnable
{
   /**
    * The constant DUMMY.
    */
   public static File DUMMY = new File("");
   private BlockingQueue<File> queue;
   private File startingDirectory;

   /**
    * Instantiates a new File enumeration task.
    *
    * @param queue             the queue
    * @param startingDirectory the starting directory
    */
   public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory)
   {
      this.queue = queue;
      this.startingDirectory = startingDirectory;
   }

   public void run()
   {
      try
      {
         enumerate(startingDirectory);
         queue.put(DUMMY);
      }
      catch (InterruptedException e)
      {
      }
   }

   /**
    * Enumerate.
    *
    * @param directory the directory
    * @throws InterruptedException the interrupted exception
    */
   public void enumerate(File directory) throws InterruptedException
   {
      File[] files = directory.listFiles();
      for (File file : files)
      {
         if (file.isDirectory()) enumerate(file);
         else queue.put(file);
      }
   }
}

/**
 * The type Search task.
 */
class SearchTask implements Runnable
{
   private BlockingQueue<File> queue;
   private String keyword;

   /**
    * Instantiates a new Search task.
    *
    * @param queue   the queue
    * @param keyword the keyword
    */
   public SearchTask(BlockingQueue<File> queue, String keyword)
   {
      this.queue = queue;
      this.keyword = keyword;
   }

   public void run()
   {
      try
      {
         boolean done = false;
         while (!done)
         {
            File file = queue.take();
            if (file == FileEnumerationTask.DUMMY)
            {
               queue.put(file);
               done = true;
            }
            else search(file);
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      catch (InterruptedException e)
      {
      }
   }

   /**
    * Search.
    *
    * @param file the file
    * @throws IOException the io exception
    */
   public void search(File file) throws IOException
   {
      try (Scanner in = new Scanner(file))
      {
         int lineNumber = 0;
         while (in.hasNextLine())
         {
            lineNumber++;
            String line = in.nextLine();
            if (line.contains(keyword)) 
               System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
         }
      }
   }
}
