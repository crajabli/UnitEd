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
  public ExpressionParser(final String[] expression)
      throws OperationFormatException, IncompleteUnitsException, NoValueEnteredException, IncompleteExpressionException
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
  private void parseHelper(final String[] expression)
      throws OperationFormatException, IncompleteUnitsException, NoValueEnteredException, IncompleteExpressionException
  {

    if (expression == null || expression.length == 0)
    {
      throw new IllegalArgumentException("You didn't enter anything.");
    }

//     potentially change this to allow null to be passed in so we can throw error message in real
//     time
//     Checks there is a string in each array index
     for (int i = 0; i < expression.length; i++)
    
     if (expression[i] == null || expression[i].length() == 0)
    
     {
     throw new IncompleteExpressionException("You did not enter anything.");
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
   * @throws IncompleteUnitsException
   * @throws NoValueEnteredException 
   */
  private Operand setOperand(final String op)
      throws OperationFormatException, IncompleteUnitsException, NoValueEnteredException
  {
    StringBuilder toBeValue = new StringBuilder();
    StringBuilder toBeUnit = new StringBuilder();

    
    if (op.charAt(0) == '-')
    {
      toBeValue = toBeValue.append(op.charAt(0));
    } 

    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);

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
     throw new NoValueEnteredException("You didn't enter a value.");
     }

    BigDecimal value = BigDecimal.valueOf(Double.parseDouble(toBeValue.toString()));

    String unit = toBeUnit.toString();
    if (toBeUnit.length() == 0)
    {
      toBeUnit = null;
    }
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
