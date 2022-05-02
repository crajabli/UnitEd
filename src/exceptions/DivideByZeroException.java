package exceptions;

/**
 * Custom exception for an incomplete expression. 
 *  5 / 0 
 *  
 * @author Maxine Payton
 * @version 5/2/22
 */
public class DivideByZeroException extends Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public DivideByZeroException()
  {
    super();

  }

  public DivideByZeroException(final String message)
  {
    super(message);

  }
}