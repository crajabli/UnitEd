package utilities;

import calculations.*;

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
   */
  public static String calculate(final Operand leftOp, final Operand rightOp, final String operator)
      throws OperationFormatException
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

  /**
   * mi/hr * hr = mi
   * mi/hr * hr/mi = no unit
   * mi/hr / hr = mi/hr^2
   * mi/hr * mi = mi^2/hr
   * mi/hr / mi = 1/hr
   * 
   * 5mi/ should be an error ("incomplete units...)
   * 
   * MULTIPLICATION:
   * Private helper method that checks units for - or / (used for both)
   * split units and compare individual units 
   * 
   * 
   */
}
