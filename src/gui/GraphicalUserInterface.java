package gui;

import utilities.Operand;
import utilities.Operation;
import utilities.OperationFormatException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import exceptions.DivideByZeroException;
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
public class GraphicalUserInterface implements ActionListener, ComponentListener
{

  JTextField display;
  JTextField input;
  String[] expression = new String[4];
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
  // static final ResourceBundle STRINGS = ResourceBundle.getBundle("gui.Strings");
  static final Locale LOCALE = null; // Locale.getDefault(); Belgium and French 
  static JButton intStepsButton = new JButton("<");
  static Timer historyTimer = new Timer(3, historyDisplay);
  static Timer intermediateTimer = new Timer(3, intermediateDisplay);
  private final String EXPONENT = "X\u02B8";
  boolean integerPowerActive = false;
  static JButton exponent = new JButton("X\u02B8");
  private String aboutStr = "This calculator is by unitEd. This is a four-function calculator with"
      + " some extra features including the ability to inverse a function as well as evaluate an "
      + "integer exponent. This calculator will not let you type units into the input bar; you must "
      + "select one from the dropdown menu. Additionally, it will change languages based on your "
      + "locality but is currently limited to English, French, and Russian-speaking localities. The "
      + "calculator shows all previous calculations in the history display to the right and shows the "
      + "steps of those calculations in the intermediate steps display on the left.";
  Object[] finalUnits;

  /**
   * Constructor.
   */
  public GraphicalUserInterface()
  {
    setLayout();
  }

