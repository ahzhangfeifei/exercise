package com.core.java.v1.v1ch10. systemInfo;

import java.io.IOException;
import java.util.Properties;

/**
 * The type System info.
 */
public class SystemInfo
{
   /**
    * Main.
    *
    * @param args the args
    */
   public static void main(String args[])
   {
      try
      {
         Properties sysprops = System.getProperties();
         sysprops.store(System.out, "System Properties");
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
