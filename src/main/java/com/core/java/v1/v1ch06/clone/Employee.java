package com.core.java.v1.v1ch06. clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The type Employee.
 */
public class Employee implements Cloneable
{
   private String name;
   private double salary;
   private Date hireDay;

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
      hireDay = new Date();
   }

   public Employee clone() throws CloneNotSupportedException
   {
      // call Object.clone()
      Employee cloned = (Employee) super.clone();

      // clone mutable fields
      cloned.hireDay = (Date) hireDay.clone();

      return cloned;
   }

   /**
    * Sets hire day.
    *
    * @param year  the year
    * @param month the month
    * @param day   the day
    */
   public void setHireDay(int year, int month, int day)
   {
      Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
      
      // Example of instance field mutation
      hireDay.setTime(newHireDay.getTime());
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

   public String toString()
   {
      return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
   }
}