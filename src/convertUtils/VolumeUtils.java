package convertUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.Operand;

/**
 * VolumeUtils class.
 * 
 * @author Victor Aten
 * @version 05/04/2022
 */
public class VolumeUtils {
	/**
	 * Converts given Operand to pints
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toPint(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "qt":
			// qt to pt
	    	value = value.multiply(new BigDecimal(2.0));
	        break;
	        
	      case "gal":
	    	// gal to pt
	    	value = value.multiply(new BigDecimal(8.0));
	        break;

	      case "cc":
	    	// cc to pt
	    	value = value.divide(new BigDecimal(473.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	          
	      case "l":
	    	 // l to pt
	    	 value = value.multiply(new BigDecimal(2.11338));
	         break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to quarts
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toQuart(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "pt":
			// pt to qt
	    	value = value.divide(new BigDecimal(2.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	        
	      case "gal":
	    	// gal to qt
	    	value = value.multiply(new BigDecimal(4.0));
	        break;

	      case "cc":
	    	// cc to qt
	    	value = value.divide(new BigDecimal(946.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	          
	      case "l":
	    	 // l to qt
	    	 value = value.multiply(new BigDecimal(1.05669));
	         break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to gallons
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toGallon(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "qt":
			// qt to gal
	    	value = value.divide(new BigDecimal(4.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	        
	      case "pt":
	    	// pt to gal
	    	value = value.divide(new BigDecimal(8.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;

	      case "cc":
	    	// cc to gal
	    	value = value.divide(new BigDecimal(3785.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	          
	      case "l":
	    	 // l to gal
	    	 value = value.divide(new BigDecimal(3.785), 6,
				        RoundingMode.HALF_DOWN);
	         break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to cubic centimeters
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toCubicCentimeter(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "qt":
			// qt to cc
	    	value = value.multiply(new BigDecimal(946.0));
	        break;
	        
	      case "gal":
	    	// gal to cc
	    	value = value.multiply(new BigDecimal(3785.0));
	        break;

	      case "pt":
	    	// pt to cc
	    	value = value.multiply(new BigDecimal(473.0));
	        break;
	          
	      case "l":
	    	 // l to cc
	    	 value = value.multiply(new BigDecimal(1000.0));
	         break;
		}

		return value;
	}
	
	/**
	 * Converts given Operand to liters
	 * 
	 * @param op represents Operand
	 * @return BigDecimal value
	 */
	public static BigDecimal toLiter(Operand op) {
		String unit = op.getUnit();
		BigDecimal value = op.getValue();

		switch (unit) {
		  case "qt":
			// qt to l
	    	value = value.divide(new BigDecimal(1.057), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	        
	      case "gal":
	    	// gal to l
	    	value = value.multiply(new BigDecimal(3.785));
	        break;

	      case "cc":
	    	// cc to l
	    	value = value.divide(new BigDecimal(1000.0), 6,
			        RoundingMode.HALF_DOWN);
	        break;
	          
	      case "pt":
	    	 // pt to l
	    	 value = value.divide(new BigDecimal(2.113), 6,
				        RoundingMode.HALF_DOWN);
	         break;
		}

		return value;
	}

}
