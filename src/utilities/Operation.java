package utilities;

public class Operation
{

  private Operand leftOp;
  private Operand rightOp;
  
  public Operation(Operand leftOp, Operand rightOp)
  {
    
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }
  
  public double Calculate(double leftValue, double rightValue, String operator)
  {
    
    double result = 0.0;
    
    // Rough draft
    switch (operator)
    {
      
      case "+":
        result = leftValue + rightValue;
        break;
        
      case "-":
        result = leftValue - rightValue;
        break;
        
      case "/":
        result = leftValue / rightValue;
        break;
        
      case "*":
        result = leftValue * rightValue;
        break;
    }
    
    return result;
  }
  
  public String toString()
  {
    
    return "";
  }
}
