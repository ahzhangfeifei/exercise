package com.core.java.v2.v2ch06. treeModel;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * The type Object tree model.
 */
public class ObjectTreeModel implements TreeModel
{
   private Variable root;
   private EventListenerList listenerList = new EventListenerList();

   /**
    * Instantiates a new Object tree model.
    */
   public ObjectTreeModel()
   {
      root = null;
   }

   /**
    * Sets root.
    *
    * @param v the v
    */
   public void setRoot(Variable v)
   {
      Variable oldRoot = v;
      root = v;
      fireTreeStructureChanged(oldRoot);
   }

   public Object getRoot()
   {
      return root;
   }

   public int getChildCount(Object parent)
   {
      return ((Variable) parent).getFields().size();
   }

   public Object getChild(Object parent, int index)
   {
      ArrayList<Field> fields = ((Variable) parent).getFields();
      Field f = (Field) fields.get(index);
      Object parentValue = ((Variable) parent).getValue();
      try
      {
         return new Variable(f.getType(), f.getName(), f.get(parentValue));
      }
      catch (IllegalAccessException e)
      {
         return null;
      }
   }

   public int getIndexOfChild(Object parent, Object child)
   {
      int n = getChildCount(parent);
      for (int i = 0; i < n; i++)
         if (getChild(parent, i).equals(child)) return i;
      return -1;
   }

   public boolean isLeaf(Object node)
   {
      return getChildCount(node) == 0;
   }

   public void valueForPathChanged(TreePath path, Object newValue)
   {
   }

   public void addTreeModelListener(TreeModelListener l)
   {
      listenerList.add(TreeModelListener.class, l);
   }

   public void removeTreeModelListener(TreeModelListener l)
   {
      listenerList.remove(TreeModelListener.class, l);
   }

   /**
    * Fire tree structure changed.
    *
    * @param oldRoot the old root
    */
   protected void fireTreeStructureChanged(Object oldRoot)
   {
      TreeModelEvent event = new TreeModelEvent(this, new Object[] { oldRoot });
      for (TreeModelListener l : listenerList.getListeners(TreeModelListener.class))
         l.treeStructureChanged(event);
   }
}
