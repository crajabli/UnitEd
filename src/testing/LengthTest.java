package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import calculations.*;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.OperationFormatException;

class LengthTest
{

  @Test
  void testToInch() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both in
    left = new Operand(new BigDecimal(10.0), "in", 1, "in");
    right = new Operand(new BigDecimal(10.0), "in", 1, "in");
    assertEquals("20.000000 in", Addition.calculate(left, right));
    assertEquals("0.000000 in", Subtraction.calculate(left, right));
    assertEquals("100.000000 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to in
    left = new Operand(new BigDecimal(10.0), "in", 1, "in");
    right = new Operand(new BigDecimal(10.0), "ft", 1, "in");
    assertEquals("130.000000 in", Addition.calculate(left, right));
    assertEquals("-110.000000 in", Subtraction.calculate(left, right));
    assertEquals("1200.000000 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("0.083333", Division.calculate(left, right, "/"));

    // yd to in
    left = new Operand(new BigDecimal(10.0), "in", 1, "in");
    right = new Operand(new BigDecimal(10.0), "yd", 1, "in");
    assertEquals("370.000000 in", Addition.calculate(left, right));
    assertEquals("-350.000000 in", Subtraction.calculate(left, right));
    assertEquals("3600.000000 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("0.027778", Division.calculate(left, right, "/"));

    // mi to in
    left = new Operand(new BigDecimal(10.0), "in", 1, "in");
    right = new Operand(new BigDecimal(1.0), "mi", 1, "in");
    assertEquals("63370.000000 in", Addition.calculate(left, right));
    assertEquals("-63350.000000 in", Subtraction.calculate(left, right));
    assertEquals("633600.000000 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("0.000158", Division.calculate(left, right, "/"));

    // mm to in
    left = new Operand(new BigDecimal(1.0), "in", 1, "in");
    right = new Operand(new BigDecimal(25.4), "mm", 1, "in");
    assertEquals("2.000000 in", Addition.calculate(left, right));
    assertEquals("0.000000 in", Subtraction.calculate(left, right));
    assertEquals("1.000000 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // cm to in
    left = new Operand(new BigDecimal(1.0), "in", 1, "in");
    right = new Operand(new BigDecimal(25.4), "cm", 1, "in");
    assertEquals("11.000000 in", Addition.calculate(left, right));
    assertEquals("-9.000000 in", Subtraction.calculate(left, right));
    assertEquals("10.000000 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("0.100000", Division.calculate(left, right, "/"));

    // m to in
    left = new Operand(new BigDecimal(1.0), "in", 1, "in");
    right = new Operand(new BigDecimal(25.4), "m", 1, "in");
    assertEquals("1001.000540 in", Addition.calculate(left, right));
    assertEquals("-999.000540 in", Subtraction.calculate(left, right));
    assertEquals("1000.000540 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("0.001000", Division.calculate(left, right, "/"));

    // km to in
    left = new Operand(new BigDecimal(1.0), "in", 1, "in");
    right = new Operand(new BigDecimal(0.001), "km", 1, "in");
    assertEquals("40.370100 in", Addition.calculate(left, right));
    assertEquals("-38.370100 in", Subtraction.calculate(left, right));
    assertEquals("39.370100 in\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("0.025400", Division.calculate(left, right, "/"));
  }

  @Test
  void testToFeet() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both ft
    left = new Operand(new BigDecimal(10.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(10.0), "ft", 1, "ft");
    assertEquals("20.000000 ft", Addition.calculate(left, right));
    assertEquals("0.000000 ft", Subtraction.calculate(left, right));
    assertEquals("100.000000 ft\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // in to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(12.0), "in", 1, "ft");
    assertEquals("2.000000 ft", Addition.calculate(left, right));

    // yd to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(1.0), "yd", 1, "ft");
    assertEquals("4.000000 ft", Addition.calculate(left, right));

    // mi to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(1.0), "mi", 1, "ft");
    assertEquals("5281.000000 ft", Addition.calculate(left, right));

    // mm to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(305.0), "mm", 1, "ft");
    assertEquals("2.000000 ft", Addition.calculate(left, right));

    // cm to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(30.48), "cm", 1, "ft");
    assertEquals("2.000000 ft", Addition.calculate(left, right));

    // m to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(1.0), "m", 1, "ft");
    assertEquals("4.281000 ft", Addition.calculate(left, right));

    // km to ft
    left = new Operand(new BigDecimal(1.0), "ft", 1, "ft");
    right = new Operand(new BigDecimal(1.0), "km", 1, "ft");
    assertEquals("3281.840000 ft", Addition.calculate(left, right));
  }

  @Test
  void testToYard() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both yd
    left = new Operand(new BigDecimal(10.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(10.0), "yd", 1, "yd");
    assertEquals("20.000000 yd", Addition.calculate(left, right));
    assertEquals("0.000000 yd", Subtraction.calculate(left, right));
    assertEquals("100.000000 yd\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(3.0), "ft", 1, "yd");
    assertEquals("2.000000 yd", Addition.calculate(left, right));

    // in to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(36.0), "in", 1, "yd");
    assertEquals("2.000000 yd", Addition.calculate(left, right));

    // mi to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(1.0), "mi", 1, "yd");
    assertEquals("1761.000000 yd", Addition.calculate(left, right));

    // mm to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(914.0), "mm", 1, "yd");
    assertEquals("2.000000 yd", Addition.calculate(left, right));

    // cm to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(91.44), "cm", 1, "yd");
    assertEquals("2.000000 yd", Addition.calculate(left, right));

    // m to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(1.09361), "m", 1, "yd");
    assertEquals("2.195983 yd", Addition.calculate(left, right));

    // km to yd
    left = new Operand(new BigDecimal(1.0), "yd", 1, "yd");
    right = new Operand(new BigDecimal(1.0), "km", 1, "yd");
    assertEquals("1094.610000 yd", Addition.calculate(left, right));
  }

  @Test
  void testToMile() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both mi
    left = new Operand(new BigDecimal(10.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(10.0), "mi", 1, "mi");
    assertEquals("20.000000 mi", Addition.calculate(left, right));
    assertEquals("0.000000 mi", Subtraction.calculate(left, right));
    assertEquals("100.000000 mi\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(5280.0), "ft", 1, "mi");
    assertEquals("2.000000 mi", Addition.calculate(left, right));

    // yd to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(1760.0), "yd", 1, "mi");
    assertEquals("2.000000 mi", Addition.calculate(left, right));

    // in to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(63360.0), "in", 1, "mi");
    assertEquals("2.000000 mi", Addition.calculate(left, right));

    // mm to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(10000000.0), "mm", 1, "mi");
    assertEquals("7.215040 mi", Addition.calculate(left, right));

    // cm to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(160934.0), "cm", 1, "mi");
    assertEquals("2.000000 mi", Addition.calculate(left, right));

    // m to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(1609.0), "m", 1, "mi");
    assertEquals("2.000000 mi", Addition.calculate(left, right));

    // km to mi
    left = new Operand(new BigDecimal(1.0), "mi", 1, "mi");
    right = new Operand(new BigDecimal(1.609), "km", 1, "mi");
    assertEquals("2.000000 mi", Addition.calculate(left, right));
  }

  @Test
  void testToMillimeter()
      throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both mm
    left = new Operand(new BigDecimal(10.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(10.0), "mm", 1, "mm");
    assertEquals("20.000000 mm", Addition.calculate(left, right));
    assertEquals("0.000000 mm", Subtraction.calculate(left, right));
    assertEquals("100.000000 mm\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(1.0), "ft", 1, "mm");
    assertEquals("305.800000 mm", Addition.calculate(left, right));

    // yd to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(1.0), "yd", 1, "mm");
    assertEquals("915.400000 mm", Addition.calculate(left, right));

    // mi to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(0.25), "mi", 1, "mm");
    assertEquals("402251.000000 mm", Addition.calculate(left, right));

    // in to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(1.0), "in", 1, "mm");
    assertEquals("26.400000 mm", Addition.calculate(left, right));

    // cm to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(1.0), "cm", 1, "mm");
    assertEquals("11.000000 mm", Addition.calculate(left, right));

    // m to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(1.0), "m", 1, "mm");
    assertEquals("1001.000000 mm", Addition.calculate(left, right));

    // km to mm
    left = new Operand(new BigDecimal(1.0), "mm", 1, "mm");
    right = new Operand(new BigDecimal(0.5), "km", 1, "mm");
    assertEquals("500001.000000 mm", Addition.calculate(left, right));
  }

  @Test
  void testToCentimeter()
      throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both cm
    left = new Operand(new BigDecimal(10.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(10.0), "cm", 1, "cm");
    assertEquals("20.000000 cm", Addition.calculate(left, right));
    assertEquals("0.000000 cm", Subtraction.calculate(left, right));
    assertEquals("100.000000 cm\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(1.0), "ft", 1, "cm");
    assertEquals("31.480000 cm", Addition.calculate(left, right));

    // yd to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(1.0), "yd", 1, "cm");
    assertEquals("92.440000 cm", Addition.calculate(left, right));

    // mi to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(1.0), "mi", 1, "cm");
    assertEquals("160935.000000 cm", Addition.calculate(left, right));

    // mm to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(10.0), "mm", 1, "cm");
    assertEquals("2.000000 cm", Addition.calculate(left, right));

    // in to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(1.0), "in", 1, "cm");
    assertEquals("3.540000 cm", Addition.calculate(left, right));

    // m to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(1.0), "m", 1, "cm");
    assertEquals("101.000000 cm", Addition.calculate(left, right));

    // km to cm
    left = new Operand(new BigDecimal(1.0), "cm", 1, "cm");
    right = new Operand(new BigDecimal(1.0), "km", 1, "cm");
    assertEquals("100001.000000 cm", Addition.calculate(left, right));
  }

  @Test
  void testToMeter() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both m
    left = new Operand(new BigDecimal(10.0), "m", 1, "m");
    right = new Operand(new BigDecimal(10.0), "m", 1, "m");
    assertEquals("20.000000 m", Addition.calculate(left, right));
    assertEquals("0.000000 m", Subtraction.calculate(left, right));
    assertEquals("100.000000 m\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(3.281), "ft", 1, "m");
    assertEquals("2.000000 m", Addition.calculate(left, right));

    // yd to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(1.094), "yd", 1, "m");
    assertEquals("2.000000 m", Addition.calculate(left, right));

    // mi to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(1.0), "mi", 1, "m");
    assertEquals("1610.340000 m", Addition.calculate(left, right));

    // mm to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(1000.0), "mm", 1, "m");
    assertEquals("2.000000 m", Addition.calculate(left, right));

    // cm to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(100.0), "cm", 1, "m");
    assertEquals("2.000000 m", Addition.calculate(left, right));

    // in to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(39.37), "in", 1, "m");
    assertEquals("2.000000 m", Addition.calculate(left, right));

    // km to m
    left = new Operand(new BigDecimal(1.0), "m", 1, "m");
    right = new Operand(new BigDecimal(1.0), "km", 1, "m");
    assertEquals("1001.000000 m", Addition.calculate(left, right));
  }

  @Test
  void testToKilometer()
      throws OperationFormatException, DivideByZeroException, NotLikeUnitsException
  {
    Operand left;
    Operand right;

    // Both km
    left = new Operand(new BigDecimal(10.0), "km", 1, "km");
    right = new Operand(new BigDecimal(10.0), "km", 1, "km");
    assertEquals("20.000000 km", Addition.calculate(left, right));
    assertEquals("0.000000 km", Subtraction.calculate(left, right));
    assertEquals("100.000000 km\u00B2", Multiplication.calculate(left, right, "x"));
    assertEquals("1.000000", Division.calculate(left, right, "/"));

    // ft to km
    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(3281.0), "ft", 1, "km");
    assertEquals("2.000000 km", Addition.calculate(left, right));

    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(1094.0), "yd", 1, "km");
    assertEquals("2.000000 km", Addition.calculate(left, right));

    // mi to km
    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(1.0), "mi", 1, "km");
    assertEquals("2.609000 km", Addition.calculate(left, right));

    // mm to km
    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(1000000.0), "mm", 1, "km");
    assertEquals("2.000000 km", Addition.calculate(left, right));

    // cm to km
    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(100000.0), "cm", 1, "km");
    assertEquals("2.000000 km", Addition.calculate(left, right));

    // m to km
    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(1000.0), "m", 1, "km");
    assertEquals("2.000000 km", Addition.calculate(left, right));

    // in to km
    left = new Operand(new BigDecimal(1.0), "km", 1, "km");
    right = new Operand(new BigDecimal(39370.0), "in", 1, "km");
    assertEquals("2.000000 km", Addition.calculate(left, right));
  }

}
