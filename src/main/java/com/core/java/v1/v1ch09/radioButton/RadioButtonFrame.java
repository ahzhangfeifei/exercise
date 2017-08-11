package com.core.java.v1.v1ch09. radioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Radio button frame.
 */
public class RadioButtonFrame extends JFrame
{
   private JPanel buttonPanel;
   private ButtonGroup group;
   private JLabel label;
   private static final int DEFAULT_SIZE = 36;

   /**
    * Instantiates a new Radio button frame.
    */
   public RadioButtonFrame()
   {      
      // add the sample text label

      label = new JLabel("The quick brown fox jumps over the lazy dog.");
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, BorderLayout.CENTER);

      // add the radio buttons

      buttonPanel = new JPanel();
      group = new ButtonGroup();

      addRadioButton("Small", 8);
      addRadioButton("Medium", 12);
      addRadioButton("Large", 18);
      addRadioButton("Extra large", 36);

      add(buttonPanel, BorderLayout.SOUTH);
      pack();
   }

   /**
    * Add radio button.
    *
    * @param name the name
    * @param size the size
    */
   public void addRadioButton(String name, final int size)
   {
      boolean selected = size == DEFAULT_SIZE;
      JRadioButton button = new JRadioButton(name, selected);
      group.add(button);
      buttonPanel.add(button);

      // this listener sets the label font size

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // size refers to the final parameter of the addRadioButton
               // method
               label.setFont(new Font("Serif", Font.PLAIN, size));
            }
         };

      button.addActionListener(listener);
   }
}