package com.core.java.v1.v1ch14.swingWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/**
 * The type Swing worker test.
 */
public class SwingWorkerTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws Exception the exception
    */
   public static void main(String[] args) throws Exception
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new SwingWorkerFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Swing worker frame.
 */
class SwingWorkerFrame extends JFrame
{
   private JFileChooser chooser;
   private JTextArea textArea;
   private JLabel statusLine;
   private JMenuItem openItem;
   private JMenuItem cancelItem;
   private SwingWorker<StringBuilder, ProgressData> textReader;
   /**
    * The constant TEXT_ROWS.
    */
   public static final int TEXT_ROWS = 20;
   /**
    * The constant TEXT_COLUMNS.
    */
   public static final int TEXT_COLUMNS = 60;

   /**
    * Instantiates a new Swing worker frame.
    */
   public SwingWorkerFrame()
   {
      chooser = new JFileChooser();
      chooser.setCurrentDirectory(new File("."));

      textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      add(new JScrollPane(textArea));

      statusLine = new JLabel(" ");
      add(statusLine, BorderLayout.SOUTH);

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menu = new JMenu("File");
      menuBar.add(menu);

      openItem = new JMenuItem("Open");
      menu.add(openItem);
      openItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // show file chooser dialog
               int result = chooser.showOpenDialog(null);

               // if file selected, set it as icon of the label
               if (result == JFileChooser.APPROVE_OPTION)
               {
                  textArea.setText("");
                  openItem.setEnabled(false);
                  textReader = new TextReader(chooser.getSelectedFile());
                  textReader.execute();
                  cancelItem.setEnabled(true);
               }
            }
         });

      cancelItem = new JMenuItem("Cancel");
      menu.add(cancelItem);
      cancelItem.setEnabled(false);
      cancelItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               textReader.cancel(true);
            }
         });
      pack();
   }

   private class ProgressData
   {
      /**
       * The Number.
       */
      public int number;
      /**
       * The Line.
       */
      public String line;
   }

   private class TextReader extends SwingWorker<StringBuilder, ProgressData>
   {
      private File file;
      private StringBuilder text = new StringBuilder();

      /**
       * Instantiates a new Text reader.
       *
       * @param file the file
       */
      public TextReader(File file)
      {
         this.file = file;
      }

      // The following method executes in the worker thread; it doesn't touch Swing components.

      @Override
      public StringBuilder doInBackground() throws IOException, InterruptedException
      {
         int lineNumber = 0;
         try (Scanner in = new Scanner(new FileInputStream(file)))
         {
            while (in.hasNextLine())         
            {
               String line = in.nextLine();
               lineNumber++;
               text.append(line);
               text.append("\n");
               ProgressData data = new ProgressData();
               data.number = lineNumber;
               data.line = line;
               publish(data);
               Thread.sleep(1); // to test cancellation; no need to do this in your programs
            }
         }
         return text;
      }

      // The following methods execute in the event dispatch thread.

      @Override
      public void process(List<ProgressData> data)
      {
         if (isCancelled()) return;
         StringBuilder b = new StringBuilder();
         statusLine.setText("" + data.get(data.size() - 1).number);
         for (ProgressData d : data)
         {
            b.append(d.line);
            b.append("\n");
         }
         textArea.append(b.toString());
      }

      @Override
      public void done()
      {
         try
         {
            StringBuilder result = get();
            textArea.setText(result.toString());
            statusLine.setText("Done");
         }
         catch (InterruptedException ex)
         {
         }
         catch (CancellationException ex)
         {
            textArea.setText("");
            statusLine.setText("Cancelled");
         }
         catch (ExecutionException ex)
         {
            statusLine.setText("" + ex.getCause());
         }

         cancelItem.setEnabled(false);
         openItem.setEnabled(true);
      }

   };
}
