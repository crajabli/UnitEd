package gui;

import utilities.Operation;
import utilities.OperationFormatException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.URL;

import javax.swing.*;

import exceptions.IncompleteExpressionException;
import exceptions.IncompleteUnitsException;
import exceptions.NoValueEnteredException;

/**
 * 
 * @author Makenzie Williams, Chingiz Rajabli
 * @version 1
 *
 */
public class GraphicalUserInterface implements ActionListener, ComponentListener
{

  JTextField display;
  JTextField input;
  String[] expression = new String[3];
  private final String DIVIDE = "\u00F7";
  String lastResult = null;
  private final String SIGN = "\u00B1";
  private final String BACK = "\u232B";
  static History historyDisplay = new History();
  JComboBox unitsDropDown;
  JComboBox resultsDropDown;
  static JButton historyButton = new JButton(">");
  static JButton intStepsButton = new JButton("<");
  static Timer timer = new Timer(3, historyDisplay);
  private final String EXPONENT = "X\u02B8";

  /**
   * Constructor.
   */
  public GraphicalUserInterface()
  {
    setLayout();
  }

  public void resetTimer()
  {
    timer.restart();
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

  public static void startTimer()
  {
    timer.start();
  }

  public static void stopTimer()
  {
    timer.stop();
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

  public static void setHistoryButtonVisible()
  {
    historyButton.setVisible(true);
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    String ac = e.getActionCommand();

    switch (ac)
    {
      case "R" -> reset();
      case "C" -> clear();
      case "+" ->
      {
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("\\d", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        if (lastResult == null && !numeric.equals(""))
        {
          if (!units.equals(""))
          {
            if (units.charAt(units.length() - 1) == ('/')
                || units.charAt(units.length() - 1) == ('-'))
            {
              {
                JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                    "Wrong units", JOptionPane.INFORMATION_MESSAGE);
                reset();
                break;
              }
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

          display.setText("");
          display.setText(
              display.getText() + input.getText() + " " + unitsDropDown.getSelectedItem() + " + ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "+");
          clear();

        }
        else if (lastResult != null && numeric.equals(""))
        {
          display.setText(lastResult + " + ");
          addOperand(lastResult, "+");
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Enter value", "No value",
              JOptionPane.INFORMATION_MESSAGE);
        }

      }
      case "-" ->
      {
        // parse the input
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("\\d", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        if (!units.equals(""))
        {
          if (units.charAt(units.length() - 1) == ('/')
              || units.charAt(units.length() - 1) == ('-'))
          {
            {
              JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                  "Wrong units", JOptionPane.INFORMATION_MESSAGE);
              reset();
              break;
            }
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

        if (lastResult == null && !numeric.equals(""))
        {
          display.setText("");
          if (unitsDropDown.getSelectedItem().equals("none"))
          {
            display.setText(display.getText() + input.getText() + " - ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "-");
            clear();
          }
          else
          {
            display.setText(
                display.getText() + input.getText() + " " + unitsDropDown.getSelectedItem() + " - ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "-");
            clear();
          }
        }
        else if (lastResult != null)
        {
          display.setText(lastResult + " - ");
          addOperand(lastResult, "-");
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Enter value", "No value",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }
      case "1" ->
      {
        // put the input
        putInput(1);
      }
      case "2" ->
      {
        // put the input
        putInput(2);
      }
      case "3" ->
      {
        // put the input
        putInput(3);
      }
      case "4" ->
      {
        // put the input
        putInput(4);
      }
      case "5" ->
      {
        // put the input
        putInput(5);
      }
      case "6" ->
      {
        // put the input
        putInput(6);
      }
      case "7" ->
      {
        // put the input
        putInput(7);
      }
      case "8" ->
      {
        // put the input
        putInput(8);
      }
      case "9" ->
      {
        // put the input
        putInput(9);
      }
      case "0" ->
      {
        // put the input
        putInput(0);
      }
      case ">" ->
      {
        // set history visible
        startTimer();

        historyDisplay.setVisible(true);
        historyButton.setVisible(false);

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
        String units = input.getText().replaceAll("\\d", "");

        if (numeric.length() > 0)
        {
          input.setText(numeric.substring(0, numeric.length() - 1) + units);
        }
      }
      case "x" ->
      {
        // parse the input
        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("\\d", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        if (!units.equals(""))
        {
          if (units.charAt(units.length() - 1) == ('/')
              || units.charAt(units.length() - 1) == ('-'))
          {
            {
              JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                  "Wrong units", JOptionPane.INFORMATION_MESSAGE);
              reset();
              break;
            }
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

        if (lastResult == null && !numeric.equals(""))
        {

          display.setText("");
          if (unitsDropDown.getSelectedItem().equals("none"))
          {
            display.setText(display.getText() + input.getText() + " x ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "x");
            clear();
          }
          else
          {
            display
                .setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " x ");
            addOperand(input.getText() + unitsDropDown.getSelectedItem(), "x");
            clear();
          }
        }
        else if (lastResult != null)
        {
          display.setText(lastResult + " x ");
          addOperand(lastResult, "x");
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Enter value", "No value",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }
      case DIVIDE ->
      {
        // parse the input

        String numeric = input.getText().replaceAll("[^0-9]", "");
        String units = input.getText().replaceAll("\\d", "");
        String dropdownUnits = unitsDropDown.getSelectedItem().toString();

        if (!units.equals(""))
        {
          if (units.charAt(units.length() - 1) == ('/')
              || units.charAt(units.length() - 1) == ('-'))
          {
            {
              JOptionPane.showMessageDialog(null, "The units you entered are incomplete",
                  "Wrong units", JOptionPane.INFORMATION_MESSAGE);
              reset();
              break;
            }
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

        if (lastResult == null && !numeric.equals(""))
        {
          display.setText("");
          display.setText(display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " / ");
          addOperand(input.getText() + unitsDropDown.getSelectedItem(), "/");
          clear();

        }
        else if (lastResult != null)
        {
          display.setText(lastResult + " / ");
          addOperand(lastResult, "/");
          clear();
        }
        else if (lastResult == null && numeric.equals(""))
        {
          JOptionPane.showMessageDialog(null, "Enter value", "No value",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }
      case "=" ->
      {
        // calculate;

        expression[2] = input.getText() + unitsDropDown.getSelectedItem();

        try
        {
          String result;
          ExpressionParser parser = new ExpressionParser(expression);
          result = Operation.calculate(parser.getLeft(), parser.getRight(), parser.getOperator());

          display.setText(
              display.getText() + input.getText() + unitsDropDown.getSelectedItem() + " = " + result);
          historyDisplay.updateText(display.getText());
          lastResult = result;
          expression = new String[3];

        }

        catch (IncompleteUnitsException iue)
        {
          reset();
          JOptionPane.showMessageDialog(null, "The units you entered are incomplete", "Wrong units",
              JOptionPane.INFORMATION_MESSAGE);
        }
        catch (OperationFormatException ex)
        {
          reset();
          JOptionPane.showMessageDialog(null, "Units are not same ", "Wrong unit ",
              JOptionPane.INFORMATION_MESSAGE);
        }
        // catch (ArithmeticException ax)
        // {
        // reset();
        // JOptionPane.showMessageDialog(null, "You didn't enter a unit ", "No unit ",
        // JOptionPane.INFORMATION_MESSAGE);
        // }
        // catch (ArrayIndexOutOfBoundsException ax)
        // {
        // reset();
        // JOptionPane.showMessageDialog(null, "You didn't enter a value ", "No unit ",
        // JOptionPane.INFORMATION_MESSAGE);
        // }

        // catch (ArithmeticException ax)
        // {
        // reset();
        // JOptionPane.showMessageDialog(null, "You didn't enter a unit ", "No unit ",
        // JOptionPane.INFORMATION_MESSAGE);
        // }
        // catch (ArrayIndexOutOfBoundsException ax)
        // {
        // reset();
        // JOptionPane.showMessageDialog(null, "You didn't enter a value ", "No unit ",
        // JOptionPane.INFORMATION_MESSAGE);
        // }
        catch (NoValueEnteredException e1)
        {
          reset();
          JOptionPane.showMessageDialog(null, "Please enter a value", "No Value",
              JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IncompleteExpressionException iee)
        {
          reset();
          JOptionPane.showMessageDialog(null, "The expression you entered was incomplete.",
              "Incomplete Expression", JOptionPane.INFORMATION_MESSAGE);
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
    JFrame frame = new JFrame("UnitED");
    JPanel contentPane = (JPanel) frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

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
    
    // result units drop down menu
    resultsDropDown = new JComboBox();
    resultsDropDown.setEditable(true);
    resultsDropDown.setVisible(true);
    

    // string array of units for dropdown menu
    String[] measurements = {"", "in", "ft", "yd", "mi", "mm", "cm", "m", "km", "oz", "lb", "ton",
        "g", "kg", "pt", "qt", "gal", "cc", "l", "c", "$", "sec", "hr", "day", "mon", "yr"};

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
    JButton exponent = new JButton("X\u02B8");
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
    
    frame.addComponentListener(this);

    // adding display and input to respective panels
    displayPanel.add(display, BorderLayout.WEST);
    displayPanel.add(resultsDropDown);
    inputPanel.add(input, BorderLayout.WEST);
    inputPanel.add(unitsDropDown);

//    try
//    {
//      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    }
//    catch (Exception e)
//    {
//      // Use the default
//    }

    // setting frame
    frame.setSize(550, 400);
    frame.setVisible(true);
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
   * Helper methods to load the icon.
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
}
