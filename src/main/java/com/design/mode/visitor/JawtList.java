package com.design.mode.visitor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Vector;

/**
 * The type Jawt list.
 */
public class JawtList extends JScrollPane
        implements ListSelectionListener, awtList {
    private JList listWindow;
    private JListData listContents;

    /**
     * Instantiates a new Jawt list.
     *
     * @param rows the rows
     */

    public JawtList(int rows) {
        listContents = new JListData();
        listWindow = new JList(listContents);
        listWindow.setPrototypeCellValue("Abcdefg Hijkmnop");
        getViewport().add(listWindow);

    }

    public void add(String s) {
        listContents.addElement(s);
    }

    public void remove(String s) {
        listContents.removeElement(s);
    }

    /**
     * Clear.
     */

    public void clear() {
        listContents.clear();
    }

    public String[] getSelectedItems() {
        Object[] obj = listWindow.getSelectedValues();
        String[] s = new String[obj.length];
        for (int i = 0; i < obj.length; i++)
            s[i] = obj[i].toString();
        return s;
    }

    public void valueChanged(ListSelectionEvent e) {
    }

}

/**
 * The type J list data.
 */
class JListData extends AbstractListModel {
    private Vector data;

    /**
     * Instantiates a new J list data.
     */

    public JListData() {
        data = new Vector();
    }

    public int getSize() {
        return data.size();
    }

    public Object getElementAt(int index) {
        return data.elementAt(index);
    }

    /**
     * Add element.
     *
     * @param s the s
     */
    public void addElement(String s) {
        data.addElement(s);
        fireIntervalAdded(this, data.size() - 1, data.size());
    }

    /**
     * Remove element.
     *
     * @param s the s
     */
    public void removeElement(String s) {
        data.removeElement(s);
        fireIntervalRemoved(this, 0, data.size());
    }

    /**
     * Clear.
     */
    public void clear() {
        int size = data.size();
        data = new Vector();
        fireIntervalRemoved(this, 0, size);
    }
}

