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
   * @param expression final expression
   */
  public ExpressionParser(final String[] expression)
  {
    parseHelper(expression);
  }


  /**
   * getter for left operand.
   *
   * @return left operand
   */
  public Operand getLeftOp()
  {
    return this.leftOp;
  }

  /**
   * getter for the right operand.
   *
   * @return the right operand
   */
  public Operand getRightOp()
  {
    return this.rightOp;
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

    // Checks if there is a string in each array index
    // Removes all spaces from the Strings
    for (String str : expression)
    {
      int i = 0;
      
      if (str == null || str.isEmpty())
      {
        throw new IllegalArgumentException("You did not enter anything.");

      }
      
      expression[i] = str.replaceAll("\\s", " ");
      i++;
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
   * @param op given String
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
    if (value.compareTo(BigDecimal.ZERO) < 0)
    {
      throw new NumberFormatException("You entered a negative number.");
    }
    
    String unit = toBeUnit.toString();
    
    return new Operand(value, unit);
  }

}
