package com.core.java.v2.v2ch09. hash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/**
 * The type Digest.
 */
public class Digest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException              the io exception
    * @throws GeneralSecurityException the general security exception
    */
   public static void main(String[] args) throws IOException, GeneralSecurityException
   {
      String algname = args.length >= 2 ? args[1] : "SHA-1";                     
      MessageDigest alg = MessageDigest.getInstance(algname);
      byte[] input = Files.readAllBytes(Paths.get(args[0]));
      byte[] hash = alg.digest(input);
      String d = "";
      for (int i = 0; i < hash.length; i++)
      {
         int v = hash[i] & 0xFF;
         if (v < 16) d += "0";
         d += Integer.toString(v, 16).toUpperCase() + " ";
      }
      System.out.println(d);
   }
}
