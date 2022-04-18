package gui;

import utilities.Operation;
import utilities.OperationFormatException;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author Makenzie Williams, Chingiz Rajabli
 * @version 1
 *
 */
public class GraphicalUserInterface implements ActionListener
{

  JTextField display;
  JTextField input;
  String[] expression = new String[3];
  private final String DIVIDE = "\u00F7";
  String lastResult = null;
  private final String SIGN = "\u00B1";
  private final String BACK = "\u232B";


  /**
   * Constructor.
   */
  public GraphicalUserInterface()
  {
    setLayout();
  }


  public void setButtons()
  {

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
        // parsing the inputField

        /*display.setText("");
        display.setText(display.getText() + input.getText() + " + ");
        addOperand(input.getText(), "+");
        clear();*/

        if(lastResult == null)
        {
          display.setText(display.getText() + input.getText() + " + ");
          addOperand(input.getText(), "+");
          clear();
        } else if (lastResult != null){
          display.setText(lastResult + " + ");
          addOperand(lastResult, "+");
          clear();
        }

      }
      case "-" ->
      {
        // parse the input
        if(lastResult == null)
        {
          display.setText(display.getText() + input.getText() + " - ");
          addOperand(input.getText(), "-");
          clear();
        } else if (lastResult != null){
          display.setText(lastResult + " - ");
          addOperand(lastResult, "-");
          clear();
        }
      }
      case "1" ->
          {
            // parse the input
              display.setText(display.getText() + "1");
              clear();
          }
      case "2" ->
          {
            // parse the input
            display.setText(display.getText() + "2");
            clear();
          }
      case "3" ->
          {
            // parse the input
            display.setText(display.getText() + "3");
            clear();
          }
      case "4" ->
          {
            // parse the input
            display.setText(display.getText() + "4");
            clear();
          }
      case "5" ->
          {
            // parse the input
            display.setText(display.getText() + "5");
            clear();
          }
      case "6" ->
          {
            // parse the input
            display.setText(display.getText() + "6");
            clear();
          }
      case "7" ->
          {
            // parse the input
            display.setText(display.getText() + "7");
            clear();
          }
      case "8" ->
          {
            // parse the input
            display.setText(display.getText() + "8");
            clear();
          }
      case "9" ->
          {
            // parse the input
            display.setText(display.getText() + "9");
            clear();
          }
      case "0" ->
          {
            // parse the input
            display.setText(display.getText() + "0");
            clear();
          }
      case BACK ->
          {
            // parse the input
            display.setText(display.getText().substring(0, display.getText().length() - 1));
            clear();
          }
      case "x" ->
      {
        // parse the input
        if(lastResult == null)
        {
          display.setText(display.getText() + input.getText() + " x ");
          addOperand(input.getText(), "x");
          clear();
        } else if (lastResult != null){
          display.setText(lastResult + " x ");
          addOperand(lastResult, "x");
          clear();
        }
      }
      case DIVIDE ->
      {
        // parse the input
        if(lastResult == null)
        {
          display.setText(display.getText() + input.getText() + " / ");
          addOperand(input.getText(), "/");
          clear();
        } else if (lastResult != null){
          display.setText(lastResult + " / ");
          addOperand(lastResult, "/");
          clear();
        }
      }
      case "=" ->
      {
        // calculate;
        expression[2] = input.getText();

        try
        {
          String result;
          ExpressionParser parser = new ExpressionParser(expression);
          result = Operation.calculate(parser.getLeft(), parser.getRight(), parser.getOperator());
          display.setText(display.getText() + input.getText() + " = " + result);
          lastResult = result;
          expression = new String[3];
        }

        catch (IllegalArgumentException ie)
        {
          reset();
          JOptionPane.showMessageDialog(null, "You entered too many '-' or'/'", "No unit ",
              JOptionPane.INFORMATION_MESSAGE);
        }
        catch (OperationFormatException ex)
        {
          reset();
          JOptionPane.showMessageDialog(null, "Units are not same ", "Wrong unit ",
              JOptionPane.INFORMATION_MESSAGE);
        }
        catch (ArithmeticException ax)
        {
          reset();
          JOptionPane.showMessageDialog(null, "You didn't enter a unit ", "No unit ",
              JOptionPane.INFORMATION_MESSAGE);
        }
        catch (ArrayIndexOutOfBoundsException ax)
        {
          reset();
          JOptionPane.showMessageDialog(null, "You didn't enter a value ", "No unit ",
              JOptionPane.INFORMATION_MESSAGE);
        }


        clear();

      }
    }

  }

  /**
   * sets up the layout.
   */
  @SuppressWarnings("rawtypes")
  private void setLayout()
  {

    // creation of frame and content pane
    JFrame frame = new JFrame("UnitED");
    JPanel contentPane = (JPanel) frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    // creation of panels
    JPanel topExteriorPanel = new JPanel();
    topExteriorPanel.setLayout(new BoxLayout(topExteriorPanel, BoxLayout.Y_AXIS));

    JPanel bottomExteriorPanel = new JPanel();
    bottomExteriorPanel.setLayout(new BoxLayout(bottomExteriorPanel, BoxLayout.X_AXIS));

    JPanel logoPanel = new JPanel();
    logoPanel.setLayout(new BorderLayout());

    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

    JPanel numberPanel = new JPanel();
    numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.Y_AXIS));

    JPanel numberPanelOne = new JPanel();
    JPanel numberPanelTwo = new JPanel();
    JPanel numberPanelThree = new JPanel();
    JPanel numberPanelFour = new JPanel();
    JPanel numberPanelFive = new JPanel();

    JPanel operatorPanel = new JPanel();
    operatorPanel.setLayout(new BoxLayout(operatorPanel, BoxLayout.Y_AXIS));

    JPanel plusPanel = new JPanel();
    JPanel minusPanel = new JPanel();
    JPanel multiplyPanel = new JPanel();
    JPanel dividePanel = new JPanel();
    JPanel equalsPanel = new JPanel();

    JPanel historyPanel = new JPanel();

    // creation of image label
    ImageIcon image = new ImageIcon("src/unitED_Logo.png");
    JLabel label = new JLabel(image);
    logoPanel.add(label);

    // creation of options in dropdown menu
    String[] measurements = {"none", "c", "cm", "cm-cm", "ft", "ft-ft", "ft-ft-ft", "gal", "gr", "hrs", "in", "kg", "km", "l", "lbs",
        "m", "mg", "mi", "mi-mi", "min", "mm", "mph", "oz", "pt", "qt", "sec", "sec-sec", "tbsp", "tsp", "yd"};

    // creation of drop down menu
    @SuppressWarnings("unchecked")
    JComboBox dropdown = new JComboBox(measurements);
    dropdown.setEditable(true);
    dropdown.setVisible(true);

    // adding interior panels to exterior panels
    topExteriorPanel.add(logoPanel);
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

    bottomExteriorPanel.add(numberPanel);
    bottomExteriorPanel.add(operatorPanel);
    bottomExteriorPanel.add(historyPanel);

    // adding panels to content frame
    contentPane.add(topExteriorPanel);
    contentPane.add(bottomExteriorPanel);

    // creation of display text field
    display = new JTextField();
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.CENTER);
    display.setSize(500, 50);

    // creation of input text field
    input = new JTextField();

    // creation of utility, operator, and history buttons
    JButton sign = new JButton(SIGN);
    JButton reset = new JButton("R");
    JButton clear = new JButton("C");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("x");
    JButton divide = new JButton(DIVIDE);
    JButton equals = new JButton("=");
    JButton history = new JButton(">");
    JButton backspace = new JButton(BACK);

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

    // adding operator buttons to panel
    plusPanel.add(plus);
    minusPanel.add(minus);
    multiplyPanel.add(multiply);
    dividePanel.add(divide);
    equalsPanel.add(equals);

    // adding history button to panel
    historyPanel.add(history);

    // adding action listener to each button
    sign.addActionListener(this);
    reset.addActionListener(this);
    clear.addActionListener(this);
    plus.addActionListener(this);
    minus.addActionListener(this);
    multiply.addActionListener(this);
    divide.addActionListener(this);
    equals.addActionListener(this);
    history.addActionListener(this);
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

    // adding display and input to respective panels
    displayPanel.add(display, BorderLayout.CENTER);
    inputPanel.add(input, BorderLayout.CENTER);
    inputPanel.add(dropdown);

    // setting frame
    frame.setSize(550, 250);
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

}
