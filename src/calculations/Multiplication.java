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
    
    String tempUnit = Unit.calculateUnits(leftOp.getUnit(), "") + "-"
        + Unit.calculateUnits(rightOp.getUnit(), operator);
    
    String unit = Unit.calculateUnits(tempUnit, "");

    return value.toString() + " " + Unit.format(unit);
  }
}
