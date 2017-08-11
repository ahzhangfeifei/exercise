package com.core.java.v2.v2ch09. signed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The type File read applet.
 */
public class FileReadApplet extends JApplet
{
   private JTextField fileNameField;
   private JTextArea fileText;

   public void init()
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               fileNameField = new JTextField(20);
               JPanel panel = new JPanel();
               panel.add(new JLabel("File name:"));
               panel.add(fileNameField);
               JButton openButton = new JButton("Open");
               panel.add(openButton);
               ActionListener listener = new ActionListener()
               {
                  public void actionPerformed(ActionEvent event)
                  {
                     loadFile(fileNameField.getText());
                  }
               };
               fileNameField.addActionListener(listener);
               openButton.addActionListener(listener);

               add(panel, "North");

               fileText = new JTextArea();
               add(new JScrollPane(fileText), "Center");
            }
         });
   }

   /**
    * Load file.
    *
    * @param filename the filename
    */
   public void loadFile(String filename)
   {
      fileText.setText("");
      try 
      {
         fileText.append(new String(Files.readAllBytes(Paths.get(filename))));            
      }
      catch (IOException ex)
      {
         fileText.append(ex + "\n");
      }
      catch (SecurityException ex)
      {
         fileText.append("I am sorry, but I cannot do that.\n");
         fileText.append(ex + "\n");
         ex.printStackTrace();
      }
   }
}
