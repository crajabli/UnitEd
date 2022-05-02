package convertUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.Operand;

public class LengthUtils {
	/**
	 * Converts given Operand to inches
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toInch(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to in
				value = value.multiply(new BigDecimal(12.0));
		        break;
		        
			case "yd":
				// yd to in
				value = value.multiply(new BigDecimal(36.0));
		        break;
		        
			case "mi":
				// mi to in
				value = value.multiply(new BigDecimal(63360.0));
		        break;
		        
			case "mm":
				// mm to in
				value = value.divide(new BigDecimal(25.4), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "cm":
				// cm to in
				value = value.divide(new BigDecimal(2.54), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "m":
				// m to in
				value = value.multiply(new BigDecimal(39.3701));
		        break;
		        
			case "km":
				// km to in
				value = value.multiply(new BigDecimal(39370.1));
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to feet
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toFeet(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "in":
				// in to ft
				value = value.divide(new BigDecimal(12.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "yd":
				// yd to ft
				value = value.multiply(new BigDecimal(3.0));
		        break;
		        
			case "mi":
				// mi to ft
				value = value.multiply(new BigDecimal(5280.0));
		        break;
		        
			case "mm":
				// mm to ft
				value = value.divide(new BigDecimal(305.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "cm":
				// cm to ft
				value = value.divide(new BigDecimal(30.48), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "m":
				// m to ft
				value = value.multiply(new BigDecimal(3.281));
		        break;
		        
			case "km":
				// km to ft
				value = value.multiply(new BigDecimal(3280.84));
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to yards
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toYard(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to yd
				value = value.divide(new BigDecimal(3.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "in":
				// in to yd
				value = value.divide(new BigDecimal(36.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "mi":
				// mi to yd
				value = value.multiply(new BigDecimal(1760.0));
		        break;
		        
			case "mm":
				// mm to yd
				value = value.divide(new BigDecimal(914.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "cm":
				// cm to yd
				value = value.divide(new BigDecimal(91.44), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "m":
				// m to yd
				value = value.multiply(new BigDecimal(1.09361));
		        break;
		        
			case "km":
				// km to yd
				value = value.multiply(new BigDecimal(1093.61));
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to miles
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toMile(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to mi
				value = value.divide(new BigDecimal(5280.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "yd":
				// yd to mi
				value = value.divide(new BigDecimal(1760.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "in":
				// in to mi
				value = value.divide(new BigDecimal(63360.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "mm":
				// mm to mi
				value = value.divide(new BigDecimal(1609000.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "cm":
				// cm to mi
				value = value.divide(new BigDecimal(160934.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "m":
				// m to mi
				value = value.divide(new BigDecimal(1609.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "km":
				// km to mi
				value = value.divide(new BigDecimal(1.609), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to millimeters
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toMillimeter(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to mm
				value = value.multiply(new BigDecimal(304.8));
		        break;
		        
			case "yd":
				// yd to mm
				value = value.multiply(new BigDecimal(914.4));
		        break;
		        
			case "mi":
				// mi to mm
				value = value.multiply(new BigDecimal(1609000.0));
		        break;
		        
			case "in":
				// in to mm
				value = value.multiply(new BigDecimal(25.4));
		        break;
		        
			case "cm":
				// cm to mm
				value = value.multiply(new BigDecimal(10.0));
		        break;
		        
			case "m":
				// m to mm
				value = value.multiply(new BigDecimal(1000.0));
		        break;
		        
			case "km":
				// km to mm
				value = value.multiply(new BigDecimal(1000000.0));
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to centimeters
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toCentimeter(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to cm
				value = value.multiply(new BigDecimal(30.48));
		        break;
		        
			case "yd":
				// yd to cm
				value = value.multiply(new BigDecimal(91.44));
		        break;
		        
			case "mi":
				// mi to cm
				value = value.multiply(new BigDecimal(160934.0));
		        break;
		        
			case "mm":
				// mm to cm
				value = value.divide(new BigDecimal(10.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "in":
				// in to cm
				value = value.multiply(new BigDecimal(2.54));
		        break;
		        
			case "m":
				// m to cm
				value = value.multiply(new BigDecimal(100.0));
		        break;
		        
			case "km":
				// km to cm
				value = value.multiply(new BigDecimal(100000.0));
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to meters
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toMeter(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to m
				value = value.divide(new BigDecimal(3.281), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "yd":
				// yd to m
				value = value.divide(new BigDecimal(1.094), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "mi":
				// mi to m
				value = value.multiply(new BigDecimal(1609.34));
		        break;
		        
			case "mm":
				// mm to m
				value = value.divide(new BigDecimal(1000.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "cm":
				// cm to m
				value = value.divide(new BigDecimal(100.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "in":
				// in to m
				value = value.divide(new BigDecimal(39.37), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "km":
				// km to m
				value = value.multiply(new BigDecimal(1000.0));
		        break;
		}

		return value;
	}

	/**
	 * Converts given Operand to kilometers
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toKilometer(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "ft":
				// ft to km
				value = value.divide(new BigDecimal(3281.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "yd":
				// yd to km
				value = value.divide(new BigDecimal(1094.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "mi":
				// mi to km
				value = value.multiply(new BigDecimal(1.609));
		        break;
		        
			case "mm":
				// mm to km
				value = value.divide(new BigDecimal(1000000.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "cm":
				// cm to km
				value = value.divide(new BigDecimal(100000.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "m":
				// m to km
				value = value.divide(new BigDecimal(1000.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		        
			case "in":
				// in to km
				value = value.divide(new BigDecimal(39370.0), 6,
		        RoundingMode.HALF_DOWN);
		        break;
		}

		return value;
	}
}
