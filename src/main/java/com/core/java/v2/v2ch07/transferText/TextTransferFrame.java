package com.core.java.v2.v2ch07. transferText;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The type Text transfer frame.
 */
public class TextTransferFrame extends JFrame
{
   private JTextArea textArea;
   private static final int TEXT_ROWS = 20;
   private static final int TEXT_COLUMNS = 60;

   /**
    * Instantiates a new Text transfer frame.
    */
   public TextTransferFrame()
   {
      textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      JPanel panel = new JPanel();

      JButton copyButton = new JButton("Copy");
      panel.add(copyButton);
      copyButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               copy();
            }
         });

      JButton pasteButton = new JButton("Paste");
      panel.add(pasteButton);
      pasteButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               paste();
            }
         });

      add(panel, BorderLayout.SOUTH);
      pack();
   }

   private void copy()
   {
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      String text = textArea.getSelectedText();
      if (text == null) text = textArea.getText();
      StringSelection selection = new StringSelection(text);
      clipboard.setContents(selection, null);
   }

   private void paste()
   {
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      DataFlavor flavor = DataFlavor.stringFlavor;
      if (clipboard.isDataFlavorAvailable(flavor))
      {
         try
         {
            String text = (String) clipboard.getData(flavor);
            textArea.replaceSelection(text);
         }
         catch (UnsupportedFlavorException e)
         {
            JOptionPane.showMessageDialog(this, e);
         }
         catch (IOException e)
         {
            JOptionPane.showMessageDialog(this, e);
         }
      }
   }
}
