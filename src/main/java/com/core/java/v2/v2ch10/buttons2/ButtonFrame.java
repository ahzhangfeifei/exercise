package com.core.java.v2.v2ch10. buttons2;
import javax.swing.*;

/**
 * The type Button frame.
 */
public abstract class ButtonFrame extends JFrame
{
   /**
    * The constant DEFAULT_WIDTH.
    */
   public static final int DEFAULT_WIDTH = 300;
   /**
    * The constant DEFAULT_HEIGHT.
    */
   public static final int DEFAULT_HEIGHT = 200;

   /**
    * The Panel.
    */
   protected JPanel panel;
   /**
    * The Yellow button.
    */
   protected JButton yellowButton;
   /**
    * The Blue button.
    */
   protected JButton blueButton;
   /**
    * The Red button.
    */
   protected JButton redButton;

   /**
    * Add event handlers.
    */
   protected abstract void addEventHandlers();

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
      
      addEventHandlers();
   }
}
