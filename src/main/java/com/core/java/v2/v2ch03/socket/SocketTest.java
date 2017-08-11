package com.core.java.v2.v2ch03. socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * The type Socket test.
 */
public class SocketTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException the io exception
    */
   public static void main(String[] args) throws IOException
   {
      try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13))
      {
         InputStream inStream = s.getInputStream();
         Scanner in = new Scanner(inStream);

         while (in.hasNextLine())
         {
            String line = in.nextLine();
            System.out.println(line);
         }
      }
   }
}
