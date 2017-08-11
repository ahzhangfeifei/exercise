package com.core.java.v2.v2ch07. stroke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * The type Stroke test.
 */
public class StrokeTest
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
               JFrame frame = new StrokeTestFrame();
               frame.setTitle("StrokeTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Stroke test frame.
 */
class StrokeTestFrame extends JFrame
{
   private StrokeComponent canvas;
   private JPanel buttonPanel;

   /**
    * Instantiates a new Stroke test frame.
    */
   public StrokeTestFrame()
   {
      canvas = new StrokeComponent();
      add(canvas, BorderLayout.CENTER);

      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(3, 3));
      add(buttonPanel, BorderLayout.NORTH);

      ButtonGroup group1 = new ButtonGroup();
      makeCapButton("Butt Cap", BasicStroke.CAP_BUTT, group1);
      makeCapButton("Round Cap", BasicStroke.CAP_ROUND, group1);
      makeCapButton("Square Cap", BasicStroke.CAP_SQUARE, group1);

      ButtonGroup group2 = new ButtonGroup();
      makeJoinButton("Miter Join", BasicStroke.JOIN_MITER, group2);
      makeJoinButton("Bevel Join", BasicStroke.JOIN_BEVEL, group2);
      makeJoinButton("Round Join", BasicStroke.JOIN_ROUND, group2);

      ButtonGroup group3 = new ButtonGroup();
      makeDashButton("Solid Line", false, group3);
      makeDashButton("Dashed Line", true, group3);
   }

   private void makeCapButton(String label, final int style, ButtonGroup group)
   {
      // select first button in group
      boolean selected = group.getButtonCount() == 0;
      JRadioButton button = new JRadioButton(label, selected);
      buttonPanel.add(button);
      group.add(button);
      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.setCap(style);
            }
         });
      pack();
   }

   private void makeJoinButton(String label, final int style, ButtonGroup group)
   {
      // select first button in group
      boolean selected = group.getButtonCount() == 0;
      JRadioButton button = new JRadioButton(label, selected);
      buttonPanel.add(button);
      group.add(button);
      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.setJoin(style);
            }
         });
   }

   private void makeDashButton(String label, final boolean style, ButtonGroup group)
   {
      // select first button in group
      boolean selected = group.getButtonCount() == 0;
      JRadioButton button = new JRadioButton(label, selected);
      buttonPanel.add(button);
      group.add(button);
      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.setDash(style);
            }
         });
   }
}

/**
 * The type Stroke component.
 */
class StrokeComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 400;
   private static final int DEFAULT_HEIGHT = 400;
   private static int SIZE = 10;

   private Point2D[] points;
   private int current;
   private float width;
   private int cap;
   private int join;
   private boolean dash;

   /**
    * Instantiates a new Stroke component.
    */
   public StrokeComponent()
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

      points = new Point2D[3];
      points[0] = new Point2D.Double(200, 100);
      points[1] = new Point2D.Double(100, 200);
      points[2] = new Point2D.Double(200, 200);
      current = -1;
      width = 8.0F;
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      GeneralPath path = new GeneralPath();
      path.moveTo((float) points[0].getX(), (float) points[0].getY());
      for (int i = 1; i < points.length; i++)
         path.lineTo((float) points[i].getX(), (float) points[i].getY());
      BasicStroke stroke;
      if (dash)
      {
         float miterLimit = 10.0F;
         float[] dashPattern = { 10F, 10F, 10F, 10F, 10F, 10F, 30F, 10F, 30F, 10F, 30F, 10F, 10F,
               10F, 10F, 10F, 10F, 30F };
         float dashPhase = 0;
         stroke = new BasicStroke(width, cap, join, miterLimit, dashPattern, dashPhase);
      }
      else stroke = new BasicStroke(width, cap, join);
      g2.setStroke(stroke);
      g2.draw(path);
   }

   /**
    * Sets join.
    *
    * @param j the j
    */
   public void setJoin(int j)
   {
      join = j;
      repaint();
   }

   /**
    * Sets cap.
    *
    * @param c the c
    */
   public void setCap(int c)
   {
      cap = c;
      repaint();
   }

   /**
    * Sets dash.
    *
    * @param d the d
    */
   public void setDash(boolean d)
   {
      dash = d;
      repaint();
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
