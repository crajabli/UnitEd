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
    this.unit = unitExp(unit, exponent);
    this.exponent = exponent;

//    if (resultUnit == null)
//    {
//      this.resultUnit = unit;
//    }
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
   * Parses out individual units if apart of a conjunction.
   * 
   * @return string array of individual units
   */
  public static String[] separateDashUnits(String unit)
  {
    String[] units = unit.split("-");
    return units;
  }

  /**
   * Parses out individual units if apart of a conjunction.
   * 
   * @return string array of individual units
   */
  public static String[] separateSlashUnits(String unit)
  {
    String[] units = unit.split("/");
    return units;
  }

  private String unitExp(String unit, int exponent) {
    
    if (unit.equals("") || unit == null) {
      
      return "";
    }
    
    String e = String.valueOf(exponent);
    String exp = "";
    
    char[] c = e.toCharArray();
    
    for (int i = 0; i < e.length(); i++)
    {
      
      c[i] = e.charAt(i);
    }
    
    for (char ch : c)
    {
      
      switch (ch)
      {
        
        case '0':
          
          exp += ("\u2070");
          break;
          
        case '1':
          
          exp += ("\u00B9");
          break;
          
        case '2':
          
          exp += ("\u00B2");
          break;

        case '3':
          
          exp += ("\u00B3");
          break;

        case '4':
          
          exp += ("\u2074");
          break;

        case '5':
          
          exp += ("\u2075");
          break;

        case '6':
          
          exp += ("\u2076");
          break;

        case '7':
          
          exp += ("\u2077");
          break;

        case '8':
          
          exp += ("\u2078");
          break;

        case '9':
          
          exp += ("\u2079");
          break;

        default:
          
          break;
      }
    }
    
    if (exp.equals("\u00B9"))
    {
      
      exp = "";
    }
    
    String r = "";
    
    for (int i = 0; i < unit.length(); i++)
    {
      
      if (Character.isLetter(unit.charAt(i)))
      {
        
        r += unit.charAt(i);
      
      } else
      {
        
        r += exp + unit.charAt(i);
      }
    }
    
    return r + exp;
  }
}
