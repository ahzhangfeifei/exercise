package com.core.java.v2.v2ch01.findDirectories;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * The type Find directories.
 */
public class FindDirectories
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException the io exception
    */
   public static void main(String[] args) throws IOException
   {
      Path dir = Paths.get(args.length == 0 ? System.getProperty("user.home") : args[0]);
      Files.walkFileTree(dir, new SimpleFileVisitor<Path>()
         {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
            {               
               if (attrs.isDirectory()) 
                  System.out.println(file);
               return FileVisitResult.CONTINUE;
            }
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
            {
               return FileVisitResult.CONTINUE;
            }
         });
   }
}
