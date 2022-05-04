package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import calculations.Addition;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.OperationFormatException;

class SpeedTest {

	@Test
	void testToMiPerSec() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both mi/sec
		left = new Operand(new BigDecimal(1.0), "mi/sec", 1, "mi/sec");
		right = new Operand(new BigDecimal(1.0), "mi/sec", 1, "mi/sec");
		assertEquals("2.000000 mi/sec", Addition.calculate(left, right));

		// mi/hr to mi/sec
		left = new Operand(new BigDecimal(1.0), "mi/sec", 1, "mi/sec");
		right = new Operand(new BigDecimal(1.0), "mi/hr", 1, "mi/sec");
		assertEquals("1.000278 mi/sec", Addition.calculate(left, right));

		// km/sec to mi/sec
		left = new Operand(new BigDecimal(1.0), "mi/sec", 1, "mi/sec");
		right = new Operand(new BigDecimal(1.0), "km/sec", 1, "mi/sec");
		assertEquals("1.621504 mi/sec", Addition.calculate(left, right));

		// km/hr to mi/sec
		left = new Operand(new BigDecimal(1.0), "mi/sec", 1, "mi/sec");
		right = new Operand(new BigDecimal(1.0), "km/hr", 1, "mi/sec");
		assertEquals("1.000173 mi/sec", Addition.calculate(left, right));
	}
	
	@Test
	void testToMiPerHr() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both mi/hr
		left = new Operand(new BigDecimal(1.0), "mi/hr", 1, "mi/hr");
		right = new Operand(new BigDecimal(1.0), "mi/hr", 1, "mi/hr");
		assertEquals("2.000000 mi/hr", Addition.calculate(left, right));

		// mi/sec to mi/hr
		left = new Operand(new BigDecimal(1.0), "mi/hr", 1, "mi/hr");
		right = new Operand(new BigDecimal(1.0), "mi/sec", 1, "mi/hr");
		assertEquals("3601.000000 mi/hr", Addition.calculate(left, right));

		// km/sec to mi/hr
		left = new Operand(new BigDecimal(1.0), "mi/hr", 1, "mi/hr");
		right = new Operand(new BigDecimal(1.0), "km/sec", 1, "mi/hr");
		assertEquals("2237.940000 mi/hr", Addition.calculate(left, right));

		// km/hr to mi/hr
		left = new Operand(new BigDecimal(1.0), "mi/hr", 1, "mi/hr");
		right = new Operand(new BigDecimal(1.0), "km/hr", 1, "mi/hr");
		assertEquals("1.621504 mi/hr", Addition.calculate(left, right));
	}
	
	@Test
	void testToKmPerSec() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both km/sec
		left = new Operand(new BigDecimal(1.0), "km/sec", 1, "km/sec");
		right = new Operand(new BigDecimal(1.0), "km/sec", 1, "km/sec");
		assertEquals("2.000000 km/sec", Addition.calculate(left, right));

		// mi/hr to km/sec
		left = new Operand(new BigDecimal(1.0), "km/sec", 1, "km/sec");
		right = new Operand(new BigDecimal(1.0), "mi/hr", 1, "km/sec");
		assertEquals("1.000447 km/sec", Addition.calculate(left, right));

		// mi/sec to km/sec
		left = new Operand(new BigDecimal(1.0), "km/sec", 1, "km/sec");
		right = new Operand(new BigDecimal(1.0), "mi/sec", 1, "km/sec");
		assertEquals("2.609000 km/sec", Addition.calculate(left, right));

		// km/hr to km/sec
		left = new Operand(new BigDecimal(1.0), "km/sec", 1, "km/sec");
		right = new Operand(new BigDecimal(3600.0), "km/hr", 1, "km/sec");
		assertEquals("2.000000 km/sec", Addition.calculate(left, right));
	}
	
	@Test
	void testToKmPerHr() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;

		// Both km/hr
		left = new Operand(new BigDecimal(1.0), "km/hr", 1, "km/hr");
		right = new Operand(new BigDecimal(1.0), "km/hr", 1, "km/hr");
		assertEquals("2.000000 km/hr", Addition.calculate(left, right));

		// mi/hr to km/hr
		left = new Operand(new BigDecimal(1.0), "km/hr", 1, "km/hr");
		right = new Operand(new BigDecimal(1.0), "mi/hr", 1, "km/hr");
		assertEquals("2.609000 km/hr", Addition.calculate(left, right));

		// km/sec to km/hr
		left = new Operand(new BigDecimal(1.0), "km/hr", 1, "km/hr");
		right = new Operand(new BigDecimal(1.0), "km/sec", 1, "km/hr");
		assertEquals("3601.000000 km/hr", Addition.calculate(left, right));

		// mi/sec to km/hr
		left = new Operand(new BigDecimal(1.0), "km/hr", 1, "km/hr");
		right = new Operand(new BigDecimal(1.0), "mi/sec", 1, "km/hr");
		assertEquals("5794.648006 km/hr", Addition.calculate(left, right));
	}

}
