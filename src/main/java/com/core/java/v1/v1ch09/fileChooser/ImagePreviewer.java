package com.core.java.v1.v1ch09. fileChooser;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

/**
 * The type Image previewer.
 */
public class ImagePreviewer extends JLabel
{
   /**
    * Instantiates a new Image previewer.
    *
    * @param chooser the chooser
    */
   public ImagePreviewer(JFileChooser chooser)
   {
      setPreferredSize(new Dimension(100, 100));
      setBorder(BorderFactory.createEtchedBorder());

      chooser.addPropertyChangeListener(new PropertyChangeListener()
         {
            public void propertyChange(PropertyChangeEvent event)
            {
               if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
               {
                  // the user has selected a new file
                  File f = (File) event.getNewValue();
                  if (f == null)
                  {
                     setIcon(null);
                     return;
                  }

                  // read the image into an icon
                  ImageIcon icon = new ImageIcon(f.getPath());

                  // if the icon is too large to fit, scale it
                  if (icon.getIconWidth() > getWidth()) icon = new ImageIcon(icon.getImage()
                        .getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));

                  setIcon(icon);
               }
            }
         });
   }
}
