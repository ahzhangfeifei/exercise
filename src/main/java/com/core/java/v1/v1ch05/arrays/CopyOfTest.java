package com.core.java.v1.v1ch05. arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * The type Copy of test.
 */
public class CopyOfTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      int[] a = { 1, 2, 3 };
      a = (int[]) goodCopyOf(a, 10);
      System.out.println(Arrays.toString(a));

      String[] b = { "Tom", "Dick", "Harry" };
      b = (String[]) goodCopyOf(b, 10);
      System.out.println(Arrays.toString(b));

      System.out.println("The following call will generate an exception.");
      b = (String[]) badCopyOf(b, 10);
   }

   /**
    * Bad copy of object [ ].
    *
    * @param a         the a
    * @param newLength the new length
    * @return the object [ ]
    */
   public static Object[] badCopyOf(Object[] a, int newLength) // not useful
   {
      Object[] newArray = new Object[newLength];
      System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
      return newArray;
   }

   /**
    * Good copy of object.
    *
    * @param a         the a
    * @param newLength the new length
    * @return the object
    */
   public static Object goodCopyOf(Object a, int newLength)
   {
      Class cl = a.getClass();
      if (!cl.isArray()) return null;
      Class componentType = cl.getComponentType();
      int length = Array.getLength(a);
      Object newArray = Array.newInstance(componentType, newLength);
      System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
      return newArray;
   }
}
