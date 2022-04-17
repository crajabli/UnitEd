package calculations;

import java.math.BigDecimal;

import utilities.Operand;
import utilities.OperationFormatException;

/**
 * Subtraction class.
 * 
 * @author David Nguyen
 * @version 04-20-2022
 */
public class Subtraction
{

  /**
   * Method performs a subtraction.
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

    Unit.sameUnitException(leftOp, rightOp);
    BigDecimal value = leftOp.getValue().subtract(rightOp.getValue());

    return value.toString() + " " + leftOp.getUnit();
  }
}