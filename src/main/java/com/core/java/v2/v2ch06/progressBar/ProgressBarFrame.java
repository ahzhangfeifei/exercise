package com.core.java.v2.v2ch06. progressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Progress bar frame.
 */
public class ProgressBarFrame extends JFrame
{
   /**
    * The constant TEXT_ROWS.
    */
   public static final int TEXT_ROWS = 10;
   /**
    * The constant TEXT_COLUMNS.
    */
   public static final int TEXT_COLUMNS = 40;

   private JButton startButton;
   private JProgressBar progressBar;
   private JCheckBox checkBox;
   private JTextArea textArea;
   private SimulatedActivity activity;

   /**
    * Instantiates a new Progress bar frame.
    */
   public ProgressBarFrame()
   {
      // this text area holds the activity output
      textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);

      // set up panel with button and progress bar

      final int MAX = 1000;
      JPanel panel = new JPanel();
      startButton = new JButton("Start");
      progressBar = new JProgressBar(0, MAX);
      progressBar.setStringPainted(true);
      panel.add(startButton);
      panel.add(progressBar);

      checkBox = new JCheckBox("indeterminate");
      checkBox.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               progressBar.setIndeterminate(checkBox.isSelected());
               progressBar.setStringPainted(!progressBar.isIndeterminate());
            }
         });
      panel.add(checkBox);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(panel, BorderLayout.SOUTH);

      // set up the button action

      startButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               startButton.setEnabled(false);
               activity = new SimulatedActivity(MAX);
               activity.execute();
            }
         });
      pack();
   }

   /**
    * The type Simulated activity.
    */
   class SimulatedActivity extends SwingWorker<Void, Integer>
   {
      private int current;
      private int target;

      /**
       * Instantiates a new Simulated activity.
       *
       * @param t the t
       */
      public SimulatedActivity(int t)
      {
         current = 0;
         target = t;
      }

      protected Void doInBackground() throws Exception
      {
         try
         {
            while (current < target)
            {
               Thread.sleep(100);
               current++;
               publish(current);
            }
         }
         catch (InterruptedException e)
         {
         }
         return null;
      }

      protected void process(List<Integer> chunks)
      {
         for (Integer chunk : chunks)
         {
            textArea.append(chunk + "\n");
            progressBar.setValue(chunk);
         }
      }
      
      protected void done()
      {
         startButton.setEnabled(true);
      }     
   }   
}