package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

public class Length
{
  /**
   * Returns converted operand.
   * 
   * @param op
   *          represents given Operand
   * @return Operand
   */
  static Operand convertLength(Operand op)
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
      case "in":
        value = LengthUtils.toInch(op);
        break;

      case "ft":
        value = LengthUtils.toFeet(op);
        break;

      case "yd":
        value = LengthUtils.toYard(op);
        break;

      case "mi":
        value = LengthUtils.toMile(op);
        break;

      case "mm":
        value = LengthUtils.toMillimeter(op);
        break;

      case "cm":
        value = LengthUtils.toCentimeter(op);
        break;

      case "m":
        value = LengthUtils.toMeter(op);
        break;

      case "km":
        value = LengthUtils.toKilometer(op);
        break;
    }

    return new Operand(value, unit, op.getExp(), unit);
  }
}
