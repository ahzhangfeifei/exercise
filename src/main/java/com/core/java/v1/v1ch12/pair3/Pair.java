package com.core.java.v1.v1ch12.pair3;

/**
 * The type Pair.
 *
 * @param <T> the type parameter
 */
public class Pair<T>
{
   private T first;
   private T second;

   /**
    * Instantiates a new Pair.
    */
   public Pair() { first = null; second = null; }

   /**
    * Instantiates a new Pair.
    *
    * @param first  the first
    * @param second the second
    */
   public Pair(T first, T second) { this.first = first;  this.second = second; }

   /**
    * Gets first.
    *
    * @return the first
    */
   public T getFirst() { return first; }

   /**
    * Gets second.
    *
    * @return the second
    */
   public T getSecond() { return second; }

   /**
    * Sets first.
    *
    * @param newValue the new value
    */
   public void setFirst(T newValue) { first = newValue; }

   /**
    * Sets second.
    *
    * @param newValue the new value
    */
   public void setSecond(T newValue) { second = newValue; }
}
