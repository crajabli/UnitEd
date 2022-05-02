package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

public class Money
{
  /**
   * Returns converted operand.
   * 
   * @param op
   *          represents given Operand
   * @return Operand
   */
  static Operand convertMoney(Operand op)
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
      case "c":
        value = MoneyUtils.toCent(op);
        break;

      case "$":
        value = MoneyUtils.toDollar(op);
        break;

    }

    return new Operand(value, unit, op.getExp(), unit);
  }
}
