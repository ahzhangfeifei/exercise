package com.core.java.v1.v1ch05. abstractClasses;

/**
 * The type Student.
 */
public class Student extends Person
{
   private String major;

   /**
    * Instantiates a new Student.
    *
    * @param n the n
    * @param m the m
    */
   public Student(String n, String m)
   {
      // pass n to superclass constructor
      super(n);
      major = m;
   }

   public String getDescription()
   {
      return "a student majoring in " + major;
   }
}
