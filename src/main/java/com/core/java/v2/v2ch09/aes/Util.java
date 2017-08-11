package com.core.java.v2.v2ch09. aes;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

/**
 * The type Util.
 */
public class Util
{
   /**
    * Crypt.
    *
    * @param in     the in
    * @param out    the out
    * @param cipher the cipher
    * @throws IOException              the io exception
    * @throws GeneralSecurityException the general security exception
    */
   public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException,
         GeneralSecurityException
   {
      int blockSize = cipher.getBlockSize();
      int outputSize = cipher.getOutputSize(blockSize);
      byte[] inBytes = new byte[blockSize];
      byte[] outBytes = new byte[outputSize];

      int inLength = 0;
      ;
      boolean more = true;
      while (more)
      {
         inLength = in.read(inBytes);
         if (inLength == blockSize)
         {
            int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
            out.write(outBytes, 0, outLength);
         }
         else more = false;
      }
      if (inLength > 0) outBytes = cipher.doFinal(inBytes, 0, inLength);
      else outBytes = cipher.doFinal();
      out.write(outBytes);
   }
}
