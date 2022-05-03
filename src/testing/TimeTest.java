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
		assertEquals("100.000000 sec^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));
		
		// hr to sec
		left = new Operand(new BigDecimal(1.0), "sec", 1, "sec");
		right = new Operand(new BigDecimal(0.25), "hr", 1, "sec");
		assertEquals("901.000000 sec", Addition.calculate(left, right));
		assertEquals("-899.000000 sec", Subtraction.calculate(left, right));
		assertEquals("900.000000 sec^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.001111 ", Division.calculate(left, right, "/"));
		
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
	void testToHour() throws OperationFormatException, DivideByZeroException {
		// Both hr
		
		// sec to hr
		
		// day to hr

		// mon to hr

		// yr to hr
		fail("Not yet implemented");
	}
	
	@Test
	void testToDay() throws OperationFormatException, DivideByZeroException {
		// Both day
		
		// hr to day
		
		// sec to day

		// mon to day

		// yr to day
		fail("Not yet implemented");
	}
	
	@Test
	void testToMonth() throws OperationFormatException, DivideByZeroException {
		// Both mon
		
		// hr to mon
		
		// day to mon

		// sec to mon

		// yr to mon
		fail("Not yet implemented");
	}
	
	
	@Test
	void testToYear() throws OperationFormatException, DivideByZeroException {
		// Both yr
		
		// hr to yr
		
		// day to yr

		// mon to yr

		// sec to yr
		fail("Not yet implemented");
	}
}
