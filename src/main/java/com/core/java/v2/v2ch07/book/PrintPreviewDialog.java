package com.core.java.v2.v2ch07. book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

/**
 * The type Print preview dialog.
 */
public class PrintPreviewDialog extends JDialog
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 300;

   private PrintPreviewCanvas canvas;

   /**
    * Instantiates a new Print preview dialog.
    *
    * @param p     the p
    * @param pf    the pf
    * @param pages the pages
    */
   public PrintPreviewDialog(Printable p, PageFormat pf, int pages)
   {
      Book book = new Book();
      book.append(p, pf, pages);
      layoutUI(book);
   }

   /**
    * Instantiates a new Print preview dialog.
    *
    * @param b the b
    */
   public PrintPreviewDialog(Book b)
   {
      layoutUI(b);
   }

   /**
    * Layout ui.
    *
    * @param book the book
    */
   public void layoutUI(Book book)
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      canvas = new PrintPreviewCanvas(book);
      add(canvas, BorderLayout.CENTER);

      JPanel buttonPanel = new JPanel();

      JButton nextButton = new JButton("Next");
      buttonPanel.add(nextButton);
      nextButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.flipPage(1);
            }
         });

      JButton previousButton = new JButton("Previous");
      buttonPanel.add(previousButton);
      previousButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               canvas.flipPage(-1);
            }
         });

      JButton closeButton = new JButton("Close");
      buttonPanel.add(closeButton);
      closeButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setVisible(false);
            }
         });

      add(buttonPanel, BorderLayout.SOUTH);
   }
}
