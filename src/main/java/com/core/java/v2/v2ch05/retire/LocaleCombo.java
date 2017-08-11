package com.core.java.v2.v2ch05. retire;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * The type Locale combo.
 */
public class LocaleCombo extends JComboBox<Locale>
{
   private int selected;
   private Locale[] locales;
   private ListCellRenderer<Locale> renderer;

   /**
    * Instantiates a new Locale combo.
    *
    * @param locales the locales
    */
   public LocaleCombo(Locale[] locales)
   {
      this.locales = (Locale[]) locales.clone();
      sort();
      setSelectedItem(getLocale());
   }

   public void setLocale(Locale newValue)
   {
      super.setLocale(newValue);
      sort();
   }

   private void sort()
   {
      final Locale loc = getLocale();
      final Collator collator = Collator.getInstance(loc);
      final Comparator<Locale> comp = new Comparator<Locale>()
         {
            public int compare(Locale a, Locale b)
            {
               return collator.compare(a.getDisplayName(loc), b.getDisplayName(loc));
            }
         };
      Arrays.sort(locales, comp);
      setModel(new ComboBoxModel<Locale>()
         {
            public Locale getElementAt(int i)
            {
               return locales[i];
            }

            public int getSize()
            {
               return locales.length;
            }

            public void addListDataListener(ListDataListener l)
            {
            }

            public void removeListDataListener(ListDataListener l)
            {
            }

            public Locale getSelectedItem()
            {
               return selected >= 0 ? locales[selected] : null;
            }

            public void setSelectedItem(Object anItem)
            {
               if (anItem == null) selected = -1;
               else selected = Arrays.binarySearch(locales, (Locale) anItem, comp);
            }

         });
      setSelectedItem(selected);
   }

   public ListCellRenderer<Locale> getRenderer()
   {
      if (renderer == null)
      {
         @SuppressWarnings("unchecked") final ListCellRenderer<Object> originalRenderer 
            = (ListCellRenderer<Object>) super.getRenderer();
         if (originalRenderer == null) return null;
         renderer = new ListCellRenderer<Locale>()
            {
               public Component getListCellRendererComponent(JList<? extends Locale> list, Locale value, int index,
                     boolean isSelected, boolean cellHasFocus)
               {
                  String renderedValue =  value.getDisplayName(getLocale());
                  return originalRenderer.getListCellRendererComponent(list, renderedValue, index,
                        isSelected, cellHasFocus);
               }
            };
      }
      return renderer;
   }

   public void setRenderer(ListCellRenderer<? super Locale> newValue)
   {
      renderer = null;
      super.setRenderer(newValue);
   }
}
