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
   * 
   * @return the result
   */
  public static String calculate(final Operand leftOp, final Operand rightOp)
  {
    
    BigDecimal value = leftOp.getValue().multiply(rightOp.getValue());

    return value.toString() + " " + leftOp.getUnit() + "-" + rightOp.getUnit();
  }
}
