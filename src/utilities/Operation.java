package utilities;

import java.math.BigDecimal;

/**
 * Calculates result given two operands and an operator.
 * 
<<<<<<< HEAD
 * @author Team 22
 * @version 4/4/22
=======
 * @author Victor Aten
 * @version 4/5/22
>>>>>>> branch 'main' of https://github.com/bernstdh/team22
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
	 * @throws OperationFormatException 
	 */
	public String calculate(final Operand leftOp, final Operand rightOp, final String operator)
	    throws OperationFormatException 
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
	 * @throws OperationFormatException when units are not the same
	 */
	public String add(final Operand leftOp, final Operand rightOp)
	    throws OperationFormatException 
	{
		
		sameUnitException(leftOp, rightOp);
		BigDecimal value = leftOp.getValue().add(rightOp.getValue());
		return value + space + leftOp.getUnit();
	}

	/**
	 * Subtracts the given operands in the format leftOp - rightOp.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 * @throws OperationFormatException when units are not the same
	 */
	public String subtract(final Operand leftOp, final Operand rightOp) 
	    throws OperationFormatException 
	{
    
		sameUnitException(leftOp, rightOp);
		BigDecimal value = leftOp.getValue().subtract(rightOp.getValue());
		
		return value + space + leftOp.getUnit(); 
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
	 * @throws OperationFormatException when trying to divide by zero
	 */
	public String divide(final Operand leftOp, final Operand rightOp)
	    throws OperationFormatException 
	{
	  
		// Check that rightOp value is not zero
		if (rightOp.getValue().equals(0))
		{
			throw new OperationFormatException("Cannot divide by zero");
		}
		
		BigDecimal value = leftOp.getValue().divide(rightOp.getValue());
		return value + space + leftOp.getUnit() + division + rightOp.getUnit();
	}
	
	/**
	 * Helper method to throw exception.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @throws OperationFormatException when units are the same
	 */
	private void sameUnitException(final Operand leftOp, final Operand rightOp)
	    throws OperationFormatException
	{
		if (!leftOp.getUnit().equals(rightOp.getUnit()))
		{
			throw new OperationFormatException("Units must be the same for this"
			    + "operation");
		}
	}
}
