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
  private String[] resultUnits;
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
    for (int i = 0; i < expression.length - 1; i++)
    {

      if (expression[i] == null || expression[i].length() == 0)

      {
        throw new IncompleteExpressionException("The expression you entered was incomplete");
      }
    }

    // Construct left and right operands
    String left = expression[0];
    resultUnit = expression[3];
    operator = expression[1];
    String right = expression[2];
    resultUnits = new String[2];

    if (operator.equals("x"))
    {

      resultUnits = Operand.separateDashUnits(expression[3]);
      leftOp = setOperand(left, resultUnits[0]);
      rightOp = setOperand(right, resultUnits[1]);
    }
    else if (operator.equals("/"))
    {
      resultUnits = Operand.separateSlashUnits(expression[3]);
      leftOp = setOperand(left, resultUnits[0]);
      rightOp = setOperand(right, resultUnits[1]);

    }
    else if (resultUnit == null || resultUnit.isEmpty())
    {
      resultUnits[0] = "";
      resultUnits[1] = "";
      leftOp = setOperand(left, resultUnits[0]);
      rightOp = setOperand(right, resultUnits[1]);

    }
    else
    {
      leftOp = setOperand(left, resultUnit);

      rightOp = setOperand(right, resultUnit);
    }
    // System.out.println(resultUnits[1]);
    // System.out.println(resultUnits[0]);
    // rightOp = setOperand(right, resultUnits[1]);
    // leftOp = setOperand(left, resultUnits[0]);

  }

  /**
   * Private Helper method to make sure the operands were inputed correctly before setting them.
   * 
   * @param op
   *          given String
   * 
   * @return Operand object
   * @throws OperationFormatException
   * @throws IncompleteUnitsException
   * @throws NoValueEnteredException
   */
  private Operand setOperand(final String op, String resultUnit)
      throws OperationFormatException, IncompleteUnitsException, NoValueEnteredException
  {
    StringBuilder toBeValue = new StringBuilder();
    StringBuilder toBeUnit = new StringBuilder();
    int exponent = 1;

    System.out.println(op.charAt(0) == '-'); 

    if (op.charAt(0) == '-')
    {
      System.out.println("add to value: " + op.charAt(0)); 
      toBeValue = toBeValue.append(op.charAt(0));
    }

    for (int i = 0; i < op.length(); i++)
    {
      char c = op.charAt(i);
      System.out.println("C is: " + c + " i: " + i); 
      if ((i == 0 && Character.isDigit(c))
          || (i > 0 && Character.isDigit(c) && op.charAt(i - 1) != '^') || c == '.')
      {
        System.out.println("add to value: " + c); 
        toBeValue = toBeValue.append(c);
      }
      else if (c != '-' && (Character.isLetter(c) || c == '/' || c == '-' || (c == '^')
          || (i != 0 && Character.isDigit(c) && op.charAt(i - 1) == '^')))
      {
        System.out.println("add to unit: " + c); 

        toBeUnit = toBeUnit.append(c);

      }
      else if (!Character.isDigit(c) && !Character.isLetter(c) && c != ' ' && c != '-')
      {
        try
        {
          System.out.println("add to expoent: " + c); 
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
