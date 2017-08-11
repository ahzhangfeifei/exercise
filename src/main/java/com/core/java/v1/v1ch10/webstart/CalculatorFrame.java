package com.core.java.v1.v1ch10. webstart;

import javax.jnlp.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The type Calculator frame.
 */
public class CalculatorFrame extends JFrame
{
   private CalculatorPanel panel;

   /**
    * Instantiates a new Calculator frame.
    */
   public CalculatorFrame()
   {
      setTitle();
      panel = new CalculatorPanel();
      add(panel);

      JMenu fileMenu = new JMenu("File");
      JMenuBar menuBar = new JMenuBar();
      menuBar.add(fileMenu);
      setJMenuBar(menuBar);

      JMenuItem openItem = fileMenu.add("Open");
      openItem.addActionListener(EventHandler.create(ActionListener.class, this, "open"));
      JMenuItem saveItem = fileMenu.add("Save");
      saveItem.addActionListener(EventHandler.create(ActionListener.class, this, "save"));
      
      pack();
   }

   /**
    * Sets title.
    */
   public void setTitle()
   {
      try
      {
         String title = null;

         BasicService basic = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
         URL codeBase = basic.getCodeBase();

         PersistenceService service = (PersistenceService) ServiceManager
               .lookup("javax.jnlp.PersistenceService");
         URL key = new URL(codeBase, "title");

         try
         {
            FileContents contents = service.get(key);
            InputStream in = contents.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            title = reader.readLine();
         }
         catch (FileNotFoundException e)
         {
            title = JOptionPane.showInputDialog("Please supply a frame title:");
            if (title == null) return;

            service.create(key, 100);
            FileContents contents = service.get(key);
            OutputStream out = contents.getOutputStream(true);
            PrintStream printOut = new PrintStream(out);
            printOut.print(title);
         }
         setTitle(title);
      }
      catch (UnavailableServiceException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
      catch (MalformedURLException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
      catch (IOException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }

   /**
    * Open.
    */
   public void open()
   {
      try
      {
         FileOpenService service = (FileOpenService) ServiceManager
               .lookup("javax.jnlp.FileOpenService");
         FileContents contents = service.openFileDialog(".", new String[] { "txt" });

         JOptionPane.showMessageDialog(this, contents.getName());
         if (contents != null)
         {
            InputStream in = contents.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null)
            {
               panel.append(line);
               panel.append("\n");
            }
         }
      }
      catch (UnavailableServiceException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
      catch (IOException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }

   /**
    * Save.
    */
   public void save()
   {
      try
      {
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         PrintStream printOut = new PrintStream(out);
         printOut.print(panel.getText());
         InputStream data = new ByteArrayInputStream(out.toByteArray());
         FileSaveService service = (FileSaveService) ServiceManager
               .lookup("javax.jnlp.FileSaveService");
         service.saveFileDialog(".", new String[] { "txt" }, data, "calc.txt");
      }
      catch (UnavailableServiceException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
      catch (IOException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }
}
