package com.core.java.v2.v2ch07. shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * The type Shape test.
 */
public class ShapeTest
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
               JFrame frame = new ShapeTestFrame();
               frame.setTitle("ShapeTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Shape test frame.
 */
class ShapeTestFrame extends JFrame
{
   /**
    * Instantiates a new Shape test frame.
    */
   public ShapeTestFrame()
   {
      final ShapeComponent comp = new ShapeComponent();
      add(comp, BorderLayout.CENTER);
      final JComboBox<ShapeMaker> comboBox = new JComboBox<>();
      comboBox.addItem(new LineMaker());
      comboBox.addItem(new RectangleMaker());
      comboBox.addItem(new RoundRectangleMaker());
      comboBox.addItem(new EllipseMaker());
      comboBox.addItem(new ArcMaker());
      comboBox.addItem(new PolygonMaker());
      comboBox.addItem(new QuadCurveMaker());
      comboBox.addItem(new CubicCurveMaker());
      comboBox.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               ShapeMaker shapeMaker = comboBox.getItemAt(comboBox.getSelectedIndex());
               comp.setShapeMaker(shapeMaker);
            }
         });
      add(comboBox, BorderLayout.NORTH);
      comp.setShapeMaker((ShapeMaker) comboBox.getItemAt(0));
      pack();
   }

}

/**
 * The type Shape component.
 */
class ShapeComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   private Point2D[] points;
   private static Random generator = new Random();
   private static int SIZE = 10;
   private int current;
   private ShapeMaker shapeMaker;

   /**
    * Instantiates a new Shape component.
    */
   public ShapeComponent()
   {
      addMouseListener(new MouseAdapter()
         {
            public void mousePressed(MouseEvent event)
            {
               Point p = event.getPoint();
               for (int i = 0; i < points.length; i++)
               {
                  double x = points[i].getX() - SIZE / 2;
                  double y = points[i].getY() - SIZE / 2;
                  Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
                  if (r.contains(p))
                  {
                     current = i;
                     return;
                  }
               }
            }

            public void mouseReleased(MouseEvent event)
            {
               current = -1;
            }
         });
      addMouseMotionListener(new MouseMotionAdapter()
         {
            public void mouseDragged(MouseEvent event)
            {
               if (current == -1) return;
               points[current] = event.getPoint();
               repaint();
            }
         });
      current = -1;
   }

   /**
    * Sets shape maker.
    *
    * @param aShapeMaker the a shape maker
    */
   public void setShapeMaker(ShapeMaker aShapeMaker)
   {
      shapeMaker = aShapeMaker;
      int n = shapeMaker.getPointCount();
      points = new Point2D[n];
      for (int i = 0; i < n; i++)
      {
         double x = generator.nextDouble() * getWidth();
         double y = generator.nextDouble() * getHeight();
         points[i] = new Point2D.Double(x, y);
      }
      repaint();
   }

   public void paintComponent(Graphics g)
   {
      if (points == null) return;
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 0; i < points.length; i++)
      {
         double x = points[i].getX() - SIZE / 2;
         double y = points[i].getY() - SIZE / 2;
         g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
      }

      g2.draw(shapeMaker.makeShape(points));
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}

/**
 * The type Shape maker.
 */
abstract class ShapeMaker
{
   /**
    * Make shape shape.
    *
    * @param p the p
    * @return the shape
    */
   public abstract Shape makeShape(Point2D[] p);
   private int pointCount;

   /**
    * Instantiates a new Shape maker.
    *
    * @param aPointCount the a point count
    */
   public ShapeMaker(int aPointCount)
   {
      pointCount = aPointCount;
   }

   /**
    * Gets point count.
    *
    * @return the point count
    */
   public int getPointCount()
   {
      return pointCount;
   }

   public String toString()
   {
      return getClass().getName();
   }

}

/**
 * The type Line maker.
 */
class LineMaker extends ShapeMaker
{
   /**
    * Instantiates a new Line maker.
    */
   public LineMaker()
   {
      super(2);
   }

   public Shape makeShape(Point2D[] p)
   {
      return new Line2D.Double(p[0], p[1]);
   }
}

/**
 * The type Rectangle maker.
 */
class RectangleMaker extends ShapeMaker
{
   /**
    * Instantiates a new Rectangle maker.
    */
   public RectangleMaker()
   {
      super(2);
   }

