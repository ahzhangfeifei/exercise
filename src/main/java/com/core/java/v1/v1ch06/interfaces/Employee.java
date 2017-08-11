package com.core.java.v1.v1ch06. interfaces;

/**
 * The type Employee.
 */
public class Employee implements Comparable<Employee>
{
   private String name;
   private double salary;

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
    * Gets name.
    *
    * @return the name
    */
   public String getName()
   {
      return name;
   }

   /**
    * Gets salary.
    *
    * @return the salary
    */
   public double getSalary()
   {
      return salary;
   }

   /**
    * Raise salary.
    *
    * @param byPercent the by percent
    */
   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public int compareTo(Employee other)
   {
      return Double.compare(salary, other.salary);
   }
}