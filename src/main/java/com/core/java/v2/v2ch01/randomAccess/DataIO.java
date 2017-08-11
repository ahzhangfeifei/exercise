package com.core.java.v2.v2ch01. randomAccess;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * The type Data io.
 */
public class DataIO
{
   /**
    * Read fixed string string.
    *
    * @param size the size
    * @param in   the in
    * @return the string
    * @throws IOException the io exception
    */
   public static String readFixedString(int size, DataInput in)
      throws IOException
   {  
      StringBuilder b = new StringBuilder(size);
      int i = 0;
      boolean more = true;
      while (more && i < size)
      {  
         char ch = in.readChar();
         i++;
         if (ch == 0) more = false;
         else b.append(ch);
      }
      in.skipBytes(2 * (size - i));
      return b.toString();
   }

   /**
    * Write fixed string.
    *
    * @param s    the s
    * @param size the size
    * @param out  the out
    * @throws IOException the io exception
    */
   public static void writeFixedString(String s, int size, DataOutput out)
      throws IOException
   {
      for (int i = 0; i < size; i++)
      {  
         char ch = 0;
         if (i < s.length()) ch = s.charAt(i);
         out.writeChar(ch);
      }
   }
}
