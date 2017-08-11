package com.core.java.v2.v2ch06. tableCellRender;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * The type Color table cell renderer.
 */
public class ColorTableCellRenderer extends JPanel implements TableCellRenderer
{
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
         boolean hasFocus, int row, int column)
   {
      setBackground((Color) value);
      if (hasFocus) setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
      else setBorder(null);
      return this;
   }
}