package calculations;

import java.math.BigDecimal;

import utilities.Operand;
import utilities.OperationFormatException;

/**
 * Addition class.
 * 
 * @author David Nguyen
 * @version 04-20-2022
 */
public class Addition
{
  
  /**
   * Method performs an addition.
   * 
   * @param leftOp for the left operand
   * @param rightOp for the right operand
   * 
   * @return the result
   * 
   * @throws OperationFormatException when the units are not the same
   */
  public static String calculate(final Operand leftOp, final Operand rightOp)
      throws OperationFormatException
  {

    sameUnitException(leftOp, rightOp);
    BigDecimal value = leftOp.getValue().add(rightOp.getValue());
    return value.toString() + " " + leftOp.getUnit();
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
