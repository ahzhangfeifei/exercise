package com.core.java.v1.v1ch09. dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type About dialog.
 */
public class AboutDialog extends JDialog
{
   /**
    * Instantiates a new About dialog.
    *
    * @param owner the owner
    */
   public AboutDialog(JFrame owner)
   {
      super(owner, "About DialogTest", true);

      // add HTML label to center

      add(
            new JLabel(
                  "<html><h1><i>Core Java</i></h1><hr>By Cay Horstmann and Gary Cornell</html>"),
            BorderLayout.CENTER);

      // OK button closes the dialog

      JButton ok = new JButton("OK");
      ok.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setVisible(false);
            }
         });

      // add OK button to southern border

      JPanel panel = new JPanel();
      panel.add(ok);
      add(panel, BorderLayout.SOUTH);

      pack();
   }
}
