package com.core.java.v1.v1ch13.treeSet;

import java.util.Objects;

/**
 * The type Item.
 */
public class Item implements Comparable<Item>
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

      return "[descripion=" + description + ", partNumber=" + partNumber + "]";
   }

   public boolean equals(Object otherObject)
   {
      if (this == otherObject) return true;
      if (otherObject == null) return false;
      if (getClass() != otherObject.getClass()) return false;
      Item other = (Item) otherObject;
      return Objects.equals(description, other.description) && partNumber == other.partNumber;
   }

   public int hashCode()
   {
      return Objects.hash(description, partNumber);
   }

   public int compareTo(Item other)
   {
      return Integer.compare(partNumber, other.partNumber);
   }
}
