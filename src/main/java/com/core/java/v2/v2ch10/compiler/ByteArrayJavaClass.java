package com.core.java.v2.v2ch10. compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * The type Byte array java class.
 */
public class ByteArrayJavaClass extends SimpleJavaFileObject
{
   private ByteArrayOutputStream stream;

   /**
    * Instantiates a new Byte array java class.
    *
    * @param name the name
    */
   public ByteArrayJavaClass(String name)
   {
      super(URI.create("bytes:///" + name), Kind.CLASS);
      stream = new ByteArrayOutputStream();
   }

   public OutputStream openOutputStream() throws IOException
   {
      return stream;
   }

   /**
    * Get bytes byte [ ].
    *
    * @return the byte [ ]
    */
   public byte[] getBytes()
   {
      return stream.toByteArray();
   }
}
