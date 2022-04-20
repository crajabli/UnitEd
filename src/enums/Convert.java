package enums;

import java.math.BigDecimal;

import utilities.Operand;

public class Convert
{
  /**
   * Returns a new right operand for Length
   */
  public static Operand convertLength(final Operand leftOp, final Operand rightOp)
  {
    String unit = leftOp.getUnit();
    BigDecimal value = new BigDecimal(0.0);

    switch (unit)
    {
      case "km":
        value = kmSwitch(rightOp);
        break;
     
      case "m":
        value = mSwitch(rightOp);
        break;

      case "cm":
        value = cmSwitch(rightOp);
        break;

      case "mi":
        value = miSwitch(rightOp);
        break;

      case "ft":
        value = ftSwitch(rightOp);
        break;

      case "in":
        value = inSwitch(rightOp);
        break;
    }

    return new Operand(value, unit);
  }

  /**
   * Returns a new right operand for Weight
   */
  public static Operand convertWeight(final Operand leftOp, final Operand rightOp)
  {
    String unit = leftOp.getUnit();
    BigDecimal value = new BigDecimal(0.0);

    switch (unit)
    {
      case "kg":
        value = kgSwitch(rightOp);
        break;
    
      case "g":
        value = gSwitch(rightOp);
        break;

      case "lb":
        value = lbSwitch(rightOp);
        break;

      case "oz":
        value = ozSwitch(rightOp);
        break;
    }

    return new Operand(value, unit);
  }

  // PRIVATE METHODS FOR CONVERTING LENGTHS
  // Convert rightOp unit to km
  private static BigDecimal kmSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "m":
        value = value.multiply(ConvertUtils.M_TO_KM);
        break;

      case "cm":
        value = value.multiply(ConvertUtils.CM_TO_KM);
        break;

      case "mi":
        value = value.multiply(ConvertUtils.MI_TO_KM);
        break;

      case "ft":
        value = value.multiply(ConvertUtils.FT_TO_KM);
        break;

      case "in":
        value = value.multiply(ConvertUtils.IN_TO_KM);
        break;
    }

    return value;
  }

  // Convert rightOp unit to m
  private static BigDecimal mSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "km":
        value = value.multiply(ConvertUtils.KM_TO_M);
        break;

      case "cm":
        value = value.multiply(ConvertUtils.CM_TO_M);
        break;

      case "mi":
        value = value.multiply(ConvertUtils.MI_TO_M);
        break;

      case "ft":
        value = value.multiply(ConvertUtils.FT_TO_M);
        break;

      case "in":
        value = value.multiply(ConvertUtils.IN_TO_M);
        break;
    }

    return value;
  }

  // Convert rightOp unit to cm
  private static BigDecimal cmSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "m":
        value = value.multiply(ConvertUtils.M_TO_CM);
        break;

      case "km":
        value = value.multiply(ConvertUtils.KM_TO_CM);
        break;

      case "mi":
        value = value.multiply(ConvertUtils.MI_TO_CM);
        break;

      case "ft":
        value = value.multiply(ConvertUtils.FT_TO_CM);
        break;

      case "in":
        value = value.multiply(ConvertUtils.IN_TO_CM);
        break;
    }

    return value;
  }

  // Convert rightOp unit to mi
  private static BigDecimal miSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "m":
        value = value.multiply(ConvertUtils.M_TO_MI);
        break;

      case "cm":
        value = value.multiply(ConvertUtils.CM_TO_MI);
        break;

      case "km":
        value = value.multiply(ConvertUtils.KM_TO_MI);
        break;

      case "ft":
        value = value.multiply(ConvertUtils.FT_TO_MI);
        break;

      case "in":
        value = value.multiply(ConvertUtils.IN_TO_MI);
        break;
    }

    return value;
  }

  // Convert rightOp unit to ft
  private static BigDecimal ftSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "m":
        value = value.multiply(ConvertUtils.M_TO_FT);
        break;

      case "cm":
        value = value.multiply(ConvertUtils.CM_TO_FT);
        break;

      case "mi":
        value = value.multiply(ConvertUtils.MI_TO_FT);
        break;

      case "km":
        value = value.multiply(ConvertUtils.KM_TO_FT);
        break;

      case "in":
        value = value.multiply(ConvertUtils.IN_TO_FT);
        break;
    }

    return value;
  }

  // Convert rightOp unit to in
  private static BigDecimal inSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "m":
        value = value.multiply(ConvertUtils.M_TO_IN);
        break;

      case "cm":
        value = value.multiply(ConvertUtils.CM_TO_IN);
        break;

      case "mi":
        value = value.multiply(ConvertUtils.MI_TO_IN);
        break;

      case "ft":
        value = value.multiply(ConvertUtils.FT_TO_IN);
        break;

      case "km":
        value = value.multiply(ConvertUtils.KM_TO_IN);
        break;
    }

    return value;
  }

  // PRIVATE METHODS FOR CONVERTING WEIGHTS
  // Convert rightOp unit to kg
  private static BigDecimal kgSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "g":
        value = value.multiply(ConvertUtils.G_TO_KG);
        break;

      case "lb":
        value = value.multiply(ConvertUtils.LB_TO_KG);
        break;

      case "oz":
        value = value.multiply(ConvertUtils.OZ_TO_KG);
        break;
    }

    return value;
  }

  // Convert rightOp unit to g
  private static BigDecimal gSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "kg":
        value = value.multiply(ConvertUtils.KG_TO_G);
        break;

      case "lb":
        value = value.multiply(ConvertUtils.LB_TO_G);
        break;

      case "oz":
        value = value.multiply(ConvertUtils.OZ_TO_G);
        break;
    }

    return value;
  }

  // Convert rightOp unit to lb
  private static BigDecimal lbSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "g":
        value = value.multiply(ConvertUtils.G_TO_LB);
        break;

      case "kg":
        value = value.multiply(ConvertUtils.KG_TO_LB);
        break;

      case "oz":
        value = value.multiply(ConvertUtils.OZ_TO_LB);
        break;
    }

    return value;
  }

  // Convert rightOp unit to oz
  private static BigDecimal ozSwitch(final Operand rightOp)
  {
    String unit = rightOp.getUnit();
    BigDecimal value = rightOp.getValue();

    switch (unit)
    {
      case "g":
        value = value.multiply(ConvertUtils.G_TO_OZ);
        break;

      case "lb":
        value = value.multiply(ConvertUtils.LB_TO_OZ);
        break;

      case "kg":
        value = value.multiply(ConvertUtils.KG_TO_OZ);
        break;
    }

    return value;
  }

}
