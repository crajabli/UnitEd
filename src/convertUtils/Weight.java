package convertUtils;

import java.math.BigDecimal;

import utilities.Operand;

/**
 * Weight class.
 * 
 * @author Victor Aten
 * @version 05/04/2022
 */
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
        value = WeightUtils.toOunce(op);
        break;

      case "lb":
        value = WeightUtils.toPound(op);
        break;
        
      case "ton":
        value = WeightUtils.toTon(op);
        break;

      case "g":
        value = WeightUtils.toGram(op);
        break;
          
      case "kg":
         value = WeightUtils.toKilogram(op);
         break;

    }

    return new Operand(value, unit, op.getExp(), unit);
  }

}
