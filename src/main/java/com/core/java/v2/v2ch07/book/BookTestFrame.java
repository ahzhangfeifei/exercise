package com.core.java.v2.v2ch07. book;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * The type Book test frame.
 */
public class BookTestFrame extends JFrame
{
   private JTextField text;
   private PageFormat pageFormat;
   private PrintRequestAttributeSet attributes;

   /**
    * Instantiates a new Book test frame.
    */
   public BookTestFrame()
   {
      text = new JTextField();
      add(text, BorderLayout.NORTH);

      attributes = new HashPrintRequestAttributeSet();

      JPanel buttonPanel = new JPanel();

      JButton printButton = new JButton("Print");
      buttonPanel.add(printButton);
      printButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               try
               {
                  PrinterJob job = PrinterJob.getPrinterJob();
                  job.setPageable(makeBook());
                  if (job.printDialog(attributes))
                  {
                     job.print(attributes);
                  }
               }
               catch (PrinterException e)
               {
                  JOptionPane.showMessageDialog(BookTestFrame.this, e);
               }
            }
         });

      JButton pageSetupButton = new JButton("Page setup");
      buttonPanel.add(pageSetupButton);
      pageSetupButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               PrinterJob job = PrinterJob.getPrinterJob();
               pageFormat = job.pageDialog(attributes);
            }
         });

      JButton printPreviewButton = new JButton("Print preview");
      buttonPanel.add(printPreviewButton);
      printPreviewButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               PrintPreviewDialog dialog = new PrintPreviewDialog(makeBook());
               dialog.setVisible(true);
            }
         });

      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }

   /**
    * Make book book.
    *
    * @return the book
    */
   public Book makeBook()
   {
      if (pageFormat == null)
      {
         PrinterJob job = PrinterJob.getPrinterJob();
         pageFormat = job.defaultPage();
      }
      Book book = new Book();
      String message = text.getText();
      Banner banner = new Banner(message);
      int pageCount = banner.getPageCount((Graphics2D) getGraphics(), pageFormat);
      book.append(new CoverPage(message + " (" + pageCount + " pages)"), pageFormat);
      book.append(banner, pageFormat, pageCount);
      return book;
   }
}
