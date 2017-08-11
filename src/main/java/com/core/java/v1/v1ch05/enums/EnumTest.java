package com.core.java.v1.v1ch05. enums;

import java.util.Scanner;

/**
 * The type Enum test.
 */
public class EnumTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
      String input = in.next().toUpperCase();
      Size size = Enum.valueOf(Size.class, input);
      System.out.println("size=" + size);
      System.out.println("abbreviation=" + size.getAbbreviation());
      if (size == Size.EXTRA_LARGE)
         System.out.println("Good job--you paid attention to the _.");      
   }
}

/**
 * The enum Size.
 */
enum Size
{
   /**
    * Small size.
    */
   SMALL("S"), /**
 * Medium size.
 */
MEDIUM("M"), /**
 * Large size.
 */
LARGE("L"), /**
 * Extra large size.
 */
EXTRA_LARGE("XL");

   private Size(String abbreviation) { this.abbreviation = abbreviation; }

   /**
    * Gets abbreviation.
    *
    * @return the abbreviation
    */
   public String getAbbreviation() { return abbreviation; }

   private String abbreviation;
}
