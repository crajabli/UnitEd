package utilities;

import java.math.BigDecimal;

/**
 * Calculates result given two operands and an operator.
 * 
 * @author Team 22
 * @version 4/4/22
 */
public class Operation
{
  
  private final String minus = "-";
  private final String plus = "+";
  private final String division = "/";
  private final String multiplication = "x";
  private final String space = " ";
  
	/**
	 * Returns String that represents the calculation of the given expression.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @param operator represents which calculation to do
	 * @return String
	 */
	public String calculate(final Operand leftOp, final Operand rightOp, final String operator) 
	{
		String result = "";

		// Check operation
		switch (operator)
		{
		  
		  case plus:
		    result = add(leftOp, rightOp);
		    break;

		  case minus:
		    result = subtract(leftOp, rightOp);
		    break;

		  case division:
		    result = divide(leftOp, rightOp);
		    break;

		  case multiplication:
		    result = multiply(leftOp, rightOp);
		    break;
		    
		  default:
		    break;
		}

		return result;
	}

	/**
	 * Adds the given operands together.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 */
	public String add(final Operand leftOp, final Operand rightOp) 
	{
		
	  // check that units are the same
	  if (!leftOp.getUnit().equals(rightOp.getUnit()))
	  {
	    
	    throw new IllegalArgumentException("The units are different!");
	  }
	  
	  BigDecimal r = leftOp.getValue().add(rightOp.getValue());
	  
		return r.toString() + space + leftOp.getUnit();
	}

	/**
	 * Subtracts the given operands in the format leftOp - rightOp.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 */
	public String subtract(final Operand leftOp, final Operand rightOp) 
	{
		// check that units are the same
	  if (!leftOp.getUnit().equals(rightOp.getUnit()))
    {
      
      throw new IllegalArgumentException("The units are different");
    }
    
    BigDecimal r = leftOp.getValue().subtract(rightOp.getValue());
    
    return r.toString() + space + rightOp.getUnit();
	}

	/**
	 * Multiplies the given operands together.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 */
	public String multiply(final Operand leftOp, final Operand rightOp) 
	{
	  
	  BigDecimal r = leftOp.getValue().multiply(rightOp.getValue());
	  
		return r.toString() + space + leftOp.getUnit() + minus + rightOp.getUnit();
	}

	/**
	 * Divides the given operands in the format leftOp / rightOp.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 */
	public String divide(final Operand leftOp, final Operand rightOp) 
	{
		// check that rightOp value is not zero
	  
	  if (rightOp.getValue() == BigDecimal.ZERO) {
	    
	    throw new IllegalArgumentException("Cannot divide by 0");
	  }
	  
		return "";
	}
}
