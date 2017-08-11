package com.core.java.v1.v1ch09. gridbag;

import java.awt.*;

/**
 * The type Gbc.
 */
public class GBC extends GridBagConstraints
{
   /**
    * Instantiates a new Gbc.
    *
    * @param gridx the gridx
    * @param gridy the gridy
    */
   public GBC(int gridx, int gridy)
   {
      this.gridx = gridx;
      this.gridy = gridy;
   }

   /**
    * Instantiates a new Gbc.
    *
    * @param gridx      the gridx
    * @param gridy      the gridy
    * @param gridwidth  the gridwidth
    * @param gridheight the gridheight
    */
   public GBC(int gridx, int gridy, int gridwidth, int gridheight)
   {
      this.gridx = gridx;
      this.gridy = gridy;
      this.gridwidth = gridwidth;
      this.gridheight = gridheight;
   }

   /**
    * Sets anchor.
    *
    * @param anchor the anchor
    * @return the anchor
    */
   public GBC setAnchor(int anchor)
   {
      this.anchor = anchor;
      return this;
   }

   /**
    * Sets fill.
    *
    * @param fill the fill
    * @return the fill
    */
   public GBC setFill(int fill)
   {
      this.fill = fill;
      return this;
   }

   /**
    * Sets weight.
    *
    * @param weightx the weightx
    * @param weighty the weighty
    * @return the weight
    */
   public GBC setWeight(double weightx, double weighty)
   {
      this.weightx = weightx;
      this.weighty = weighty;
      return this;
   }

   /**
    * Sets insets.
    *
    * @param distance the distance
    * @return the insets
    */
   public GBC setInsets(int distance)
   {
      this.insets = new Insets(distance, distance, distance, distance);
      return this;
   }

   /**
    * Sets insets.
    *
    * @param top    the top
    * @param left   the left
    * @param bottom the bottom
    * @param right  the right
    * @return the insets
    */
   public GBC setInsets(int top, int left, int bottom, int right)
   {
      this.insets = new Insets(top, left, bottom, right);
      return this;
   }

   /**
    * Sets ipad.
    *
    * @param ipadx the ipadx
    * @param ipady the ipady
    * @return the ipad
    */
   public GBC setIpad(int ipadx, int ipady)
   {
      this.ipadx = ipadx;
      this.ipady = ipady;
      return this;
   }
}
