package com.core.java.v1.v1ch14.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The type Swing thread test.
 */
public class SwingThreadTest
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
               JFrame frame = new SwingThreadFrame();
               frame.setTitle("SwingThreadTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Swing thread frame.
 */
class SwingThreadFrame extends JFrame
{
   /**
    * Instantiates a new Swing thread frame.
    */
   public SwingThreadFrame()
   {
      final JComboBox<Integer> combo = new JComboBox<>();
      combo.insertItemAt(Integer.MAX_VALUE, 0);
      combo.setPrototypeDisplayValue(combo.getItemAt(0));
      combo.setSelectedIndex(0);

      JPanel panel = new JPanel();

      JButton goodButton = new JButton("Good");
      goodButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               new Thread(new GoodWorkerRunnable(combo)).start();
            }
         });
      panel.add(goodButton);
      JButton badButton = new JButton("Bad");
      badButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               new Thread(new BadWorkerRunnable(combo)).start();
            }
         });
      panel.add(badButton);

      panel.add(combo);
      add(panel);
      pack();
   }
}

/**
 * The type Bad worker runnable.
 */
class BadWorkerRunnable implements Runnable
{
   private JComboBox<Integer> combo;
   private Random generator;

   /**
    * Instantiates a new Bad worker runnable.
    *
    * @param aCombo the a combo
    */
   public BadWorkerRunnable(JComboBox<Integer> aCombo)
   {
      combo = aCombo;
      generator = new Random();
   }

   public void run()
   {
      try
      {
         while (true)
         {
            int i = Math.abs(generator.nextInt());
            if (i % 2 == 0) combo.insertItemAt(i, 0);
            else if (combo.getItemCount() > 0) combo.removeItemAt(i % combo.getItemCount());
            Thread.sleep(1);
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}

/**
 * The type Good worker runnable.
 */
class GoodWorkerRunnable implements Runnable
{
   private JComboBox<Integer> combo;
   private Random generator;

   /**
    * Instantiates a new Good worker runnable.
    *
    * @param aCombo the a combo
    */
   public GoodWorkerRunnable(JComboBox<Integer> aCombo)
   {
      combo = aCombo;
      generator = new Random();
   }

   public void run()
   {
      try
      {
         while (true)
         {
            EventQueue.invokeLater(new Runnable()
               {
                  public void run()
                  {
                     int i = Math.abs(generator.nextInt());
                     if (i % 2 == 0) combo.insertItemAt(i, 0);
                     else if (combo.getItemCount() > 0) combo.removeItemAt(i
                           % combo.getItemCount());
                  }
               });
            Thread.sleep(1);
         }
      }
      catch (InterruptedException e)
      {
      }
   }
}
