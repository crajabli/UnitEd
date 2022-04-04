package utilities;

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
