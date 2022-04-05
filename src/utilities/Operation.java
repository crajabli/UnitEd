package utilities;

import java.math.BigDecimal;

/**
 * Calculates result given two operands and an operator.
 * 
 * @author Victor Aten
 * @version 4/4/22
 */
public class Operation {
	/**
	 * Returns String that represents the calculation of the given expression.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @param operator represents which calculation to do
	 * @return String
	 * @throws OperationFormatException 
	 */
	public String calculate(final Operand leftOp, final Operand rightOp, final String operator) throws OperationFormatException 
	{
		String result = "";

		// Check operation
		switch (operator) {
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
		}

		return result;
	}

	/**
	 * Adds the given operands together.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 * @throws OperationFormatException 
	 */
	public String add(final Operand leftOp, final Operand rightOp) throws OperationFormatException 
	{
		sameUnitException(leftOp, rightOp);
		BigDecimal value = leftOp.getValue().add(rightOp.getValue());
		return "";
	}

	/**
	 * Subtracts the given operands in the format leftOp - rightOp.
	 * 
	 * @param leftOp represents left operand
	 * @param rightOp represents right operand
	 * @return String
	 * @throws OperationFormatException 
	 */
	public String subtract(final Operand leftOp, final Operand rightOp) throws OperationFormatException 
	{
		sameUnitException(leftOp, rightOp);
		BigDecimal value = leftOp.getValue().subtract(rightOp.getValue());
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
	
	private void sameUnitException(final Operand leftOp, final Operand rightOp) throws OperationFormatException
	{
		if (!leftOp.getUnit().equals(rightOp.getUnit()))
		{
			throw new OperationFormatException("Units must be the same for this operation");
		}
	}
}
