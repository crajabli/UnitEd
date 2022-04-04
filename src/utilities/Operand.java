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
  private int countDash = 0;
  private int countSlash = 0;

  /**
   * Constructor: passed the full user input expression (left op, operator, right op). Parse out
   * left op, operator, right op
   * 
   * Throw exception if no units are found?
   * 
   * @param expression
   *          full user input
   */
  public Operand(final String expression)
  {
    helpParse(expression);
  }

  private void helpParse(final String expression)
  {
    if (expression == null || expression.isEmpty())
    {
      throw new IllegalArgumentException("You didn't enter anything.");
    }

    String noSpace = expression.replaceAll("\\s", " ");
    StringBuilder toBeValue = new StringBuilder();
    StringBuilder toBeUnit = new StringBuilder();

    for (int i = 0; i < noSpace.length(); i++)
    {
      char c = noSpace.charAt(i);
      if (Character.isDigit(c))
      {
        toBeValue = toBeValue.append(c);
      }
      else if (Character.isLetter(c))
      {
        toBeUnit = toBeUnit.append(c);
      }

      if (c == '/')
      {
        countSlash += 1;
      }
      else if (c == '-')
      {
        countDash += 1;
      }

    }

    this.value = BigDecimal.valueOf(Double.parseDouble(toBeValue.toString()));
    this.unit = toBeUnit.toString();
  }

  /**
   * Getter method for operand's values.
   * 
   * @return value
   */
  public BigDecimal getValue()
  {
    return value;
  }

  /**
   * Getter method for operand's values.
   * 
   * @return unit
   */
  public String getUnit()
  {
    if (isUnit()) 
    {
      return this.unit; 
    }
    return null;
  }

  /**
   * Checks if either the left operand's value or right operand's value is negative. WHERE/WHEN TO
   * THROW EXCEPTION
   * 
   * @return true if negative, false if not
   */
  public Boolean isNegative()
  {    
    return value.compareTo(BigDecimal.ZERO) < 0;
  }

  /**
   * Checks if there is a unit in the measure.
   * 
   * @return true if there is a unit.
   */
  public Boolean isValue()
  {
    return value != null && !unit.isEmpty();
  }
  
  /**
   * Checks if there is a unit in the measure.
   * 
   * @return true if there is a unit.
   */
  public Boolean isUnit()
  {
    return unit != null && !unit.isEmpty();
  }

  /**
   * Checks if either value is a fraction. WHERE/WHEN TO THROW EXCEPTION
   * 
   * @return true if fraction, false if not.
   */
  public Boolean isFraction()
  {
    return true;
  }

  /**
   * Check for more than one dash. WHERE/WHEN TO THROW EXCEPTION
   * 
   * @return true if more than one dash
   */
  public Boolean multipleDashes()
  {
    return countDash > 1;
  }

  /**
   * Check for more than one slash. WHERE/WHEN TO THROW EXCEPTION
   * 
   * @return true if more than one slash
   */
  public Boolean multipleSlashes()
  {
    return countSlash > 1;
  }

}
