package com.core.java.v2.v2ch10. compiler;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

/**
 * The type String builder java source.
 */
public class StringBuilderJavaSource extends SimpleJavaFileObject
{
   private StringBuilder code;

   /**
    * Instantiates a new String builder java source.
    *
    * @param name the name
    */
   public StringBuilderJavaSource(String name)
   {
      super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), 
         Kind.SOURCE);
      code = new StringBuilder();
   }

   public CharSequence getCharContent(boolean ignoreEncodingErrors)
   {
      return code;
   }

   /**
    * Append.
    *
    * @param str the str
    */
   public void append(String str)
   {
      code.append(str);
      code.append('\n');
   }
}
