package com.core.java.v1.v1ch09. optionDialog;

import javax.swing.*;

/**
 * The type Button panel.
 */
public class ButtonPanel extends JPanel
{
   private ButtonGroup group;

   /**
    * Instantiates a new Button panel.
    *
    * @param title   the title
    * @param options the options
    */
   public ButtonPanel(String title, String... options)
   {
      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      group = new ButtonGroup();

      // make one radio button for each option
      for (String option : options)
      {
         JRadioButton b = new JRadioButton(option);
         b.setActionCommand(option);
         add(b);
         group.add(b);
         b.setSelected(option == options[0]);
      }
   }

   /**
    * Gets selection.
    *
    * @return the selection
    */
   public String getSelection()
   {
      return group.getSelection().getActionCommand();
   }
}

