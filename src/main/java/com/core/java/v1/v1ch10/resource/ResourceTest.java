package com.core.java.v1.v1ch10. resource;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * The type Resource test.
 */
public class ResourceTest
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
               JFrame frame = new ResourceTestFrame();
               frame.setTitle("ResourceTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Resource test frame.
 */
class ResourceTestFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 300;

   /**
    * Instantiates a new Resource test frame.
    */
   public ResourceTestFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      URL aboutURL = getClass().getResource("about.gif");
      Image img = new ImageIcon(aboutURL).getImage();
      setIconImage(img);

      JTextArea textArea = new JTextArea();
      InputStream stream = getClass().getResourceAsStream("about.txt");
      Scanner in = new Scanner(stream);
      while (in.hasNext())
         textArea.append(in.nextLine() + "\n");
      add(textArea);
   }
}