   public Shape makeShape(Point2D[] p)
   {
      Rectangle2D s = new Rectangle2D.Double();
      s.setFrameFromDiagonal(p[0], p[1]);
      return s;
   }
}

/**
 * The type Round rectangle maker.
 */
class RoundRectangleMaker extends ShapeMaker
{
   /**
    * Instantiates a new Round rectangle maker.
    */
   public RoundRectangleMaker()
   {
      super(2);
   }

   public Shape makeShape(Point2D[] p)
   {
      RoundRectangle2D s = new RoundRectangle2D.Double(0, 0, 0, 0, 20, 20);
      s.setFrameFromDiagonal(p[0], p[1]);
      return s;
   }
}

/**
 * The type Ellipse maker.
 */
class EllipseMaker extends ShapeMaker
{
   /**
    * Instantiates a new Ellipse maker.
    */
   public EllipseMaker()
   {
      super(2);
   }

   public Shape makeShape(Point2D[] p)
   {
      Ellipse2D s = new Ellipse2D.Double();
      s.setFrameFromDiagonal(p[0], p[1]);
      return s;
   }
}

/**
 * The type Arc maker.
 */
class ArcMaker extends ShapeMaker
{
   /**
    * Instantiates a new Arc maker.
    */
   public ArcMaker()
   {
      super(4);
   }

   public Shape makeShape(Point2D[] p)
   {
      double centerX = (p[0].getX() + p[1].getX()) / 2;
      double centerY = (p[0].getY() + p[1].getY()) / 2;
      double width = Math.abs(p[1].getX() - p[0].getX());
      double height = Math.abs(p[1].getY() - p[0].getY());

      double skewedStartAngle = Math.toDegrees(Math.atan2(-(p[2].getY() - centerY) * width, 
         (p[2].getX() - centerX) * height));
      double skewedEndAngle = Math.toDegrees(Math.atan2(-(p[3].getY() - centerY) * width, 
         (p[3].getX() - centerX) * height));
      double skewedAngleDifference = skewedEndAngle - skewedStartAngle;
      if (skewedStartAngle < 0) skewedStartAngle += 360;
      if (skewedAngleDifference < 0) skewedAngleDifference += 360;

      Arc2D s = new Arc2D.Double(0, 0, 0, 0, skewedStartAngle, skewedAngleDifference, Arc2D.OPEN);
      s.setFrameFromDiagonal(p[0], p[1]);

      GeneralPath g = new GeneralPath();
      g.append(s, false);
      Rectangle2D r = new Rectangle2D.Double();
      r.setFrameFromDiagonal(p[0], p[1]);
      g.append(r, false);
      Point2D center = new Point2D.Double(centerX, centerY);
      g.append(new Line2D.Double(center, p[2]), false);
      g.append(new Line2D.Double(center, p[3]), false);
      return g;
   }
}

/**
 * The type Polygon maker.
 */
class PolygonMaker extends ShapeMaker
{
   /**
    * Instantiates a new Polygon maker.
    */
   public PolygonMaker()
   {
      super(6);
   }

   public Shape makeShape(Point2D[] p)
   {
      GeneralPath s = new GeneralPath();
      s.moveTo((float) p[0].getX(), (float) p[0].getY());
      for (int i = 1; i < p.length; i++)
         s.lineTo((float) p[i].getX(), (float) p[i].getY());
      s.closePath();
      return s;
   }
}

/**
 * The type Quad curve maker.
 */
class QuadCurveMaker extends ShapeMaker
{
   /**
    * Instantiates a new Quad curve maker.
    */
   public QuadCurveMaker()
   {
      super(3);
   }

   public Shape makeShape(Point2D[] p)
   {
      return new QuadCurve2D.Double(p[0].getX(), p[0].getY(), p[1].getX(), p[1].getY(), 
         p[2].getX(), p[2].getY());
   }
}

/**
 * The type Cubic curve maker.
 */
class CubicCurveMaker extends ShapeMaker
{
   /**
    * Instantiates a new Cubic curve maker.
    */
   public CubicCurveMaker()
   {
      super(4);
   }

   public Shape makeShape(Point2D[] p)
   {
      return new CubicCurve2D.Double(p[0].getX(), p[0].getY(), p[1].getX(), p[1].getY(), p[2]
            .getX(), p[2].getY(), p[3].getX(), p[3].getY());
   }
}
