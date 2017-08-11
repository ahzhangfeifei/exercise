package com.core.java.v1.v1ch05. methods;

import java.lang.reflect.Method;

/**
 * The type Method table test.
 */
public class MethodTableTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws Exception the exception
    */
   public static void main(String[] args) throws Exception
   {
      // get method pointers to the square and sqrt methods
      Method square = MethodTableTest.class.getMethod("square", double.class);
      Method sqrt = Math.class.getMethod("sqrt", double.class);

      // print tables of x- and y-values

      printTable(1, 10, 10, square);
      printTable(1, 10, 10, sqrt);
   }

   /**
    * Square double.
    *
    * @param x the x
    * @return the double
    */
   public static double square(double x)
   {
      return x * x;
   }

   /**
    * Print table.
    *
    * @param from the from
    * @param to   the to
    * @param n    the n
    * @param f    the f
    */
   public static void printTable(double from, double to, int n, Method f)
   {
      // print out the method as table header
      System.out.println(f);

      double dx = (to - from) / (n - 1);

      for (double x = from; x <= to; x += dx)
      {
         try
         {
            double y = (Double) f.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
}
