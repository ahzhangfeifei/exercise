package com.core.java.v1.v1ch09. fileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;

/**
 * The type File icon view.
 */
public class FileIconView extends FileView
{
   private FileFilter filter;
   private Icon icon;

   /**
    * Instantiates a new File icon view.
    *
    * @param aFilter the a filter
    * @param anIcon  the an icon
    */
   public FileIconView(FileFilter aFilter, Icon anIcon)
   {
      filter = aFilter;
      icon = anIcon;
   }

   public Icon getIcon(File f)
   {
      if (!f.isDirectory() && filter.accept(f)) return icon;
      else return null;
   }
}
