package com.core.java.v2.v2ch10. set;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Set test.
 */
public class SetTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {  
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINEST);
      Handler handler = new ConsoleHandler();
      handler.setLevel(Level.FINEST);
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).addHandler(handler);

      Set<Item> parts = new HashSet<>();
      parts.add(new Item("Toaster", 1279));
      parts.add(new Item("Microwave", 4104));
      parts.add(new Item("Toaster", 1279));
      System.out.println(parts);
   }
}
