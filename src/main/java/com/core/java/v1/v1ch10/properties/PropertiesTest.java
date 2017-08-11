package com.core.java.v1.v1ch10. properties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Properties test.
 */
public class PropertiesTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               PropertiesFrame frame = new PropertiesFrame();
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Properties frame.
 */
class PropertiesFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   private File propertiesFile;
   private Properties settings;

   /**
    * Instantiates a new Properties frame.
    */
   public PropertiesFrame()
   {
      // get position, size, title from properties

      String userDir = System.getProperty("user.home");
      File propertiesDir = new File(userDir, ".corejava");
      if (!propertiesDir.exists()) propertiesDir.mkdir();
      propertiesFile = new File(propertiesDir, "program.properties");

      Properties defaultSettings = new Properties();
      defaultSettings.put("left", "0");
      defaultSettings.put("top", "0");
      defaultSettings.put("width", "" + DEFAULT_WIDTH);
      defaultSettings.put("height", "" + DEFAULT_HEIGHT);
      defaultSettings.put("title", "");

      settings = new Properties(defaultSettings);

      if (propertiesFile.exists()) try
      {
         FileInputStream in = new FileInputStream(propertiesFile);
         settings.load(in);
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }

      int left = Integer.parseInt(settings.getProperty("left"));
      int top = Integer.parseInt(settings.getProperty("top"));
      int width = Integer.parseInt(settings.getProperty("width"));
      int height = Integer.parseInt(settings.getProperty("height"));
      setBounds(left, top, width, height);

      // if no title given, ask user

      String title = settings.getProperty("title");
      if (title.equals("")) title = JOptionPane.showInputDialog("Please supply a frame title:");
      if (title == null) title = "";
      setTitle(title);

      addWindowListener(new WindowAdapter()
         {
            public void windowClosing(WindowEvent event)
            {
               settings.put("left", "" + getX());
               settings.put("top", "" + getY());
               settings.put("width", "" + getWidth());
               settings.put("height", "" + getHeight());
               settings.put("title", getTitle());
               try
               {
                  FileOutputStream out = new FileOutputStream(propertiesFile);
                  settings.store(out, "Program Properties");
               }
               catch (IOException ex)
               {
                  ex.printStackTrace();
               }
               System.exit(0);
            }
         });
   }
}
