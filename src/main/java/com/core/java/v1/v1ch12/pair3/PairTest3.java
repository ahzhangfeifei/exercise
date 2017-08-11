package com.core.java.v1.v1ch12.pair3;

/**
 * The type Pair test 3.
 */
public class PairTest3
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
      Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
      Pair<Manager> buddies = new Pair<>(ceo, cfo);      
      printBuddies(buddies);

      ceo.setBonus(1000000);
      cfo.setBonus(500000);
      Manager[] managers = { ceo, cfo };

      Pair<Employee> result = new Pair<>();
      minmaxBonus(managers, result);
      System.out.println("first: " + result.getFirst().getName() 
         + ", second: " + result.getSecond().getName());
      maxminBonus(managers, result);
      System.out.println("first: " + result.getFirst().getName() 
         + ", second: " + result.getSecond().getName());
   }

   /**
    * Print buddies.
    *
    * @param p the p
    */
   public static void printBuddies(Pair<? extends Employee> p)
   {
      Employee first = p.getFirst();
      Employee second = p.getSecond();
      System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
   }

   /**
    * Minmax bonus.
    *
    * @param a      the a
    * @param result the result
    */
   public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
   {
      if (a == null || a.length == 0) return;
      Manager min = a[0];
      Manager max = a[0];
      for (int i = 1; i < a.length; i++)
      {
         if (min.getBonus() > a[i].getBonus()) min = a[i];
         if (max.getBonus() < a[i].getBonus()) max = a[i];
      }
      result.setFirst(min);
      result.setSecond(max);
   }

   /**
    * Maxmin bonus.
    *
    * @param a      the a
    * @param result the result
    */
   public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
   {
      minmaxBonus(a, result);
      PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
   }
}

/**
 * The type Pair alg.
 */
class PairAlg
{
   /**
    * Has nulls boolean.
    *
    * @param p the p
    * @return the boolean
    */
   public static boolean hasNulls(Pair<?> p)
   {
      return p.getFirst() == null || p.getSecond() == null;
   }

   /**
    * Swap.
    *
    * @param p the p
    */
   public static void swap(Pair<?> p) { swapHelper(p); }

   /**
    * Swap helper.
    *
    * @param <T> the type parameter
    * @param p   the p
    */
   public static <T> void swapHelper(Pair<T> p)
   {
      T t = p.getFirst();
      p.setFirst(p.getSecond());
      p.setSecond(t);
   }
}


