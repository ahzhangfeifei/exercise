package com.core.java.v1.v1ch14.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Bounce.
 */
public class Bounce
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
               JFrame frame = new BounceFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Bounce frame.
 */
class BounceFrame extends JFrame
{
   private BallComponent comp;
   /**
    * The constant STEPS.
    */
   public static final int STEPS = 1000;
   /**
    * The constant DELAY.
    */
   public static final int DELAY = 3;

   /**
    * Instantiates a new Bounce frame.
    */
   public BounceFrame()
   {
      setTitle("Bounce");

      comp = new BallComponent();
      add(comp, BorderLayout.CENTER);
      JPanel buttonPanel = new JPanel();
      addButton(buttonPanel, "Start", new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               addBall();
            }
         });

      addButton(buttonPanel, "Close", new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }

   /**
    * Add button.
    *
    * @param c        the c
    * @param title    the title
    * @param listener the listener
    */
   public void addButton(Container c, String title, ActionListener listener)
   {
      JButton button = new JButton(title);
      c.add(button);
      button.addActionListener(listener);
   }

   /**
    * Add ball.
    */
   public void addBall()
   {
      try
      {
         Ball ball = new Ball();
         comp.add(ball);

         for (int i = 1; i <= STEPS; i++)
         {
            ball.move(comp.getBounds());
            comp.paint(comp.getGraphics());
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}
