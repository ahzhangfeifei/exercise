package com.core.java.v1.v1ch05. equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * The type Employee.
 */
public class Employee
{
   private String name;
   private double salary;
   private Date hireDay;

   /**
    * Instantiates a new Employee.
    *
    * @param n     the n
    * @param s     the s
    * @param year  the year
    * @param month the month
    * @param day   the day
    */
   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      hireDay = calendar.getTime();
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
    * Gets hire day.
    *
    * @return the hire day
    */
   public Date getHireDay()
   {
      return hireDay;
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

   public boolean equals(Object otherObject)
   {
      // a quick test to see if the objects are identical
      if (this == otherObject) return true;

      // must return false if the explicit parameter is null
      if (otherObject == null) return false;

      // if the classes don't match, they can't be equal
      if (getClass() != otherObject.getClass()) return false;

      // now we know otherObject is a non-null Employee
      Employee other = (Employee) otherObject;

      // test whether the fields have identical values
      return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
   }

   public int hashCode()
   {
      return Objects.hash(name, salary, hireDay); 
   }

   public String toString()
   {
      return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
            + "]";
   }
}
