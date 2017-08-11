package com.core.java.v1.v1ch08.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * The type Mouse component.
 */
public class MouseComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   private static final int SIDELENGTH = 10;
   private ArrayList<Rectangle2D> squares;
   private Rectangle2D current; // the square containing the mouse cursor

   /**
    * Instantiates a new Mouse component.
    */
   public MouseComponent()
   {
      squares = new ArrayList<>();
      current = null;

      addMouseListener(new MouseHandler());
      addMouseMotionListener(new MouseMotionHandler());
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      // draw all squares
      for (Rectangle2D r : squares)
         g2.draw(r);
   }

   /**
    * Find rectangle 2 d.
    *
    * @param p the p
    * @return the rectangle 2 d
    */
   public Rectangle2D find(Point2D p)
   {
      for (Rectangle2D r : squares)
      {
         if (r.contains(p)) return r;
      }
      return null;
   }

   /**
    * Add.
    *
    * @param p the p
    */
   public void add(Point2D p)
   {
      double x = p.getX();
      double y = p.getY();

      current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH,
            SIDELENGTH);
      squares.add(current);
      repaint();
   }

   /**
    * Remove.
    *
    * @param s the s
    */
   public void remove(Rectangle2D s)
   {
      if (s == null) return;
      if (s == current) current = null;
      squares.remove(s);
      repaint();
   }

   private class MouseHandler extends MouseAdapter
   {
      public void mousePressed(MouseEvent event)
      {
         // add a new square if the cursor isn't inside a square
         current = find(event.getPoint());
         if (current == null) add(event.getPoint());
      }

      public void mouseClicked(MouseEvent event)
      {
         // remove the current square if double clicked
         current = find(event.getPoint());
         if (current != null && event.getClickCount() >= 2) remove(current);
      }
   }

   private class MouseMotionHandler implements MouseMotionListener
   {
      public void mouseMoved(MouseEvent event)
      {
         // set the mouse cursor to cross hairs if it is inside
         // a rectangle

         if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
         else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      }

      public void mouseDragged(MouseEvent event)
      {
         if (current != null)
         {
            int x = event.getX();
            int y = event.getY();

            // drag the current rectangle to center it at (x, y)
            current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
            repaint();
         }
      }
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
