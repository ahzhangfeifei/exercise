package com.core.java.v2.v2ch05. retire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Retire.
 */
public class Retire
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
               JFrame frame = new RetireFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Retire frame.
 */
class RetireFrame extends JFrame
{
   private JTextField savingsField = new JTextField(10);
   private JTextField contribField = new JTextField(10);
   private JTextField incomeField = new JTextField(10);
   private JTextField currentAgeField = new JTextField(4);
   private JTextField retireAgeField = new JTextField(4);
   private JTextField deathAgeField = new JTextField(4);
   private JTextField inflationPercentField = new JTextField(6);
   private JTextField investPercentField = new JTextField(6);
   private JTextArea retireText = new JTextArea(10, 25);
   private RetireComponent retireCanvas = new RetireComponent();
   private JButton computeButton = new JButton();
   private JLabel languageLabel = new JLabel();
   private JLabel savingsLabel = new JLabel();
   private JLabel contribLabel = new JLabel();
   private JLabel incomeLabel = new JLabel();
   private JLabel currentAgeLabel = new JLabel();
   private JLabel retireAgeLabel = new JLabel();
   private JLabel deathAgeLabel = new JLabel();
   private JLabel inflationPercentLabel = new JLabel();
   private JLabel investPercentLabel = new JLabel();
   private RetireInfo info = new RetireInfo();
   private Locale[] locales = { Locale.US, Locale.CHINA, Locale.GERMANY };
   private Locale currentLocale;
   private JComboBox<Locale> localeCombo = new LocaleCombo(locales);
   private ResourceBundle res;
   private ResourceBundle resStrings;
   private NumberFormat currencyFmt;
   private NumberFormat numberFmt;
   private NumberFormat percentFmt;

