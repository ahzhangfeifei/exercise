package com.core.java.v2.v2ch05. collation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.*;
import java.util.List;

/**
 * The type Collation test.
 */
public class CollationTest
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
               JFrame frame = new CollationFrame();
               frame.setTitle("CollationTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Collation frame.
 */
class CollationFrame extends JFrame
{
   private Collator collator = Collator.getInstance(Locale.getDefault());
   private List<String> strings = new ArrayList<>();
   private Collator currentCollator;
   private Locale[] locales;
   private JComboBox<String> localeCombo = new JComboBox<>();
   private JTextField newWord = new JTextField(20);
   private JTextArea sortedWords = new JTextArea(20, 20);
   private JButton addButton = new JButton("Add");
   private EnumCombo strengthCombo = new EnumCombo(Collator.class, "Primary",
         "Secondary", "Tertiary", "Identical");
   private EnumCombo decompositionCombo = new EnumCombo(Collator.class, 
         "Canonical Decomposition", "Full Decomposition", "No Decomposition");

   /**
    * Instantiates a new Collation frame.
    */
   public CollationFrame()
   {
      setLayout(new GridBagLayout());
      add(new JLabel("Locale"), new GBC(0, 0).setAnchor(GBC.EAST));
      add(new JLabel("Strength"), new GBC(0, 1).setAnchor(GBC.EAST));
      add(new JLabel("Decomposition"), new GBC(0, 2).setAnchor(GBC.EAST));
      add(addButton, new GBC(0, 3).setAnchor(GBC.EAST));
      add(localeCombo, new GBC(1, 0).setAnchor(GBC.WEST));
      add(strengthCombo, new GBC(1, 1).setAnchor(GBC.WEST));
      add(decompositionCombo, new GBC(1, 2).setAnchor(GBC.WEST));
      add(newWord, new GBC(1, 3).setFill(GBC.HORIZONTAL));
      add(new JScrollPane(sortedWords), new GBC(0, 4, 2, 1).setFill(GBC.BOTH));
      
      locales = (Locale[]) Collator.getAvailableLocales().clone();
      Arrays.sort(locales, new Comparator<Locale>()
         {
         
            public int compare(Locale l1, Locale l2)
            {
               return collator.compare(l1.getDisplayName(), l2.getDisplayName());               
            }
         });
      for (Locale loc : locales)
         localeCombo.addItem(loc.getDisplayName());      
      localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
      
      strings.add("America");
      strings.add("able");
      strings.add("Zulu");
      strings.add("zebra");
      strings.add("\u00C5ngstr\u00F6m");
      strings.add("A\u030angstro\u0308m");
      strings.add("Angstrom");
      strings.add("Able");
      strings.add("office");
      strings.add("o\uFB03ce");
      strings.add("Java\u2122");
      strings.add("JavaTM");
      updateDisplay();

      addButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               strings.add(newWord.getText());
               updateDisplay();
            }
         });

      ActionListener listener = new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               updateDisplay();
            }
         };

      localeCombo.addActionListener(listener);
      strengthCombo.addActionListener(listener);
      decompositionCombo.addActionListener(listener);
      pack();
   }

   /**
    * Update display.
    */
   public void updateDisplay()
   {
      Locale currentLocale = locales[localeCombo.getSelectedIndex()];
      localeCombo.setLocale(currentLocale);

      currentCollator = Collator.getInstance(currentLocale);
      currentCollator.setStrength(strengthCombo.getValue());
      currentCollator.setDecomposition(decompositionCombo.getValue());

      Collections.sort(strings, currentCollator);

      sortedWords.setText("");
      for (int i = 0; i < strings.size(); i++)
      {
         String s = strings.get(i);
         if (i > 0 && currentCollator.compare(s, strings.get(i - 1)) == 0) sortedWords
               .append("= ");
         sortedWords.append(s + "\n");
      }
      pack();
   }
}
