package com.core.java.v2.v2ch06. tableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * The type Investment table.
 */
public class InvestmentTable
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
               JFrame frame = new InvestmentTableFrame();
               frame.setTitle("InvestmentTable");               
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Investment table frame.
 */
class InvestmentTableFrame extends JFrame
{
   /**
    * Instantiates a new Investment table frame.
    */
   public InvestmentTableFrame()
   {
      TableModel model = new InvestmentTableModel(30, 5, 10);
      JTable table = new JTable(model);
      add(new JScrollPane(table));
      pack();
   }

}

/**
 * The type Investment table model.
 */
class InvestmentTableModel extends AbstractTableModel
{
   private static double INITIAL_BALANCE = 100000.0;
   
   private int years;
   private int minRate;
   private int maxRate;

   /**
    * Instantiates a new Investment table model.
    *
    * @param y  the y
    * @param r1 the r 1
    * @param r2 the r 2
    */
   public InvestmentTableModel(int y, int r1, int r2)
   {
      years = y;
      minRate = r1;
      maxRate = r2;
   }

   public int getRowCount()
   {
      return years;
   }

   public int getColumnCount()
   {
      return maxRate - minRate + 1;
   }

   public Object getValueAt(int r, int c)
   {
      double rate = (c + minRate) / 100.0;
      int nperiods = r;
      double futureBalance = INITIAL_BALANCE * Math.pow(1 + rate, nperiods);
      return String.format("%.2f", futureBalance);
   }

   public String getColumnName(int c)
   {
      return (c + minRate) + "%";
   }
}
