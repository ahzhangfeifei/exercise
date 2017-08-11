package com.core.java.v2.v2ch06. treeRender;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.lang.reflect.Modifier;

/**
 * The type Class name tree cell renderer.
 */
public class ClassNameTreeCellRenderer extends DefaultTreeCellRenderer
{
   private Font plainFont = null;
   private Font italicFont = null;

   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
         boolean expanded, boolean leaf, int row, boolean hasFocus)
   {
      super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
      // get the user object
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
      Class<?> c = (Class<?>) node.getUserObject();

      // the first time, derive italic font from plain font
      if (plainFont == null)
      {
         plainFont = getFont();
         // the tree cell renderer is sometimes called with a label that has a null font
         if (plainFont != null) italicFont = plainFont.deriveFont(Font.ITALIC);
      }

      // set font to italic if the class is abstract, plain otherwise
      if ((c.getModifiers() & Modifier.ABSTRACT) == 0) setFont(plainFont);
      else setFont(italicFont);
      return this;
   }
}
