package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import calculations.Addition;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.OperationFormatException;

class WeightTest
{

  @Test
  void testToOunce() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both oz
    left = new Operand(new BigDecimal(1.0), "oz", 1, "oz");
    right = new Operand(new BigDecimal(1.0), "oz", 1, "oz");
    assertEquals("2.000000 oz", Addition.calculate(left, right));

    // lb to oz
    left = new Operand(new BigDecimal(1.0), "oz", 1, "oz");
    right = new Operand(new BigDecimal(1.0), "lb", 1, "oz");
    assertEquals("17.000000 oz", Addition.calculate(left, right));

    // ton to oz
    left = new Operand(new BigDecimal(1.0), "oz", 1, "oz");
    right = new Operand(new BigDecimal(1.0), "ton", 1, "oz");
    assertEquals("32001.000000 oz", Addition.calculate(left, right));

    // g to oz
    left = new Operand(new BigDecimal(1.0), "oz", 1, "oz");
    right = new Operand(new BigDecimal(28.35), "g", 1, "oz");
    assertEquals("2.000000 oz", Addition.calculate(left, right));

    // kg to oz
    left = new Operand(new BigDecimal(1.0), "oz", 1, "oz");
    right = new Operand(new BigDecimal(1.0), "kg", 1, "oz");
    assertEquals("36.274000 oz", Addition.calculate(left, right));
  }

  @Test
  void testToPound() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both lb
    left = new Operand(new BigDecimal(1.0), "lb", 1, "lb");
    right = new Operand(new BigDecimal(1.0), "lb", 1, "lb");
    assertEquals("2.000000 lb", Addition.calculate(left, right));

    // oz to lb
    left = new Operand(new BigDecimal(1.0), "lb", 1, "lb");
    right = new Operand(new BigDecimal(16.0), "oz", 1, "lb");
    assertEquals("2.000000 lb", Addition.calculate(left, right));

    // ton to lb
    left = new Operand(new BigDecimal(1.0), "lb", 1, "lb");
    right = new Operand(new BigDecimal(1.0), "ton", 1, "lb");
    assertEquals("2001.000000 lb", Addition.calculate(left, right));

    // g to lb
    left = new Operand(new BigDecimal(1.0), "lb", 1, "lb");
    right = new Operand(new BigDecimal(454.0), "g", 1, "lb");
    assertEquals("2.000000 lb", Addition.calculate(left, right));

    // kg to lb
    left = new Operand(new BigDecimal(1.0), "lb", 1, "lb");
    right = new Operand(new BigDecimal(1.0), "kg", 1, "lb");
    assertEquals("3.204620 lb", Addition.calculate(left, right));
  }

  @Test
  void testToTon() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both ton
    left = new Operand(new BigDecimal(1.0), "ton", 1, "ton");
    right = new Operand(new BigDecimal(1.0), "ton", 1, "ton");
    assertEquals("2.000000 ton", Addition.calculate(left, right));

    // oz to ton
    left = new Operand(new BigDecimal(1.0), "ton", 1, "ton");
    right = new Operand(new BigDecimal(32000.0), "oz", 1, "ton");
    assertEquals("2.000000 ton", Addition.calculate(left, right));

    // lb to ton
    left = new Operand(new BigDecimal(1.0), "ton", 1, "ton");
    right = new Operand(new BigDecimal(2000.0), "lb", 1, "ton");
    assertEquals("2.000000 ton", Addition.calculate(left, right));

    // g to ton
    left = new Operand(new BigDecimal(1.0), "ton", 1, "ton");
    right = new Operand(new BigDecimal(907185.0), "g", 1, "ton");
    assertEquals("2.000000 ton", Addition.calculate(left, right));

    // kg to ton
    left = new Operand(new BigDecimal(1.0), "ton", 1, "ton");
    right = new Operand(new BigDecimal(907.0), "kg", 1, "ton");
    assertEquals("2.000000 ton", Addition.calculate(left, right));
  }

  @Test
  void testToGram() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both g
    left = new Operand(new BigDecimal(1.0), "g", 1, "g");
    right = new Operand(new BigDecimal(1.0), "g", 1, "g");
    assertEquals("2.000000 g", Addition.calculate(left, right));

    // oz to g
    left = new Operand(new BigDecimal(1.0), "g", 1, "g");
    right = new Operand(new BigDecimal(1.0), "oz", 1, "g");
    assertEquals("29.349500 g", Addition.calculate(left, right));

    // ton to g
    left = new Operand(new BigDecimal(1.0), "g", 1, "g");
    right = new Operand(new BigDecimal(1.0), "ton", 1, "g");
    assertEquals("907186.000000 g", Addition.calculate(left, right));

    // lb to g
    left = new Operand(new BigDecimal(1.0), "g", 1, "g");
    right = new Operand(new BigDecimal(1.0), "lb", 1, "g");
    assertEquals("454.592000 g", Addition.calculate(left, right));

    // kg to g
    left = new Operand(new BigDecimal(1.0), "g", 1, "g");
    right = new Operand(new BigDecimal(1.0), "kg", 1, "g");
    assertEquals("1001.000000 g", Addition.calculate(left, right));
  }

  @Test
  void testToKilogram()
      throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both kg
    left = new Operand(new BigDecimal(1.0), "kg", 1, "kg");
    right = new Operand(new BigDecimal(1.0), "kg", 1, "kg");
    assertEquals("2.000000 kg", Addition.calculate(left, right));

    // oz to kg
    left = new Operand(new BigDecimal(1.0), "kg", 1, "kg");
    right = new Operand(new BigDecimal(35.274), "oz", 1, "kg");
    assertEquals("2.000000 kg", Addition.calculate(left, right));

    // ton to kg
    left = new Operand(new BigDecimal(1.0), "kg", 1, "kg");
    right = new Operand(new BigDecimal(1.0), "ton", 1, "kg");
    assertEquals("908.185000 kg", Addition.calculate(left, right));

    // g to kg
    left = new Operand(new BigDecimal(1.0), "kg", 1, "kg");
    right = new Operand(new BigDecimal(1000.0), "g", 1, "kg");
    assertEquals("2.000000 kg", Addition.calculate(left, right));

    // lb to kg
    left = new Operand(new BigDecimal(1.0), "kg", 1, "kg");
    right = new Operand(new BigDecimal(2.205), "lb", 1, "kg");
    assertEquals("2.000000 kg", Addition.calculate(left, right));
  }
}
