package com.core.java.v2.v2ch05. collation;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Enum combo.
 */
public class EnumCombo extends JComboBox<String>
{ 
   private Map<String, Integer> table = new TreeMap<>();

   /**
    * Instantiates a new Enum combo.
    *
    * @param cl     the cl
    * @param labels the labels
    */
   public EnumCombo(Class<?> cl, String... labels)
   {  
      for (String label : labels)
      {  
         String name = label.toUpperCase().replace(' ', '_');
         int value = 0;
         try
         {  
            java.lang.reflect.Field f = cl.getField(name);
            value = f.getInt(cl);
         }
         catch (Exception e)
         {  
            label = "(" + label + ")";
         }
         table.put(label, value);
         addItem(label);
      }
      setSelectedItem(labels[0]);
   }

   /**
    * Gets value.
    *
    * @return the value
    */
   public int getValue()
   {  
      return table.get(getSelectedItem());
   }
}
