package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import convertUtils.Convert;
import convertUtils.Units;
import exceptions.NotLikeUnitsException;
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
   * @throws NotLikeUnitsException for non-compatible units 
   */
  public static String calculate(final Operand leftOp, final Operand rightOp)
      throws NotLikeUnitsException
  {
    // checks if units are like units before adding
    if (!Units.instanceOf(leftOp.getUnit(), rightOp.getUnit())) {
      throw new NotLikeUnitsException("You cannot add/subtract non-like units"); 
    }
    
    // Functionality for unit conversion
    Operand[] temp = Convert.convert(leftOp, rightOp);
    Operand tempLeft = temp[0];
    Operand tempRight = temp[1];
    
    
    BigDecimal value = tempLeft.getValue().add(tempRight.getValue()).setScale(6,
        RoundingMode.HALF_DOWN);
    
    return value.toString() + " " + tempLeft.getUnit();
  }
}
