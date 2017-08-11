package com.core.java.v2.v2ch07. book;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * The type Banner.
 */
public class Banner implements Printable
{
   private String message;
   private double scale;

   /**
    * Instantiates a new Banner.
    *
    * @param m the m
    */
   public Banner(String m)
   {
      message = m;
   }

   /**
    * Gets page count.
    *
    * @param g2 the g 2
    * @param pf the pf
    * @return the page count
    */
   public int getPageCount(Graphics2D g2, PageFormat pf)
   {
      if (message.equals("")) return 0;
      FontRenderContext context = g2.getFontRenderContext();
      Font f = new Font("Serif", Font.PLAIN, 72);
      Rectangle2D bounds = f.getStringBounds(message, context);
      scale = pf.getImageableHeight() / bounds.getHeight();
      double width = scale * bounds.getWidth();
      int pages = (int) Math.ceil(width / pf.getImageableWidth());
      return pages;
   }

   public int print(Graphics g, PageFormat pf, int page) throws PrinterException
   {
      Graphics2D g2 = (Graphics2D) g;
      if (page > getPageCount(g2, pf)) return Printable.NO_SUCH_PAGE;
      g2.translate(pf.getImageableX(), pf.getImageableY());

      drawPage(g2, pf, page);
      return Printable.PAGE_EXISTS;
   }

   /**
    * Draw page.
    *
    * @param g2   the g 2
    * @param pf   the pf
    * @param page the page
    */
   public void drawPage(Graphics2D g2, PageFormat pf, int page)
   {
      if (message.equals("")) return;
      page--; // account for cover page

      drawCropMarks(g2, pf);
      g2.clip(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));
      g2.translate(-page * pf.getImageableWidth(), 0);
      g2.scale(scale, scale);
      FontRenderContext context = g2.getFontRenderContext();
      Font f = new Font("Serif", Font.PLAIN, 72);
      TextLayout layout = new TextLayout(message, f, context);
      AffineTransform transform = AffineTransform.getTranslateInstance(0, layout.getAscent());
      Shape outline = layout.getOutline(transform);
      g2.draw(outline);
   }

   /**
    * Draw crop marks.
    *
    * @param g2 the g 2
    * @param pf the pf
    */
   public void drawCropMarks(Graphics2D g2, PageFormat pf)
   {
      final double C = 36; // crop mark length = 1/2 inch
      double w = pf.getImageableWidth();
      double h = pf.getImageableHeight();
      g2.draw(new Line2D.Double(0, 0, 0, C));
      g2.draw(new Line2D.Double(0, 0, C, 0));
      g2.draw(new Line2D.Double(w, 0, w, C));
      g2.draw(new Line2D.Double(w, 0, w - C, 0));
      g2.draw(new Line2D.Double(0, h, 0, h - C));
      g2.draw(new Line2D.Double(0, h, C, h));
      g2.draw(new Line2D.Double(w, h, w, h - C));
      g2.draw(new Line2D.Double(w, h, w - C, h));
   }
}

/**
 * The type Cover page.
 */
class CoverPage implements Printable
{
   private String title;

   /**
    * Instantiates a new Cover page.
    *
    * @param t the t
    */
   public CoverPage(String t)
   {
      title = t;
   }

   public int print(Graphics g, PageFormat pf, int page) throws PrinterException
   {
      if (page >= 1) return Printable.NO_SUCH_PAGE;
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(Color.black);
      g2.translate(pf.getImageableX(), pf.getImageableY());
      FontRenderContext context = g2.getFontRenderContext();
      Font f = g2.getFont();
      TextLayout layout = new TextLayout(title, f, context);
      float ascent = layout.getAscent();
      g2.drawString(title, 0, ascent);
      return Printable.PAGE_EXISTS;
   }
}
