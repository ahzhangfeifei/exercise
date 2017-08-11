package com.core.java.v2.v2ch06. longList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * The type Long list frame.
 */
public class LongListFrame extends JFrame
{
   private JList<String> wordList;
   private JLabel label;
   private String prefix = "The quick brown ";
   private String suffix = " jumps over the lazy dog.";

   /**
    * Instantiates a new Long list frame.
    */
   public LongListFrame()
   {
      wordList = new JList<String>(new WordListModel(3));
      wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      wordList.setPrototypeCellValue("www");
      JScrollPane scrollPane = new JScrollPane(wordList);

      JPanel p = new JPanel();
      p.add(scrollPane);
      wordList.addListSelectionListener(new ListSelectionListener()
         {
            public void valueChanged(ListSelectionEvent evt)
            {
               setSubject(wordList.getSelectedValue());
            }
         });

      Container contentPane = getContentPane();
      contentPane.add(p, BorderLayout.NORTH);
      label = new JLabel(prefix + suffix);
      contentPane.add(label, BorderLayout.CENTER);
      setSubject("fox");
      pack();
   }

   /**
    * Sets subject.
    *
    * @param word the word
    */
   public void setSubject(String word)
   {
      StringBuilder text = new StringBuilder(prefix);
      text.append(word);
      text.append(suffix);
      label.setText(text.toString());
   }
}
