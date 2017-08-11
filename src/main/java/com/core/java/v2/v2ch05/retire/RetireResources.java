package com.core.java.v2.v2ch05. retire;

import java.awt.*;

/**
 * The type Retire resources.
 */
public class RetireResources extends java.util.ListResourceBundle
{
   private static final Object[][] contents = {
   // BEGIN LOCALIZE
         { "colorPre", Color.blue }, { "colorGain", Color.white }, { "colorLoss", Color.red }
   // END LOCALIZE
   };

   public Object[][] getContents()
   {
      return contents;
   }
}
