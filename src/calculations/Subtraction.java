package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import convertUtils.Convert;
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
    Operand[] temp = Convert.convert(leftOp, rightOp);
    Operand tempLeft = temp[0];
    Operand tempRight = temp[1];
    
    Unit.sameUnitException(tempLeft, tempRight);
    
    BigDecimal value = tempLeft.getValue().subtract(tempRight.getValue()).setScale(6,
        RoundingMode.HALF_DOWN);

    return value.toString() + " " + tempLeft.getUnit();
  }
}