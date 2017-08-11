package com.core.java.v1.v1ch14.bounceThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Bounce thread.
 */
public class BounceThread
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
               frame.setTitle("BounceThread");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Ball runnable.
 */
class BallRunnable implements Runnable
{
   private Ball ball;
   private Component component;
   /**
    * The constant STEPS.
    */
   public static final int STEPS = 1000;
   /**
    * The constant DELAY.
    */
   public static final int DELAY = 5;

   /**
    * Instantiates a new Ball runnable.
    *
    * @param aBall      the a ball
    * @param aComponent the a component
    */
   public BallRunnable(Ball aBall, Component aComponent)
   {
      ball = aBall;
      component = aComponent;
   }

   public void run()
   {
      try
      {
         for (int i = 1; i <= STEPS; i++)
         {
            ball.move(component.getBounds());
            component.repaint();
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException e)
      {
      }
   }

}

/**
 * The type Bounce frame.
 */
class BounceFrame extends JFrame
{
   private BallComponent comp;

   /**
    * Instantiates a new Bounce frame.
    */
   public BounceFrame()
   {
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
      Ball b = new Ball();
      comp.add(b);
      Runnable r = new BallRunnable(b, comp);
      Thread t = new Thread(r);
      t.start();
   }
}
