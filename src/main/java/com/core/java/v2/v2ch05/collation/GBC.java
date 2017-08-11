package com.core.java.v2.v2ch05. collation;

/*
GBC - A convenience class to tame the GridBagLayout

Copyright (C) 2002 Cay S. Horstmann (http://horstmann.com)

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

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