   /**
    * Instantiates a new Retire frame.
    */
   public RetireFrame()
   {
      setLayout(new GridBagLayout());
      add(languageLabel, new GBC(0, 0).setAnchor(GBC.EAST));
      add(savingsLabel, new GBC(0, 1).setAnchor(GBC.EAST));
      add(contribLabel, new GBC(2, 1).setAnchor(GBC.EAST));
      add(incomeLabel, new GBC(4, 1).setAnchor(GBC.EAST));
      add(currentAgeLabel, new GBC(0, 2).setAnchor(GBC.EAST));
      add(retireAgeLabel, new GBC(2, 2).setAnchor(GBC.EAST));
      add(deathAgeLabel, new GBC(4, 2).setAnchor(GBC.EAST));
      add(inflationPercentLabel, new GBC(0, 3).setAnchor(GBC.EAST));
      add(investPercentLabel, new GBC(2, 3).setAnchor(GBC.EAST));
      add(localeCombo, new GBC(1, 0, 3, 1));
      add(savingsField, new GBC(1, 1).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(contribField, new GBC(3, 1).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(incomeField, new GBC(5, 1).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(currentAgeField, new GBC(1, 2).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(retireAgeField, new GBC(3, 2).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(deathAgeField, new GBC(5, 2).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(inflationPercentField, new GBC(1, 3).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(investPercentField, new GBC(3, 3).setWeight(100, 0).setFill(GBC.HORIZONTAL));
      add(retireCanvas, new GBC(0, 4, 4, 1).setWeight(100, 100).setFill(GBC.BOTH));
      add(new JScrollPane(retireText), new GBC(4, 4, 2, 1).setWeight(0, 100).setFill(GBC.BOTH));

      computeButton.setName("computeButton");
      computeButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               getInfo();
               updateData();
               updateGraph();
            }
         });
      add(computeButton, new GBC(5, 3));

      retireText.setEditable(false);
      retireText.setFont(new Font("Monospaced", Font.PLAIN, 10));

      info.setSavings(0);
      info.setContrib(9000);
      info.setIncome(60000);
      info.setCurrentAge(35);
      info.setRetireAge(65);
      info.setDeathAge(85);
      info.setInvestPercent(0.1);
      info.setInflationPercent(0.05);

      int localeIndex = 0; // US locale is default selection
      for (int i = 0; i < locales.length; i++)
         // if current locale one of the choices, select it
         if (getLocale().equals(locales[i])) localeIndex = i;
      setCurrentLocale(locales[localeIndex]);

      localeCombo.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setCurrentLocale((Locale) localeCombo.getSelectedItem());
               validate();
            }
         });
      pack();
   }

   /**
    * Sets current locale.
    *
    * @param locale the locale
    */
   public void setCurrentLocale(Locale locale)
   {
      currentLocale = locale;
      localeCombo.setSelectedItem(currentLocale);
      localeCombo.setLocale(currentLocale);

      res = ResourceBundle.getBundle("retire.RetireResources", currentLocale);
      resStrings = ResourceBundle.getBundle("retire.RetireStrings", currentLocale);
      currencyFmt = NumberFormat.getCurrencyInstance(currentLocale);
      numberFmt = NumberFormat.getNumberInstance(currentLocale);
      percentFmt = NumberFormat.getPercentInstance(currentLocale);

      updateDisplay();
      updateInfo();
      updateData();
      updateGraph();
   }

   /**
    * Update display.
    */
   public void updateDisplay()
   {
      languageLabel.setText(resStrings.getString("language"));
      savingsLabel.setText(resStrings.getString("savings"));
      contribLabel.setText(resStrings.getString("contrib"));
      incomeLabel.setText(resStrings.getString("income"));
      currentAgeLabel.setText(resStrings.getString("currentAge"));
      retireAgeLabel.setText(resStrings.getString("retireAge"));
      deathAgeLabel.setText(resStrings.getString("deathAge"));
      inflationPercentLabel.setText(resStrings.getString("inflationPercent"));
      investPercentLabel.setText(resStrings.getString("investPercent"));
      computeButton.setText(resStrings.getString("computeButton"));
   }

   /**
    * Update info.
    */
   public void updateInfo()
   {
      savingsField.setText(currencyFmt.format(info.getSavings()));
      contribField.setText(currencyFmt.format(info.getContrib()));
      incomeField.setText(currencyFmt.format(info.getIncome()));
      currentAgeField.setText(numberFmt.format(info.getCurrentAge()));
      retireAgeField.setText(numberFmt.format(info.getRetireAge()));
      deathAgeField.setText(numberFmt.format(info.getDeathAge()));
      investPercentField.setText(percentFmt.format(info.getInvestPercent()));
      inflationPercentField.setText(percentFmt.format(info.getInflationPercent()));
   }

   /**
    * Update data.
    */
   public void updateData()
   {
      retireText.setText("");
      MessageFormat retireMsg = new MessageFormat("");
      retireMsg.setLocale(currentLocale);
      retireMsg.applyPattern(resStrings.getString("retire"));

      for (int i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
      {
         Object[] args = { i, info.getBalance(i) };
         retireText.append(retireMsg.format(args) + "\n");
      }
   }

   /**
    * Update graph.
    */
   public void updateGraph()
   {
      retireCanvas.setColorPre((Color) res.getObject("colorPre"));
      retireCanvas.setColorGain((Color) res.getObject("colorGain"));
      retireCanvas.setColorLoss((Color) res.getObject("colorLoss"));
      retireCanvas.setInfo(info);
      repaint();
   }

   /**
    * Gets info.
    */
   public void getInfo()
   {
      try
      {
         info.setSavings(currencyFmt.parse(savingsField.getText()).doubleValue());
         info.setContrib(currencyFmt.parse(contribField.getText()).doubleValue());
         info.setIncome(currencyFmt.parse(incomeField.getText()).doubleValue());
         info.setCurrentAge(numberFmt.parse(currentAgeField.getText()).intValue());
         info.setRetireAge(numberFmt.parse(retireAgeField.getText()).intValue());
         info.setDeathAge(numberFmt.parse(deathAgeField.getText()).intValue());
         info.setInvestPercent(percentFmt.parse(investPercentField.getText()).doubleValue());
         info.setInflationPercent(percentFmt.parse(inflationPercentField.getText()).doubleValue());
      }
      catch (ParseException ex)
      {
         ex.printStackTrace();
      }
   }
}

/**
 * The type Retire info.
 */
class RetireInfo
{
   private double savings;
   private double contrib;
   private double income;
   private int currentAge;
   private int retireAge;
   private int deathAge;
   private double inflationPercent;
   private double investPercent;
   private int age;
   private double balance;

   /**
    * Gets balance.
    *
    * @param year the year
    * @return the balance
    */
   public double getBalance(int year)
   {
      if (year < currentAge) return 0;
      else if (year == currentAge)
      {
         age = year;
         balance = savings;
         return balance;
      }
      else if (year == age) return balance;
      if (year != age + 1) getBalance(year - 1);
      age = year;
      if (age < retireAge) balance += contrib;
      else balance -= income;
      balance = balance * (1 + (investPercent - inflationPercent));
      return balance;
   }

   /**
    * Gets savings.
    *
    * @return the savings
    */
   public double getSavings()
   {
      return savings;
   }

   /**
    * Sets savings.
    *
    * @param newValue the new value
    */
   public void setSavings(double newValue)
   {
      savings = newValue;
   }

   /**
    * Gets contrib.
    *
    * @return the contrib
    */
   public double getContrib()
   {
      return contrib;
   }

   /**
    * Sets contrib.
    *
    * @param newValue the new value
    */
   public void setContrib(double newValue)
   {
      contrib = newValue;
   }

   /**
    * Gets income.
    *
    * @return the income
    */
   public double getIncome()
   {
      return income;
   }

   /**
    * Sets income.
    *
    * @param newValue the new value
    */
   public void setIncome(double newValue)
   {
      income = newValue;
   }

   /**
    * Gets current age.
    *
    * @return the current age
    */
   public int getCurrentAge()
   {
      return currentAge;
   }

   /**
    * Sets current age.
    *
    * @param newValue the new value
    */
   public void setCurrentAge(int newValue)
   {
      currentAge = newValue;
   }

   /**
    * Gets retire age.
    *
    * @return the retire age
    */
   public int getRetireAge()
   {
      return retireAge;
   }

   /**
    * Sets retire age.
    *
    * @param newValue the new value
    */
   public void setRetireAge(int newValue)
   {
      retireAge = newValue;
   }

   /**
    * Gets death age.
    *
    * @return the death age
    */
   public int getDeathAge()
   {
      return deathAge;
   }

   /**
    * Sets death age.
    *
    * @param newValue the new value
    */
   public void setDeathAge(int newValue)
   {
      deathAge = newValue;
   }

   /**
    * Gets inflation percent.
    *
    * @return the inflation percent
    */
   public double getInflationPercent()
   {
      return inflationPercent;
   }

   /**
    * Sets inflation percent.
    *
    * @param newValue the new value
    */
   public void setInflationPercent(double newValue)
   {
      inflationPercent = newValue;
   }

   /**
    * Gets invest percent.
    *
    * @return the invest percent
    */
   public double getInvestPercent()
   {
      return investPercent;
   }

   /**
    * Sets invest percent.
    *
    * @param newValue the new value
    */
   public void setInvestPercent(double newValue)
   {
      investPercent = newValue;
   }
}

/**
 * The type Retire component.
 */
class RetireComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 800;
   private static final int DEFAULT_HEIGHT = 600;
   private static final int PANEL_WIDTH = 400;
   private static final int PANEL_HEIGHT = 200;

   private RetireInfo info = null;
   private Color colorPre;
   private Color colorGain;
   private Color colorLoss;

   /**
    * Instantiates a new Retire component.
    */
   public RetireComponent()
   {
      setSize(PANEL_WIDTH, PANEL_HEIGHT);
   }

   /**
    * Sets info.
    *
    * @param newInfo the new info
    */
   public void setInfo(RetireInfo newInfo)
   {
      info = newInfo;
      repaint();
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      if (info == null) return;

      double minValue = 0;
      double maxValue = 0;
      int i;
      for (i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
      {
         double v = info.getBalance(i);
         if (minValue > v) minValue = v;
         if (maxValue < v) maxValue = v;
      }
      if (maxValue == minValue) return;

      int barWidth = getWidth() / (info.getDeathAge() - info.getCurrentAge() + 1);
      double scale = getHeight() / (maxValue - minValue);

      for (i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
      {
         int x1 = (i - info.getCurrentAge()) * barWidth + 1;
         int y1;
         double v = info.getBalance(i);
         int height;
         int yOrigin = (int) (maxValue * scale);

         if (v >= 0)
         {
            y1 = (int) ((maxValue - v) * scale);
            height = yOrigin - y1;
         }
         else
         {
            y1 = yOrigin;
            height = (int) (-v * scale);
         }

         if (i < info.getRetireAge()) g2.setPaint(colorPre);
         else if (v >= 0) g2.setPaint(colorGain);
         else g2.setPaint(colorLoss);
         Rectangle2D bar = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
         g2.fill(bar);
         g2.setPaint(Color.black);
         g2.draw(bar);
      }
   }

   /**
    * Sets color pre.
    *
    * @param color the color
    */
   public void setColorPre(Color color)
   {
      colorPre = color;
      repaint();
   }

   /**
    * Sets color gain.
    *
    * @param color the color
    */
   public void setColorGain(Color color)
   {
      colorGain = color;
      repaint();
   }

   /**
    * Sets color loss.
    *
    * @param color the color
    */
   public void setColorLoss(Color color)
   {
      colorLoss = color;
      repaint();
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }   
}
