package com.core.java.v2.v2ch08. imageViewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Image viewer bean.
 */
public class ImageViewerBean extends JLabel
{
   private Path path = null;
   private static final int XPREFSIZE = 200;
   private static final int YPREFSIZE = 200;

   /**
    * Instantiates a new Image viewer bean.
    */
   public ImageViewerBean()
   {
      setBorder(BorderFactory.createEtchedBorder());
   }

   /**
    * Sets file name.
    *
    * @param fileName the file name
    */
   public void setFileName(String fileName)
   {
      path = Paths.get(fileName);
      try (InputStream in = Files.newInputStream(path))
      {
         setIcon(new ImageIcon(ImageIO.read(in)));
      }
      catch (IOException e)
      {
         path = null;
         setIcon(null);
      }
   }

   /**
    * Gets file name.
    *
    * @return the file name
    */
   public String getFileName()
   {
      if (path == null) return "";
      else return path.toString();
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(XPREFSIZE, YPREFSIZE);
   }
}
