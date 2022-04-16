package gui;

import java.math.BigDecimal;
import utilities.Operand;
import utilities.OperationFormatException;

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
   *          final expression
   * @throws OperationFormatException
   */
  public ExpressionParser(final String[] expression) throws OperationFormatException
  {
    parseHelper(expression);
  }

  /**
   * Getter method.
   * 
   * @return operator
   */
  public String getOperator()
  {
    return operator;
  }

  /**
   * Private helper.
   * 
   * @param expression
   * @throws OperationFormatException
   */
  private void parseHelper(final String[] expression) throws OperationFormatException
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
   * @throws OperationFormatException
   */
  private Operand setOperand(final String op) throws OperationFormatException
  {
    
    if (op.charAt(op.length() - 1) == '/' || op.charAt(op.length() - 1) == '-')
    {
      
      throw new IllegalArgumentException("The unit cannot end with a - or /");
    }
    
    StringBuilder toBeValue = new StringBuilder();
    StringBuilder toBeUnit = new StringBuilder();

    int countSlash = 0;
    int countDash = 0;
    if (op.charAt(0) == '-')
    {
      toBeValue = toBeValue.append(op.charAt(0));
    }

    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      if (Character.isDigit(c) || c == '.')
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
    if (toBeValue.length() == 0)
    {
      throw new ArrayIndexOutOfBoundsException("You didn't enter a value.");
    }

    // check if there is a unit entered
    if (toBeUnit.length() == 0)
    {
      throw new ArithmeticException("You didn't enter a unit.");
    }

    // check if they entered too many slashes or dashes
    if (countSlash > 1 || countDash > 1)
    {
      throw new IllegalArgumentException("You entered too many '-' or '/'.");
    }

    BigDecimal value = BigDecimal.valueOf(Double.parseDouble(toBeValue.toString()));

    // check if they entered a negative number
    if (value.compareTo(BigDecimal.ZERO) < 0)
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
