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

class MoneyTest {

	@Test
	void testToCent() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both c
		left = new Operand(new BigDecimal(10.0), "c", 1, "c");
		right = new Operand(new BigDecimal(10.0), "c", 1, "c");
		assertEquals("20.000000 c", Addition.calculate(left, right));
		assertEquals("0.000000 c", Subtraction.calculate(left, right));
		assertEquals("100.000000 c^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));
		
		// c to $
		left = new Operand(new BigDecimal(10.0), "$", 1, "c");
		right = new Operand(new BigDecimal(10.0), "c", 1, "c");
		assertEquals("1010.000000 c", Addition.calculate(left, right));
		assertEquals("990.000000 c", Subtraction.calculate(left, right));
		assertEquals("10000.000000 c^2", Multiplication.calculate(left, right, "x"));
		assertEquals("100.000000 ", Division.calculate(left, right, "/"));
		
		left = new Operand(new BigDecimal(10.0), "c", 1, "c");
		right = new Operand(new BigDecimal(10.0), "$", 1, "c");
		assertEquals("1010.000000 c", Addition.calculate(left, right));
		assertEquals("-990.000000 c", Subtraction.calculate(left, right));
		assertEquals("10000.000000 c^2", Multiplication.calculate(left, right, "x"));
		assertEquals("0.010000 ", Division.calculate(left, right, "/"));
	}
	
	@Test
	void testToDollar() throws OperationFormatException, DivideByZeroException, NotLikeUnitsException {
		Operand left;
		Operand right;
		
		// Both $
		left = new Operand(new BigDecimal(10.0), "$", 1, "$");
		right = new Operand(new BigDecimal(10.0), "$", 1, "$");
		assertEquals("20.000000 $", Addition.calculate(left, right));
		assertEquals("0.000000 $", Subtraction.calculate(left, right));
		assertEquals("100.000000 $^2", Multiplication.calculate(left, right, "x"));
		assertEquals("1.000000 ", Division.calculate(left, right, "/"));
		
		// $ to c
	}

}
