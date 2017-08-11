package com.core.java.v2.v2ch08. persistentFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The type Persistent frame test.
 */
public class PersistentFrameTest
{
   private static JFileChooser chooser;
   private JFrame frame;

   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      chooser = new JFileChooser();
      chooser.setCurrentDirectory(new File("."));      
      PersistentFrameTest test = new PersistentFrameTest();
      test.init();
   }

   /**
    * Init.
    */
   public void init()
   {
      frame = new JFrame();
      frame.setLayout(new FlowLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("PersistentFrameTest");
      frame.setSize(400, 200);

      JButton loadButton = new JButton("Load");
      frame.add(loadButton);
      loadButton.addActionListener(EventHandler.create(ActionListener.class, this, "load"));

      JButton saveButton = new JButton("Save");
      frame.add(saveButton);
      saveButton.addActionListener(EventHandler.create(ActionListener.class, this, "save"));
     
      frame.setVisible(true);
   }

   /**
    * Load.
    */
   public void load()
   {
      // show file chooser dialog
      int r = chooser.showOpenDialog(null);

      // if file selected, open
      if(r == JFileChooser.APPROVE_OPTION)
      {
         try
         {
            File file = chooser.getSelectedFile();
            XMLDecoder decoder = new XMLDecoder(new FileInputStream(file));
            decoder.readObject(); 
            decoder.close();
         }
         catch (IOException e)
         {
            JOptionPane.showMessageDialog(null, e);
         }
      }
   }

   /**
    * Save.
    */
   public void save()
   {
      if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
      {
         try
         {
            File file = chooser.getSelectedFile();
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file));
            encoder.writeObject(frame);
            encoder.close();
         }
         catch (IOException e)
         {
            JOptionPane.showMessageDialog(null, e);
         }
      }
   }
}
