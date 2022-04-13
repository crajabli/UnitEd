package utilities;

import java.math.BigDecimal;

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
  private static final String SPACE = " ";

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
        result = add(leftOp, rightOp);
        break;

      case MINUS:
        result = subtract(leftOp, rightOp);
        break;

      case DIVISION:
        result = divide(leftOp, rightOp);
        break;

      case MULTIPLICATION:
        result = multiply(leftOp, rightOp);
        break;

      default:
        break;
    }

    return result;
  }

  /**
   * Adds the given operands together.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @return String
   * @throws OperationFormatException
   *           when units are not the same
   */
  public static String add(final Operand leftOp, final Operand rightOp)
      throws OperationFormatException
  {

    sameUnitException(leftOp, rightOp);
    BigDecimal value = leftOp.getValue().add(rightOp.getValue());
    return value.toString() + SPACE + leftOp.getUnit();
  }

  /**
   * Subtracts the given operands in the format leftOp - rightOp.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @return String
   * @throws OperationFormatException
   *           when units are not the same
   */
  public static String subtract(final Operand leftOp, final Operand rightOp)
      throws OperationFormatException
  {

    sameUnitException(leftOp, rightOp);
    BigDecimal value = leftOp.getValue().subtract(rightOp.getValue());

    return value.toString() + SPACE + leftOp.getUnit();
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

  /**
   * Multiplies the given operands together.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @return String
   */
  public static String multiply(final Operand leftOp, final Operand rightOp)
  {
    
    BigDecimal value = leftOp.getValue().multiply(rightOp.getValue());

    return value.toString() + SPACE + leftOp.getUnit() + MINUS + rightOp.getUnit();
  }

  /**
   * Divides the given operands in the format leftOp / rightOp.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @return String
   * @throws OperationFormatException
   *           when trying to divide by zero
   */
  public static String divide(final Operand leftOp, final Operand rightOp)
      throws OperationFormatException
  {
    // Check that rightOp value is not zero
    if (rightOp.getValue().equals(BigDecimal.ZERO))
    {
      throw new OperationFormatException("Cannot divide by zero");
    }
    
    BigDecimal value = leftOp.getValue().divide(rightOp.getValue());

    /**
     *  Check mi/h / h = mi/h-h
     *  Check mi/h / mi = mi/h-mi
     */
    if (leftOp.getUnit().equals(rightOp.getUnit()))
    {
      return value.toString();
    }
    else if (leftOp.getUnit().contains(rightOp.getUnit()))
    {
      return value.toString() + SPACE + rightOp.getUnit();
    }
    else if (rightOp.getUnit().contains(leftOp.getUnit()))
    {
      return value.toString() + SPACE + leftOp.getUnit();
    }
    else
    {
      return value.toString() + SPACE + leftOp.getUnit() + DIVISION + rightOp.getUnit();
    }
  }

  /**
   * Helper method to throw exception.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @throws OperationFormatException
   *           when units are the same
   */
  private static void sameUnitException(final Operand leftOp, final Operand rightOp)
      throws OperationFormatException
  {
    if (!leftOp.getUnit().equals(rightOp.getUnit()))
    {
      throw new OperationFormatException("Units must be the same for this" + "operation");
    }
  }
}