  public void resetTimer()
  {
    historyTimer.restart();
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
    String numeric = input.getText().replaceAll("[^0-9]", "");
    String units = input.getText().replaceAll("\\d", "");
    input.setText(numeric + n + units);
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


  private void updateFinalDropdown(Object[] units) {
    resultsDropDown.setModel(new DefaultComboBoxModel(finalUnits));
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
            JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
                JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
            // STRINGS.getString("WRONG_UNITS"),
            // JOptionPane.INFORMATION_MESSAGE);
            reset();
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
            JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                "Wrong units", JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
            // STRINGS.getString("WRONG_UNITS"),
            // JOptionPane.INFORMATION_MESSAGE);
            reset();
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // initial calculation
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + " " + unitsDropDown.getSelectedItem() + " + ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "+");
          finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
              (String) unitsDropDown.getSelectedItem(), 1, "result"));
          updateFinalDropdown(finalUnits);
          clear();

        }
        else if (lastResult != null && numeric.equals("")) // calculation for the rolling over
                                                           // operations.
        {
          display.setText(lastResult + " + ");
          addOperand(lastResult, "+");
          finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
              (String) unitsDropDown.getSelectedItem(), 1, "result"));
          updateFinalDropdown(finalUnits);
          clear();
        }
        else if (lastResult != null && !numeric.equals("")) // calculations for the non rolling over
                                                            // operations that arent first
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + " " + unitsDropDown.getSelectedItem() + " + ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "+");
          finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
              (String) unitsDropDown.getSelectedItem(), 1, "result"));
          updateFinalDropdown(finalUnits);
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);

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
            JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
                JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
            // STRINGS.getString("WRONG_UNITS"),
            // JOptionPane.INFORMATION_MESSAGE);
            reset();
            break;
          }
        }
        if (!dropdownUnits.equals(""))
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                "Wrong units", JOptionPane.INFORMATION_MESSAGE);

            reset();
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // the first calculation
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + " " + unitsDropDown.getSelectedItem() + " - ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "-");
          finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
              (String) unitsDropDown.getSelectedItem(), 1, "result"));
          updateFinalDropdown(finalUnits);
          clear();

        }
        else if (lastResult != null && numeric.equals("")) // rolling calculation
        {
          display.setText(lastResult + " - ");
          addOperand(lastResult, "-");
          finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
              (String) unitsDropDown.getSelectedItem(), 1, "result"));
          updateFinalDropdown(finalUnits);
          clear();
        }
        if (lastResult != null && !numeric.equals("")) // non rolling calculation but with
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + " " + unitsDropDown.getSelectedItem() + " - ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "-");
          finalUnits = ResultUnits.likeUnits(new Operand(new BigDecimal(12),
              (String) unitsDropDown.getSelectedItem(), 1, "result"));
          updateFinalDropdown(finalUnits);
          clear();

        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
                JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
            // STRINGS.getString("WRONG_UNITS"),
            // JOptionPane.INFORMATION_MESSAGE);
            reset();
            break;
          }
        }
        if (!dropdownUnits.equals("")) // checking dropdown units
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                "Wrong units", JOptionPane.INFORMATION_MESSAGE);
            reset();
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // first operation
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " x ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "x");
          clear();
        }
        else if (lastResult != null && numeric.equals("")) // rolling calculation
        {
          display.setText(lastResult + " x ");
          addOperand(lastResult, "x");
          clear();
        }
        else if (lastResult != null && !numeric.equals("")) // non rolling calculation but not first
                                                            // one
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " x ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "x");
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No units allowed in input field", "Wrong units",
                JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(null, STRINGS.getString("NO_UNITS_INPUT"),
            // STRINGS.getString("WRONG_UNITS"),
            // JOptionPane.INFORMATION_MESSAGE);
            reset();
            break;
          }
        }
        if (!dropdownUnits.equals(""))
        {
          if (dropdownUnits.charAt(dropdownUnits.length() - 1) == ('/')
              || dropdownUnits.charAt(dropdownUnits.length() - 1) == ('-'))
          {
            JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                "Wrong units", JOptionPane.INFORMATION_MESSAGE);
            reset();
            break;
          }
        }

        if (lastResult == null && !numeric.equals("")) // first operation
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " / ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "/");
          clear();

        }
        else if (lastResult != null && numeric.equals("")) // rolling operation
        {
          display.setText(lastResult + " / ");
          addOperand(lastResult, "/");
          clear();
        }
        if (lastResult != null && !numeric.equals("")) // normal calculation
        {
          display.setText("");
          display.setText(
              display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " / ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "/");
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
        }
        integerPowerActive = false;

      }
      case "About" ->
      {
        JDialog aboutDialog = new JDialog();
        JPanel aboutPanel = (JPanel) aboutDialog.getContentPane();
        JTextArea textArea = new JTextArea(5, 40);

        textArea.setText(aboutStr);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        aboutPanel.add(textArea);
        aboutDialog.setVisible(true);
        aboutDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        aboutDialog.setSize(400, 200);
        aboutDialog.setLocationRelativeTo(null);
      }
      case "=" ->
      {
        // calculate;
        integerPowerActive = false;
        expression[2] = input.getText() + unitsDropDown.getSelectedItem();
        // if (results != null
        expression[3] = "" + resultsDropDown.getSelectedItem();
        // else do expression[3] = "";
        try
        {
          String result;
          ExpressionParser parser = new ExpressionParser(expression);
          result = Operation.calculate(parser.getLeft(), parser.getRight(), parser.getOperator());

          display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem()
              + " = " + result);
          historyDisplay.updateText(display.getText());
          lastResult = result;
          expression = new String[4];

        }

        catch (DivideByZeroException dbz)
        {
          reset();
          JOptionPane.showMessageDialog(null, "You cannot divide by zero", "Incorrect Equation",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString(""),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IncompleteUnitsException iue)
        {
          reset();
          JOptionPane.showMessageDialog(null, "The units you entered are incomplete", "Wrong units",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString(""),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
        }
        catch (OperationFormatException ex)
        {
          reset();
          JOptionPane.showMessageDialog(null, "Units are not same ", "Wrong unit ",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString(""),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
        }
<<<<<<< HEAD
       
=======

>>>>>>> branch 'main' of https://github.com/bernstdh/team22.git
        catch (NoValueEnteredException e1)
        {
          reset();
          JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
              JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString("ENTER_VALUE"),
          // STRINGS.getString("NO_VALUE"),
          // JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IncompleteExpressionException iee)
        {
          reset();
          JOptionPane.showMessageDialog(null, "The expression you entered was incomplete",
              "Incomplete Expression", JOptionPane.INFORMATION_MESSAGE);
          // JOptionPane.showMessageDialog(null, STRINGS.getString("EXPRESSION_INCOM"),
          // STRINGS.getString("INCOMPLETE"),
          // JOptionPane.INFORMATION_MESSAGE);
        }

        clear();

      }
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
    JFrame frame = new JFrame("UnitED");
    JPanel contentPane = (JPanel) frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    // create menu bar, menus, menu items.
    JMenuBar menuBar = new JMenuBar();
    JMenu help = new JMenu("Help"); // STRINGS.getString("HELP")
    JMenuItem about = new JMenuItem("About"); // STRINGS.getString("ABOUT")

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
    ImageIcon image = loadImageIcon("unitED_Logo.png");
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

    // string array of units for dropdown menu
    String[] measurements = {"", "in", "ft", "yd", "mi", "mm", "cm", "m", "km", "oz", "lb", "ton",
        "g", "kg", "pt", "qt", "gal", "cc", "l", "c", "$", "sec", "hr", "day", "mon", "yr"};

    // result units drop down menu
    resultsDropDown = new JComboBox(measurements);
    resultsDropDown.setEditable(true);
    resultsDropDown.setVisible(true);

    // units drop down menu
    unitsDropDown = new JComboBox(measurements);
    unitsDropDown.setEditable(true);
    unitsDropDown.setVisible(true);

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

    // creation of utility buttons
    JButton sign = new JButton(SIGN);
    JButton reset = new JButton("R");
    JButton clear = new JButton("C");
    JButton backspace = new JButton(BACK);

    // operator buttons
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("x");
    JButton divide = new JButton(DIVIDE);
    JButton equals = new JButton("=");

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
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Clears both input and display field.
   */
  private void reset()
  {
    display.setText("");
    input.setText("");
    expression = new String[3];
    lastResult = null;
  }

  /**
   * Clears input field.
   */
  private void clear()
  {
    input.setText("");
  }

  @Override
  public void componentResized(ComponentEvent e)
  {

  }

  @Override
  public void componentMoved(ComponentEvent e)
  {
    historyDisplay.setLocation((int) e.getComponent().getLocation().getX() + 545,
        (int) e.getComponent().getLocation().getY() + 112);

    intermediateDisplay.setLocation((int) e.getComponent().getLocation().getX() + 6,
        (int) e.getComponent().getLocation().getY() + 112);

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

    int r2 = Integer.parseInt(COLORS.getString("R2"));
    int g2 = Integer.parseInt(COLORS.getString("G2"));
    int b2 = Integer.parseInt(COLORS.getString("B2"));

    Color first = new Color(r1, g1, b1);
    Color second = new Color(r2, g2, b2);

    // Set the colors below
    
    if (set)
    {
      
      
    }
  }
}
