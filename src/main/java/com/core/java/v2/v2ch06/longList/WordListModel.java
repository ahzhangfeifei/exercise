package com.core.java.v2.v2ch06. longList;

import javax.swing.*;

/**
 * The type Word list model.
 */
public class WordListModel extends AbstractListModel<String>
{
   private int length;
   /**
    * The constant FIRST.
    */
   public static final char FIRST = 'a';
   /**
    * The constant LAST.
    */
   public static final char LAST = 'z';

   /**
    * Instantiates a new Word list model.
    *
    * @param n the n
    */
   public WordListModel(int n)
   {
      length = n;
   }

   public int getSize()
   {
      return (int) Math.pow(LAST - FIRST + 1, length);
   }

   public String getElementAt(int n)
   {
      StringBuilder r = new StringBuilder();
      
      for (int i = 0; i < length; i++)
      {
         char c = (char) (FIRST + n % (LAST - FIRST + 1));
         r.insert(0, c);
         n = n / (LAST - FIRST + 1);
      }
      return r.toString();
   }
}
