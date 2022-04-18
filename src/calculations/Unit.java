package calculations;

import java.util.ArrayList;
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
   * 
   * @return the final unit
   */
  public static String calculateUnits(final String unit, final String operator)
  {
    
    numerator = new ArrayList<String>();
    denominator = new ArrayList<String>();
    
    String temp = "";
    char c = '-';
    
    // Separate units of the numerator and denominator of the left operand.
    
    if (operator.equals(SLASH))
    {
      
      for (int i = 0; i < unit.length(); i++)
      {
        
        char t = unit.charAt(i);
        
        if (t == '-' || t == '/')
        {
          
          if (c == '-')
          {
              
            denominator.add(temp);
            
          } else
          {
              
            numerator.add(temp);
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
        
        denominator.add(temp);
      
      } else
      {
        
        numerator.add(temp);
      }
      
    } else
    {
      
      for (int i = 0; i < unit.length(); i++)
      {
        
        char t = unit.charAt(i);
        
        if (t == '-' || t == '/')
        {
          
          if (c == '-')
          {
            
            numerator.add(temp);
          
          } else if (c == '/')
          {
            
            denominator.add(temp);
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
        
        numerator.add(temp);
      
      } else
      {
        
        denominator.add(temp);
      }
    }
    
    // Cancel out unit if it appears on numerator and denominator
    checkDuplicate(numerator, denominator);
    
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
    char hat = '^';
    
    for (Map.Entry<String, Integer> e : mapNumerator.entrySet())
    {
      
      if (e.getValue() > 1)
      {
        
        r += e.getKey() + hat + e.getValue();
      
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
          
          r += e.getKey() + hat + e.getValue();
        
        } else
        {
          
          r += e.getKey();
        }
        
        r += '/';
      }
    }
    
    if (!r.equals(""))
    {
     
      r = r.substring(0, r.length() - 1);
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
}
