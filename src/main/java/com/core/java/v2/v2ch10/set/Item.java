package com.core.java.v2.v2ch10. set;

import com.core.java.v2.v2ch10.bytecodeAnnotations.LogEntry;

import java.util.Objects;

/**
 * The type Item.
 */
public class Item
{
   private String description;
   private int partNumber;

   /**
    * Instantiates a new Item.
    *
    * @param aDescription the a description
    * @param aPartNumber  the a part number
    */
   public Item(String aDescription, int aPartNumber)
   {
      description = aDescription;
      partNumber = aPartNumber;
   }

   /**
    * Gets description.
    *
    * @return the description
    */
   public String getDescription()
   {
      return description;
   }

   public String toString()
   {
      return "[description=" + description + ", partNumber=" + partNumber + "]";
   }

   @LogEntry(logger = "global")
   public boolean equals(Object otherObject)
   {
      if (this == otherObject) return true;
      if (otherObject == null) return false;
      if (getClass() != otherObject.getClass()) return false;
      Item other = (Item) otherObject;
      return Objects.equals(description, other.description) && partNumber == other.partNumber;
   }

   @LogEntry(logger = "global")
   public int hashCode()
   {
      return Objects.hash(description, partNumber);
   }
}
