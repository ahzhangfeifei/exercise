package com.core.java.v2.v2ch06. table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * The type Table test.
 */
public class TableTest
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
               JFrame frame = new PlanetTableFrame();
               frame.setTitle("TableTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Planet table frame.
 */
class PlanetTableFrame extends JFrame
{
   private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color" };
   private Object[][] cells = { { "Mercury", 2440.0, 0, false, Color.YELLOW },
         { "Venus", 6052.0, 0, false, Color.YELLOW }, { "Earth", 6378.0, 1, false, Color.BLUE },
         { "Mars", 3397.0, 2, false, Color.RED }, { "Jupiter", 71492.0, 16, true, Color.ORANGE },
         { "Saturn", 60268.0, 18, true, Color.ORANGE },
         { "Uranus", 25559.0, 17, true, Color.BLUE }, { "Neptune", 24766.0, 8, true, Color.BLUE },
         { "Pluto", 1137.0, 1, false, Color.BLACK } };

   /**
    * Instantiates a new Planet table frame.
    */
   public PlanetTableFrame()
   {
      final JTable table = new JTable(cells, columnNames);
      table.setAutoCreateRowSorter(true);
      add(table, BorderLayout.CENTER);
      JButton printButton = new JButton("Print");
      printButton.addActionListener(EventHandler.create(ActionListener.class, table, "print"));
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(printButton);
      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }
}
