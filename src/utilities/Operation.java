package utilities;

import calculations.*;
import exceptions.DivideByZeroException;

/**
 * Calculates result given two operands and an operator.
 * 
 * @author Team 22
 * @version 4/6/22
 * 
 */
public class Operation
{

  private static final String MINUS = "-";
  private static final String PLUS = "+";
  private static final String DIVISION = "/";
  private static final String MULTIPLICATION = "x";

  /**
   * Returns String that represents the calculation of the given expression.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @param operator
   *          represents which calculation to do
   * @return String
   * @throws OperationFormatException
   * @throws DivideByZeroException 
   */
  public static String calculate(final Operand leftOp, final Operand rightOp, final String operator)
      throws OperationFormatException, DivideByZeroException
  {

    String result = "";

    // Check operation
    switch (operator)
    {

      case PLUS:
        result = Addition.calculate(leftOp, rightOp);
        break;

      case MINUS:
        result = Subtraction.calculate(leftOp, rightOp);
        break;

      case DIVISION:
        result = Division.calculate(leftOp, rightOp, DIVISION);
        break;

      case MULTIPLICATION:
        result = Multiplication.calculate(leftOp, rightOp, MULTIPLICATION);
        break;

      default:
        break;
    }

    return result;
  }
}
