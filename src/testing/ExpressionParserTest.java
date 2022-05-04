package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import exceptions.IncompleteExpressionException;
import exceptions.IncompleteUnitsException;
import exceptions.NoValueEnteredException;
import gui.ExpressionParser;
import utilities.Operand;
import utilities.OperationFormatException;

class ExpressionParserTest
{
  private final String MULTIPLICATION = "x";
  private final String DIVISION = "/";
  private final String SUBTRACTION = "-";
  private final String ADDITION = "+";

  private String[] expression = new String[4];

  @Test
  void testGoodArray() throws OperationFormatException, IncompleteUnitsException,
      NoValueEnteredException, IncompleteExpressionException
  {
    expression[0] = "5ft";
    expression[1] = ADDITION;
    expression[2] = "9miles";
    expression[3] = null;

    ExpressionParser ep = new ExpressionParser(expression);
    BigDecimal val = new BigDecimal("5.0");
    Operand left = new Operand(val, "ft", 1, null);
    Operand right = new Operand(new BigDecimal("9.0"), "miles", 1, null);
    assertEquals(left.getUnit(), ep.getLeft().getUnit());
    assertEquals(left.getValue(), ep.getLeft().getValue());
    assertEquals(right.getValue(), ep.getRight().getValue());
    assertEquals(right.getUnit(), ep.getRight().getUnit());

    expression[0] = "0 miles";
    expression[1] = DIVISION;
    expression[2] = "100 miles";
    expression[3] = null;

    ExpressionParser ep1 = new ExpressionParser(expression);
    BigDecimal val1 = new BigDecimal("0.0");
    Operand left1 = new Operand(val1, "miles", 1, null);
    Operand right1 = new Operand(new BigDecimal("100.0"), "miles", 1, null);
    assertEquals(left1.getUnit(), ep1.getLeft().getUnit());
    assertEquals(left1.getValue(), ep1.getLeft().getValue());
    assertEquals(right1.getValue(), ep1.getRight().getValue());
    assertEquals(right1.getUnit(), ep1.getRight().getUnit());
    assertEquals(DIVISION, ep1.getOperator());
  }

  @Test
  void testParseExponent() throws OperationFormatException, IncompleteUnitsException,
      NoValueEnteredException, IncompleteExpressionException
  {
    String[] exp = new String[4];

    exp[0] = "92\u00b3";
    exp[1] = ADDITION;
    exp[2] = "7mi";
    exp[3] = "ft";
    ExpressionParser ep = new ExpressionParser(exp);
    BigDecimal bd = new BigDecimal("92.0");
    Operand left = new Operand(bd, null, 3, "ft");
    assertEquals(left.getExp(), 3);
    BigDecimal d = new BigDecimal("778688.0");
    assertEquals(ep.getLeft().getValue(), d);
    assertEquals(ep.getLeft().getUnit(), "");

    assertEquals(ep.getRight().getUnit(), "mi");
    BigDecimal b = new BigDecimal("7.0");
    assertEquals(ep.getRight().getValue(), b);

    assertEquals(ep.getRight().getExp(), 1);
    assertEquals(ep.getRight().getResultUnit(), "ft");
    assertEquals(ep.getLeft().getResultUnit(), "ft");

  }

  @Test
  void testIncompleteExpression() throws OperationFormatException, IncompleteUnitsException,
      NoValueEnteredException, IncompleteExpressionException
  {
    expression[0] = "";
    expression[1] = ""; 
    expression[2] = ""; 

    try
    {
      ExpressionParser ep = new ExpressionParser(expression);
    }
    catch (IncompleteExpressionException iee)
    {

    }
    
    expression[0] = null;
    expression[1] = null; 
    expression[2] = null; 
    try
    {
      ExpressionParser ep = new ExpressionParser(expression);
    }
    catch (IncompleteExpressionException iee)
    {

    }
    
    
    
  }

}
