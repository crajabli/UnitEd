package gui;

import java.math.BigDecimal;

import utilities.Operand;

/**
 * Parses value, unit, and operator from the users expression.
 * 
 * @author Team 22
 * @version 4/6/22
 */
public class ExpressionParser
{
  private Operand leftOp;
  private Operand rightOp;
  private String operator;

  /**
   * Parses the expression.
   * 
   * @param expression
   */
  public ExpressionParser(final String[] expression)
  {
    parseHelper(expression);
  }

  /**
   * Private helper.
   * 
   * @param expression
   */
  private void parseHelper(final String[] expression)
  {

    if (expression == null || expression.length == 0)
    {
      throw new IllegalArgumentException("You didn't enter anything.");
    }

    // Checks there is a string in each array index
    for (int i = 0; i < expression.length; i++)

      if (expression[i] == null || expression[i].isEmpty())

      {
        throw new IllegalArgumentException("You did not enter anything.");

      }

    // Construct left and right operands
    String left = expression[0];
    leftOp = setOperand(left);
    operator = expression[1];

    String right = expression[2];
    rightOp = setOperand(right);

  }

  /**
   * Private Helper method to make sure the operands were inputted correctly before setting them.
   * 
   * @param op
   *          given String
   * 
   * @return Operand object
   */
  private Operand setOperand(final String op)
  {
    StringBuilder toBeValue = new StringBuilder();
    StringBuilder toBeUnit = new StringBuilder();
    
    int countSlash = 0;
    int countDash = 0;

    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      if (Character.isDigit(c))
      {
        toBeValue = toBeValue.append(c);
      }
      else if (Character.isLetter(c) || c == '/' || c == '-')
      {

        toBeUnit = toBeUnit.append(c);

        if (c == '/')
        {
          countSlash++;
        }
        else if (c == '-')
        {
          countDash++;
        }
      }
    }

    // check if there is a value entered
    if (toBeValue.toString() == null || toBeValue.isEmpty())
    {
      throw new IllegalArgumentException("You didn't enter a value.");
    }

    // check if there is a unit entered
    if (toBeUnit.toString() == null || toBeUnit.toString().isEmpty())
    {
      throw new IllegalArgumentException("You didn't enter a unit.");
    }

    // check if they entered too many slashes or dashes
    if (countSlash > 1 || countDash > 1)
    {
      throw new IllegalArgumentException("You entered too many '-' or '/'.");
    }

    BigDecimal value = BigDecimal.valueOf(Double.parseDouble(toBeValue.toString()));

    // check if they entered a negative number
    if (value.compareTo(BigDecimal.ZERO) > 0)
    {
      throw new NumberFormatException("You entered a negative number.");
    }

    String unit = toBeUnit.toString();

    return new Operand(value, unit);
  }

  /**
   * Helper method for testing purposes.
   * 
   * @return left operand
   */
  public Operand getLeft()
  {
    return this.leftOp;
  }

  /**
   * Helper method for testing purposes.
   * 
   * @return left operand
   */
  public Operand getRight()
  {
    return this.rightOp;
  }

}