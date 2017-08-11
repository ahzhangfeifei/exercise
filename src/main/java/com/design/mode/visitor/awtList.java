package com.design.mode.visitor;

/**
 * The interface Awt list.
 */
public interface awtList
{
     /**
      * Add.
      *
      * @param s the s
      */
     public void add(String s);

     /**
      * Remove.
      *
      * @param s the s
      */
     public void remove(String s);

     /**
      * Get selected items string [ ].
      *
      * @return the string [ ]
      */
     public String[] getSelectedItems();

}

