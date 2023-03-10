package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

//import enums.Convert;
import exceptions.DivideByZeroException;
import convertUtils.Convert;

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
      throws DivideByZeroException
  {
    // Check that rightOp value is not zero
    // changed BigDecimal.ZERO to BigDecimal.valueOf(0.0)
    if (rightOp.getValue().equals(BigDecimal.valueOf(0.0)))
    {
      throw new DivideByZeroException("Cannot divide by zero");
    }
     
    // Functionality for unit conversion
    Operand[] temp = Convert.convert(leftOp, rightOp);
    Operand tempLeft = temp[0];
    Operand tempRight = temp[1];
    
    BigDecimal value = tempLeft.getValue().divide(tempRight.getValue(), 6,
        RoundingMode.HALF_DOWN);
    
    String left = tempLeft.getUnit();
    String right = tempRight.getUnit();
    String unit;
    
    if (left.equals("") && right.equals(""))
    {
      
      unit = "";
    
    } else if (left.equals(""))
    {
      
      unit =  "1/" + Unit.calculateUnits(right, operator, false);
    
    } else if (right.equals(""))
    {
      
      unit = Unit.calculateUnits(left, "", false);
    
    } else
    {
    
      String tempUnit = Unit.calculateUnits(left, "", false) + "/"
          + Unit.calculateUnits(right, operator, false);
      
      unit = Unit.calculateUnits(tempUnit, "", true);
    }

    String result = "";
    
    if (unit.equals(""))
    {
      
      result = value.toString();
    
    } else
    {
      
      result = value.toString() + " " + Unit.format(unit);
    }

    return result;
  }
}
