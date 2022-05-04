package gui;

import utilities.Operand;
import utilities.Operation;
import utilities.OperationFormatException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import exceptions.IncompleteExpressionException;
import exceptions.IncompleteUnitsException;
import exceptions.NoValueEnteredException;
import utilities.ResultUnits;

/**
 * The Graphical User Interface for the unitED calculator.
 * 
 * @author Makenzie Williams, Chingiz Rajabli
 * @version 1
 *
 */
public class GraphicalUserInterface implements ActionListener, ComponentListener, KeyListener
{

  static JTextField display;
  JTextField input;
  static String[] expression = new String[4];
  private final String DIVIDE = "\u00F7";
  String lastResult = null;
  private final String SIGN = "\u00B1";
  private final String BACK = "\u232B";
  static History historyDisplay = new History();
  static Intermediate intermediateDisplay = new Intermediate();
  JComboBox unitsDropDown;
  JComboBox resultsDropDown;
  static JButton historyButton = new JButton(">");
  static Timer timer = new Timer(3, historyDisplay);
  static final ResourceBundle COLORS = ResourceBundle.getBundle("gui.Colors");

  static final Locale LOCALE = Locale.getDefault(); // Belgium and French
  static final ResourceBundle STRINGS = ResourceBundle.getBundle("gui.Strings");
  static JButton intStepsButton = new JButton("<");
  static Timer historyTimer = new Timer(3, historyDisplay);
  static Timer intermediateTimer = new Timer(3, intermediateDisplay);
  private final String EXPONENT = "X\u02B8";
  boolean integerPowerActive = false;
  static String wholeExponent = "";
  static JButton exponent = new JButton("X\u02B8");
  // static final ResourceBundle COLORS = ResourceBundle.getBundle("gui.Colors");

  JButton plus, minus, multiply, divide, equals;
  // static final ResourceBundle COLORS = ResourceBundle.getBundle("gui.Colors");

  // private final String ABOUT = STRINGS.getString("About");
  // private String aboutStr = "This calculator is by unitEd. This is a four-function calculator
  // with"
  // + " some extra features including the ability to inverse a function as well as evaluate an "
  // + "integer exponent. This calculator will not let you type units into the input bar; you must "
  // + "select one from the dropdown menu. Additionally, it will change languages based on your "
  // + "locality but is currently limited to English, French, and Russian-speaking localities. The "
  // + "calculator shows all previous calculations in the history display to the right and shows the
  // "
  // + "steps of those calculations in the intermediate steps display on the left.";
  Object[] finalUnits;
  static Object secondUnit;
  // string array of units for dropdown menu
  static String[] measurements = {"", "in", "ft", "yd", "mi", "mm", "cm", "m", "km", "oz", "lb",
      "ton", "g", "kg", "pt", "qt", "gal", "cc", "l", "c", "$", "sec", "hr", "day", "mon", "yr"};

  /**
   * Constructor.
   */
  public GraphicalUserInterface()
  {
    setLayout();

  }

  public static String getOperator()
  {
    return expression[1];
  }

  public void resetTimer()
  {
    historyTimer.restart();
  }

  public static String getFirstUnit(String op)
  {

    op = op.replaceAll("\\d", "");
    StringBuilder toBeUnit = new StringBuilder();
    int exponent = 0;
    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      if ((op.charAt(0) != '-') && (Character.isLetter(c) || c == '/' || c == '-' || (c == '^')
          || (i != 0 && Character.isDigit(c) && op.charAt(i - 1) == '^')))
      {

        toBeUnit = toBeUnit.append(c);

      }
      else if (!Character.isDigit(c) && !Character.isLetter(c))
      {
        try
        {
          exponent = Character.getNumericValue(c);
        }
        catch (NumberFormatException nfe)
        {
          exponent = 1;
        }
      }
    }

