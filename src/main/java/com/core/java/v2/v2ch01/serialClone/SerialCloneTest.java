package com.core.java.v2.v2ch01. serialClone;

/**
   @version 1.20 17 Aug 1998
   @author Cay Horstmann
*/

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The type Serial clone test.
 */
public class SerialCloneTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {  
      Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
      // clone harry
      Employee harry2 = (Employee) harry.clone();

      // mutate harry
      harry.raiseSalary(10);

      // now harry and the clone are different
      System.out.println(harry);
      System.out.println(harry2);
   }
}

/**
 * The type Serial cloneable.
 */
class SerialCloneable implements Cloneable, Serializable
{  
   public Object clone()
   {  
      try
      {  
         // save the object to a byte array
         ByteArrayOutputStream bout = new ByteArrayOutputStream();
         ObjectOutputStream out = new ObjectOutputStream(bout);
         out.writeObject(this);
         out.close();

         // read a clone of the object from the byte array
         ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
         ObjectInputStream in = new ObjectInputStream(bin);
         Object ret = in.readObject();
         in.close();

         return ret;
      }  
      catch (Exception e)
      {  
         return null;
      }
   }
}

/**
 * The type Employee.
 */
class Employee extends SerialCloneable
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

   public String toString()
   {  
      return getClass().getName()
         + "[name=" + name
         + ",salary=" + salary
         + ",hireDay=" + hireDay
         + "]";
   }
}
