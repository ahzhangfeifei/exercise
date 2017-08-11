package com.core.java.v2.v2ch06. tableCellRender;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * The type Table cell render frame.
 */
public class TableCellRenderFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 600;
   private static final int DEFAULT_HEIGHT = 400;

   /**
    * Instantiates a new Table cell render frame.
    */
   public TableCellRenderFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      TableModel model = new PlanetTableModel();
      JTable table = new JTable(model);
      table.setRowSelectionAllowed(false);

      // set up renderers and editors

      table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
      table.setDefaultEditor(Color.class, new ColorTableCellEditor());

      JComboBox<Integer> moonCombo = new JComboBox<>();
      for (int i = 0; i <= 20; i++)
         moonCombo.addItem(i);

      TableColumnModel columnModel = table.getColumnModel();
      TableColumn moonColumn = columnModel.getColumn(PlanetTableModel.MOONS_COLUMN);
      moonColumn.setCellEditor(new DefaultCellEditor(moonCombo));
      moonColumn.setHeaderRenderer(table.getDefaultRenderer(ImageIcon.class));
      moonColumn.setHeaderValue(new ImageIcon(getClass().getResource("Moons.gif")));

      // show table

      table.setRowHeight(100);
      add(new JScrollPane(table), BorderLayout.CENTER);
   }
}

