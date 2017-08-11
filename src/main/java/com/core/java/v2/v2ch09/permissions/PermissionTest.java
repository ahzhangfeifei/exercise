package com.core.java.v2.v2ch09. permissions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Permission test.
 */
public class PermissionTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      System.setProperty("java.encrypt.policy", "permissions/PermissionTest.policy");
      System.setSecurityManager(new SecurityManager());
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new PermissionTestFrame();
               frame.setTitle("PermissionTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Permission test frame.
 */
class PermissionTestFrame extends JFrame
{
   private JTextField textField;
   private WordCheckTextArea textArea;
   private static final int TEXT_ROWS = 20;
   private static final int TEXT_COLUMNS = 60;

   /**
    * Instantiates a new Permission test frame.
    */
   public PermissionTestFrame()
   {
      textField = new JTextField(20);
      JPanel panel = new JPanel();
      panel.add(textField);
      JButton openButton = new JButton("Insert");
      panel.add(openButton);
      openButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               insertWords(textField.getText());
            }
         });

      add(panel, BorderLayout.NORTH);

      textArea = new WordCheckTextArea();
      textArea.setRows(TEXT_ROWS);
      textArea.setColumns(TEXT_COLUMNS);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      pack();
   }

   /**
    * Insert words.
    *
    * @param words the words
    */
   public void insertWords(String words)
   {
      try
      {
         textArea.append(words + "\n");
      }
      catch (SecurityException ex)
      {
         JOptionPane.showMessageDialog(this, "I am sorry, but I cannot do that.");
         ex.printStackTrace();
      }
   }
}

/**
 * The type Word check text area.
 */
class WordCheckTextArea extends JTextArea
{
   public void append(String text)
   {
      WordCheckPermission p = new WordCheckPermission(text, "insert");
      SecurityManager manager = System.getSecurityManager();
      if (manager != null) manager.checkPermission(p);
      super.append(text);
   }
}
