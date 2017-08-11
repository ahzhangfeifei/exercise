package com.core.java.v1.v1ch09. dataExchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Data exchange frame.
 */
public class DataExchangeFrame extends JFrame
{
   /**
    * The constant TEXT_ROWS.
    */
   public static final int TEXT_ROWS = 20;
   /**
    * The constant TEXT_COLUMNS.
    */
   public static final int TEXT_COLUMNS = 40;
   private PasswordChooser dialog = null;
   private JTextArea textArea;

   /**
    * Instantiates a new Data exchange frame.
    */
   public DataExchangeFrame()
   {
      // construct a File menu

      JMenuBar mbar = new JMenuBar();
      setJMenuBar(mbar);
      JMenu fileMenu = new JMenu("File");
      mbar.add(fileMenu);

      // add Connect and Exit menu items

      JMenuItem connectItem = new JMenuItem("Connect");
      connectItem.addActionListener(new ConnectAction());
      fileMenu.add(connectItem);

      // The Exit item exits the program

      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      fileMenu.add(exitItem);

      textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      pack();
   }

   private class ConnectAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         // if first time, construct dialog

         if (dialog == null) dialog = new PasswordChooser();

         // set default values
         dialog.setUser(new User("yourname", null));

         // pop up dialog
         if (dialog.showDialog(DataExchangeFrame.this, "Connect"))
         {
            // if accepted, retrieve user input
            User u = dialog.getUser();
            textArea.append("user name = " + u.getName() + ", password = "
                  + (new String(u.getPassword())) + "\n");
         }
      }
   }
}