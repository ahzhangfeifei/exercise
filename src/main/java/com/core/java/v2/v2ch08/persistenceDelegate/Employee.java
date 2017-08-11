package com.core.java.v2.v2ch08. persistenceDelegate;

import java.util.Date;
import java.util.GregorianCalendar;

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
         // GregorianCalendar uses 0 for January
      hireDay = calendar.getTime();
   }

   /**
    * Instantiates a new Employee.
    *
    * @param n the n
    * @param s the s
    * @param h the h
    */
   public Employee(String n, double s, Date h)
   {  
      name = n;
      salary = s;
      hireDay = h;
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
}
