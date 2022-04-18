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
  
  private static final String SPACE = " ";

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

    /**
     *  Check mi/h / h = mi/h-h
     *  Check mi/h / mi = mi/h-mi
     */
    if (leftOp.getUnit().equals(rightOp.getUnit()))
    {
      return value.toString();
    }
    else if (leftOp.getUnit().contains(rightOp.getUnit()))
    {
      return value.toString() + SPACE + rightOp.getUnit();
    }
    else if (rightOp.getUnit().contains(leftOp.getUnit()))
    {
      return value.toString() + SPACE + leftOp.getUnit();
    }
    else
    {
      return value.toString() + SPACE + leftOp.getUnit() + "/" + rightOp.getUnit();
    }
  }
}
