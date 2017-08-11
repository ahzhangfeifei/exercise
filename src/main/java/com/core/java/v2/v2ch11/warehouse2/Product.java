package com.core.java.v2.v2ch11.warehouse2;
import java.io.Serializable;

/**
 * The type Product.
 */
public class Product implements Serializable
{
   private String description;
   private double price;
   private Warehouse location;

   /**
    * Instantiates a new Product.
    *
    * @param description the description
    * @param price       the price
    */
   public Product(String description, double price)
   {
      this.description = description;
      this.price = price;
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

   /**
    * Gets price.
    *
    * @return the price
    */
   public double getPrice()
   {
      return price;
   }

   /**
    * Gets location.
    *
    * @return the location
    */
   public Warehouse getLocation()
   {
      return location;
   }

   /**
    * Sets location.
    *
    * @param location the location
    */
   public void setLocation(Warehouse location)
   {
      this.location = location;
   }
}
