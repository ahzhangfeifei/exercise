package com.core.java.v1.v1ch05. objectAnalyzer;

import java.util.ArrayList;

/**
 * The type Object analyzer test.
 */
public class ObjectAnalyzerTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      ArrayList<Integer> squares = new ArrayList<>();
      for (int i = 1; i <= 5; i++)
         squares.add(i * i);
      System.out.println(new ObjectAnalyzer().toString(squares));
   }
}