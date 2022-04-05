package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

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
    Operand leftOp = new Operand(a, "lb");
    Operand rightOp = new Operand(b, "lb");
    
    assertEquals("14 lb", Operation.calculate(leftOp, rightOp, "+"));
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
    Operand leftOp = new Operand(a, "lb");
    Operand rightOp = new Operand(b, "lb");
    
    assertEquals("5 lb", Operation.calculate(leftOp, rightOp, "-"));
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
    Operand leftOp = new Operand(a, "lb");
    Operand rightOp = new Operand(b, "lb");
    
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
    Operand leftOp = new Operand(a, "lb");
    Operand rightOp = new Operand(b, "lb");
    
    assertEquals("2 lb", Operation.calculate(leftOp, rightOp, "/"));
  }
}
