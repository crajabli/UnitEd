package utilities;

import java.math.BigDecimal;

/**
 * Creates Operand objects.
 * 
 * @author Team 22
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
    if (unit == null || unit == "none")
    {
      this.unit = "";
    }
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

  /**
   * Parses out individual units if apart of a conjuction.
   * 
   * @return string array of individual units
   */
  public String[] separateDashUnits(String unit)
  {
    String[] units = unit.split("-");
    return units;
  }

  /**
   * Parses out individual units if apart of a conjuction.
   * 
   * @return string array of individual units
   */
  public String[] separateSlashUnits(String unit)
  {
    String[] units = unit.split("-");
    return units;
  }

}
