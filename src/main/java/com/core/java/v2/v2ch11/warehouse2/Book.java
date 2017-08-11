package com.core.java.v2.v2ch11.warehouse2;

/**
 * The type Book.
 */
public class Book extends Product
{
   private String isbn;

   /**
    * Instantiates a new Book.
    *
    * @param title the title
    * @param isbn  the isbn
    * @param price the price
    */
   public Book(String title, String isbn, double price)
   {
      super(title, price);
      this.isbn = isbn;
   }
   
   public String getDescription()
   {
      return super.getDescription() + " " + isbn;
   }  
}
