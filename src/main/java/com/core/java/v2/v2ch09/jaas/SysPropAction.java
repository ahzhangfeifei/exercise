package com.core.java.v2.v2ch09. jaas;

import java.security.PrivilegedAction;

/**
 * The type Sys prop action.
 */
public class SysPropAction implements PrivilegedAction<String>
{
   private String propertyName;

   /**
    * Instantiates a new Sys prop action.
    *
    * @param propertyName the property name
    */
   public SysPropAction(String propertyName)
   {
      this.propertyName = propertyName;
   }

   public String run()
   {
      return System.getProperty(propertyName);
   }
}
