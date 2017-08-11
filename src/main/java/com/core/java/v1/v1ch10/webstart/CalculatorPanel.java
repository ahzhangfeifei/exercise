package com.core.java.v1.v1ch10. webstart;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Calculator panel.
 */
public class CalculatorPanel extends JPanel
{  
   private JTextArea display;
   private JPanel panel;
   private double result;
   private String lastCommand;
   private boolean start;

   /**
    * Instantiates a new Calculator panel.
    */
   public CalculatorPanel()
   {  
      setLayout(new BorderLayout());

      result = 0;
      lastCommand = "=";
      start = true;
      
      // add the display

      display = new JTextArea(10, 20);

      add(new JScrollPane(display), BorderLayout.NORTH);
      
      ActionListener insert = new InsertAction();
      ActionListener command = new CommandAction();

      // add the buttons in a 4 x 4 grid

      panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4));

      addButton("7", insert);
      addButton("8", insert);
      addButton("9", insert);
      addButton("/", command);

      addButton("4", insert);
      addButton("5", insert);
      addButton("6", insert);
      addButton("*", command);

      addButton("1", insert);
      addButton("2", insert);
      addButton("3", insert);
      addButton("-", command);

      addButton("0", insert);
      addButton(".", insert);
      addButton("=", command);
      addButton("+", command);

      add(panel, BorderLayout.CENTER);
   }

   /**
    * Gets text.
    *
    * @return the text
    */
   public String getText()
   {
      return display.getText();
   }

   /**
    * Append.
    *
    * @param s the s
    */
   public void append(String s)
   {
      display.append(s);
   }

   private void addButton(String label, ActionListener listener)
   {  
      JButton button = new JButton(label);
      button.addActionListener(listener);
      panel.add(button);
   }

   private class InsertAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String input = event.getActionCommand();
         start = false;
         display.append(input);
      }
   }

   private class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {  
         String command = event.getActionCommand();

         if (start)
         {  
            if (command.equals("-")) 
            { 
               display.append(command); 
               start = false; 
            }
            else 
               lastCommand = command;
         }
         else
         {  
            try
            {
               int lines = display.getLineCount();
               int lineStart = display.getLineStartOffset(lines - 1);
               int lineEnd = display.getLineEndOffset(lines - 1);
               String value = display.getText(lineStart, lineEnd - lineStart);
               display.append(" ");
               display.append(command); 
               calculate(Double.parseDouble(value));
               if (command.equals("="))
                  display.append("\n" + result);
               lastCommand = command;
               display.append("\n");
               start = true;
            }
            catch (BadLocationException e)
            {
               e.printStackTrace();
            }
         }
      }
   }

   /**
    * Calculate.
    *
    * @param x the x
    */
   public void calculate(double x)
   {
      if (lastCommand.equals("+")) result += x;
      else if (lastCommand.equals("-")) result -= x;
      else if (lastCommand.equals("*")) result *= x;
      else if (lastCommand.equals("/")) result /= x;
      else if (lastCommand.equals("=")) result = x;
   }  
}
