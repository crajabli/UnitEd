package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

public class Weight
{
  /**
   * Returns converted operand.
   * 
   * @param op
   *          represents given Operand
   * @return Operand
   */
  static Operand convertWeight(Operand op)
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
    //"oz", "lb", "ton", "g", "kg"
    
    switch (unit)
    {
      case "oz":
        value = TimeUtils.toSecond(op);
        break;

      case "lb":
        value = TimeUtils.toHour(op);
        break;
        
      case "ton":
        value = TimeUtils.toDay(op);
        break;

      case "g":
        value = TimeUtils.toMonth(op);
        break;
          
      case "kg":
         value = TimeUtils.toYear(op);
         break;

    }

    return new Operand(value, unit, op.getExp(), unit);
  }

}
