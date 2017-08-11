package com.core.java.v1.v1ch05. equals;

/**
 * The type Manager.
 */
public class Manager extends Employee
{
   private double bonus;

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
      bonus = 0;
   }

   public double getSalary()
   {
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }

   /**
    * Sets bonus.
    *
    * @param b the b
    */
   public void setBonus(double b)
   {
      bonus = b;
   }

   public boolean equals(Object otherObject)
   {
      if (!super.equals(otherObject)) return false;
      Manager other = (Manager) otherObject;
      // super.equals checked that this and other belong to the same class
      return bonus == other.bonus;
   }

   public int hashCode()
   {
      return super.hashCode() + 17 * new Double(bonus).hashCode();
   }

   public String toString()
   {
      return super.toString() + "[bonus=" + bonus + "]";
   }
}

