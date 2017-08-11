package com.core.java.v1.v1ch07. font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * The type Font test.
 */
public class FontTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new FontFrame();
               frame.setTitle("FontTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Font frame.
 */
class FontFrame extends JFrame
{
   /**
    * Instantiates a new Font frame.
    */
   public FontFrame()
   {      
      add(new FontComponent());
      pack();
   }
}

/**
 * The type Font component.
 */
class FontComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      String message = "Hello, World!";

      Font f = new Font("Serif", Font.BOLD, 36);
      g2.setFont(f);

      // measure the size of the message

      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D bounds = f.getStringBounds(message, context);

      // set (x,y) = top left corner of text

      double x = (getWidth() - bounds.getWidth()) / 2;
      double y = (getHeight() - bounds.getHeight()) / 2;

      // add ascent to y to reach the baseline

      double ascent = -bounds.getY();
      double baseY = y + ascent;

      // draw the message

      g2.drawString(message, (int) x, (int) baseY);

      g2.setPaint(Color.LIGHT_GRAY);

      // draw the baseline

      g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

      // draw the enclosing rectangle

      Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
      g2.draw(rect);
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
