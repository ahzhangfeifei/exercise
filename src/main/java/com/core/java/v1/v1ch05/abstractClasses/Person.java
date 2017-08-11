package com.core.java.v1.v1ch05. abstractClasses;

/**
 * The type Person.
 */
public abstract class Person
{
   /**
    * Gets description.
    *
    * @return the description
    */
   public abstract String getDescription();
   private String name;

   /**
    * Instantiates a new Person.
    *
    * @param n the n
    */
   public Person(String n)
   {
      name = n;
   }

   /**
    * Gets name.
    *
    * @return the name
    */
   public String getName()
   {
      return name;
   }
}
