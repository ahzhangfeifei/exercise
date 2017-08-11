package com.core.java.v1.v1ch09. checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Check box frame.
 */
public class CheckBoxFrame extends JFrame
{
   private JLabel label;
   private JCheckBox bold;
   private JCheckBox italic;
   private static final int FONTSIZE = 24;

   /**
    * Instantiates a new Check box frame.
    */
   public CheckBoxFrame()
   {      
      // add the sample text label

      label = new JLabel("The quick brown fox jumps over the lazy dog.");
      label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
      add(label, BorderLayout.CENTER);

      // this listener sets the font attribute of
      // the label to the check box state

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int mode = 0;
               if (bold.isSelected()) mode += Font.BOLD;
               if (italic.isSelected()) mode += Font.ITALIC;
               label.setFont(new Font("Serif", mode, FONTSIZE));
            }
         };

      // add the check boxes

      JPanel buttonPanel = new JPanel();

      bold = new JCheckBox("Bold");
      bold.addActionListener(listener);
      bold.setSelected(true);
      buttonPanel.add(bold);

      italic = new JCheckBox("Italic");
      italic.addActionListener(listener);
      buttonPanel.add(italic);

      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }
}
