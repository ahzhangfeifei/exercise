package com.core.java.v2.v2ch07. composite;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * The type Composite component.
 */
class CompositeComponent extends JComponent
{
   private int rule;
   private Shape shape1;
   private Shape shape2;
   private float alpha;

   /**
    * Instantiates a new Composite component.
    */
   public CompositeComponent()
   {
      shape1 = new Ellipse2D.Double(100, 100, 150, 100);
      shape2 = new Rectangle2D.Double(150, 150, 150, 100);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D gImage = image.createGraphics();
      gImage.setPaint(Color.red);
      gImage.fill(shape1);
      AlphaComposite composite = AlphaComposite.getInstance(rule, alpha);
      gImage.setComposite(composite);
      gImage.setPaint(Color.blue);
      gImage.fill(shape2);
      g2.drawImage(image, null, 0, 0);
   }

   /**
    * Sets rule.
    *
    * @param r the r
    */
   public void setRule(int r)
   {
      rule = r;
      repaint();
   }

   /**
    * Sets alpha.
    *
    * @param a the a
    */
   public void setAlpha(int a)
   {
      alpha = (float) a / 100.0F;
      repaint();
   }
}
