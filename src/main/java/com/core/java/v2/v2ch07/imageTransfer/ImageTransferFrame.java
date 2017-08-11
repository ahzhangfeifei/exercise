package com.core.java.v2.v2ch07. imageTransfer;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The type Image transfer frame.
 */
class ImageTransferFrame extends JFrame
{
   private JLabel label;
   private Image image;
   private static final int IMAGE_WIDTH = 300;
   private static final int IMAGE_HEIGHT = 300;

   /**
    * Instantiates a new Image transfer frame.
    */
   public ImageTransferFrame()
   {
      label = new JLabel();
      image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
      Graphics g = image.getGraphics();
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
      g.setColor(Color.RED);
      g.fillOval(IMAGE_WIDTH / 4, IMAGE_WIDTH / 4, IMAGE_WIDTH / 2, IMAGE_HEIGHT / 2);

      label.setIcon(new ImageIcon(image));
      add(new JScrollPane(label), BorderLayout.CENTER);
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
      ImageTransferable selection = new ImageTransferable(image);
      clipboard.setContents(selection, null);
   }

   private void paste()
   {
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      DataFlavor flavor = DataFlavor.imageFlavor;
      if (clipboard.isDataFlavorAvailable(flavor))
      {
         try
         {
            image = (Image) clipboard.getData(flavor);
            label.setIcon(new ImageIcon(image));
         }
         catch (UnsupportedFlavorException exception)
         {
            JOptionPane.showMessageDialog(this, exception);
         }
         catch (IOException exception)
         {
            JOptionPane.showMessageDialog(this, exception);
         }
      }
   }
}