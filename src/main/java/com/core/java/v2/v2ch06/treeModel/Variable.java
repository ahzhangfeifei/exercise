package com.core.java.v2.v2ch06. treeModel;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * The type Variable.
 */
public class Variable
{
   private Class<?> type;
   private String name;
   private Object value;
   private ArrayList<Field> fields;

   /**
    * Instantiates a new Variable.
    *
    * @param aType  the a type
    * @param aName  the a name
    * @param aValue the a value
    */
   public Variable(Class<?> aType, String aName, Object aValue)
   {
      type = aType;
      name = aName;
      value = aValue;
      fields = new ArrayList<>();

      // find all fields if we have a class type except we don't expand strings and null values

      if (!type.isPrimitive() && !type.isArray() && !type.equals(String.class) && value != null)
      {
         // get fields from the class and all superclasses
         for (Class<?> c = value.getClass(); c != null; c = c.getSuperclass())
         {
            Field[] fs = c.getDeclaredFields();
            AccessibleObject.setAccessible(fs, true);

            // get all nonstatic fields
            for (Field f : fs)
               if ((f.getModifiers() & Modifier.STATIC) == 0) fields.add(f);
         }
      }
   }

   /**
    * Gets value.
    *
    * @return the value
    */
   public Object getValue()
   {
      return value;
   }

   /**
    * Gets fields.
    *
    * @return the fields
    */
   public ArrayList<Field> getFields()
   {
      return fields;
   }

   public String toString()
   {
      String r = type + " " + name;
      if (type.isPrimitive()) r += "=" + value;
      else if (type.equals(String.class)) r += "=" + value;
      else if (value == null) r += "=null";
      return r;
   }
}
