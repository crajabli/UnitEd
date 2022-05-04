package convertUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.Operand;

public class SpeedUtils {
	/**
	 * Converts given Operand to mi/sec
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toMiPerSec(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "mi/hr":
			// mi/hr to mi/sec
			value = value.divide(new BigDecimal(3600.0), 6,
				        RoundingMode.HALF_DOWN);
	        break;
	        
	      case "km/sec":
	    	// km/sec to mi/sec
	    	value = value.divide(new BigDecimal(1.609), 6,
				        RoundingMode.HALF_DOWN);
	        break;

	      case "km/hr":
	    	// km/hr to mi/sec
	    	value = value.divide(new BigDecimal(5794.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to mi/hr
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toMiPerHr(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "mi/sec":
			// mi/sec to mi/hr
	    	value = value.multiply(new BigDecimal(3600.0));
	        break;
	        
	      case "km/sec":
	    	// km/sec to mi/hr
	    	value = value.multiply(new BigDecimal(2236.94));
	        break;

	      case "km/hr":
	    	// km/hr to mi/hr
	    	value = value.divide(new BigDecimal(1.609), 6,
			        RoundingMode.HALF_DOWN);
	        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to km/sec
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toKmPerSec(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "mi/hr":
			// mi/hr to km/sec
		    value = value.divide(new BigDecimal(2237.0), 6,
				        RoundingMode.HALF_DOWN);
	        break;
	        
	      case "mi/sec":
	    	// mi/sec to km/sec
	    	value = value.multiply(new BigDecimal(1.609));
	        break;

	      case "km/hr":
	    	// km/hr to km/sec
	    	value = value.divide(new BigDecimal(3600.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to km/hr
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toKmPerHr(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "mi/hr":
			// mi/hr to km/hr
	    	value = value.multiply(new BigDecimal(1.609));
	        break;
	        
	      case "km/sec":
	    	// km/sec to km/hr
	    	value = value.multiply(new BigDecimal(3600.0));
	        break;

	      case "mi/sec":
	    	// mi/sec to km/hr
	    	value = value.multiply(new BigDecimal(5793.648005852));
	        break;
		}

		return value;
	}

}
