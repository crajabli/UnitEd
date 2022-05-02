package utilities;

import convertUtils.Units;

import java.util.List;

public class ResultUnits {
  private static String leftUnit;
  private static String rightUnit;
  private static Object[] result;

  public static Object[] likeUnits(Operand leftOperand) {
    leftUnit = leftOperand.getUnit();
    List<String> units = Units.instanceOf(leftOperand);
    result = units.toArray();
    return result;
  }


  public static Object[] multiplicationUnits(Operand leftOperand, Operand rightOperand) {
    Object[] leftUnitInstance = Units.instanceOf(leftOperand).toArray();
    Object[] rightUnitInstance = Units.instanceOf(rightOperand).toArray();
    List<String> result = null;
    for (Object unit : leftUnitInstance) {
      for (Object secondUnit :  rightUnitInstance) {
        result.add(unit + "-" + secondUnit);
      }
    }
    return result.toArray();
  }


  public static Object[] divisionUnits(Operand leftOperand, Operand rightOperand) {
    Object[] leftUnitInstance = Units.instanceOf(leftOperand).toArray();
    Object[] rightUnitInstance = Units.instanceOf(rightOperand).toArray();
    return null;
  }





}
