package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

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
        value = MoneyUtils.toCent(op);
        break;

      case "hr":
        value = MoneyUtils.toDollar(op);
        break;
        
      case "day":
        value = MoneyUtils.toCent(op);
        break;

      case "mon":
        value = MoneyUtils.toDollar(op);
        break;
          
      case "yr":
         value = MoneyUtils.toCent(op);
         break;

    }

    return new Operand(value, unit, op.getExp(), unit);
  }
}
