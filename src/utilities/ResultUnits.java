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
    int leftExponent = leftOperand.getExp();
    String leftExponentString = GraphicalUserInterface.getFirstExponentAsString();
    String rightExponentString = GraphicalUserInterface.getWholeExponent();
    int rightExponent = rightOperand.getExp();
    Object[] leftUnitInstance = Units.instanceOf(new Operand(leftOperand.getValue(),
        GraphicalUserInterface.getFirstUnit(leftOperand.getUnit()), 1, "")).toArray();
    Object[] rightUnitInstance = Units.instanceOf(new Operand(rightOperand.getValue(),
        GraphicalUserInterface.getFirstUnit(rightOperand.getUnit()), 1, "")).toArray();
    List<String> result = new ArrayList<>();

    if (op.equals("x")) {
      if (leftExponent == 1 && rightExponent == 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + "-" + secondUnit);
          }
        }
      } else if (leftExponent > 1 && rightExponent == 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + leftExponentString + "-" + secondUnit);
          }
        }
      } else if (leftExponent == 1 && rightExponent > 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + "-" + secondUnit + rightExponentString);
          }
        }
      } else if (leftExponent > 1 && rightExponent > 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + leftExponentString + "-" + secondUnit + rightExponentString);
          }
        }
      }
    } else if (op.equals("/")) {
      if (leftExponent == 1 && rightExponent == 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + "/" + secondUnit);
          }
        }
      } else if (leftExponent > 1 && rightExponent == 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + leftExponentString + "/" + secondUnit);
          }
        }
      } else if (leftExponent == 1 && rightExponent > 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + "/" + secondUnit + rightExponentString);
          }
        }
      } else if (leftExponent > 1 && rightExponent > 1) {
        for (Object unit : leftUnitInstance) {
          for (Object secondUnit : rightUnitInstance) {
            result.add(unit + leftExponentString + "/" + secondUnit + rightExponentString);
          }
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
