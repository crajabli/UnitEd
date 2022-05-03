package calculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import utilities.Operand;
import utilities.OperationFormatException;

/**
 * Unit class.
 * 
 * @author David Nguyen
 * @version 04-20-2022
 */
public class Unit
{

  private static final String DASH = "-";
  private static final String SLASH = "/";
  private static ArrayList<String> numerator;
  private static ArrayList<String> denominator;
  /**
   * Method throws an exception if different units.
   * 
   * @param leftOp
   *          represents left operand
   * @param rightOp
   *          represents right operand
   * @throws OperationFormatException
   *           when units are the same
   */
  public static void sameUnitException(final Operand leftOp, final Operand rightOp)
      throws OperationFormatException
  {
    if (!leftOp.getUnit().equals(rightOp.getUnit()))
    {
      throw new OperationFormatException("Units must be the same for this operation");
    }
  }
  
  /**
   * Method cancels out or adds units to each other.
   * 
   * @param unit for the unit
   * @param operator for the operator
   * @param check true means it is calculating final expression with two non empty operands
   * 
   * @return the final unit
   */
  public static String calculateUnits(final String unit, final String operator, final boolean check)
  {
    
    numerator = new ArrayList<String>();
    denominator = new ArrayList<String>();
    
    String clone;
    
    if (!check)
    {
      
      clone = unwrap(unit);
    
    } else 
    {
      
      clone = unit;
    }
    
    System.out.println("This is the clone: " + clone);
    
    char c = '-';
    
    if (operator.equals(SLASH))
    {
      
      clone = reverse(clone);
      c = '/';
    }
    
    String temp = "";
    String digit = "";
    
    // Separate units of the numerator and denominator of the left operand.
    
    for (int i = 0; i < clone.length(); i++)
    {
      
      char t = clone.charAt(i);
      
      if (Character.isDigit(t))
      {
        
        digit += t;
        
      } else if (Character.isLetter(t))
      {
        
        temp += t;
      
      } else if (t != '^')
      {
        
        if (!digit.equals(""))
        {
          
          unformat(temp, digit, c);
          digit = "";
          temp = "";
        
        } else
        {
          
          if (c == '-')
          {
              
            numerator.add(temp);
            
          } else
          {
              
            denominator.add(temp);
          }
            
          temp = "";
        }
        
        c = t;
      }
    }
    
    if (Character.isDigit(clone.charAt(clone.length() - 1)))
    {
      
      unformat(temp, digit, c);
    
    } else
    {
    
      if (c == '-')
      {
        
        numerator.add(temp);
      
      } else
      {
        
        denominator.add(temp);
      }
    }
    
    // Cancel out unit if it appears on numerator and denominator
    checkDuplicate(numerator, denominator);
    
    if (check)
    {
      if (numerator.size() == 0 && denominator.size() > 0)
      {
        
        numerator.add("1");
      }
    }
    
    String result = "";
    
    for (String s : numerator)
    {
      
      result += s + DASH;
    }
    
    if (denominator.size() > 0)
    {
      
      if (!result.equals(""))
      {
        
        result = result.substring(0, result.length() - 1) + SLASH;
      }
      
      for (String s : denominator)
      {
        
        result += s + SLASH;
      }
    }
    
    if (!result.equals(""))
    {
      
      result = result.substring(0, result.length() - 1);
    }
    
    return result;
  }
  
  /**
   * Helper method to remove duplicate units.
   * 
   * @param list1 for the list of units on the numerator
   * @param list2 for the list of units on the denominator
   */
  private static void checkDuplicate(final ArrayList<String> list1, final ArrayList<String> list2)
  {
    
    ArrayList<String> temp = new ArrayList<String>(list1);
    
    for (String t : temp)
    {
      
      if(list2.contains(t))
      {
          
        list1.remove(t);
        list2.remove(t);
      }
    }
  }
  
