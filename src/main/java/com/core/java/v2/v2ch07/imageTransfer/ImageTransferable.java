package com.core.java.v2.v2ch07. imageTransfer;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 * The type Image transferable.
 */
public class ImageTransferable implements Transferable
{
   private Image theImage;

   /**
    * Instantiates a new Image transferable.
    *
    * @param image the image
    */
   public ImageTransferable(Image image)
   {
      theImage = image;
   }

   public DataFlavor[] getTransferDataFlavors()
   {
      return new DataFlavor[] { DataFlavor.imageFlavor };
   }

   public boolean isDataFlavorSupported(DataFlavor flavor)
   {
      return flavor.equals(DataFlavor.imageFlavor);
   }

   public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
   {
      if (flavor.equals(DataFlavor.imageFlavor))
      {
         return theImage;
      }
      else
      {
         throw new UnsupportedFlavorException(flavor);
      }
   }
}
