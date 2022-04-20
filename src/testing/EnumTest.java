package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import enums.Convert;
import enums.Length;
import utilities.Operand;

public class EnumTest {

	@Test
	void testLength()
	{
		assertEquals("cm", Length.CM.getUnit());
		
		// Test true
		assertTrue(Length.instanceOf("km"));
		assertTrue(Length.instanceOf("m"));
		assertTrue(Length.instanceOf("mi"));
		assertTrue(Length.instanceOf("ft"));
		assertTrue(Length.instanceOf("in"));
		
		// Test false
		assertFalse(Length.instanceOf("i"));
		assertFalse(Length.instanceOf("f"));
		assertFalse(Length.instanceOf("yard"));
		
		// Test conversions
		Operand left = new Operand(new BigDecimal(12.0), "km");
		Operand right = new Operand(new BigDecimal(12.0), "m");
		Operand expected = new Operand(new BigDecimal(0.012), "km");
		
//		assertEquals(expected.getValue(), Convert.convertLength(left, right).getValue());
//		assertEquals(expected.getUnit(), Convert.convertLength(left, right).getUnit());
	}
}
