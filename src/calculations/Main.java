package calculations;

import java.math.BigDecimal;

import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.Operation;
import utilities.OperationFormatException;

public class Main
{

  public static void main(String[] args) throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {

    BigDecimal a = BigDecimal.valueOf(2);
    
    Operand left = new Operand(a, "mm", 1, "mm");
    Operand right = new Operand(a, "cm", 1, "mm");
    
    System.out.println("Left operand value: " + left.getValue().toString());
    System.out.println("Left operand unit: " + left.getUnit());
    
    //System.out.println(Operation.calculate(left, right, "x"));
  }

}
