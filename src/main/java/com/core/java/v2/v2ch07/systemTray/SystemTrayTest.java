package com.core.java.v2.v2ch07. systemTray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type System tray test.
 */
public class SystemTrayTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      SystemTrayApp app = new SystemTrayApp();
      app.init();
   }
}

/**
 * The type System tray app.
 */
class SystemTrayApp
{
   /**
    * Init.
    */
   public void init()
   {      
      final TrayIcon trayIcon;

      if (!SystemTray.isSupported())
      {
         System.err.println("System tray is not supported.");
         return;
      }

      SystemTray tray = SystemTray.getSystemTray();
      Image image = new ImageIcon(getClass().getResource("cookie.png")).getImage();

      PopupMenu popup = new PopupMenu();
      MenuItem exitItem = new MenuItem("Exit");
      exitItem.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               System.exit(0);
            }
         });
      popup.add(exitItem);

      trayIcon = new TrayIcon(image, "Your Fortune", popup);

      trayIcon.setImageAutoSize(true);
      trayIcon.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               trayIcon.displayMessage("How do I turn this off?",
                     "Right-click on the fortune cookie and select Exit.",
                     TrayIcon.MessageType.INFO);
            }
         });

      try
      {
         tray.add(trayIcon);
      }
      catch (AWTException e)
      {
         System.err.println("TrayIcon could not be added.");
         return;
      }

      final List<String> fortunes = readFortunes();
      Timer timer = new Timer(10000, new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               int index = (int) (fortunes.size() * Math.random());
               trayIcon.displayMessage("Your Fortune", fortunes.get(index),
                     TrayIcon.MessageType.INFO);
            }
         });
      timer.start();
   }

   private List<String> readFortunes()
   {
      List<String> fortunes = new ArrayList<>();
      try (InputStream inStream = getClass().getResourceAsStream("fortunes"))       
      {
         Scanner in = new Scanner(inStream); 
         StringBuilder fortune = new StringBuilder();
         while (in.hasNextLine())
         {
            String line = in.nextLine();
            if (line.equals("%"))
            {
               fortunes.add(fortune.toString());
               fortune = new StringBuilder();
            }
            else
            {
               fortune.append(line);
               fortune.append(' ');
            }
         }
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }
      return fortunes;
   }
}
