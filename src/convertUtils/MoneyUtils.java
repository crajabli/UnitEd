package convertUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.Operand;

public class MoneyUtils {
	/**
	 * Converts given Operand to cents
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toCent(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "$":
				// $ to c
				value = value.multiply(new BigDecimal(100.0));
		        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to dollars
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toDollar(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "c":
				// c to $
				value = value.divide(new BigDecimal(100.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		}

		return value;
	}

}
