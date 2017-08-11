package com.core.java.v1.v1ch09. colorChooser;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Color chooser panel.
 */
public class ColorChooserPanel extends JPanel
{
   /**
    * Instantiates a new Color chooser panel.
    */
   public ColorChooserPanel()
   {
      JButton modalButton = new JButton("Modal");
      modalButton.addActionListener(new ModalListener());
      add(modalButton);

      JButton modelessButton = new JButton("Modeless");
      modelessButton.addActionListener(new ModelessListener());
      add(modelessButton);

      JButton immediateButton = new JButton("Immediate");
      immediateButton.addActionListener(new ImmediateListener());
      add(immediateButton);
   }

   private class ModalListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         Color defaultColor = getBackground();
         Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background",
               defaultColor);
         if (selected != null) setBackground(selected);
      }
   }

   private class ModelessListener implements ActionListener
   {
      private JDialog dialog;
      private JColorChooser chooser;

      /**
       * Instantiates a new Modeless listener.
       */
      public ModelessListener()
      {
         chooser = new JColorChooser();
         dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color",
               false /* not modal */, chooser, 
               new ActionListener() // OK button listener               
                  {
                     public void actionPerformed(ActionEvent event)
                     {
                        setBackground(chooser.getColor());
                     }
                  }, null /* no Cancel button listener */);
      }

      public void actionPerformed(ActionEvent event)
      {
         chooser.setColor(getBackground());
         dialog.setVisible(true);
      }
   }

   private class ImmediateListener implements ActionListener
   {
      private JDialog dialog;
      private JColorChooser chooser;

      /**
       * Instantiates a new Immediate listener.
       */
      public ImmediateListener()
      {
         chooser = new JColorChooser();
         chooser.getSelectionModel().addChangeListener(new ChangeListener()
            {
               public void stateChanged(ChangeEvent event)
               {
                  setBackground(chooser.getColor());
               }
            });

         dialog = new JDialog((Frame) null, false /* not modal */);
         dialog.add(chooser);
         dialog.pack();
      }

      public void actionPerformed(ActionEvent event)
      {
         chooser.setColor(getBackground());
         dialog.setVisible(true);
      }
   }
}
