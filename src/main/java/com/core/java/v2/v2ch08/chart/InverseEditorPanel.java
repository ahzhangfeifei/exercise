package com.core.java.v2.v2ch08. chart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyEditorSupport;

/**
 * The type Inverse editor panel.
 */
public class InverseEditorPanel extends JPanel
{
   private JButton button;
   private PropertyEditorSupport editor;
   private ImageIcon normalIcon = new ImageIcon(getClass().getResource("ChartBean_MONO_16x16.gif"));

   /**
    * Instantiates a new Inverse editor panel.
    *
    * @param ed the ed
    */
   public InverseEditorPanel(PropertyEditorSupport ed)
   {
      editor = ed;
      button = new JButton();
      updateButton();
      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               editor.setValue(!(Boolean) editor.getValue());
               updateButton();
            }
         });
      add(button);
   }

   private void updateButton()
   {
      if ((Boolean) editor.getValue())
      {
         button.setIcon(inverseIcon);
         button.setText("Inverse");
      }
      else
      {
         button.setIcon(normalIcon);
         button.setText("Normal");
      }
   }

   private ImageIcon inverseIcon = new ImageIcon(getClass().getResource(
         "ChartBean_INVERSE_16x16.gif"));
}
