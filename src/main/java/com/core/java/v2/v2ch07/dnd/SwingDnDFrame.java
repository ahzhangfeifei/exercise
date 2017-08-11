package com.core.java.v2.v2ch07. dnd;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * The type Swing dn d frame.
 */
public class SwingDnDFrame extends JFrame
{
   /**
    * Instantiates a new Swing dn d frame.
    */
   public SwingDnDFrame()
   {
      JTabbedPane tabbedPane = new JTabbedPane();

      JList<String> list = SampleComponents.list();
      tabbedPane.addTab("List", list);
      JTable table = SampleComponents.table();
      tabbedPane.addTab("Table", table);
      JTree tree = SampleComponents.tree();
      tabbedPane.addTab("Tree", tree);
      JFileChooser fileChooser = new JFileChooser();
      tabbedPane.addTab("File Chooser", fileChooser);
      JColorChooser colorChooser = new JColorChooser();
      tabbedPane.addTab("Color Chooser", colorChooser);

      final JTextArea textArea = new JTextArea(4, 40);
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Drag text here"));

      JTextField textField = new JTextField("Drag color here");
      textField.setTransferHandler(new TransferHandler("background"));
      
      tabbedPane.addChangeListener(new ChangeListener()
         {
            public void stateChanged(ChangeEvent e)
            {
               textArea.setText("");             
            }
         });

      tree.setDragEnabled(true);
      table.setDragEnabled(true);
      list.setDragEnabled(true);
      fileChooser.setDragEnabled(true);
      colorChooser.setDragEnabled(true);
      textField.setDragEnabled(true);

      add(tabbedPane, BorderLayout.NORTH);
      add(scrollPane, BorderLayout.CENTER);
      add(textField, BorderLayout.SOUTH);
      pack();
   }
}
