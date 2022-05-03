package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import calculations.*;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.OperationFormatException;

class LengthTest {

	@Test
	void testToInch() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both in
		left = new Operand(new BigDecimal(10.0), "in", 1, "in");
		right = new Operand(new BigDecimal(10.0), "in", 1, "in");
		assertEquals("20.000000 in", Addition.calculate(left, right));
		assertEquals("0.000000 in", Subtraction.calculate(left, right));
		assertEquals("100.000000 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to in
		left = new Operand(new BigDecimal(10.0), "in", 1, "in");
		right = new Operand(new BigDecimal(10.0), "ft", 1, "in");
		assertEquals("130.000000 in", Addition.calculate(left, right));
		assertEquals("-110.000000 in", Subtraction.calculate(left, right));
		assertEquals("1200.000000 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.083333 ", Division.calculate(left, right, "/"));

		// yd to in
		left = new Operand(new BigDecimal(10.0), "in", 1, "in");
		right = new Operand(new BigDecimal(10.0), "yd", 1, "in");
		assertEquals("370.000000 in", Addition.calculate(left, right));
		assertEquals("-350.000000 in", Subtraction.calculate(left, right));
		assertEquals("3600.000000 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.027778 ", Division.calculate(left, right, "/"));

		// mi to in
		left = new Operand(new BigDecimal(10.0), "in", 1, "in");
		right = new Operand(new BigDecimal(1.0), "mi", 1, "in");
		assertEquals("63370.000000 in", Addition.calculate(left, right));
		assertEquals("-63350.000000 in", Subtraction.calculate(left, right));
		assertEquals("633600.000000 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.000158 ", Division.calculate(left, right, "/"));

		// mm to in
		left = new Operand(new BigDecimal(1.0), "in", 1, "in");
		right = new Operand(new BigDecimal(25.4), "mm", 1, "in");
		assertEquals("2.000000 in", Addition.calculate(left, right));
		assertEquals("0.000000 in", Subtraction.calculate(left, right));
		assertEquals("1.000000 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// cm to in
		left = new Operand(new BigDecimal(1.0), "in", 1, "in");
		right = new Operand(new BigDecimal(25.4), "cm", 1, "in");
		assertEquals("11.000000 in", Addition.calculate(left, right));
		assertEquals("-9.000000 in", Subtraction.calculate(left, right));
		assertEquals("10.000000 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.100000 ", Division.calculate(left, right, "/"));

		// m to in
		left = new Operand(new BigDecimal(1.0), "in", 1, "in");
		right = new Operand(new BigDecimal(25.4), "m", 1, "in");
		assertEquals("1001.000540 in", Addition.calculate(left, right));
		assertEquals("-999.000540 in", Subtraction.calculate(left, right));
		assertEquals("1000.000540 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.001000 ", Division.calculate(left, right, "/"));

		// km to in
		left = new Operand(new BigDecimal(1.0), "in", 1, "in");
		right = new Operand(new BigDecimal(0.001), "km", 1, "in");
		assertEquals("40.370100 in", Addition.calculate(left, right));
		assertEquals("-38.370100 in", Subtraction.calculate(left, right));
		assertEquals("39.370100 in^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.025400 ", Division.calculate(left, right, "/"));
	}

	@Test
	void testToFeet() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both ft
		left = new Operand(new BigDecimal(10.0), "ft", 1, "ft");
		right = new Operand(new BigDecimal(10.0), "ft", 1, "ft");
		assertEquals("20.000000 ft", Addition.calculate(left, right));
		assertEquals("0.000000 ft", Subtraction.calculate(left, right));
		assertEquals("100.000000 ft^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// in to ft

		// yd to ft

		// mi to ft

		// mm to ft

		// cm to ft

		// m to ft

		// km to ft
	}

	@Test
	void testToYard() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both yd
		left = new Operand(new BigDecimal(10.0), "yd", 1, "yd");
		right = new Operand(new BigDecimal(10.0), "yd", 1, "yd");
		assertEquals("20.000000 yd", Addition.calculate(left, right));
		assertEquals("0.000000 yd", Subtraction.calculate(left, right));
		assertEquals("100.000000 yd^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to yd

		// in to yd

		// mi to yd

		// mm to yd

		// cm to yd

		// m to yd

		// km to yd
	}

	@Test
	void testToMile() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both mi
		left = new Operand(new BigDecimal(10.0), "mi", 1, "mi");
		right = new Operand(new BigDecimal(10.0), "mi", 1, "mi");
		assertEquals("20.000000 mi", Addition.calculate(left, right));
		assertEquals("0.000000 mi", Subtraction.calculate(left, right));
		assertEquals("100.000000 mi^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to in

		// yd to in

		// mi to in

		// mm to in

		// cm to in

		// m to in

		// km to in
	}

	@Test
	void testToMillimeter() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both mm
		left = new Operand(new BigDecimal(10.0), "mm", 1, "mm");
		right = new Operand(new BigDecimal(10.0), "mm", 1, "mm");
		assertEquals("20.000000 mm", Addition.calculate(left, right));
		assertEquals("0.000000 mm", Subtraction.calculate(left, right));
		assertEquals("100.000000 mm^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to mm

		// yd to mm

		// mi to mm

		// in to mm

		// cm to mm

		// m to mm

		// km to mm
	}

	@Test
	void testToCentimeter() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both cm
		left = new Operand(new BigDecimal(10.0), "cm", 1, "cm");
		right = new Operand(new BigDecimal(10.0), "cm", 1, "cm");
		assertEquals("20.000000 cm", Addition.calculate(left, right));
		assertEquals("0.000000 cm", Subtraction.calculate(left, right));
		assertEquals("100.000000 cm^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to cm

		// yd to cm

		// mi to cm

		// mm to cm

		// in to cm

		// m to cm

		// km to cm
	}

	@Test
	void testToMeter() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both m
		left = new Operand(new BigDecimal(10.0), "m", 1, "m");
		right = new Operand(new BigDecimal(10.0), "m", 1, "m");
		assertEquals("20.000000 m", Addition.calculate(left, right));
		assertEquals("0.000000 m", Subtraction.calculate(left, right));
		assertEquals("100.000000 m^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to in

		// yd to in

		// mi to in

		// mm to in

		// cm to in

		// m to in

		// km to in
	}

	@Test
	void testToKilometer() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both km
		left = new Operand(new BigDecimal(10.0), "km", 1, "km");
		right = new Operand(new BigDecimal(10.0), "km", 1, "km");
		assertEquals("20.000000 km", Addition.calculate(left, right));
		assertEquals("0.000000 km", Subtraction.calculate(left, right));
		assertEquals("100.000000 km^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));

		// ft to km

		// yd to km

		// mi to km

		// mm to km

		// cm to km

		// m to km

		// in to km
	}

}
