package convertUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.Operand;

public class TimeUtils {
	/**
	 * Converts given Operand to seconds
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toSecond(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "yr":
				// yr to sec
				value = value.multiply(new BigDecimal(3.154e+7));
		        break;

		      case "hr":
		    	// hr to sec
		        value = value.multiply(new BigDecimal(3600.0));
		        break;
		        
		      case "day":
		    	// day to sec
		        value = value.multiply(new BigDecimal(86400));
		        break;

		      case "mon":
		    	// mon to sec
		        value = value.multiply(new BigDecimal(2.628e+6));
		        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to hours
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toHour(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "yr":
				// yr to hr
				value = value.multiply(new BigDecimal(8760.0));
		        break;

		      case "sec":
		    	// sec to hr
		        value = value.divide(new BigDecimal(3600.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		        
		      case "day":
		    	// day to hr
		        value = value.multiply(new BigDecimal(24.0));
		        break;

		      case "mon":
		    	// mon to hr
		        value = value.multiply(new BigDecimal(730.0));
		        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to days
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toDay(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "yr":
				// yr to day
				value = value.multiply(new BigDecimal(365.0));
		        break;

		      case "hr":
		    	// hr to day
		        value = value.divide(new BigDecimal(24.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		        
		      case "sec":
		    	// sec to day
		        value = value.divide(new BigDecimal(86400.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;

		      case "mon":
		    	// mon to day
		        value = value.multiply(new BigDecimal(30.0));
		        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to months
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toMonth(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "yr":
				// yr to mon
				value = value.multiply(new BigDecimal(12.0));
		        break;

		      case "hr":
		    	// hr to mon
		        value = value.divide(new BigDecimal(730.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		        
		      case "day":
		    	// day to mon
		        value = value.divide(new BigDecimal(30.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;

		      case "sec":
		    	// sec to mon
		        value = value.divide(new BigDecimal(2.628e+6), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to years
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toYear(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
			case "sec":
				// sec to yr
				value = value.divide(new BigDecimal(3.154e+7), 6,
				        RoundingMode.HALF_DOWN);
		        break;

		      case "hr":
		    	// hr to yr
		        value = value.divide(new BigDecimal(8760.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		        
		      case "day":
		    	// day to yr
		        value = value.divide(new BigDecimal(365.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;

		      case "mon":
		    	// mon to yr
		        value = value.divide(new BigDecimal(12.0), 6,
				        RoundingMode.HALF_DOWN);
		        break;
		}

		return value;
	}

}
