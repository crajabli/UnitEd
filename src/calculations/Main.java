package calculations;

import java.math.BigDecimal;

import utilities.*;

public class Main
{

  public static void main(String[] args) throws OperationFormatException
  {

    Operand left = new Operand(BigDecimal.valueOf(5), "ft-ft");
    Operand right = new Operand(BigDecimal.valueOf(5), "ft-ft");
    
    String result = Operation.calculate(left, right, "/");
    
    System.out.println(result);
  }
}