package com.core.java.v2.v2ch06. progressMonitorInputStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * The type Text frame.
 */
public class TextFrame extends JFrame
{
   /**
    * The constant TEXT_ROWS.
    */
   public static final int TEXT_ROWS = 10;
   /**
    * The constant TEXT_COLUMNS.
    */
   public static final int TEXT_COLUMNS = 40;

   private JMenuItem openItem;
   private JMenuItem exitItem;
   private JTextArea textArea;
   private JFileChooser chooser;

   /**
    * Instantiates a new Text frame.
    */
   public TextFrame()
   {
      textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      add(new JScrollPane(textArea));

      chooser = new JFileChooser();
      chooser.setCurrentDirectory(new File("."));

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu fileMenu = new JMenu("File");
      menuBar.add(fileMenu);
      openItem = new JMenuItem("Open");
      openItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               try
               {
                  openFile();
               }
               catch (IOException exception)
               {
                  exception.printStackTrace();
               }
            }
         });

      fileMenu.add(openItem);
      exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      fileMenu.add(exitItem);
      pack();
   }

   /**
    * Open file.
    *
    * @throws IOException the io exception
    */
   public void openFile() throws IOException
   {
      int r = chooser.showOpenDialog(this);
      if (r != JFileChooser.APPROVE_OPTION) return;
      final File f = chooser.getSelectedFile();

      // set up stream and reader filter sequence
      
      InputStream fileIn = Files.newInputStream(f.toPath());
      final ProgressMonitorInputStream progressIn = new ProgressMonitorInputStream(
         this, "Reading " + f.getName(), fileIn);      

      textArea.setText("");

      SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>()
         {
            protected Void doInBackground() throws Exception
            {
               try (Scanner in = new Scanner(progressIn))
               {
                  while (in.hasNextLine())
                  {
                     String line = in.nextLine();
                     textArea.append(line);
                     textArea.append("\n");
                  }
               }
               return null;
            }
         };
      worker.execute();
   }
}
