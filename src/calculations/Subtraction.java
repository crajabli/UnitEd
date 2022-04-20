package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import enums.Convert;
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
    // Functionality for unit conversion
    Operand tempRight = Convert.convert(leftOp, rightOp);
    
    Unit.sameUnitException(leftOp, tempRight);
    
    BigDecimal value = leftOp.getValue().subtract(tempRight.getValue()).setScale(6,
        RoundingMode.HALF_DOWN);

    return value.toString() + " " + leftOp.getUnit();
  }
}