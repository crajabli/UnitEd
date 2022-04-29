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
  private int exponent;
  private String resultUnit;

  /**
   * Constructs operand objects.
   * 
   * @param value
   * @param unit
   */
  public Operand(final BigDecimal value, final String unit, final int exponent,
      final String resultUnit)
  {
    if (unit == null || unit == "none")
    {
      this.unit = "";
    }
    this.unit = unit;
    this.exponent = exponent;

    if (resultUnit == null)
    {
      this.resultUnit = unit;
    }
    this.resultUnit = resultUnit;
    this.value = BigDecimal.valueOf(Math.pow(value.doubleValue(), exponent));
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
   * 
   * @return the unit to be converted to 
   */
  public String getResultUnit()
  {
    return resultUnit;
  }
  
  /**
   * Helper method for testing purposes.
   * 
   * @return operand's exponent
   */
  public int getExp()
  {
    return this.exponent;
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
