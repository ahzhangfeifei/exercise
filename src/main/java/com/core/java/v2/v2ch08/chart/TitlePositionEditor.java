package com.core.java.v2.v2ch08.chart;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 * The type Title position editor.
 */
public class TitlePositionEditor extends PropertyEditorSupport
{
   private String[] tags = { "Left", "Center", "Right" };

   public String[] getTags()
   {
      return tags;
   }

   public String getJavaInitializationString()
   {
      return ChartBean.Position.class.getName().replace('$', '.') + "." + getValue();
   }

   public String getAsText()
   {
      int index = ((ChartBean.Position) getValue()).ordinal();
      return tags[index];
   }

   public void setAsText(String s)
   {
      int index = Arrays.asList(tags).indexOf(s);
      if (index >= 0) setValue(ChartBean.Position.values()[index]);
   }
}
