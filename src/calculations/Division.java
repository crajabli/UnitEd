package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import enums.Convert;
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
    
    // Functionality for unit conversion
    Operand tempRight = Convert.convert(leftOp, rightOp);
    
    BigDecimal value = leftOp.getValue().divide(tempRight.getValue()).setScale(6,
        RoundingMode.HALF_DOWN);
    
    String left = leftOp.getUnit();
    String right = tempRight.getUnit();
    String unit;
    
    if (left.equals("") && right.equals(""))
    {
      
      unit = "";
    
    } else if (left.equals(""))
    {
      
      unit = Unit.calculateUnits(right, operator, false);
    
    } else if (right.equals(""))
    {
      
      unit = Unit.calculateUnits(left, "", false);
    
    } else
    {
    
      String tempUnit = Unit.calculateUnits(left, "", false) + "/"
          + Unit.calculateUnits(right, operator, false);
      
      unit = Unit.calculateUnits(tempUnit, "", true);
    }

    return value.toString() + " " + (unit);
  }
}
