package com.design.mode.decorator;
import javax.swing.table.TableModel;

/**
 * The type Table sort decorator.
 * Created by zhangfeifei on 2016/12/08.
 */
public abstract class TableSortDecorator extends
                                         TableModelDecorator {
   /**
    * Sort.
    *
    * @param column the column
    */
// Extensions of TableSortDecorator must implement the
   // abstract sort method, in addition to tableChanged. The
   // latter is required because TableModelDecorator
   // implements the TableModelListener interface.
   abstract public void sort(int column);

    /**
     * Instantiates a new Table sort decorator.
     *
     * @param realModel the real model
     */
    public TableSortDecorator(TableModel realModel) {
      super(realModel);
   }
}
