package com.core.java.v2.v2ch09. jaas;

import java.security.Principal;
import java.util.Objects;

/**
 * The type Simple principal.
 */
public class SimplePrincipal implements Principal
{
   private String descr;
   private String value;

   /**
    * Instantiates a new Simple principal.
    *
    * @param descr the descr
    * @param value the value
    */
   public SimplePrincipal(String descr, String value)
   {
      this.descr = descr;
      this.value = value;
   }

   public String getName()
   {
      return descr + "=" + value;
   }

   public boolean equals(Object otherObject)
   {
      if (this == otherObject) return true;
      if (otherObject == null) return false;
      if (getClass() != otherObject.getClass()) return false;
      SimplePrincipal other = (SimplePrincipal) otherObject;
      return Objects.equals(getName(), other.getName());
   }

   public int hashCode()
   {
      return Objects.hashCode(getName());
   }
}
