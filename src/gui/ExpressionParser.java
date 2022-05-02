package gui;

import java.math.BigDecimal;

import exceptions.IncompleteExpressionException;
import exceptions.IncompleteUnitsException;
import exceptions.NoValueEnteredException;
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
  private String resultUnit; 

  /**
   * Parses the expression.
   * 
   * @param expression
   *          final expression
   * @throws OperationFormatException
   * @throws IncompleteUnitsException
   * @throws NoValueEnteredException
   * @throws IncompleteExpressionException
   */
  public ExpressionParser(final String[] expression) throws OperationFormatException,
      IncompleteUnitsException, NoValueEnteredException, IncompleteExpressionException
  {    
    parseHelper(expression);
  }

  /**
   * Getter method.
   * 
   * @return operator sign
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
   * @throws IncompleteUnitsException
   * @throws NoValueEnteredException
   * @throws IncompleteExpressionException
   */
  private void parseHelper(final String[] expression) throws OperationFormatException,
      IncompleteUnitsException, NoValueEnteredException, IncompleteExpressionException
  {

//    if (expression == null || expression.length == 0)
//    {
//      throw new IllegalArgumentException("You didn't enter anything.");
//    }

    // potentially change this to allow null to be passed in so we can throw error message in real
    // time
    // Checks there is a string in each array index

    for (int i = 0; i < expression.length - 1; i++)

      if (expression[i] == null || expression[i].length() == 0)

      {
        throw new IncompleteExpressionException("The expression you entered was incomplete");
      }

    // Construct left and right operands
    String left = expression[0];
    resultUnit = expression[3]; 
    leftOp = setOperand(left);
    operator = expression[1];
    // Do a check here first to see if we have something in for the right expression
    // maybe pass the Expression parser in expression[3] a specific string "No Input yet"?
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
   * @throws IncompleteUnitsException
   * @throws NoValueEnteredException
   */
  private Operand setOperand(final String op)
      throws OperationFormatException, IncompleteUnitsException, NoValueEnteredException
  {
    StringBuilder toBeValue = new StringBuilder();
    StringBuilder toBeUnit = new StringBuilder();
    int exponent = 1;

    if (op.charAt(0) == '-')
    {
      toBeValue = toBeValue.append(op.charAt(0));
    }

    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      // System.out.println(c); 
      if ((i == 0 && Character.isDigit(c))
          || (i > 0 && Character.isDigit(c) && op.charAt(i - 1) != '^') || c == '.')
      {
        toBeValue = toBeValue.append(c);
      }
      else if ((op.charAt(0) != '-') && (Character.isLetter(c) || c == '/' || c == '-' || (c == '^')
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

    // check for incomplete units
    if (toBeUnit.length() != 0 && (toBeUnit.charAt(toBeUnit.length() - 1) == '/'
        || toBeUnit.charAt(toBeUnit.length() - 1) == '-'))
    {
      throw new IncompleteUnitsException("The unit you entered is incomplete");
    }

    // check if there is a value entered
    if (toBeValue.length() == 0)
    {
      throw new NoValueEnteredException("Please enter a value");
    }

    BigDecimal value = BigDecimal.valueOf(Double.parseDouble(toBeValue.toString()));

    String unit = toBeUnit.toString();
    if (toBeUnit.length() == 0)
    {
      toBeUnit = null;
    }

    return new Operand(value, unit, exponent, resultUnit);
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
  
 
  
  /**
   * Helper method for testing purposes.
   * 
   * @return left operand
   */
  public String getResultUnit()
  {
    return this.resultUnit;
  }

}
