package com.core.java.v2.v2ch07. composite;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Composite test frame.
 */
class CompositeTestFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 400;
   private static final int DEFAULT_HEIGHT = 400;

   private CompositeComponent canvas;
   private JComboBox<Rule> ruleCombo;
   private JSlider alphaSlider;
   private JTextField explanation;

   /**
    * Instantiates a new Composite test frame.
    */
   public CompositeTestFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      canvas = new CompositeComponent();
      add(canvas, BorderLayout.CENTER);

      ruleCombo = new JComboBox<>(new Rule[] { new Rule("CLEAR", "  ", "  "),
            new Rule("SRC", " S", " S"), new Rule("DST", "  ", "DD"),
            new Rule("SRC_OVER", " S", "DS"), new Rule("DST_OVER", " S", "DD"),
            new Rule("SRC_IN", "  ", " S"), new Rule("SRC_OUT", " S", "  "),
            new Rule("DST_IN", "  ", " D"), new Rule("DST_OUT", "  ", "D "),
            new Rule("SRC_ATOP", "  ", "DS"), new Rule("DST_ATOP", " S", " D"),
            new Rule("XOR", " S", "D "), });
      ruleCombo.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               Rule r = (Rule) ruleCombo.getSelectedItem();
               canvas.setRule(r.getValue());
               explanation.setText(r.getExplanation());
            }
         });

      alphaSlider = new JSlider(0, 100, 75);
      alphaSlider.addChangeListener(new ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               canvas.setAlpha(alphaSlider.getValue());
            }
         });
      JPanel panel = new JPanel();
      panel.add(ruleCombo);
      panel.add(new JLabel("Alpha"));
      panel.add(alphaSlider);
      add(panel, BorderLayout.NORTH);

      explanation = new JTextField();
      add(explanation, BorderLayout.SOUTH);

      canvas.setAlpha(alphaSlider.getValue());
      Rule r = ruleCombo.getItemAt(ruleCombo.getSelectedIndex());
      canvas.setRule(r.getValue());
      explanation.setText(r.getExplanation());      
   }
}