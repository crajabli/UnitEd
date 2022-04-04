package utilities;

/**
 * Calculates result given two operands and an operator.
 * 
 * @author Victor Aten
 * @version 4/4/22
 */
public class Operation
{
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
		  
		  case "+":
		    result = add(leftOp, rightOp);
		    break;

		  case "-":
		    result = subtract(leftOp, rightOp);
		    break;

		  case "/":
		    result = divide(leftOp, rightOp);
		    break;

		  case "x": // Check 'x' or '*'
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
		return "";
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
		return "";
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
		return "";
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
		return "";
	}
}