  /**
   * Method formats the result.
   * 
   * @param expression for the expression
   * 
   * @return the formatted result
   */
  public static String format(final String expression)
  {
    
    TreeMap<String, Integer> mapNumerator = new TreeMap<String, Integer>();
    TreeMap<String, Integer> mapDenominator = new TreeMap<String, Integer>();
    
    char c = '-';
    String temp = "";
    
    for (int i = 0; i < expression.length(); i++)
    {
      
      char t = expression.charAt(i);
      
      if (t == '-' || t == '/')
      {
        
        if (c == '-')
        {
          
          int n = 1;
          
          if (mapNumerator.containsKey(temp))
          {
            
            n = mapNumerator.get(temp) + 1;
          }
          
          mapNumerator.put(temp, n);

        } else
        {
          
          int n = 1;
          
          if (mapDenominator.containsKey(temp))
          {
            
            n = mapDenominator.get(temp) + 1;
          }
          
          mapDenominator.put(temp, n);
        }
        
        c = t;
        temp = "";
        
      } else
      {
        
        temp += t;
      }
    }
    
    if (c == '-')
    {
      
      int n = 1;
      
      if (mapNumerator.containsKey(temp))
      {
        
        n = mapNumerator.get(temp) + 1;
      }
      
      mapNumerator.put(temp, n);

    } else
    {
      
      int n = 1;
      
      if (mapDenominator.containsKey(temp))
      {
        
        n = mapDenominator.get(temp) + 1;
      }
      
      mapDenominator.put(temp, n);
    }
    
    String r = "";
    
    for (Map.Entry<String, Integer> e : mapNumerator.entrySet())
    {
      
      if (e.getValue() > 1)
      {
        
        r += unicode(e.getKey(), e.getValue());
      
      } else
      {
        
        r += e.getKey();
      }
      
      r += '-';
    }
    
    if (mapDenominator.size() != 0)
    {
      
      r = r.substring(0, r.length() - 1) + '/';
      
      for (Map.Entry<String, Integer> e : mapDenominator.entrySet())
      {
        
        if (e.getValue() > 1)
        {
          
          r += unicode(e.getKey(), e.getValue());
        
        } else
        {
          
          r += e.getKey();
        }
        
        r += '/';
      }
    }
    
    if (!r.equals(""))
    {
      
      if (r.charAt(r.length() - 1) == '/' || r.charAt(r.length() - 1) == '-')
      {
        
        r = r.substring(0, r.length() - 1);
      }
    }
    
    return r;
  }
  
  /**
   * Method unformats the expression.
   * 
   * @param unit for the unit
   * @param power for the power
   * @param operator for the operator
   */
  private static void unformat(final String unit, final String power, final char operator)
  {
    
    int n = Integer.parseInt(power);
    
    if (operator == '-')
    {
      
      for (int i = 0; i < n; i++)
      {
        
        numerator.add(unit);
      }
    
    } else 
    {
      
      for (int i = 0; i < n; i++)
      {
        
        denominator.add(unit);
      }
    }
  }
  
  /**
   * Method changes the / to - and - to /.
   * 
   * @param unit for the unit
   * 
   * @return the string
   */
  private static String reverse(final String unit)
  {
    
    String r = "";
    
    for (int i = 0; i < unit.length(); i++)
    {
      
      char t = unit.charAt(i);
      if (t == '-')
      {
        
        r += '/';
      
      } else if (t == '/')
      {
        
        r += '-';
      
      } else 
      {
        
        r += t;
      }
    }
    
    return r;
  }
  
  /**
   * Private helper method to convert to unicode.
   * 
   * @param unit for the unit
   * @param n for the number
   * 
   * @return the exponent
   */
  public static String unicode(final String unit, final int n)
  {
    
    String e = String.valueOf(n);
    String exp = "";
    
    char[] c = new char[e.length()];
    
    for (int i = 0; i < e.length(); i++)
    {
      
      c[i] = e.charAt(i);
    }
    
    for (char ch : c)
    {
      
      switch (ch)
      {
        
        case '0':
          
          exp +=("\u2070");
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
    
    return unit + exp;
  }
  
  /**
   * Method to convert all exponents to ^.
   * 
   * @param unit for the unit
   * 
   * @return the result
   */
  public static String unwrap(final String unit)
  {
    
    String r = "";
    
    for (int i = 0; i < unit.length(); i++)
    {
      
      r += unit.charAt(i);
    }
    
    
    if (r.contains("\u2070"))
    {
      
      r = r.replace("\u2070", "0");
    }
    
    if (r.contains("\u00B9"))
    {
      
      r = r.replace("\u00B9", "1");
    }
    
    if (r.contains("\u00B2"))
    {
      
      r = r.replace("\u00B2", "2");
    }
    
    if (r.contains("\u00B3"))
    {
      
      r = r.replace("\u00B3", "3");
    }
    
    if (r.contains("\u2074"))
    {
      
      r = r.replace("\u2074", "4");
    }
    
    if (r.contains("\u2075"))
    {
      
      r = r.replace("\u2075", "5");
    }
    
    if (r.contains("\u2076")) 
    {

      r = r.replace("\u2076", "6");
    }
    
    if (r.contains("\u2077")) 
    {
      
      r = r.replace("\u2077", "7");
    }
    
    if (r.contains("\u2078")) 
    {

      r = r.replace("\u2078", "8");
    } 

    if (r.contains("\u2079"))
    {

      r = r.replace("\u2079", "9");
    }
    
    boolean check = false;
    String rs = "";
    
    for (int i = 0; i < r.length(); i++)
    {
      
      if (Character.isDigit(r.charAt(i)))
      {
        
        if (!check)
        {
          
          rs += '^';
          check = true;
        }
        
        rs += r.charAt(i);
        
      } else
      {
        
        rs += r.charAt(i);
        check = false;
      }
    }
    
    System.out.println("This is rs: " + rs);
    
    return rs;
  }
}
