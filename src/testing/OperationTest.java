package testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exceptions.DivideByZeroException;

import java.math.BigDecimal;

import utilities.Operand;
import utilities.Operation;
import utilities.OperationFormatException;

/**
 * Testing class for Operation.
 * 
 * @author Team 22
 * @version 04-06-2022
 *
 */
public class OperationTest
{

  private final String unit = "lb";

  /**
   * Testing add method.
   * 
   * @throws OperationFormatException 
   * @throws DivideByZeroException 
   */
  @Test
  public void add() throws OperationFormatException, DivideByZeroException
  {
    
    BigDecimal a = BigDecimal.valueOf(12);
    BigDecimal b = BigDecimal.valueOf(2);
    String add = "+";
    Operand leftOp = new Operand(a, unit, 1, unit);
    Operand rightOp = new Operand(b, unit, 1, unit);
    
    assertEquals("14.000000 lb", Operation.calculate(leftOp, rightOp, add));
    
    // Throws the exception
    Operand leftOp1 = new Operand(a, unit, 1, unit);
    Operand rightOp1 = new Operand(b, "ft", 1, "ft");
    
    assertThrows(OperationFormatException.class, () ->
    {
      
      Operation.calculate(leftOp1, rightOp1, add);
    });
  }

  /**
   * Testing subtract method.
   * 
   * @throws OperationFormatException 
   * @throws DivideByZeroException 
   */
  @Test
  public void subtract() throws OperationFormatException, DivideByZeroException
  {
    
    BigDecimal a = BigDecimal.valueOf(9);
    BigDecimal b = BigDecimal.valueOf(4);
    String subtract = "-";
    Operand leftOp = new Operand(a, unit, 1, unit);
    Operand rightOp = new Operand(b, unit, 1, unit);
    
    assertEquals("5.000000 lb", Operation.calculate(leftOp, rightOp, subtract));
    
    // Throws the exception
    Operand leftOp1 = new Operand(a, unit, 1, unit);
    Operand rightOp1 = new Operand(b, "km", 1, "km");
    
    assertThrows(OperationFormatException.class, () ->
    {
      
      Operation.calculate(leftOp1, rightOp1, subtract);
    });
  }

  /**
   * Testing multiply method.
   * 
   * @throws OperationFormatException 
   * @throws DivideByZeroException 
   */
  @Test
  public void multiply() throws OperationFormatException, DivideByZeroException
  {

    BigDecimal a = BigDecimal.valueOf(6);
    BigDecimal b = BigDecimal.valueOf(5);
    Operand leftOp = new Operand(a, unit, 1, unit);
    Operand rightOp = new Operand(b, unit, 1, unit);

    assertEquals("30.000000 lb\u00B2", Operation.calculate(leftOp, rightOp, "x"));
    
    String u = "mi/h";
    leftOp = new Operand(a, u, 1, u);
    rightOp = new Operand(b, u, 1, u);
    
    assertEquals("30.000000 mi\u00B2/h\u00B2", Operation.calculate(leftOp, rightOp, "x"));
    
    // Square the operands
    
    leftOp = new Operand(a, unit, 2, unit);
    rightOp = new Operand(b, unit, 2, unit);
    
    assertEquals("900.000000 lb\u2074", Operation.calculate(leftOp, rightOp, "x"));
    
    // No unit
    
    leftOp = new Operand(a, "", 2, "");
    rightOp = new Operand(b, "", 1, "");
    
    assertEquals("180.000000", Operation.calculate(leftOp, rightOp, "x"));
    
    // Only left unit
    
    leftOp = new Operand(a, unit, 2, unit);
    rightOp = new Operand(b, "", 1, "");
    
    assertEquals("180.000000 lb\u00B2", Operation.calculate(leftOp, rightOp, "x"));
    
    // Only right unit
    
    leftOp = new Operand(a, "", 1, "");
    rightOp = new Operand(b, unit, 2, unit);
    
    assertEquals("150.000000 lb\u00B2", Operation.calculate(leftOp, rightOp, "x"));
    
    // Raising to exponent 3
    
    leftOp = new Operand(a, "km/h", 2, "km/h");
    rightOp = new Operand(b, "km", 1, "km");
    
    assertEquals("180.000000 km\u00B3/h\u00B2", Operation.calculate(leftOp, rightOp, "x"));
    
    // High exponent
    
    a = BigDecimal.valueOf(1);
    b = BigDecimal.valueOf(1);
    
    leftOp = new Operand(a, "km/h", 6, "km/h");
    rightOp = new Operand(b, "km", 7, "km");
    
    assertEquals("1.000000 km\u00B9\u00B3/h\u2076", Operation.calculate(leftOp, rightOp, "x"));
  }

  /**
   * Testing divide method.
   * 
   * @throws DivideByZeroException 
   * @throws OperationFormatException 
   */
  @Test
  public void divide() throws DivideByZeroException, OperationFormatException
  {

    BigDecimal a = BigDecimal.valueOf(8);
    BigDecimal b = BigDecimal.valueOf(4);
    String divide = "/";
    
    // Cancel units
    
    Operand leftOp = new Operand(a, unit, 1, unit);
    Operand rightOp = new Operand(b, unit, 1, unit);
    
    assertEquals("2.000000", Operation.calculate(leftOp, rightOp, divide));
    
    // Normal division
    
    Operand leftOp1 = new Operand(a, "lb-m", 1, "lb-m");
    Operand rightOp1 = new Operand(b, "ft-km", 1, "ft-km");
    
    assertEquals("2.000000 lb-m/ft/km", Operation.calculate(leftOp1, rightOp1, divide));
    
    Operand leftOp2 = new Operand(a, unit, 2, unit);
    Operand rightOp2 = new Operand(b, "m", 1, "m");
    
    // Cancel the square
    
    assertEquals("16.000000 lb", Operation.calculate(leftOp2, rightOp, divide));
    
    leftOp = new Operand(a, "lb-ft", 1, "lb-ft");
    rightOp = new Operand(b, "km/ft", 1, "km/ft");
    
    assertEquals("2.000000 lb/km", Operation.calculate(leftOp, rightOp, divide));
    
    // No unit
    
    leftOp = new Operand(a, "", 1, "");
    rightOp = new Operand(b, "", 1, "");
    
    assertEquals("2.000000", Operation.calculate(leftOp, rightOp, divide));
    
    // Only left unit
    
    leftOp = new Operand(a, unit, 1, unit);
    rightOp = new Operand(b, "", 1, "");
    
    assertEquals("2.000000 lb", Operation.calculate(leftOp, rightOp, divide));
    
    // Only right unit
    
    leftOp = new Operand(a, "", 1, "");
    rightOp = new Operand(b, unit, 1, unit);
    
    assertEquals("2.000000 1/lb", Operation.calculate(leftOp, rightOp, divide));
    
    // Cancel numerator
    
    leftOp = new Operand(a, "lb/ft", 1, "lb/ft");
    rightOp = new Operand(b, unit, 1, unit);
    
    assertEquals("2.000000 1/ft", Operation.calculate(leftOp, rightOp, divide));
    
    // High exponent
    a = BigDecimal.valueOf(1);
    b = BigDecimal.valueOf(1);
    
    leftOp = new Operand(a, unit, 12, unit);
    rightOp = new Operand(b, unit, 9, unit);
    
    assertEquals("1.000000 lb\u00B3", Operation.calculate(leftOp, rightOp, divide));
  }
}
