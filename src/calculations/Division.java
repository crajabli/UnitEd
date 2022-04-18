package calculations;

import java.math.BigDecimal;

import utilities.Operand;
import utilities.OperationFormatException;

/**
 * Division class.
 * 
 * @author David Nguyen
 * @version 04-20-2022
 */
public class Division
{
  
  /**
   * 
   * @param leftOp for the left operand
   * @param rightOp for the right operand
   * @param operator for the operator
   * 
   * @return the result
   * 
   * @throws OperationFormatException when trying to divide by zero
   */
  public static String calculate(final Operand leftOp, final Operand rightOp, final String operator)
      throws OperationFormatException
  {
    // Check that rightOp value is not zero
    if (rightOp.getValue().equals(BigDecimal.ZERO))
    {
      throw new OperationFormatException("Cannot divide by zero");
    }
    
    BigDecimal value = leftOp.getValue().divide(rightOp.getValue());

    String tempUnit = Unit.calculateUnits(leftOp.getUnit(), "") + "-"
        + Unit.calculateUnits(rightOp.getUnit(), operator);
    
    String unit = Unit.calculateUnits(tempUnit, "");
    
    return value.toString() + " " + unit;
  }
}
