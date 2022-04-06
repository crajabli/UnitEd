package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import gui.ExpressionParser;
import utilities.Operand;

class ExpressionParserTest
{
  private final String MULTIPLICATION = "x";
  private final String DIVISION = "/";
  private final String SUBTRACTION = "-";
  private final String ADDITION = "+";

  private String[] expression = new String[3];

  @Test
  void testGoodArray()
  {
    expression[0] = "5ft";
    expression[1] = ADDITION;
    expression[2] = "9miles";

    ExpressionParser ep = new ExpressionParser(expression);
    BigDecimal val = new BigDecimal("5.0");
    Operand left = new Operand(val, "ft");
    Operand right = new Operand(new BigDecimal("9.0"), "miles");
    assertEquals(left.getUnit(), ep.getLeft().getUnit());
    assertEquals(left.getValue(), ep.getLeft().getValue());
    assertEquals(right.getValue(), ep.getRight().getValue());
    assertEquals(right.getUnit(), ep.getRight().getUnit());

    expression[0] = "0 miles";
    expression[1] = DIVISION;
    expression[2] = "100 miles";

    ExpressionParser ep1 = new ExpressionParser(expression);
    BigDecimal val1 = new BigDecimal("0.0");
    Operand left1 = new Operand(val1, "miles");
    Operand right1 = new Operand(new BigDecimal("100.0"), "miles");
    assertEquals(left1.getUnit(), ep1.getLeft().getUnit());
    assertEquals(left1.getValue(), ep1.getLeft().getValue());
    assertEquals(right1.getValue(), ep1.getRight().getValue());
    assertEquals(right1.getUnit(), ep1.getRight().getUnit());
    assertEquals(DIVISION, ep1.getOperator());
  }

  @Test
  void testNoUnits()
  {
    expression[0] = "5";
    expression[1] = MULTIPLICATION;
    expression[2] = "9 miles";

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("You didn't enter any units");
    }

    expression[0] = "";
    expression[1] = MULTIPLICATION;
    expression[2] = "";

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("You didn't enter an unit");
    }

  }

  @Test
  void testNoValue()
  {
    expression[0] = "feet";
    expression[1] = "-";
    expression[2] = "10 miles";

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("You didn't enter an value");
    }

    expression[0] = null;
    expression[1] = "-";
    expression[2] = "miles";

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("You didn't enter an value");
    }

  }

  @Test
  void testNothingEntered()
  {
    expression = new String[3];

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("You didn't anything");
    }

    expression[0] = "";
    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("You didn't anything for one string");
    }

    expression = new String[0];

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("Wrong array length");
    }

  }

  @Test
  void testArrayNull()
  {
    expression = null;

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("Array was null");
    }

    expression = new String[3];
    expression[0] = null;

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("String in array was null");
    }
  }

  @Test
  void testNegative()
  {
    expression[0] = "-10ft";
    expression[1] = SUBTRACTION;
    expression[2] = "10 miles";

    try
    {
      new ExpressionParser(expression);
    }
    catch (NumberFormatException nfe)
    {
      System.out.println("You didn't enter an positive value");
    }
  }

  @Test
  void testTooManyDash()
  {
    expression[0] = "5ft-ft-ft";
    expression[1] = ADDITION;
    expression[2] = "9miles";

    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("Too many dashes");
    }

  }

  @Test
  void testTooManySlash()
  {
    expression[0] = "5ft/ft/ft";
    expression[1] = ADDITION;
    expression[2] = "9miles";
    try
    {
      new ExpressionParser(expression);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println("Too many slashes");
    }

  }

}
