package com.core.java.v1.v1ch04.StaticTest;
/**
 * The type Static test.
 */
public class StaticTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      // fill the staff array with three Employee objects
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Tom", 40000);
      staff[1] = new Employee("Dick", 60000);
      staff[2] = new Employee("Harry", 65000);

      // print out information about all Employee objects
      for (Employee e : staff)
      {
         e.setId();
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
               + e.getSalary());
      }

      int n = Employee.getNextId(); // calls static method
      System.out.println("Next available id=" + n);
   }
}

/**
 * The type Employee.
 */
class Employee
{
   private static int nextId = 1;

   private String name;
   private double salary;
   private int id;

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
      id = 0;
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
    * Gets id.
    *
    * @return the id
    */
   public int getId()
   {
      return id;
   }

   /**
    * Sets id.
    */
   public void setId()
   {
      id = nextId; // set id to next available id
      nextId++;
   }

   /**
    * Gets next id.
    *
    * @return the next id
    */
   public static int getNextId()
   {
      return nextId; // returns static field
   }

   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args) // unit test
   {
      Employee e = new Employee("Harry", 50000);
      System.out.println(e.getName() + " " + e.getSalary());
   }
}
