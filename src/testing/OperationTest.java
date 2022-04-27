package testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
   */
  @Test
  public void add() throws OperationFormatException
  {
    
    BigDecimal a = BigDecimal.valueOf(12);
    BigDecimal b = BigDecimal.valueOf(2);
    String add = "+";
    Operand leftOp = new Operand(a, unit, 1, null);
    Operand rightOp = new Operand(b, unit, 1, null);
    
    assertEquals("14 lb", Operation.calculate(leftOp, rightOp, add));
    
    // Throws the exception
    Operand leftOp1 = new Operand(a, unit, 1, null);
    Operand rightOp1 = new Operand(b, "ft", 1, null);
    
    assertThrows(OperationFormatException.class, () ->
    {
      
      Operation.calculate(leftOp1, rightOp1, add);
    });
  }

  /**
   * Testing subtract method.
   * 
   * @throws OperationFormatException 
   */
  @Test
  public void subtract() throws OperationFormatException
  {
    
    BigDecimal a = BigDecimal.valueOf(9);
    BigDecimal b = BigDecimal.valueOf(4);
    String subtract = "-";
    Operand leftOp = new Operand(a, unit, 1, null);
    Operand rightOp = new Operand(b, unit, 1, null);
    
    assertEquals("5 lb", Operation.calculate(leftOp, rightOp, subtract));
    
    // Throws the exception
    Operand leftOp1 = new Operand(a, unit, 1, null);
    Operand rightOp1 = new Operand(b, "km", 1, null);
    
    assertThrows(OperationFormatException.class, () ->
    {
      
      Operation.calculate(leftOp1, rightOp1, subtract);
    });
  }

  /**
   * Testing multiply method.
   * 
   * @throws OperationFormatException
   */
  @Test
  public void multiply() throws OperationFormatException
  {

    BigDecimal a = BigDecimal.valueOf(6);
    BigDecimal b = BigDecimal.valueOf(5);
    Operand leftOp = new Operand(a, unit, 1, null);
    Operand rightOp = new Operand(b, unit, 1, null);

    assertEquals("30 lb-lb", Operation.calculate(leftOp, rightOp, "x"));
  }

  /**
   * Testing divide method.
   * 
   * @throws OperationFormatException
   */
  @Test
  public void divide() throws OperationFormatException
  {

    BigDecimal a = BigDecimal.valueOf(8);
    BigDecimal b = BigDecimal.valueOf(4);
    String divide = "/";
    
    Operand leftOp = new Operand(a, unit, 1, null);
    Operand rightOp = new Operand(b, unit, 1, null);
    
    assertEquals("2", Operation.calculate(leftOp, rightOp, divide));
    
    Operand leftOp1 = new Operand(a, "lb-m", 1, null);
    Operand rightOp1 = new Operand(b, "ft-km", 1, null);
    
    assertEquals("2 lb-m/ft-km", Operation.calculate(leftOp1, rightOp1, divide));
    
    String units = "lb-lb";
    
    Operand leftOp2 = new Operand(a, units, 1, null);
    Operand rightOp2 = new Operand(b, "m", 1, null);
    
    assertEquals("2 lb", Operation.calculate(leftOp2, rightOp, divide));
    assertEquals("2 lb-lb/m", Operation.calculate(leftOp2, rightOp2, divide));
    
    /**
     * Handle cases.
     * mi/h / h = mi/hr-hr
     * mi/h / mi = mi/hr-mi
     */
  }
}
