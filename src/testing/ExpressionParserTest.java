package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import gui.ExpressionParser;
import utilities.Operand;

class ExpressionParserTest
{
  private final String MULTIPLICATION = "x";
  private final String DIVISION = "x";
  private final String SUBTRACTION = "x";
  private final String ADDITION = "x";

  private String[] expression = new String[3];

  @Test
  void testGoodArray()
  {
    expression[0] = "5ft";
    expression[1] = ADDITION;
    expression[2] = "9miles";

    ExpressionParser ep = new ExpressionParser(expression);
    BigDecimal val = new BigDecimal(5);
    Operand left = new Operand(val, "ft");
    assertEquals(left.getUnit(), ep.getLeft().getUnit());
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

}
