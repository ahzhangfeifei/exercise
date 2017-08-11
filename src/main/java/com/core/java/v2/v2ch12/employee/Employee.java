package com.core.java.v2.v2ch12.employee;

/**
 * The type Employee.
 */
public class Employee
{
   private String name;
   private double salary;

   /**
    * Raise salary.
    *
    * @param byPercent the by percent
    */
   public native void raiseSalary(double byPercent);

   /**
    * Instantiates a new Employee.
    *
    * @param n the n
    * @param s the s
    */
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   /**
    * Print.
    */
   public void print()
   {
      System.out.println(name + " " + salary);
   }

   static
   {
      System.loadLibrary("Employee");
   }
}
