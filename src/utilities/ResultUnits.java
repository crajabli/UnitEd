package utilities;

import convertUtils.Units;
import gui.GraphicalUserInterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultUnits {
  private static String leftUnit;
  private static String rightUnit;
  private static Object[] result;

  public static Object[] likeUnits(Operand leftOperand,  Operand rightOperand) {
    leftUnit = leftOperand.getUnit();
    rightUnit = rightOperand.getUnit();
    List<String> units = Units.instanceOf(leftOperand, rightOperand);
    result = units.toArray();
    return result;
  }


  public static Object[] nonLikeUnits(Operand leftOperand, Operand rightOperand, String op) {
//    String operator = GraphicalUserInterface.getOperator();
    Object[] leftUnitInstance = Units.instanceOf(leftOperand).toArray();
    Object[] rightUnitInstance = Units.instanceOf(rightOperand).toArray();
    List<String> result = new ArrayList<>();

    if (op.equals("x")) {
      for (Object unit : leftUnitInstance) {
        for (Object secondUnit :  rightUnitInstance) {
          result.add(unit + "-" + secondUnit);
        }
      }
    } else if (op.equals("/")) {
      for (Object unit : leftUnitInstance) {
        for (Object secondUnit :  rightUnitInstance) {
          result.add(unit + "/" + secondUnit);
        }
      }
    }

    return result.toArray();
  }

  public static void main(String[] args) {
    Operand op1 = new Operand(new BigDecimal(1), "km", 1, "");
    Operand op2 = new Operand(new BigDecimal(1), "hr", 1, "");
    Object[] list = nonLikeUnits(op1, op2, "x");
  }






}
