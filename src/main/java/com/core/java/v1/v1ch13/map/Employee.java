package com.core.java.v1.v1ch13.map;

/**
 * The type Employee.
 */
public class Employee
{
   private String name;
   private double salary;

   /**
    * Instantiates a new Employee.
    *
    * @param n the n
    */
   public Employee(String n)
   {
      name = n;
      salary = 0;
   }

   public String toString()
   {
      return "[name=" + name + ", salary=" + salary + "]";
   }
}
