package com.design.mode.decorator;
import javax.swing.table.TableModel;

/**
 * The type Table filter decorator.
 * Created by zhangfeifei on 2016/12/08.
 */
public abstract class TableFilterDecorator extends
                                         TableModelDecorator {
   /**
    * Filter.
    */
// Extensions of TableSortDecorator must implement the
   // abstract sort method, in addition to tableChanged. The
   // latter is required because TableModelDecorator
   // implements the TableModelListener interface.
   abstract public void filter();

    /**
     * Instantiates a new Table filter decorator.
     *
     * @param realModel the real model
     */
    public TableFilterDecorator(TableModel realModel) {
      super(realModel);
   }
}
