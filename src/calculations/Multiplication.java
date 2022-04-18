package calculations;

import java.math.BigDecimal;

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
    
    BigDecimal value = leftOp.getValue().multiply(rightOp.getValue());
    
    String left = leftOp.getUnit();
    String right = rightOp.getUnit();
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
          + Unit.calculateUnits(rightOp.getUnit(), operator, false);
      
      unit = Unit.calculateUnits(tempUnit, "", true);
    }

    return value.toString() + " " + unit;
  }
}
