package com.core.java.v2.v2ch09. aes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

/**
 * The type Aes test.
 */
public class AESTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws IOException              the io exception
    * @throws GeneralSecurityException the general security exception
    * @throws ClassNotFoundException   the class not found exception
    */
   public static void main(String[] args)
      throws IOException, GeneralSecurityException, ClassNotFoundException
   {
      if (args[0].equals("-genkey"))
      {
         KeyGenerator keygen = KeyGenerator.getInstance("AES");
         SecureRandom random = new SecureRandom();
         keygen.init(random);
         SecretKey key = keygen.generateKey();
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1])))
         {
            out.writeObject(key);
         }
      }
      else
      {
         int mode;
         if (args[0].equals("-encrypt")) mode = Cipher.ENCRYPT_MODE;
         else mode = Cipher.DECRYPT_MODE;

         try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
            InputStream in = new FileInputStream(args[1]);
            OutputStream out = new FileOutputStream(args[2]))
         {
            Key key = (Key) keyIn.readObject();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            Util.crypt(in, out, cipher);
         }
      }
   }
}

