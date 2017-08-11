package com.core.java.v1.v1ch04.ConstructorTest;
import java.util.Random;

/**
 * The type Constructor test.
 */
public class ConstructorTest
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

      staff[0] = new Employee("Harry", 40000);
      staff[1] = new Employee(60000);
      staff[2] = new Employee();

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
               + e.getSalary());
   }
}

/**
 * The type Employee.
 */
class Employee
{
   private static int nextId;

   private int id;
   private String name = ""; // instance field initialization
   private double salary;
  
   // static initialization block
   static
   {
      Random generator = new Random();
      // set nextId to a random number between 0 and 9999
      nextId = generator.nextInt(10000);
   }

   // object initialization block
   {
      id = nextId;
      nextId++;
   }

   /**
    * Instantiates a new Employee.
    *
    * @param n the n
    * @param s the s
    */
// three overloaded constructors
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
   }

   /**
    * Instantiates a new Employee.
    *
    * @param s the s
    */
   public Employee(double s)
   {
      // calls the Employee(String, double) constructor
      this("Employee #" + nextId, s);
   }

   /**
    * Instantiates a new Employee.
    */
// the default constructor
   public Employee()
   {
      // name initialized to ""--see above
      // salary not explicitly set--initialized to 0
      // id initialized in initialization block
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
}
