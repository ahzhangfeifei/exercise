package com.core.java.v1.v1ch13.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Shuffle test.
 */
public class ShuffleTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 49; i++)
         numbers.add(i);
      Collections.shuffle(numbers);
      List<Integer> winningCombination = numbers.subList(0, 6);
      Collections.sort(winningCombination);
      System.out.println(winningCombination);
   }
}
