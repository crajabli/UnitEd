package utilities;

import java.math.BigDecimal;

/**
 * Creates operand objects.
 * 
 * @author Maxine Payton
 * @version 4/6/22
 *
 */
public class Operand
{
  private String unit;
  private BigDecimal value;

  /**
   * Constructs operand objects.
   * 
   * @param value
   * @param unit
   */
  public Operand(final BigDecimal value, final String unit)
  {
    this.unit = unit;
    this.value = value;
  }

  /**
   * 
   * @return value of operand
   */
  public BigDecimal getValue()
  {
    return value;
  }

  /**
   * 
   * @return unit of operand
   */
  public String getUnit()
  {
    return unit;
  }
}
