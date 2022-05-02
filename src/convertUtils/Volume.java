package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

public class Volume
{
  /**
   * Returns converted operand.
   * 
   * @param op
   *          represents given Operand
   * @return Operand
   */
  static Operand convertVolume(Operand op)
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
      case "pt":
        value = VolumeUtils.toPint(op);
        break;

      case "qt":
    	value = VolumeUtils.toPint(op);
        break;
        
      case "gal":
    	value = VolumeUtils.toPint(op);
        break;

      case "cc":
    	value = VolumeUtils.toPint(op);
        break;
          
      case "l":
    	 value = VolumeUtils.toPint(op);
         break;


    }

    return new Operand(value, unit, op.getExp(), unit);
  }
}
