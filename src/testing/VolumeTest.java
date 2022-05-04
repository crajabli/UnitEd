package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import calculations.Addition;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.OperationFormatException;

class VolumeTest
{

  @Test
  void testToPint() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both pt
    left = new Operand(new BigDecimal(1.0), "pt", 1, "pt");
    right = new Operand(new BigDecimal(1.0), "pt", 1, "pt");
    assertEquals("2.000000 pt", Addition.calculate(left, right));

    // qt to pt
    left = new Operand(new BigDecimal(1.0), "pt", 1, "pt");
    right = new Operand(new BigDecimal(0.5), "qt", 1, "pt");
    assertEquals("2.000000 pt", Addition.calculate(left, right));

    // gal to pt
    left = new Operand(new BigDecimal(1.0), "pt", 1, "pt");
    right = new Operand(new BigDecimal(1.0), "gal", 1, "pt");
    assertEquals("9.000000 pt", Addition.calculate(left, right));

    // cc to pt
    left = new Operand(new BigDecimal(1.0), "pt", 1, "pt");
    right = new Operand(new BigDecimal(473.0), "cc", 1, "pt");
    assertEquals("2.000000 pt", Addition.calculate(left, right));

    // l to pt
    left = new Operand(new BigDecimal(1.0), "pt", 1, "pt");
    right = new Operand(new BigDecimal(1.0), "l", 1, "pt");
    assertEquals("3.113380 pt", Addition.calculate(left, right));
  }

  @Test
  void testToQuart() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both qt
    left = new Operand(new BigDecimal(1.0), "qt", 1, "qt");
    right = new Operand(new BigDecimal(1.0), "qt", 1, "qt");
    assertEquals("2.000000 qt", Addition.calculate(left, right));

    // pt to qt
    left = new Operand(new BigDecimal(1.0), "qt", 1, "qt");
    right = new Operand(new BigDecimal(2.0), "pt", 1, "qt");
    assertEquals("2.000000 qt", Addition.calculate(left, right));

    // gal to qt
    left = new Operand(new BigDecimal(1.0), "qt", 1, "qt");
    right = new Operand(new BigDecimal(1.0), "gal", 1, "qt");
    assertEquals("5.000000 qt", Addition.calculate(left, right));

    // cc to qt
    left = new Operand(new BigDecimal(1.0), "qt", 1, "qt");
    right = new Operand(new BigDecimal(946.0), "cc", 1, "qt");
    assertEquals("2.000000 qt", Addition.calculate(left, right));

    // l to qt
    left = new Operand(new BigDecimal(1.0), "qt", 1, "qt");
    right = new Operand(new BigDecimal(1.0), "l", 1, "qt");
    assertEquals("2.056690 qt", Addition.calculate(left, right));
  }

  @Test
  void testToGallon() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both gal
    left = new Operand(new BigDecimal(1.0), "gal", 1, "gal");
    right = new Operand(new BigDecimal(1.0), "gal", 1, "gal");
    assertEquals("2.000000 gal", Addition.calculate(left, right));

    // qt to gal
    left = new Operand(new BigDecimal(1.0), "gal", 1, "gal");
    right = new Operand(new BigDecimal(4.0), "qt", 1, "gal");
    assertEquals("2.000000 gal", Addition.calculate(left, right));

    // pt to gal
    left = new Operand(new BigDecimal(1.0), "gal", 1, "gal");
    right = new Operand(new BigDecimal(8.0), "pt", 1, "gal");
    assertEquals("2.000000 gal", Addition.calculate(left, right));

    // cc to gal
    left = new Operand(new BigDecimal(1.0), "gal", 1, "gal");
    right = new Operand(new BigDecimal(3785.0), "cc", 1, "gal");
    assertEquals("2.000000 gal", Addition.calculate(left, right));

    // l to gal
    left = new Operand(new BigDecimal(1.0), "gal", 1, "gal");
    right = new Operand(new BigDecimal(1.0), "l", 1, "gal");
    assertEquals("1.264201 gal", Addition.calculate(left, right));
  }

  @Test
  void testToCubicCentimeter()
      throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both cc
    left = new Operand(new BigDecimal(1.0), "cc", 1, "cc");
    right = new Operand(new BigDecimal(1.0), "cc", 1, "cc");
    assertEquals("2.000000 cc", Addition.calculate(left, right));

    // qt to cc
    left = new Operand(new BigDecimal(1.0), "cc", 1, "cc");
    right = new Operand(new BigDecimal(1.0), "qt", 1, "cc");
    assertEquals("947.000000 cc", Addition.calculate(left, right));

    // gal to cc
    left = new Operand(new BigDecimal(1.0), "cc", 1, "cc");
    right = new Operand(new BigDecimal(1.0), "gal", 1, "cc");
    assertEquals("3786.000000 cc", Addition.calculate(left, right));

    // pt to cc
    left = new Operand(new BigDecimal(1.0), "cc", 1, "cc");
    right = new Operand(new BigDecimal(1.0), "pt", 1, "cc");
    assertEquals("474.000000 cc", Addition.calculate(left, right));

    // l to cc
    left = new Operand(new BigDecimal(1.0), "cc", 1, "cc");
    right = new Operand(new BigDecimal(1.0), "l", 1, "cc");
    assertEquals("1001.000000 cc", Addition.calculate(left, right));
  }

  @Test
  void testToLiter() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both l
    left = new Operand(new BigDecimal(1.0), "l", 1, "l");
    right = new Operand(new BigDecimal(1.0), "l", 1, "l");
    assertEquals("2.000000 l", Addition.calculate(left, right));

    // qt to l
    left = new Operand(new BigDecimal(1.0), "l", 1, "l");
    right = new Operand(new BigDecimal(1.0), "qt", 1, "l");
    assertEquals("1.946074 l", Addition.calculate(left, right));

    // gal to l
    left = new Operand(new BigDecimal(1.0), "l", 1, "l");
    right = new Operand(new BigDecimal(1.0), "gal", 1, "l");
    assertEquals("4.785000 l", Addition.calculate(left, right));

    // cc to l
    left = new Operand(new BigDecimal(1.0), "l", 1, "l");
    right = new Operand(new BigDecimal(1000.0), "cc", 1, "l");
    assertEquals("2.000000 l", Addition.calculate(left, right));

    // pt to l
    left = new Operand(new BigDecimal(1.0), "l", 1, "l");
    right = new Operand(new BigDecimal(1.0), "pt", 1, "l");
    assertEquals("1.473261 l", Addition.calculate(left, right));
  }
}
