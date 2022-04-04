package utilities;

import java.math.BigDecimal;

/**
 * Operation class.
 * 
 * @author Team 22
 * @version 04-06-2022
 * 
 */
public class Operation
{

  private Operand leftOp;
  private Operand rightOp;
  private String str;

  /**
   * Constructor.
   * 
   * @param leftOp
   *          left operand
   * @param rightOp
   *          right operand
   */
  public Operation(final Operand leftOp, final Operand rightOp)
  {

    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }

  /**
   * Calculates users expression.
   * 
   * @param leftValue
   *          left operand
   * @param rightValue
   *          right operand
   * @param operator
   *          op
   * @return calculated answer
   */
  public BigDecimal calculate(final BigDecimal leftValue, final BigDecimal rightValue,
      final String operator)
  {

    BigDecimal result = BigDecimal.ZERO;

    switch (operator)
    {

      case "+":
        result = leftValue.add(rightValue);
        str = result.toString() + " " + leftOp.getUnit();
        break;

      case "-":
        result = leftValue.subtract(rightValue);
        str = result.toString() + " " + leftOp.getUnit();
        break;

      // Need to handle the case for dividing different units.
      case "/":
        result = leftValue.divide(rightValue);

        if (leftOp.getUnit().equals(rightOp.getUnit()))
        {

          str = result.toString();
        }

        break;

      case "x": // Check 'x' or '*'
        result = leftValue.multiply(rightValue);
        str = result.toString() + " " + leftOp.getUnit() + "-" + rightOp.getUnit();
        break;
    }

    return result;
  }

  /**
   * 
   * @return proper answer
   */
  public String toString()
  {

    return str;
  }
}
