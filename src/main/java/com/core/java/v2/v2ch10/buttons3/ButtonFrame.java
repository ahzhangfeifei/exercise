package com.core.java.v2.v2ch10. buttons3;


import com.core.java.v2.v2ch10.runtimeAnnotations.ActionListenerFor;
import com.core.java.v2.v2ch10.runtimeAnnotations.ActionListenerInstaller;

import javax.swing.*;
import java.awt.*;

/**
 * The type Button frame.
 */
public class ButtonFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   private JPanel panel;
   private JButton yellowButton;
   private JButton blueButton;
   private JButton redButton;

   /**
    * Instantiates a new Button frame.
    */
   public ButtonFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      panel = new JPanel();
      add(panel);

      yellowButton = new JButton("Yellow");
      blueButton = new JButton("Blue");
      redButton = new JButton("Red");

      panel.add(yellowButton);
      panel.add(blueButton);
      panel.add(redButton);

      ActionListenerInstaller.processAnnotations(this);
   }

   /**
    * Yellow background.
    */
   @ActionListenerFor(source = "yellowButton")
   public void yellowBackground()
   {
      panel.setBackground(Color.YELLOW);
   }

   /**
    * Blue background.
    */
   @ActionListenerFor(source = "blueButton")
   public void blueBackground()
   {
      panel.setBackground(Color.BLUE);
   }

   /**
    * Red background.
    */
   @ActionListenerFor(source = "redButton")
   public void redBackground()
   {
      panel.setBackground(Color.RED);
   }
}
