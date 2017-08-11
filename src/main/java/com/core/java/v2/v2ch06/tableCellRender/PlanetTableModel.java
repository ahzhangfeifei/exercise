package com.core.java.v2.v2ch06. tableCellRender;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * The type Planet table model.
 */
public class PlanetTableModel extends AbstractTableModel
{
   /**
    * The constant PLANET_COLUMN.
    */
   public static final int PLANET_COLUMN = 0;
   /**
    * The constant MOONS_COLUMN.
    */
   public static final int MOONS_COLUMN = 2;
   /**
    * The constant GASEOUS_COLUMN.
    */
   public static final int GASEOUS_COLUMN = 3;
   /**
    * The constant COLOR_COLUMN.
    */
   public static final int COLOR_COLUMN = 4;

   private Object[][] cells = {
         { "Mercury", 2440.0, 0, false, Color.YELLOW, 
            new ImageIcon(getClass().getResource("Mercury.gif")) },
         { "Venus", 6052.0, 0, false, Color.YELLOW, 
            new ImageIcon(getClass().getResource("Venus.gif")) },
         { "Earth", 6378.0, 1, false, Color.BLUE, 
            new ImageIcon(getClass().getResource("Earth.gif")) },
         { "Mars", 3397.0, 2, false, Color.RED, 
            new ImageIcon(getClass().getResource("Mars.gif")) },
         { "Jupiter", 71492.0, 16, true, Color.ORANGE, 
            new ImageIcon(getClass().getResource("Jupiter.gif")) },
         { "Saturn", 60268.0, 18, true, Color.ORANGE, 
            new ImageIcon(getClass().getResource("Saturn.gif")) },
         { "Uranus", 25559.0, 17, true, Color.BLUE, 
            new ImageIcon(getClass().getResource("Uranus.gif")) },
         { "Neptune", 24766.0, 8, true, Color.BLUE, 
            new ImageIcon(getClass().getResource("Neptune.gif")) },
         { "Pluto", 1137.0, 1, false, Color.BLACK, 
            new ImageIcon(getClass().getResource("Pluto.gif")) } };

   private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color", "Image" };

   public String getColumnName(int c)
   {
      return columnNames[c];
   }

   public Class<?> getColumnClass(int c)
   {
      return cells[0][c].getClass();
   }

   public int getColumnCount()
   {
      return cells[0].length;
   }

   public int getRowCount()
   {
      return cells.length;
   }

   public Object getValueAt(int r, int c)
   {
      return cells[r][c];
   }

   public void setValueAt(Object obj, int r, int c)
   {
      cells[r][c] = obj;
   }

   public boolean isCellEditable(int r, int c)
   {
      return c == PLANET_COLUMN || c == MOONS_COLUMN || c == GASEOUS_COLUMN || c == COLOR_COLUMN;
   }
}