package com.core.java.v1.v1ch07. listFonts;

import java.awt.*;

/**
 * The type List fonts.
 */
public class ListFonts
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getAvailableFontFamilyNames();

      for (String fontName : fontNames)
         System.out.println(fontName);
   }
}
