package calculations;

import java.math.BigDecimal;

import enums.Convert;
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
    // Functionality for unit conversion
    Operand tempRight = Convert.convert(leftOp, rightOp);
    
    Unit.sameUnitException(leftOp, tempRight);
    
    BigDecimal value = leftOp.getValue().add(tempRight.getValue());
    
    return value.toString() + " " + leftOp.getUnit();
  }
}
