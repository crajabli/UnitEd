package convertUtils;

import java.util.HashMap;
import java.util.List;

import calculations.*;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;

public class Convert
{
  private static final HashMap<List<String>, String> HashUnits = new HashMap<List<String>, String>()
  {
    private static final long serialVersionUID = 1L;
    {
      put(Units.LENGTHS, "Length");
      put(Units.WEIGHTS, "Weight");
      put(Units.VOLUMES, "Volume");
      put(Units.MONEY, "Money");
      put(Units.TIMES, "Time");
      put(Units.SPEEDS, "Speed");
    }
  };

  /**
   * Returns converted left and right Operand values
   * 
   * @param left
   *          represents left Operand
   * @param right
   *          represents right Operand
   * @return Operand array
   */
  public static Operand[] convert(Operand left, Operand right)
  {
    Operand[] result = {left, right};
    List<String> compare = Units.instanceOf(left, right);

    if (compare != null && compare.size() > 0)
    {
      result[0] = convertOp(left, compare);
      result[1] = convertOp(right, compare);
    }

    return result;
  }
  
  /**
   * Returns a String representation of the converted Operand
   * 
   * @param op represents given Operand
   * @return String
   */
  public static String converted(Operand op)
  {
    Operand result = op;
    List<String> compare = Units.instanceOf(op);

    if (compare != null && compare.size() > 0)
    {
      result = convertOp(op, compare);
    }

    return result.getValue() + " " + result.getUnit();
  }
  
  /**
   * Returns a String representation of the converted Operand
   * 
   * @param op represents given Operand
   * @return String
   */
  public static String convertToString(Operand op)
  {
    Operand result = op;
    List<String> compare = Units.instanceOf(op);

    if (compare != null && compare.size() > 0)
    {
      result = convertOp(op, compare);
    }

    return op.getValue() + " " + op.getUnit() + " = " + result.getValue() + " " + result.getUnit();
  }
  
  /**
   * Returns a String representation of the converted Operands
   * 
   * @param left
   *          represents left Operand
   * @param right
   *          represents right Operand
   * @return String
   */
  public static String convertToString(Operand left, Operand right)
  {
    return convertToString(left) + "\n" + convertToString(right);
  }
  
  /**
   * Returns a String representation of the converted Operands plus their solution
   * 
   * @param left
   *          represents left Operand
   * @param right
   *          represents right Operand
   *          
   * @param operator represents operator
   * @return String
 * @throws NotLikeUnitsException 
 * @throws DivideByZeroException 
   */
  public static String convertToString(Operand left, Operand right, String operator) throws NotLikeUnitsException, DivideByZeroException
  {
	  String result = "";
	  
	  switch (operator)
	  {
	  case "+":
		  result = Addition.calculate(left, right);
		  break;
		  
	  case "-":
		  result = Subtraction.calculate(left, right);
		  break;
		  
	  case "/":
		  result = Division.calculate(left, right, operator);
		  break;
		  
	  case "x":
		  result = Multiplication.calculate(left, right, operator);
		  break;
	  }
	  
    return convertToString(left, right) + "\n" + converted(left) + " " + operator + " " + converted(right) + " = " + result;
  }


  /**
   * Helper method to determine the type of conversion to do.
   * 
   * @param op
   * @param compare
   * @return Operand
   */
  private static Operand convertOp(Operand op, List<String> compare)
  {
    Operand result = op;
    String type = HashUnits.get(compare);
    
    switch (type)
    {
      case "Length":
        result = Length.convertLength(op);
        break;
        
      case "Weight":
    	result = Weight.convertWeight(op);
        break;
        
      case "Volume":
    	result = Volume.convertVolume(op);
        break;
        
      case "Money":
      	result = Money.convertMoney(op);
    	break;
        
      case "Time":
      	result = Time.convertTime(op);
    	break;
    	
      case "Speed":
        result = Speed.convertSpeed(op);
      	break;
    }
    
    return result;
  }

}
