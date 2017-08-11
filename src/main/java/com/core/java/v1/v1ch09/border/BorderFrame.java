package com.core.java.v1.v1ch09. border;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Border frame.
 */
public class BorderFrame extends JFrame
{
   private JPanel demoPanel;
   private JPanel buttonPanel;
   private ButtonGroup group;

   /**
    * Instantiates a new Border frame.
    */
   public BorderFrame()
   {
      demoPanel = new JPanel();
      buttonPanel = new JPanel();
      group = new ButtonGroup();

      addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
      addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
      addRadioButton("Etched", BorderFactory.createEtchedBorder());
      addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
      addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
      addRadioButton("Empty", BorderFactory.createEmptyBorder());

      Border etched = BorderFactory.createEtchedBorder();
      Border titled = BorderFactory.createTitledBorder(etched, "Border types");
      buttonPanel.setBorder(titled);

      setLayout(new GridLayout(2, 1));
      add(buttonPanel);
      add(demoPanel);
      pack();
   }

   /**
    * Add radio button.
    *
    * @param buttonName the button name
    * @param b          the b
    */
   public void addRadioButton(String buttonName, final Border b)
   {
      JRadioButton button = new JRadioButton(buttonName);
      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               demoPanel.setBorder(b);
            }
         });
      group.add(button);
      buttonPanel.add(button);
   }
}