    return toBeUnit.toString();
  }

  public static int getFirstExponent()
  {
    String op = expression[0].replaceAll("\\d", "");
    String exponent = "";
    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      if (!Character.isDigit(c) && !Character.isLetter(c))
      {
        try
        {
          exponent += Character.getNumericValue(c);
        }
        catch (NumberFormatException nfe)
        {
          exponent += 1;
        }
      }
      else
      {
        break;
      }
    }
    if (exponent.equals(""))
    {
      return 1;
    }
    return Integer.parseInt(exponent);
  }

  public static String getWholeExponent()
  {
    return wholeExponent;
  }

  public static int getWholeExponentAsInt()
  {
    String op = wholeExponent;
    String exponent = "";
    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      if (!Character.isDigit(c) && !Character.isLetter(c))
      {
        try
        {
          exponent += Character.getNumericValue(c);
        }
        catch (NumberFormatException nfe)
        {
          exponent += 1;
        }
      }
      else
      {
        break;
      }
    }
    return Integer.parseInt(exponent);
  }

  public static String getFirstExponentAsString()
  {
    String op = expression[0].replaceAll("\\d", "");
    String exponent = "";
    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      if (!Character.isDigit(c) && !Character.isLetter(c))
      {
        try
        {
          exponent += c;
        }
        catch (NumberFormatException nfe)
        {
          exponent += 1;
        }
      }
      else
      {
        break;
      }
    }
    return exponent;
  }

  /**
   * adds operand to the expression array.
   *
   * @param operand
   *          first operand
   * @param operation
   *          operation
   */
  public void addOperand(final String operand, final String operation)
  {
    expression[0] = operand;
    expression[1] = operation;

  }

  public static void startHistoryTimer()
  {
    historyTimer.start();
  }

  public static void startIntermediateTimer()
  {
    intermediateTimer.start();
  }

  public static void stopHistoryTimer()
  {
    historyTimer.stop();
  }

  public static void stopIntermediateTimer()
  {
    intermediateTimer.stop();
  }

  /**
   * uses buttons to input to the input field.
   *
   * @param n
   *          button to be pressed
   */
  private void putInput(int n)
  {
    String numeric = input.getText().replaceAll("[^0-9, -]", "");
    input.setText(numeric + n);
  }

  /**
   * make first operand exponential in the backend.
   *
   * @param n
   *          the power
   */
  private void putExponent(String n)
  {
    String numeric = input.getText().replaceAll("[^0-9]", "");
    String units = input.getText().replaceAll("\\d", "");

    input.setText(numeric + units + n);

  }

  private String getNumberOfInput()
  {
    return input.getText().replaceAll("[^0-9]", "");
  }

  /**
   * make history btton visible.
   *
   */
  public static void setHistoryButtonVisible()
  {
    historyButton.setVisible(true);
  }

  /**
   * make intemediate button visible
   */
  public static void setIntermediateButtonVisible()
  {
    intStepsButton.setVisible(true);
  }

  private void updateFinalDropdown(Object[] units)
  {
    resultsDropDown.setModel(new DefaultComboBoxModel(units));
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    String ac = e.getActionCommand();

    switch (ac)
    {
      // do i internationalize this ??
      case "R" -> reset();
      case "C" -> clear();
      case "+" ->
      {
        // plus assignment for the expression
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("[\\d, .]", "");

        for (int i = 0; i < units.length(); i++)
        {
          char c = units.charAt(i);
          if ((Character.isDigit(c) || Character.isLetter(c)) && !units.equals(""))
          {
            // JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
            // JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }

        }
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        // if (!units.equals("")) // checking the units
        // {
        // {
        // JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
        // JOptionPane.INFORMATION_MESSAGE);
        // reset();
        // break;
        // }
        // }
        if (!dropdownUnits.equals("")) // checking units
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            // JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
            // "Wrong units", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // initial calculation
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          { // checking if units are selected
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + " + ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "+");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + wholeExponent + " + ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "+");
            // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
            // (String) unitsDropDown.getSelectedItem(), 1, "result"));
            // updateFinalDropdown(finalUnits);
            wholeExponent = "";
            clear();
          }

        }
        else if (lastResult != null && numeric.equals("")) // calculation for the rolling over
                                                           // operations.
        {
          display.setText(lastResult + " + ");
          addOperand(lastResult, "+");
          // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
          // (String) unitsDropDown.getSelectedItem(), 1, "result"));
          // updateFinalDropdown(finalUnits);
          clear();
          wholeExponent = "";
        }
        else if (lastResult != null && !numeric.equals("")) // calculations for the non rolling over
                                                            // operations that arent first
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          { // checking if units are selected
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + " + ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "+");
            // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
            // (String) unitsDropDown.getSelectedItem(), 1, "result"));
            // updateFinalDropdown(finalUnits);
            clear();
            wholeExponent = "";
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + wholeExponent + " + ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "+");
            // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
            // (String) unitsDropDown.getSelectedItem(), 1, "result"));
            // updateFinalDropdown(finalUnits);
            clear();
            wholeExponent = "";
          }
        }
        else if (lastResult == null && numeric.equals(""))
        {
          wholeExponent = "";
          // JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
              STRINGS.getString("NO_VALUE"), JOptionPane.INFORMATION_MESSAGE);

        }
        integerPowerActive = false;

      }
      case "-" ->
      {
        // parse the input
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("[\\d, .]", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        // Makes sure no units are entered into the input
        for (int i = 0; i < units.length(); i++)
        {
          char c = units.charAt(i);
          if ((Character.isDigit(c) || Character.isLetter(c)) && !units.equals(""))
          {
            // JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
            // JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }
        }
        if (!dropdownUnits.equals(""))
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            // JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
            // "Wrong units", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, STRINGS.getString("INCOMPLETE_UNITS"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // the first calculation
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + " - ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "-");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + wholeExponent + " - ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "-");
            // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
            // (String) unitsDropDown.getSelectedItem(), 1, "result"));
            // updateFinalDropdown(finalUnits);
            wholeExponent = "";
            clear();
          }
        }
        else if (lastResult != null && numeric.equals("")) // rolling calculation
        {
          display.setText(lastResult + " - ");
          addOperand(lastResult, "-");
          // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
          // (String) unitsDropDown.getSelectedItem(), 1, "result"));
          // updateFinalDropdown(finalUnits);
          wholeExponent = "";
          clear();
        }
        if (lastResult != null && !numeric.equals("")) // non rolling calculation but with
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + " - ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "-");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + " "
                + unitsDropDown.getSelectedItem() + wholeExponent + " - ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "-");
            // finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
            // (String) unitsDropDown.getSelectedItem(), 1, "result"));
            // updateFinalDropdown(finalUnits);
            wholeExponent = "";
            clear();
          }
        }
        else if (lastResult == null && numeric.equals(""))
        {
          // JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
              STRINGS.getString("NO_VALUE"), JOptionPane.INFORMATION_MESSAGE);
        }
        integerPowerActive = false;

      }
      case EXPONENT ->
      {
        // activate exponent
        if (integerPowerActive)
        {
          integerPowerActive = false;
        }
        else
        {
          integerPowerActive = true;
        }
      }
      case "1" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u00B9");
          wholeExponent += "\u00B9";
        }
        else
        {
          putInput(1);
        }
      }
      case "2" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u00B2");
          wholeExponent += "\u00B2";
        }
        else
        {
          putInput(2);
        }
      }
      case "3" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u00B3");
          wholeExponent += "\u00B3";
        }
        else
        {
          putInput(3);
        }
      }
      case "4" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2074");
          wholeExponent += "\u2074";
        }
        else
        {
          putInput(4);
        }
      }
      case "5" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2075");
          wholeExponent += "\u2075";
        }
        else
        {
          putInput(5);
        }
      }
      case "6" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2076");
          wholeExponent += "\u2076";
        }
        else
        {
          putInput(6);
        }
      }
      case "7" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2077");
          wholeExponent += "\u2077";
        }
        else
        {
          putInput(7);
        }
      }
      case "8" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2078");
          wholeExponent += "\u2078";
        }
        else
        {
          putInput(8);
        }
      }
      case "9" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2079");
          wholeExponent += "\u2079";
        }
        else
        {
          putInput(9);
        }
      }
      case "0" ->
      {
        // put the input
        if (integerPowerActive)
        {
          putExponent("\u2070");
          wholeExponent += "\u2070";
        }
        else
        {
          putInput(0);
        }
      }
      case ">" ->
      {
        // set history visible
        historyDisplay.setVisible(true);
        historyButton.setVisible(false);
      }
      case "1/x" ->
      {
        if (input.getText() == null || input.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
              STRINGS.getString("NO_VALUE"), JOptionPane.INFORMATION_MESSAGE);
          reset();
          break;
        }
        double result = Double.parseDouble(input.getText());
        input.setText("");
        result = 1 / result;
        input.setText("" + result);
      }
      case "<" ->
      {
        // make the intermediate display appear
        intermediateDisplay.setVisible(true);
        intStepsButton.setVisible(false);

      }
      case SIGN ->
      {
        // parse the input
        if (!input.getText().contains("-"))
        {
          input.setText("-" + input.getText());
        }
        else
        {
          input.setText(input.getText().substring(1));
        }
      }
      case BACK ->
      {
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("[\\d, .]", "");

        if (numeric.length() > 0)
        {
          input.setText(numeric.substring(0, numeric.length() - 1) + units);
        }
      }
      case "x" ->
      {
        // parse the input
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("[\\d, .]", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        // Makes sure no units are entered into the input
        for (int i = 0; i < units.length(); i++)
        {
          char c = units.charAt(i);
          if ((Character.isDigit(c) || Character.isLetter(c)) && !units.equals(""))
          {
            // JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
            // JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }
        }
        if (!dropdownUnits.equals("")) // checking dropdown units
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            // JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
            // "Wrong units", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, STRINGS.getString("INCOMPLETE_UNITS"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);

            reset();
            wholeExponent = "";
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // first operation
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          {
            display.setText("");
            display.setText(
                display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " x ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "x");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem()
                + wholeExponent + " x ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "x");
            // finalUnits = ResultUnits.multiplicationUnits(new Operand(new BigDecimal(12),
            // (String) unitsDropDown.getSelectedItem(), 1, "result"),
            // new Operand(new BigDecimal(1), (String) secondUnit, 1, ""));
            // updateFinalDropdown(finalUnits);
            wholeExponent = "";
            clear();
          }
        }
        else if (lastResult != null && numeric.equals("")) // rolling calculation
        {
          display.setText(lastResult + " x ");
          addOperand(lastResult, "x");
          clear();
          wholeExponent = "";
        }
        else if (lastResult != null && !numeric.equals("")) // non rolling calculation but not first
                                                            // one
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          {
            display.setText("");
            display.setText(
                display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " x ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "x");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem()
                + wholeExponent + " x ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "x");
            wholeExponent = "";
            clear();
          }
        }
        else if (lastResult == null && numeric.equals(""))
        {
          wholeExponent = "";
          // JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
              STRINGS.getString("NO_VALUE"), JOptionPane.INFORMATION_MESSAGE);
        }
        integerPowerActive = false;

      }
      case DIVIDE ->
      {
        // parse the input

        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("[\\d, .]", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        // Makes sure no units are entered into the input
        for (int i = 0; i < units.length(); i++)
        {
          char c = units.charAt(i);
          if ((Character.isDigit(c) || Character.isLetter(c)) && !units.equals(""))
          {
            // JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
            // JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }
        }
        if (!dropdownUnits.equals(""))
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            // JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
            // "Wrong units", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, STRINGS.getString("INCOMPLETE_UNITS"),
                STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
            reset();
            wholeExponent = "";
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // first operation
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          {
            display.setText("");
            display.setText(
                display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " / ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "/");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem()
                + wholeExponent + " / ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "/");
            wholeExponent = "";
            clear();
          }
        }
        else if (lastResult != null && numeric.equals("")) // rolling operation
        {
          display.setText(lastResult + " / ");
          addOperand(lastResult, "/");
          wholeExponent = "";
          clear();
        }
        if (lastResult != null && !numeric.equals("")) // normal calculation
        {
          if (unitsDropDown.getSelectedItem().equals(""))
          {
            display.setText("");
            display.setText(
                display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " / ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "/");
            wholeExponent = "";
            clear();
          }
          else
          {
            display.setText("");
            display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem()
                + wholeExponent + " / ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem() + wholeExponent, "/");
            wholeExponent = "";
            clear();
          }
        }
        else if (lastResult == null && numeric.equals(""))
        {
          wholeExponent = "";
          // JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
              STRINGS.getString("NO_VALUE"), JOptionPane.INFORMATION_MESSAGE);
        }
        integerPowerActive = false;

      }
      case "About" ->
      {
        JDialog aboutDialog = new JDialog();
        JPanel aboutPanel = (JPanel) aboutDialog.getContentPane();
        JTextArea textArea = new JTextArea(5, 40);

        textArea.setText(STRINGS.getString("ABOUT_MESSAGE")); // aboutStr
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        aboutPanel.add(textArea);
        aboutDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        aboutDialog.setSize(400, 200);
        aboutDialog.setLocationRelativeTo(null);
      }
      case "=" ->
      {
        // calculate;
        integerPowerActive = false;
        expression[2] = input.getText() + unitsDropDown.getSelectedItem();
        expression[3] = "" + resultsDropDown.getSelectedItem();
        try
        {
          String result;
          ExpressionParser parser = new ExpressionParser(expression);
          result = Operation.calculate(parser.getLeft(), parser.getRight(), parser.getOperator());

          display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem()
              + " = " + result);
          historyDisplay.updateText(display.getText());
          intermediateDisplay.updateIntermediate();
          lastResult = result;
          expression = new String[4];
          resultsDropDown.setModel(new DefaultComboBoxModel(measurements));
          wholeExponent = "";

        }

        catch (NotLikeUnitsException nlu)
        {
          wholeExponent = "";
          reset();
          // JOptionPane.showMessageDialog(null, "You cannot add/subtract non-compatible units",
          // "Non-compatible Units",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("NOT_LIKE_UNITS"),
              STRINGS.getString("NON_COMPAT"), JOptionPane.INFORMATION_MESSAGE);
        }
        catch (DivideByZeroException dbz)
        {
          wholeExponent = "";
          reset();
          // JOptionPane.showMessageDialog(null, "You cannot divide by zero", "Incorrect Equation",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("ZERO_DIVIDE"),
              STRINGS.getString("INCORRECT_EXPRESSION"), JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IncompleteUnitsException iue)
        {
          wholeExponent = "";
          reset();
          // JOptionPane.showMessageDialog(null, "The units you entered are incomplete", "Wrong
          // units",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("INCOMPLETE_UNITS"),
              STRINGS.getString("WRONG_UNITS"), JOptionPane.INFORMATION_MESSAGE);
        }
        catch (OperationFormatException ex)
        {
          wholeExponent = "";
          reset();
          // JOptionPane.showMessageDialog(null, "Units are not same ", "Wrong unit ",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString(""), STRINGS.getString("NO_VALUE"),
              JOptionPane.INFORMATION_MESSAGE);
        }

        catch (NoValueEnteredException e1)
        {
          wholeExponent = "";
          reset();
          // JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
          // JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
              STRINGS.getString("NO_VALUE"), JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IncompleteExpressionException iee)
        {
          wholeExponent = "";
          reset();
          // JOptionPane.showMessageDialog(null, "The expression you entered was incomplete",
          // "Incomplete Expression", JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, STRINGS.getString("EXPRESSION_INCOM"),
              STRINGS.getString("INCOMPLETE"), JOptionPane.INFORMATION_MESSAGE);
          // reset();

        }

        clear();

      }

    }

    if (ac.equals(STRINGS.getObject("ABOUT")))
    {
      JDialog aboutDialog = new JDialog();
      JPanel aboutPanel = (JPanel) aboutDialog.getContentPane();
      JTextArea textArea = new JTextArea(5, 40);

      textArea.setText(STRINGS.getString("ABOUT_MESSAGE")); // aboutStr
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setEditable(false);

      aboutPanel.add(textArea);
      aboutDialog.setVisible(true);
      aboutDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      aboutDialog.setSize(400, 200);
      aboutDialog.setLocationRelativeTo(null);
    }

  }

  /**
   * sets up the layout.
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  private void setLayout()
  {

    // creation of frame and content pane
    // Do i internationalize logo??
    JFrame frame = new JFrame(); // UnitED"
    JPanel contentPane = (JPanel) frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    // create menu bar, menus, menu items.
    JMenuBar menuBar = new JMenuBar();
    JMenu help = new JMenu(STRINGS.getString("HELP")); // "Help"
    JMenuItem about = new JMenuItem(STRINGS.getString("ABOUT")); // "About"

    menuBar.add(help);
    help.add(about);

    // top exterior panel
    JPanel topExteriorPanel = new JPanel();
    topExteriorPanel.setLayout(new BoxLayout(topExteriorPanel, BoxLayout.Y_AXIS));

    // bottom exterior panel
    JPanel bottomExteriorPanel = new JPanel();
    bottomExteriorPanel.setLayout(new BoxLayout(bottomExteriorPanel, BoxLayout.X_AXIS));

    // exterior logo panel
    JPanel extLogoPanel = new JPanel();
    topExteriorPanel.add(extLogoPanel, BorderLayout.NORTH);
    extLogoPanel.setLayout(new GridLayout(0, 2, 0, 0));

    // interior logo panel
    JPanel intLogoPanel = new JPanel();
    extLogoPanel.add(intLogoPanel);
    intLogoPanel.setLayout(new BoxLayout(intLogoPanel, BoxLayout.X_AXIS));
    intLogoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    // creation of image label
    ImageIcon image = loadImageIcon("JMU_icon.png");
    Image image1 = image.getImage();
    Image newImage = image1.getScaledInstance(150, 70, image1.SCALE_AREA_AVERAGING);
    image = new ImageIcon(newImage);
    JLabel label = new JLabel(image);
    intLogoPanel.add(label);

    // display panel
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));

    // input panel
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

    // intermediate steps panel
    JPanel intStepsPanel = new JPanel();

    // number panels
    JPanel numberPanel = new JPanel();
    numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.Y_AXIS));

    JPanel numberPanelOne = new JPanel();
    JPanel numberPanelTwo = new JPanel();
    JPanel numberPanelThree = new JPanel();
    JPanel numberPanelFour = new JPanel();
    JPanel numberPanelFive = new JPanel();

    // operator panels
    JPanel operatorPanel = new JPanel();
    operatorPanel.setLayout(new BoxLayout(operatorPanel, BoxLayout.Y_AXIS));

    // creation of interior operator panels
    JPanel plusPanel = new JPanel();
    JPanel minusPanel = new JPanel();
    JPanel multiplyPanel = new JPanel();
    JPanel dividePanel = new JPanel();
    JPanel equalsPanel = new JPanel();

    // creation of exterior function panel
    JPanel functionPanel = new JPanel();
    functionPanel.setLayout(new BoxLayout(functionPanel, BoxLayout.Y_AXIS));

    // creation of interior function panels
    JPanel exponentPanel = new JPanel();
    JPanel inversePanel = new JPanel();

    // creation of history panel
    JPanel historyPanel = new JPanel();

    // result units drop down menu
    resultsDropDown = new JComboBox(measurements);
    resultsDropDown.setEditable(true);
    resultsDropDown.setVisible(true);

    // units drop down menu
    unitsDropDown = new JComboBox(measurements);
    unitsDropDown.setEditable(true);
    unitsDropDown.setVisible(true);
    unitsDropDown.addItemListener(new ItemListener()
    {
      @Override
      public void itemStateChanged(ItemEvent e)
      {
        if (!display.getText().equals("") && expression[1] != null)
        {
          secondUnit = e.getItemSelectable().getSelectedObjects()[0];
          if (expression[1].equals("x") || expression[1].equals("/"))
          {
            if (wholeExponent.equals(""))
            {
              finalUnits = ResultUnits.nonLikeUnits(
                  new Operand(new BigDecimal(1), getFirstUnit(expression[0]), getFirstExponent(),
                      ""),
                  new Operand(new BigDecimal(1), (String) secondUnit, 1, ""), expression[1]);
              updateFinalDropdown(finalUnits);
            }
            else
            {
              finalUnits = ResultUnits.nonLikeUnits(
                  new Operand(new BigDecimal(1), getFirstUnit(expression[0]), getFirstExponent(),
                      ""),
                  new Operand(new BigDecimal(1), (String) secondUnit, getWholeExponentAsInt(), ""),
                  expression[1]);
              updateFinalDropdown(finalUnits);
            }
          }
          else if (expression[1].equals("+") || expression[1].equals("-"))
          {
            finalUnits = ResultUnits.likeUnits(
                new Operand(new BigDecimal(1), getFirstUnit(expression[0]), 1, ""),
                new Operand(new BigDecimal(1), (String) secondUnit, 1, ""));
            updateFinalDropdown(finalUnits);
          }
        }
      }
    });

    // adding interior panels to exterior panels
    topExteriorPanel.add(extLogoPanel);
    topExteriorPanel.add(displayPanel);
    topExteriorPanel.add(inputPanel);

    numberPanel.add(numberPanelOne);
    numberPanel.add(numberPanelTwo);
    numberPanel.add(numberPanelThree);
    numberPanel.add(numberPanelFour);
    numberPanel.add(numberPanelFive);

    operatorPanel.add(plusPanel);
    operatorPanel.add(minusPanel);
    operatorPanel.add(multiplyPanel);
    operatorPanel.add(dividePanel);
    operatorPanel.add(equalsPanel);

    functionPanel.add(exponentPanel);
    functionPanel.add(inversePanel);

    bottomExteriorPanel.add(intStepsPanel);
    bottomExteriorPanel.add(numberPanel);
    bottomExteriorPanel.add(operatorPanel);
    bottomExteriorPanel.add(functionPanel);
    bottomExteriorPanel.add(historyPanel);

    // adding panels to content frame
    contentPane.add(topExteriorPanel);
    contentPane.add(bottomExteriorPanel);

    // creation of display text field
    display = new JTextField();
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.LEFT);

    // creation of input text field
    input = new JTextField();
    input.addKeyListener(this);
    setColor(true);

    // creation of utility buttons
    JButton sign = new JButton(SIGN);
    JButton reset = new JButton("R");
    JButton clear = new JButton("C");
    JButton backspace = new JButton(BACK);

    // operator buttons
    plus = new JButton("+");
    minus = new JButton("-");
    multiply = new JButton("x");
    divide = new JButton(DIVIDE);
    equals = new JButton("=");

    // creation of number buttons
    JButton zero = new JButton("0");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");

    // creation of function buttons

    JButton inverse = new JButton("1/x");

    ArrayList<JButton> buttons = new ArrayList<JButton>();
    buttons.add(sign);
    buttons.add(reset);
    buttons.add(clear);
    buttons.add(backspace);
    buttons.add(plus);
    buttons.add(minus);
    buttons.add(multiply);
    buttons.add(divide);
    buttons.add(equals);
    buttons.add(zero);
    buttons.add(one);
    buttons.add(two);
    buttons.add(three);
    buttons.add(four);
    buttons.add(five);
    buttons.add(six);
    buttons.add(seven);
    buttons.add(eight);
    buttons.add(nine);
    buttons.add(inverse);
    buttons.add(intStepsButton);
    buttons.add(historyButton);
    buttons.add(exponent);

    setColor(buttons, true);

    // adding intSteps button to panel
    intStepsPanel.add(intStepsButton);

    // adding utility buttons to panel
    numberPanelOne.add(sign);
    numberPanelOne.add(clear);
    numberPanelOne.add(reset);

    // adding number buttons to panels
    numberPanelTwo.add(seven);
    numberPanelTwo.add(eight);
    numberPanelTwo.add(nine);

    numberPanelThree.add(four);
    numberPanelThree.add(five);
    numberPanelThree.add(six);

    numberPanelFour.add(one);
    numberPanelFour.add(two);
    numberPanelFour.add(three);

    numberPanelFive.add(zero);
    numberPanelFive.add(backspace);

    // adding operator buttons to individual panels
    plusPanel.add(plus);
    minusPanel.add(minus);
    multiplyPanel.add(multiply);
    dividePanel.add(divide);
    equalsPanel.add(equals);

    // adding function buttons to panels
    exponentPanel.add(exponent);
    inversePanel.add(inverse);

    // adding history button to history panel
    historyPanel.add(historyButton);

    // adding action listener to each button
    intStepsButton.addActionListener(this);

    sign.addActionListener(this);
    reset.addActionListener(this);
    clear.addActionListener(this);

    plus.addActionListener(this);
    minus.addActionListener(this);
    multiply.addActionListener(this);
    divide.addActionListener(this);
    equals.addActionListener(this);

    plus.addKeyListener(this);
    minus.addKeyListener(this);
    multiply.addKeyListener(this);
    divide.addKeyListener(this);
    equals.addKeyListener(this);

    backspace.addActionListener(this);

    zero.addActionListener(this);
    one.addActionListener(this);
    two.addActionListener(this);
    three.addActionListener(this);
    four.addActionListener(this);
    five.addActionListener(this);
    six.addActionListener(this);
    seven.addActionListener(this);
    eight.addActionListener(this);
    nine.addActionListener(this);

    historyButton.addActionListener(this);

    exponent.addActionListener(this);
    inverse.addActionListener(this);
    about.addActionListener(this);

    frame.addComponentListener(this);

    // adding display and input to respective panels
    displayPanel.add(display, BorderLayout.WEST);
    displayPanel.add(resultsDropDown);
    inputPanel.add(input, BorderLayout.WEST);
    inputPanel.add(unitsDropDown);

    // try
    // {
    // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    // }
    // catch (Exception e)
    // {
    // // Use the default
    // }

    // setting frame
    frame.setJMenuBar(menuBar);
    frame.setSize(550, 400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Clears both input and display field.
   */
  private void reset()
  {
    display.setText("");
    input.setText("");
    expression = new String[4];
    lastResult = null;
    updateFinalDropdown(measurements);
    wholeExponent = "";
  }

  /**
   * Clears input field.
   */
  private void clear()
  {
    input.setText("");
    wholeExponent = "";
  }

  @Override
  public void componentResized(ComponentEvent e)
  {

  }

  @Override
  public void componentMoved(ComponentEvent e)
  {
    historyDisplay.setLocation((int) e.getComponent().getLocation().getX() + 368,
        (int) e.getComponent().getLocation().getY() + 63);

    intermediateDisplay.setLocation((int) e.getComponent().getLocation().getX() + 6,
        (int) e.getComponent().getLocation().getY() + 63);

  }

  @Override
  public void componentShown(ComponentEvent e)
  {

  }

  @Override
  public void componentHidden(ComponentEvent e)
  {

  }

  /**
   * Helper method to load the icon.
   * 
   * @param name
   *          of the icon file
   * 
   * @return the icon
   */
  private ImageIcon loadImageIcon(String name)
  {

    URL url = this.getClass().getResource("/icons/" + name);
    ImageIcon icon = new ImageIcon(url);

    return icon;
  }

  /**
   * Helper method to set the colors.
   */
  private void setColor(boolean set)
  {

    int r1 = Integer.parseInt(COLORS.getString("R1"));
    int g1 = Integer.parseInt(COLORS.getString("G1"));
    int b1 = Integer.parseInt(COLORS.getString("B1"));

    Color color = new Color(r1, g1, b1);

    // Set the colors below

    if (set)
    {

      display.setBackground(color);
      input.setBackground(color);
    }
  }

  /**
   * Helper method to set the color of the buttons.
   * 
   * @param buttons
   *          for the list of buttons
   */
  private void setColor(ArrayList<JButton> buttons, boolean set)
  {

    int r2 = Integer.parseInt(COLORS.getString("R2"));
    int g2 = Integer.parseInt(COLORS.getString("G2"));
    int b2 = Integer.parseInt(COLORS.getString("B2"));

    Color color = new Color(r2, g2, b2);

    if (set)
    {
      for (JButton jb : buttons)
      {

        jb.setForeground(color);
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent e)
  {
    // not supported
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    // not supported
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    Character kr = e.getKeyChar();

    switch (kr)
    {
      // do i internationalize this ??
      case '+':
        fixedInput();
        plus.doClick();
        break;
      case '-':
        fixedInput();
        minus.doClick();
        break;
      case 'x':
        fixedInput();
        multiply.doClick();
        break;
      case '/':
        fixedInput();
        divide.doClick();
        break;
      case '=':
        fixedInput();
        equals.doClick();
        break;
      case '^':
        exponent.doClick();
        integerPowerActive = true;
        fixedInput();
        break;
      case KeyEvent.VK_ENTER:
        equals.doClick();
        break;
    }
  }

  /**
   * A helper method which corrects the format of the operand when a hard key is pressed.
   */
  private void fixedInput()
  {
    String text = input.getText();

    if (text.endsWith("+"))
    {
      input.setText(text.replace("+", ""));
    }
    else if (text.endsWith("-"))
    {
      input.setText(text.replace("-", ""));
    }
    else if (text.endsWith("x"))
    {
      input.setText(text.replace("x", ""));
    }
    else if (text.endsWith("/"))
    {
      input.setText(text.replace("/", ""));
    }
    else if (text.endsWith("="))
    {
      input.setText(text.replace("=", ""));
    }
    else if (text.contains("^"))
    {
      input.setText(text.replace("^", ""));
    }
  }
}
