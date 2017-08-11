package com.core.java.v2.v2ch10.chart;


import com.core.java.v2.v2ch10.sourceAnnotations.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * The type Chart bean.
 */
public class ChartBean extends JComponent
{
   /**
    * Instantiates a new Chart bean.
    */
   public ChartBean()
   {
      setPreferredSize(new Dimension(XPREFSIZE, YPREFSIZE));
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      if (values == null || values.length == 0) return;
      double minValue = 0;
      double maxValue = 0;
      for (int i = 0; i < values.length; i++)
      {
         if (minValue > getValues(i)) minValue = getValues(i);
         if (maxValue < getValues(i)) maxValue = getValues(i);
      }
      if (maxValue == minValue) return;

      Rectangle2D bounds = getBounds();
      double clientWidth = bounds.getWidth();
      double clientHeight = bounds.getHeight();
      double barWidth = (clientWidth - 2 * INSETS) / values.length;

      g2.setPaint(inverse ? color : Color.white);
      g2.fill(new Rectangle2D.Double(0, 0, clientWidth, clientHeight));
      g2.setPaint(Color.black);

      Font titleFont = new Font("SansSerif", Font.BOLD, 20);
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D titleBounds = titleFont.getStringBounds(title, context);

      double titleWidth = titleBounds.getWidth();
      double y = -titleBounds.getY();
      double x = 0;
      if (titlePosition == Position.CENTER) x += (clientWidth - titleWidth) / 2;
      else if (titlePosition == Position.RIGHT) x += clientWidth - titleWidth;

      g2.setFont(titleFont);
      g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g2.drawString(title, (float) x, (float) y);

      double top = titleBounds.getHeight();
      double scale = (clientHeight - top - 2 * INSETS) / (maxValue - minValue);
      y = clientHeight;

      for (int i = 0; i < values.length; i++)
      {
         double x1 = INSETS + i * barWidth + 1;
         double y1 = INSETS + top;
         double value = getValues(i);
         double height = value * scale;
         if (value >= 0) y1 += (maxValue - value) * scale;
         else
         {
            y1 += (int) (maxValue * scale);
            height = -height;
         }

         g2.setPaint(inverse ? Color.white : color);
         Rectangle2D bar = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
         g2.fill(bar);
         g2.setPaint(Color.black);
         g2.draw(bar);
      }
   }

   /**
    * Sets title.
    *
    * @param t the t
    */
   @Property
   public void setTitle(String t)
   {
      title = t;
   }

   /**
    * Gets title.
    *
    * @return the title
    */
   public String getTitle()
   {
      return title;
   }

   /**
    * Sets values.
    *
    * @param v the v
    */
   public void setValues(double[] v)
   {
      values = v;
   }

   /**
    * Get values double [ ].
    *
    * @return the double [ ]
    */
   public double[] getValues()
   {
      return values;
   }

   /**
    * Sets values.
    *
    * @param i     the
    * @param value the value
    */
   @Property(editor = "DoubleArrayEditor")
   public void setValues(int i, double value)
   {
      if (0 <= i && i < values.length) values[i] = value;
   }

   /**
    * Gets values.
    *
    * @param i the
    * @return the values
    */
   public double getValues(int i)
   {
      if (0 <= i && i < values.length) return values[i];
      return 0;
   }

   /**
    * Sets inverse.
    *
    * @param b the b
    */
   @Property(editor = "InverseEditor")
   public void setInverse(boolean b)
   {
      inverse = b;
   }

   /**
    * Is inverse boolean.
    *
    * @return the boolean
    */
   public boolean isInverse()
   {
      return inverse;
   }

   /**
    * Sets title position.
    *
    * @param p the p
    */
   @Property(editor = "TitlePositionEditor")
   public void setTitlePosition(Position p)
   {
      titlePosition = p;
   }

   /**
    * Gets title position.
    *
    * @return the title position
    */
   public Position getTitlePosition()
   {
      return titlePosition;
   }

   /**
    * Sets graph color.
    *
    * @param c the c
    */
   @Property
   public void setGraphColor(Color c)
   {
      color = c;
   }

   /**
    * Gets graph color.
    *
    * @return the graph color
    */
   public Color getGraphColor()
   {
      return color;
   }

   /**
    * The enum Position.
    */
   public enum Position {
      /**
       * Left position.
       */
      LEFT, /**
       * Center position.
       */
      CENTER, /**
       * Right position.
       */
      RIGHT };
   
   private static final int XPREFSIZE = 300;
   private static final int YPREFSIZE = 300;

   private static final int INSETS = 10;

   private double[] values = { 1, 2, 3 };
   private String title = "Title";
   private Position titlePosition = Position.CENTER;
   private boolean inverse;
   private Color color = Color.red;
}
