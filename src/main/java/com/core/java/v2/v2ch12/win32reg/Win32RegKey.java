package com.core.java.v2.v2ch12.win32reg;

import java.util.Enumeration;

/**
 * The type Win 32 reg key.
 */
public class Win32RegKey
{
   /**
    * The constant HKEY_CLASSES_ROOT.
    */
   public static final int HKEY_CLASSES_ROOT = 0x80000000;
   /**
    * The constant HKEY_CURRENT_USER.
    */
   public static final int HKEY_CURRENT_USER = 0x80000001;
   /**
    * The constant HKEY_LOCAL_MACHINE.
    */
   public static final int HKEY_LOCAL_MACHINE = 0x80000002;
   /**
    * The constant HKEY_USERS.
    */
   public static final int HKEY_USERS = 0x80000003;
   /**
    * The constant HKEY_CURRENT_CONFIG.
    */
   public static final int HKEY_CURRENT_CONFIG = 0x80000005;
   /**
    * The constant HKEY_DYN_DATA.
    */
   public static final int HKEY_DYN_DATA = 0x80000006;

   private int root;
   private String path;

   /**
    * Gets value.
    *
    * @param name the name
    * @return the value
    */
   public native Object getValue(String name);

   /**
    * Sets value.
    *
    * @param name  the name
    * @param value the value
    */
   public native void setValue(String name, Object value);

   /**
    * Instantiates a new Win 32 reg key.
    *
    * @param theRoot the the root
    * @param thePath the the path
    */
   public Win32RegKey(int theRoot, String thePath)
   {
      root = theRoot;
      path = thePath;
   }

   /**
    * Names enumeration.
    *
    * @return the enumeration
    */
   public Enumeration<String> names()
   {
      return new Win32RegKeyNameEnumeration(root, path);
   }

   static
   {
      System.loadLibrary("Win32RegKey");
   }
}

/**
 * The type Win 32 reg key name enumeration.
 */
class Win32RegKeyNameEnumeration implements Enumeration<String>
{
   public native String nextElement();
   public native boolean hasMoreElements();
   private int root;
   private String path;
   private int index = -1;
   private int hkey = 0;
   private int maxsize;
   private int count;

   /**
    * Instantiates a new Win 32 reg key name enumeration.
    *
    * @param theRoot the the root
    * @param thePath the the path
    */
   Win32RegKeyNameEnumeration(int theRoot, String thePath)
   {
      root = theRoot;
      path = thePath;
   }
}

/**
 * The type Win 32 reg key exception.
 */
class Win32RegKeyException extends RuntimeException
{
   /**
    * Instantiates a new Win 32 reg key exception.
    */
   public Win32RegKeyException()
   {
   }

   /**
    * Instantiates a new Win 32 reg key exception.
    *
    * @param why the why
    */
   public Win32RegKeyException(String why)
   {
      super(why);
   }
}
