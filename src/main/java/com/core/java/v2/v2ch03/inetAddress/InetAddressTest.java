package com.core.java.v2.v2ch03. inetAddress;

import java.io.IOException;
import java.net.InetAddress;

/**
 * The type Inet address test.
 */
public class InetAddressTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException the io exception
    */
   public static void main(String[] args) throws IOException
   {
      if (args.length > 0)
      {
         String host = args[0];
         InetAddress[] addresses = InetAddress.getAllByName(host);
         for (InetAddress a : addresses)
            System.out.println(a);
      }
      else
      {
         InetAddress localHostAddress = InetAddress.getLocalHost();
         System.out.println(localHostAddress);
      }
   }
}
