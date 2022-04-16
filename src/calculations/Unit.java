package calculations;

import java.util.ArrayList;

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
      throw new OperationFormatException("Units must be the same for this" + "operation");
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
    
    ArrayList<String> numerator = new ArrayList<String>();
    ArrayList<String> denominator = new ArrayList<String>();
    
    String temp = "";
    char c = '-';
    
    // Separate units of the numerator and denominator of the left operand
    String slash = "/";
    String dash = "-";
    
    if (operator.equals(slash))
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
          
          } else
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
      
      result += s + dash;
    }
    
    if (denominator.size() > 0)
    {
      
      result = result.substring(0, result.length() - 1) + slash;
      
      for (String s : denominator)
      {
        
        result += s + slash;
      }
    }
    
    return result.substring(0, result.length() - 1);
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
}
