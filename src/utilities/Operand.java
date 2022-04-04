package utilities;

/**
public class Operand
{

  private double value;
  private String unit;
  
  public Operand(String expression)
  {
    
    String[] tokens = expression.split(" ");
    
    if (tokens.length == 1)
    {
      
      String number = "";
      String measure = "";
      
      for (int i = 0; i < tokens[0].length(); i++)
      {
        
        char t = tokens[0].charAt(i);
        
        if (Character.isDigit(t))
        {
          
          number += t;
        
        } else
        {
          
          measure += t;
        }
      }
      
      value = Double.parseDouble(number);
      unit = measure;
      
    } else
    {
      
      value = Double.parseDouble(tokens[0]);
      unit = tokens[1];
    }
  }
  
  public double getValue()
  {
    
    return value;
  }
  
  public String getUnit()
  {
    
    return unit;
  }
}
*/

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
