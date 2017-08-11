package com.core.java.v1.v1ch09. text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Text component frame.
 */
public class TextComponentFrame extends JFrame
{
   /**
    * The constant TEXTAREA_ROWS.
    */
   public static final int TEXTAREA_ROWS = 8;
   /**
    * The constant TEXTAREA_COLUMNS.
    */
   public static final int TEXTAREA_COLUMNS = 20;

   /**
    * Instantiates a new Text component frame.
    */
   public TextComponentFrame()
   {
      final JTextField textField = new JTextField();
      final JPasswordField passwordField = new JPasswordField();

      JPanel northPanel = new JPanel();
      northPanel.setLayout(new GridLayout(2, 2));
      northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
      northPanel.add(textField);
      northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
      northPanel.add(passwordField);

      add(northPanel, BorderLayout.NORTH);

      final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
      JScrollPane scrollPane = new JScrollPane(textArea);

      add(scrollPane, BorderLayout.CENTER);

      // add button to append text into the text area

      JPanel southPanel = new JPanel();

      JButton insertButton = new JButton("Insert");
      southPanel.add(insertButton);
      insertButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               textArea.append("User name: " + textField.getText() + " Password: "
                     + new String(passwordField.getPassword()) + "\n");
            }
         });

      add(southPanel, BorderLayout.SOUTH);
      pack();
   }
}
