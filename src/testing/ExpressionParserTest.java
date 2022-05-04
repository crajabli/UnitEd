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
    expression[0] = "-5ft";
    expression[1] = ADDITION;
    expression[2] = "9miles";
    expression[3] = null;

    ExpressionParser ep = new ExpressionParser(expression);
    BigDecimal val = new BigDecimal("-5.0");
    Operand left = new Operand(val, "ft", 1, null);
    Operand right = new Operand(new BigDecimal("9.0"), "miles", 1, null);
    assertEquals(left.getUnit(), ep.getLeft().getUnit());
    assertEquals(left.getValue(), ep.getLeft().getValue());
    assertEquals(right.getValue(), ep.getRight().getValue());
    assertEquals(right.getUnit(), ep.getRight().getUnit());

    expression[0] = "0mm";
    expression[1] = DIVISION;
    expression[2] = "-100 miles";
    expression[3] = null;

    ExpressionParser ep1 = new ExpressionParser(expression);
    BigDecimal val1 = new BigDecimal("0.0");
    Operand left1 = new Operand(val1, "mm", 1, null);
    Operand right1 = new Operand(new BigDecimal("-100.0"), "miles", 1, null);
    assertEquals(left1.getUnit(), ep1.getLeft().getUnit());
    assertEquals(left1.getValue(), ep1.getLeft().getValue());
    assertEquals(right1.getValue(), ep1.getRight().getValue());
    assertEquals(right1.getUnit(), ep1.getRight().getUnit());
    assertEquals(DIVISION, ep1.getOperator());

    expression = new String[4];
    expression[0] = "-10pow";
    expression[1] = MULTIPLICATION;
    expression[2] = "-2 mm";
    expression[3] = "stars";

    ExpressionParser ep2 = new ExpressionParser(expression);
    Operand l = new Operand(new BigDecimal("-10"), "pow", 1, "stars");
    Operand r = new Operand(new BigDecimal("-2"), "mm", 1, "stars");

    System.out.println(l.getUnit());

    assertEquals(l.getUnit(), ep2.getLeft().getUnit());

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

  @Test
  void testSeperateMethods() throws OperationFormatException, IncompleteUnitsException,
      NoValueEnteredException, IncompleteExpressionException
  {
    expression[0] = "10ft";
    expression[1] = MULTIPLICATION;
    expression[2] = "2in";
    expression[3] = "ft-in";
    ExpressionParser ep = new ExpressionParser(expression);
    
    String[] str = Operand.separateDashUnits("ft-in"); 
    String[] s = new String[2]; 
    s[0] = "ft"; 
    s[1] = "in"; 
    assertEquals(s[0].toString(), str[0].toString());
    

    expression[0] = "10ft";
    expression[1] = DIVISION;
    expression[2] = "2in";
    expression[3] = "ft/in";
    ExpressionParser e = new ExpressionParser(expression);
    
    String[] st = Operand.separateSlashUnits("ft/in"); 
    String[] sR = new String[2]; 
    sR[0] = "ft"; 
    sR[1] = "in"; 
    assertEquals(sR[0].toString(), st[0].toString());
    
    
    String[] b = Operand.separateSlashUnits(""); 
    sR[0] = null;
    sR[1] = null; 
    assertEquals(b[0], sR[0]); 
    String[] a = Operand.separateSlashUnits(null); 
    assertEquals(a[0], sR[0]); 
    
    a = Operand.separateDashUnits("ft");
    assertEquals("ft", a[0]);
    assertEquals("ft", a[1]);
    
    a = Operand.separateSlashUnits("ft");
    assertEquals("ft", a[0]);
    assertEquals("ft", a[1]);

    BigDecimal n1 = BigDecimal.valueOf(2);
    
    Operand op = new Operand(n1, "mm", 2, "mm");
    assertEquals("mm\u00B2", op.getUnit());
    
    op = new Operand(n1, "mm", 45, "mm");
    assertEquals("mm\u2074\u2075", op.getUnit());
    
    op = new Operand(n1, "cm", 678, "cm");
    assertEquals("cm\u2076\u2077\u2078", op.getUnit());
    
    op = new Operand(n1, "cm", 309, "cm");
    assertEquals("cm\u00B3\u2070\u2079", op.getUnit());
  }

}
