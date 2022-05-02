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
    
    Operand leftOp = new Operand(a, unit, 1, unit);
    Operand rightOp = new Operand(b, unit, 1, unit);
    
    assertEquals("2.000000", Operation.calculate(leftOp, rightOp, divide));
    
    Operand leftOp1 = new Operand(a, "lb-m", 1, "lb-m");
    Operand rightOp1 = new Operand(b, "ft-km", 1, "ft-km");
    
    assertEquals("2.000000 lb-m/ft-km", Operation.calculate(leftOp1, rightOp1, divide));
    
    String units = "lb-lb";
    
    Operand leftOp2 = new Operand(a, units, 1, units);
    Operand rightOp2 = new Operand(b, "m", 1, "m");
    
    assertEquals("2.000000 lb", Operation.calculate(leftOp2, rightOp, divide));
    assertEquals("2.000000 lb-lb/m", Operation.calculate(leftOp2, rightOp2, divide));
  }
}
