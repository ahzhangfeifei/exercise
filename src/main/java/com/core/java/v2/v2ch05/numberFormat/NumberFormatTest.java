package com.core.java.v2.v2ch05. numberFormat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * The type Number format test.
 */
public class NumberFormatTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new NumberFormatFrame();
               frame.setTitle("NumberFormatTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Number format frame.
 */
class NumberFormatFrame extends JFrame
{
   private Locale[] locales;
   private double currentNumber;
   private JComboBox<String> localeCombo = new JComboBox<>();
   private JButton parseButton = new JButton("Parse");
   private JTextField numberText = new JTextField(30);
   private JRadioButton numberRadioButton = new JRadioButton("Number");
   private JRadioButton currencyRadioButton = new JRadioButton("Currency");
   private JRadioButton percentRadioButton = new JRadioButton("Percent");
   private ButtonGroup rbGroup = new ButtonGroup();
   private NumberFormat currentNumberFormat;

   /**
    * Instantiates a new Number format frame.
    */
   public NumberFormatFrame()
   {      
      setLayout(new GridBagLayout());

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               updateDisplay();
            }
         };

      JPanel p = new JPanel();
      addRadioButton(p, numberRadioButton, rbGroup, listener);
      addRadioButton(p, currencyRadioButton, rbGroup, listener);
      addRadioButton(p, percentRadioButton, rbGroup, listener);

      add(new JLabel("Locale:"), new GBC(0, 0).setAnchor(GBC.EAST));
      add(p, new GBC(1, 1));
      add(parseButton, new GBC(0, 2).setInsets(2));
      add(localeCombo, new GBC(1, 0).setAnchor(GBC.WEST));
      add(numberText, new GBC(1, 2).setFill(GBC.HORIZONTAL));
      locales = (Locale[]) NumberFormat.getAvailableLocales().clone();
      Arrays.sort(locales, new Comparator<Locale>()
         {
            public int compare(Locale l1, Locale l2)
            {
               return l1.getDisplayName().compareTo(l2.getDisplayName());
            }
         });
      for (Locale loc : locales)
         localeCombo.addItem(loc.getDisplayName());
      localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
      currentNumber = 123456.78;
      updateDisplay();

      localeCombo.addActionListener(listener);

      parseButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               String s = numberText.getText().trim();
               try
               {
                  Number n = currentNumberFormat.parse(s);
                  if (n != null)
                  {
                     currentNumber = n.doubleValue();
                     updateDisplay();
                  }
                  else
                  {
                     numberText.setText("Parse error: " + s);
                  }
               }
               catch (ParseException e)
               {
                  numberText.setText("Parse error: " + s);
               }
            }
         });
      pack();
   }

   /**
    * Add radio button.
    *
    * @param p        the p
    * @param b        the b
    * @param g        the g
    * @param listener the listener
    */
   public void addRadioButton(Container p, JRadioButton b, ButtonGroup g, ActionListener listener)
   {
      b.setSelected(g.getButtonCount() == 0);
      b.addActionListener(listener);
      g.add(b);
      p.add(b);
   }

   /**
    * Update display.
    */
   public void updateDisplay()
   {
      Locale currentLocale = locales[localeCombo.getSelectedIndex()];
      currentNumberFormat = null;
      if (numberRadioButton.isSelected()) currentNumberFormat = NumberFormat
            .getNumberInstance(currentLocale);
      else if (currencyRadioButton.isSelected()) currentNumberFormat = NumberFormat
            .getCurrencyInstance(currentLocale);
      else if (percentRadioButton.isSelected()) currentNumberFormat = NumberFormat
            .getPercentInstance(currentLocale);
      String n = currentNumberFormat.format(currentNumber);
      numberText.setText(n);
   }
}
