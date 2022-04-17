package calculations;

import java.math.BigDecimal;

import utilities.*;

public class Main
{

  public static void main(String[] args) throws OperationFormatException
  {

    Operand left = new Operand(BigDecimal.valueOf(5), "km-mi/h");
    Operand right = new Operand(BigDecimal.valueOf(2), "mi/m/min");
    
    String result = Operation.calculate(left, right, "x");
    
    System.out.println(result);
  }
}
