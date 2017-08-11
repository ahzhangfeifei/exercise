package com.core.java.v2.v2ch07. print;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * The type Print test frame.
 */
public class PrintTestFrame extends JFrame
{
   private PrintComponent canvas;
   private PrintRequestAttributeSet attributes;

   /**
    * Instantiates a new Print test frame.
    */
   public PrintTestFrame()
   {
      canvas = new PrintComponent();
      add(canvas, BorderLayout.CENTER);

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
                  job.setPrintable(canvas);
                  if (job.printDialog(attributes)) job.print(attributes);
               }
               catch (PrinterException e)
               {
                  JOptionPane.showMessageDialog(PrintTestFrame.this, e);
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
               job.pageDialog(attributes);
            }
         });

      add(buttonPanel, BorderLayout.NORTH);
      pack();
   }
}