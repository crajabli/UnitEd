package utilities;

import java.math.BigDecimal;

public class Operation
{

  private Operand leftOp;
  private Operand rightOp;
  private String str;
  
  public Operation(Operand leftOp, Operand rightOp)
  {
    
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }
  
  public BigDecimal Calculate(BigDecimal leftValue, BigDecimal rightValue, String operator)
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
        
        if (leftOp.getUnit().equals(rightOp.getUnit())) {
          
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
  
  public String toString()
  {
    
    return str;
  }
}
