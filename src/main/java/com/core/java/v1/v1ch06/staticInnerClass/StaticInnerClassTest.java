package com.core.java.v1.v1ch06. staticInnerClass;

/**
 * The type Static inner class test.
 */
public class StaticInnerClassTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      double[] d = new double[20];
      for (int i = 0; i < d.length; i++)
         d[i] = 100 * Math.random();
      ArrayAlg.Pair p = ArrayAlg.minmax(d);
      System.out.println("min = " + p.getFirst());
      System.out.println("max = " + p.getSecond());
   }
}

/**
 * The type Array alg.
 */
class ArrayAlg
{
   /**
    * The type Pair.
    */
   public static class Pair
   {
      private double first;
      private double second;

      /**
       * Instantiates a new Pair.
       *
       * @param f the f
       * @param s the s
       */
      public Pair(double f, double s)
      {
         first = f;
         second = s;
      }

      /**
       * Gets first.
       *
       * @return the first
       */
      public double getFirst()
      {
         return first;
      }

      /**
       * Gets second.
       *
       * @return the second
       */
      public double getSecond()
      {
         return second;
      }
   }

   /**
    * Minmax pair.
    *
    * @param values the values
    * @return the pair
    */
   public static Pair minmax(double[] values)
   {
      double min = Double.MAX_VALUE;
      double max = Double.MIN_VALUE;
      for (double v : values)
      {
         if (min > v) min = v;
         if (max < v) max = v;
      }
      return new Pair(min, max);
   }
}
