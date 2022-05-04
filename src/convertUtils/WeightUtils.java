package convertUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.Operand;

public class WeightUtils
{

  /**
   * Converts given Operand to ounces
   * 
   * @param op
   *          represents Operand
   * @return BigDecimal value
   */
  public static BigDecimal toOunce(Operand op)
  {
    String unit = op.getUnit();
    BigDecimal value = op.getValue();

    switch (unit)
    {
      case "lb":
        // lb to oz
        value = value.multiply(new BigDecimal(16.0));
        break;

      case "ton":
        // ton to oz
        value = value.multiply(new BigDecimal(32000.0));
        break;

      case "g":
        // g to oz
        value = value.divide(new BigDecimal(28.35), 6, RoundingMode.HALF_DOWN);
        break;

      case "kg":
        // kg to oz
        value = value.multiply(new BigDecimal(35.274));
        break;
    }

    return value;
  }

  /**
   * Converts given Operand to pounds
   * 
   * @param op
   *          represents Operand
   * @return BigDecimal value
   */
  public static BigDecimal toPound(Operand op)
  {
    String unit = op.getUnit();
    BigDecimal value = op.getValue();

    switch (unit)
    {
      case "oz":
        // oz to lb
        value = value.divide(new BigDecimal(16.0), 6, RoundingMode.HALF_DOWN);
        break;

      case "ton":
        // ton to lb
        value = value.multiply(new BigDecimal(2000.0));
        break;

      case "g":
        // g to lb
        value = value.divide(new BigDecimal(454.0), 6, RoundingMode.HALF_DOWN);
        break;

      case "kg":
        // kg to lb
        value = value.multiply(new BigDecimal(2.20462));
        break;
    }

    return value;
  }

  /**
   * Converts given Operand to tons
   * 
   * @param op
   *          represents Operand
   * @return BigDecimal value
   */
  public static BigDecimal toTon(Operand op)
  {
    String unit = op.getUnit();
    BigDecimal value = op.getValue();

    switch (unit)
    {
      case "lb":
        // lb to ton
        value = value.divide(new BigDecimal(2000.0), 6, RoundingMode.HALF_DOWN);
        break;

      case "oz":
        // oz to ton
        value = value.divide(new BigDecimal(32000.0), 6, RoundingMode.HALF_DOWN);
        break;

      case "g":
        // g to ton
        value = value.divide(new BigDecimal(907185.0), 6, RoundingMode.HALF_DOWN);
        break;

      case "kg":
        // kg to ton
        value = value.divide(new BigDecimal(907.0), 6, RoundingMode.HALF_DOWN);
        break;
    }

    return value;
  }

  /**
   * Converts given Operand to grams
   * 
   * @param op
   *          represents Operand
   * @return BigDecimal value
   */
  public static BigDecimal toGram(Operand op)
  {
    String unit = op.getUnit();
    BigDecimal value = op.getValue();

    switch (unit)
    {
      case "lb":
        // lb to g
        value = value.multiply(new BigDecimal(453.592));
        break;

      case "ton":
        // ton to g
        value = value.multiply(new BigDecimal(907185.0));
        break;

      case "oz":
        // oz to g
        value = value.multiply(new BigDecimal(28.3495));
        break;

      case "kg":
        // kg to g
        value = value.multiply(new BigDecimal(1000.0));
        break;
    }

    return value;
  }

  /**
   * Converts given Operand to kilograms
   * 
   * @param op
   *          represents Operand
   * @return BigDecimal value
   */
  public static BigDecimal toKilogram(Operand op)
  {
    String unit = op.getUnit();
    BigDecimal value = op.getValue();

    switch (unit)
    {
      case "lb":
        // lb to kg
        value = value.divide(new BigDecimal(2.205), 6, RoundingMode.HALF_DOWN);
        break;

      case "ton":
        // ton to kg
        value = value.multiply(new BigDecimal(907.185));
        break;

      case "g":
        // g to kg
        value = value.divide(new BigDecimal(1000.0), 6, RoundingMode.HALF_DOWN);
        break;

      case "oz":
        // oz to kg
        value = value.divide(new BigDecimal(35.274), 6, RoundingMode.HALF_DOWN);
        break;
    }

    return value;
  }

}
