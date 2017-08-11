package com.core.java.v2.v2ch12.employee;

/**
 * The type Employee test.
 */
public class EmployeeTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Harry Hacker", 35000);
      staff[1] = new Employee("Carl Cracker", 75000);
      staff[2] = new Employee("Tony Tester", 38000);

      for (Employee e : staff)
         e.raiseSalary(5);
      for (Employee e : staff)
         e.print();
   }
}
