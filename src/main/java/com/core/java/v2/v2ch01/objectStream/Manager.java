package com.core.java.v2.v2ch01. objectStream;

/**
 * The type Manager.
 */
public class Manager extends Employee
{
   private Employee secretary;

   /**
    * Instantiates a new Manager.
    *
    * @param n     the n
    * @param s     the s
    * @param year  the year
    * @param month the month
    * @param day   the day
    */
   public Manager(String n, double s, int year, int month, int day)
   {
      super(n, s, year, month, day);
      secretary = null;
   }

   /**
    * Sets secretary.
    *
    * @param s the s
    */
   public void setSecretary(Employee s)
   {
      secretary = s;
   }

   public String toString()
   {
      return super.toString() + "[secretary=" + secretary + "]";
   }
}
