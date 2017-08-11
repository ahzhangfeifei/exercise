package com.core.java.v1.v1ch04.ParamTest;

/**
 * The type Param test.
 */
public class ParamTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      /*
       * Test 1: Methods can't modify numeric parameters
       */
      System.out.println("Testing tripleValue:");
      double percent = 10;
      System.out.println("Before: percent=" + percent);
      tripleValue(percent);
      System.out.println("After: percent=" + percent);

      /*
       * Test 2: Methods can change the state of object parameters
       */
      System.out.println("\nTesting tripleSalary:");
      Employee harry = new Employee("Harry", 50000);
      System.out.println("Before: salary=" + harry.getSalary());
      tripleSalary(harry);
      System.out.println("After: salary=" + harry.getSalary());

      /*
       * Test 3: Methods can't attach new objects to object parameters
       */
      System.out.println("\nTesting swap:");
      Employee a = new Employee("Alice", 70000);
      Employee b = new Employee("Bob", 60000);
      System.out.println("Before: a=" + a.getName());
      System.out.println("Before: b=" + b.getName());
      swap(a, b);
      System.out.println("After: a=" + a.getName());
      System.out.println("After: b=" + b.getName());
   }

   /**
    * Triple value.
    *
    * @param x the x
    */
   public static void tripleValue(double x) // doesn't work
   {
      x = 3 * x;
      System.out.println("End of method: x=" + x);
   }

   /**
    * Triple salary.
    *
    * @param x the x
    */
   public static void tripleSalary(Employee x) // works
   {
      x.raiseSalary(200);
      System.out.println("End of method: salary=" + x.getSalary());
   }

   /**
    * Swap.
    *
    * @param x the x
    * @param y the y
    */
   public static void swap(Employee x, Employee y)
   {
      Employee temp = x;
      x = y;
      y = temp;
      System.out.println("End of method: x=" + x.getName());
      System.out.println("End of method: y=" + y.getName());
   }
}

/**
 * The type Employee.
 */
class Employee // simplified Employee class
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
}
