package calculations;

import java.math.BigDecimal;

import utilities.*;

public class Main
{

  public static void main(String[] args) throws OperationFormatException
  {

    Operand left = new Operand(BigDecimal.valueOf(5), "mi^3/h");
    Operand right = new Operand(BigDecimal.valueOf(2), "mi/h");
    
    String result = Operation.calculate(left, right, "/");
    
    System.out.println(result);
  }
}
