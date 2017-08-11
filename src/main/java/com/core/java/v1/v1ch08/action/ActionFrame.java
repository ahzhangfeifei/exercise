package com.core.java.v1.v1ch08. action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The type Action frame.
 */
public class ActionFrame extends JFrame
{
   private JPanel buttonPanel;
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   /**
    * Instantiates a new Action frame.
    */
   public ActionFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      buttonPanel = new JPanel();

      // define actions
      Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"),
            Color.YELLOW);
      Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
      Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);

      // add buttons for these actions
      buttonPanel.add(new JButton(yellowAction));
      buttonPanel.add(new JButton(blueAction));
      buttonPanel.add(new JButton(redAction));

      // add panel to frame
      add(buttonPanel);

      // associate the Y, B, and R keys with names
      InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
      imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
      imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
      imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

      // associate the names with actions
      ActionMap amap = buttonPanel.getActionMap();
      amap.put("panel.yellow", yellowAction);
      amap.put("panel.blue", blueAction);
      amap.put("panel.red", redAction);
   }

   /**
    * The type Color action.
    */
   public class ColorAction extends AbstractAction
   {
      /**
       * Instantiates a new Color action.
       *
       * @param name the name
       * @param icon the icon
       * @param c    the c
       */
      public ColorAction(String name, Icon icon, Color c)
      {
         putValue(Action.NAME, name);
         putValue(Action.SMALL_ICON, icon);
         putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
         putValue("color", c);
      }

      public void actionPerformed(ActionEvent event)
      {
         Color c = (Color) getValue("color");
         buttonPanel.setBackground(c);
      }
   }
}
