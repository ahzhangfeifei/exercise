package com.core.java.v2.v2ch07. serialTransfer;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

/**
 * The type Serial transfer frame.
 */
class SerialTransferFrame extends JFrame
{
   private JColorChooser chooser;

   /**
    * Instantiates a new Serial transfer frame.
    */
   public SerialTransferFrame()
   {
      chooser = new JColorChooser();
      add(chooser, BorderLayout.CENTER);
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
      Color color = chooser.getColor();
      SerialTransferable selection = new SerialTransferable(color);
      clipboard.setContents(selection, null);
   }

   private void paste()
   {
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      try
      {
         DataFlavor flavor = new DataFlavor(
               "application/x-java-serialized-object;class=java.awt.Color");
         if (clipboard.isDataFlavorAvailable(flavor))
         {
            Color color = (Color) clipboard.getData(flavor);
            chooser.setColor(color);
         }
      }
      catch (ClassNotFoundException e)
      {
         JOptionPane.showMessageDialog(this, e);
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

/**
 * The type Serial transferable.
 */
class SerialTransferable implements Transferable
{
   private Serializable obj;

   /**
    * Instantiates a new Serial transferable.
    *
    * @param o the o
    */
   SerialTransferable(Serializable o)
   {
      obj = o;
   }

   public DataFlavor[] getTransferDataFlavors()
   {
      DataFlavor[] flavors = new DataFlavor[2];
      Class<?> type = obj.getClass();
      String mimeType = "application/x-java-serialized-object;class=" + type.getName();
      try
      {
         flavors[0] = new DataFlavor(mimeType);
         flavors[1] = DataFlavor.stringFlavor;
         return flavors;
      }
      catch (ClassNotFoundException e)
      {
         return new DataFlavor[0];
      }
   }

   public boolean isDataFlavorSupported(DataFlavor flavor)
   {
      return DataFlavor.stringFlavor.equals(flavor)
            || "application".equals(flavor.getPrimaryType())
            && "x-java-serialized-object".equals(flavor.getSubType())
            && flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
   }

   public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
   {
      if (!isDataFlavorSupported(flavor)) throw new UnsupportedFlavorException(flavor);

      if (DataFlavor.stringFlavor.equals(flavor)) return obj.toString();

      return obj;
   }
}
