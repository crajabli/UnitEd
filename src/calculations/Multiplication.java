package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import enums.Convert;
import utilities.Operand;

/**
 * Multiplication class.
 * 
 * @author David Nguyen
 * @version 04-20-2022
 */
public class Multiplication
{

  /**
   * Method performs a multiplication.
   * 
   * @param leftOp for the left operand
   * @param rightOp for the right operand
   * @param operator for the operator
   * 
   * @return the result
   */
  public static String calculate(final Operand leftOp, final Operand rightOp, final String operator)
  {
    // Functionality for unit conversion
    Operand tempRight = Convert.convert(leftOp, rightOp);
    
    BigDecimal value = leftOp.getValue().multiply(tempRight.getValue()).setScale(6,
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
      
      unit = Unit.calculateUnits(left, operator, false);
    
    } else
    {
    
      String tempUnit = Unit.calculateUnits(leftOp.getUnit(), "", false) + "-"
          + Unit.calculateUnits(tempRight.getUnit(), operator, false);
      
      unit = Unit.calculateUnits(tempUnit, "", true);
    }

    return value.toString() + " " + Unit.format(unit);
  }
}
