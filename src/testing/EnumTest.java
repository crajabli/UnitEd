package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.Length;

public class EnumTest {

	@Test
	void testLength()
	{
		assertEquals("cm", Length.CM.getUnit());
	}
}
