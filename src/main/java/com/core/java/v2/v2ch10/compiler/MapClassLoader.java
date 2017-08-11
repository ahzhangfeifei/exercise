package com.core.java.v2.v2ch10. compiler;

import java.util.Map;

/**
 * The type Map class loader.
 */
public class MapClassLoader extends ClassLoader
{
   private Map<String, byte[]> classes;

   /**
    * Instantiates a new Map class loader.
    *
    * @param classes the classes
    */
   public MapClassLoader(Map<String, byte[]> classes)
   {
      this.classes = classes;
   }

   protected Class<?> findClass(String name) throws ClassNotFoundException
   {
      byte[] classBytes = classes.get(name);
      if (classBytes == null) throw new ClassNotFoundException(name);
      Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
      if (cl == null) throw new ClassNotFoundException(name);
      return cl;
   }
}
