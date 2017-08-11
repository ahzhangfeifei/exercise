package com.core.java.v2.v2ch01. zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The type Zip test.
 */
public class ZipTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException the io exception
    */
   public static void main(String[] args) throws IOException
   {
      String zipname = args[0];
      showContents(zipname);
      System.out.println("---");
      showContents2(zipname);
   }

   /**
    * Show contents.
    *
    * @param zipname the zipname
    * @throws IOException the io exception
    */
   public static void showContents(String zipname) throws IOException
   {
      // Here, we use the classic zip API
      try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname)))
      {
         ZipEntry entry;
         while ((entry = zin.getNextEntry()) != null)
         {
            System.out.println(entry.getName());
            
            Scanner in = new Scanner(zin);
            while (in.hasNextLine())
               System.out.println("   " + in.nextLine());
            // DO NOT CLOSE in            
            zin.closeEntry();
         }
      }
   }

   /**
    * Show contents 2.
    *
    * @param zipname the zipname
    * @throws IOException the io exception
    */
   public static void showContents2(String zipname) throws IOException
   {
      // Here, we make a Java SE 7 file system
      FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname), null);
      Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>()
         {
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException
            {               
               System.out.println(path);
               for (String line : Files.readAllLines(path, Charset.forName("UTF-8")))
                  System.out.println("   " + line);
               return FileVisitResult.CONTINUE;
            }
         });
   }
}