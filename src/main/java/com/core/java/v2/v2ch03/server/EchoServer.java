package com.core.java.v2.v2ch03. server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The type Echo server.
 */
public class EchoServer
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException the io exception
    */
   public static void main(String[] args) throws IOException
   {
      // establish server socket
      try (ServerSocket s = new ServerSocket(8189))
      {
         // wait for client connection
         try (Socket incoming = s.accept())
         {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
   
            try (Scanner in = new Scanner(inStream))
            {
               PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
      
               out.println("Hello! Enter BYE to exit.");
      
               // echo client input
               boolean done = false;
               while (!done && in.hasNextLine())
               {
                  String line = in.nextLine();
                  out.println("Echo: " + line);
                  if (line.trim().equals("BYE")) done = true;
               }
            }
         }
      }
   }
}