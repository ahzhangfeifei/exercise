package com.core.java.v1.v1ch08. plaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Plaf frame.
 */
public class PlafFrame extends JFrame
{
   private JPanel buttonPanel;

   /**
    * Instantiates a new Plaf frame.
    */
   public PlafFrame()
   {
      buttonPanel = new JPanel();
      
      UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
      for (UIManager.LookAndFeelInfo info : infos)
         makeButton(info.getName(), info.getClassName());
      
      add(buttonPanel);
      pack();
   }

   /**
    * Make button.
    *
    * @param name     the name
    * @param plafName the plaf name
    */
   void makeButton(String name, final String plafName)
   {
      // add button to panel

      JButton button = new JButton(name);
      buttonPanel.add(button);

      // set button action

      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               // button action: switch to the new look and feel
               try
               {
                  UIManager.setLookAndFeel(plafName);
                  SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                  pack();
               }
               catch (Exception e)
               {
                  e.printStackTrace();
               }
            }
         });
   }  
}
