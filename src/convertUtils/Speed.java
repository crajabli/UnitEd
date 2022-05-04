package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

/**
 * Speed class.
 * 
 * @author Victor Aten
 * @version 05/04/2022
 */
public class Speed {
	/**
	   * Returns converted operand.
	   * 
	   * @param op
	   *          represents given Operand
	   * @return Operand
	   */
	  static Operand convertSpeed(Operand op)
	  {
	    Operand result = op;

	    // If unit does not equal Result Unit
	    if (!op.getUnit().equals(op.getResultUnit()))
	    {
	      result = conversion(op);
	    }

	    return result;
	  }

	  /**
	   * Returns converted operand.
	   * 
	   * @param op
	   *          represents given Operand
	   * @return Operand
	   */
	  public static Operand conversion(Operand op)
	  {
	    String unit = op.getResultUnit();
	    BigDecimal value = op.getValue();

	    switch (unit)
	    {
	      case "mi/sec":
	        value = SpeedUtils.toMiPerSec(op);
	        break;

	      case "mi/hr":
	        value = SpeedUtils.toMiPerHr(op);
	        break;

	      case "km/sec":
	        value = SpeedUtils.toKmPerSec(op);
	        break;

	      case "km/hr":
	        value = SpeedUtils.toKmPerHr(op);
	        break;
	    }
	    return new Operand(value, unit, op.getExp(), unit);
	  }

}
