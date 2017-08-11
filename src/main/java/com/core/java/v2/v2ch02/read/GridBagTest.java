package com.core.java.v2.v2ch02. read;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The type Grid bag test.
 */
public class GridBagTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFileChooser chooser = new JFileChooser(".");
               chooser.showOpenDialog(null);
               File file = chooser.getSelectedFile();
               JFrame frame = new FontFrame(file);
               frame.setTitle("GridBagTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Font frame.
 */
class FontFrame extends JFrame
{
   private GridBagPane gridbag;
   private JComboBox<String> face;
   private JComboBox<String> size;
   private JCheckBox bold;
   private JCheckBox italic;

   /**
    * Instantiates a new Font frame.
    *
    * @param file the file
    */
   @SuppressWarnings("unchecked")
   public FontFrame(File file)
   {
      gridbag = new GridBagPane(file);
      add(gridbag);

      face = (JComboBox<String>) gridbag.get("face");
      size = (JComboBox<String>) gridbag.get("size");
      bold = (JCheckBox) gridbag.get("bold");
      italic = (JCheckBox) gridbag.get("italic");

      face.setModel(new DefaultComboBoxModel<String>(new String[] { "Serif", 
            "SansSerif", "Monospaced", "Dialog", "DialogInput" }));

      size.setModel(new DefaultComboBoxModel<String>(new String[] { "8", 
            "10", "12", "15", "18", "24", "36", "48" }));

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setSample();
            }
         };

      face.addActionListener(listener);
      size.addActionListener(listener);
      bold.addActionListener(listener);
      italic.addActionListener(listener);

      setSample();
      pack();
   }

   /**
    * Sets sample.
    */
   public void setSample()
   {
      String fontFace = face.getItemAt(face.getSelectedIndex());
      int fontSize = Integer.parseInt(size.getItemAt(size.getSelectedIndex()));
      JTextArea sample = (JTextArea) gridbag.get("sample");
      int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
            + (italic.isSelected() ? Font.ITALIC : 0);

      sample.setFont(new Font(fontFace, fontStyle, fontSize));
      sample.repaint();
   }
}
