package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import calculations.Addition;
import calculations.Division;
import calculations.Multiplication;
import calculations.Subtraction;
import exceptions.DivideByZeroException;
import exceptions.NotLikeUnitsException;
import utilities.Operand;
import utilities.OperationFormatException;

class TimeTest {

	// "sec", "hr", "day", "mon", "yr"
	@Test
	void testToSecond() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both sec
		left = new Operand(new BigDecimal(10.0), "sec", 1, "sec");
		right = new Operand(new BigDecimal(10.0), "sec", 1, "sec");
		assertEquals("20.000000 sec", Addition.calculate(left, right));
		assertEquals("0.000000 sec", Subtraction.calculate(left, right));
		assertEquals("100.000000 sec\u00B2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000", Division.calculate(left, right, "/"));
		
		// hr to sec
		left = new Operand(new BigDecimal(1.0), "sec", 1, "sec");
		right = new Operand(new BigDecimal(0.25), "hr", 1, "sec");
		assertEquals("901.000000 sec", Addition.calculate(left, right));
		assertEquals("-899.000000 sec", Subtraction.calculate(left, right));
		assertEquals("900.000000 sec\u00B2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.001111", Division.calculate(left, right, "/"));
		
		// day to sec
		left = new Operand(new BigDecimal(1.0), "sec", 1, "sec");
		right = new Operand(new BigDecimal(1.0), "day", 1, "sec");
		assertEquals("86401.000000 sec", Addition.calculate(left, right));

		// mon to sec
		left = new Operand(new BigDecimal(1.0), "sec", 1, "sec");
		right = new Operand(new BigDecimal(0.25), "mon", 1, "sec");
		assertEquals("657001.000000 sec", Addition.calculate(left, right));

		// yr to sec
		left = new Operand(new BigDecimal(1.0), "sec", 1, "sec");
		right = new Operand(new BigDecimal(0.25), "yr", 1, "sec");
		assertEquals("7885001.000000 sec", Addition.calculate(left, right));
	}
	
	@Test
	void testToHour() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both hr
		left = new Operand(new BigDecimal(1.0), "hr", 1, "hr");
		right = new Operand(new BigDecimal(1.0), "hr", 1, "hr");
		assertEquals("2.000000 hr", Addition.calculate(left, right));
		
		// sec to hr
		left = new Operand(new BigDecimal(1.0), "hr", 1, "hr");
		right = new Operand(new BigDecimal(3600.0), "sec", 1, "hr");
		assertEquals("2.000000 hr", Addition.calculate(left, right));
		
		// day to hr
		left = new Operand(new BigDecimal(1.0), "hr", 1, "hr");
		right = new Operand(new BigDecimal(1.0), "day", 1, "hr");
		assertEquals("25.000000 hr", Addition.calculate(left, right));

		// mon to hr
		left = new Operand(new BigDecimal(1.0), "hr", 1, "hr");
		right = new Operand(new BigDecimal(1.0), "mon", 1, "hr");
		assertEquals("731.000000 hr", Addition.calculate(left, right));

		// yr to hr
		left = new Operand(new BigDecimal(1.0), "hr", 1, "hr");
		right = new Operand(new BigDecimal(1.0), "yr", 1, "hr");
		assertEquals("8761.000000 hr", Addition.calculate(left, right));
	}
	
	@Test
	void testToDay() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both day
		left = new Operand(new BigDecimal(1.0), "day", 1, "day");
		right = new Operand(new BigDecimal(1.0), "day", 1, "day");
		assertEquals("2.000000 day", Addition.calculate(left, right));
		
		// hr to day
		
		// sec to day

		// mon to day

		// yr to day
	}
	
	@Test
	void testToMonth() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both mon
		left = new Operand(new BigDecimal(1.0), "mon", 1, "mon");
		right = new Operand(new BigDecimal(1.0), "mon", 1, "mon");
		assertEquals("2.000000 mon", Addition.calculate(left, right));
		
		// hr to mon
		
		// day to mon

		// sec to mon

		// yr to mon
	}
	
	
	@Test
	void testToYear() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both yr
		left = new Operand(new BigDecimal(1.0), "yr", 1, "yr");
		right = new Operand(new BigDecimal(1.0), "yr", 1, "yr");
		assertEquals("2.000000 yr", Addition.calculate(left, right));
		
		// hr to yr
		
		// day to yr

		// mon to yr

		// sec to yr
	}
}
