package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

/**
 * Time class.
 * 
 * @author Victor Aten
 * @version 05/04/2022
 */
public class Time
{
  /**
   * Returns converted operand.
   * 
   * @param op
   *          represents given Operand
   * @return Operand
   */
  static Operand convertTime(Operand op)
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
      case "sec":
        value = TimeUtils.toSecond(op);
        break;

      case "hr":
        value = TimeUtils.toHour(op);
        break;
        
      case "day":
        value = TimeUtils.toDay(op);
        break;

      case "mon":
        value = TimeUtils.toMonth(op);
        break;
          
      case "yr":
         value = TimeUtils.toYear(op);
         break;

    }

    return new Operand(value, unit, op.getExp(), unit);
  }
}
