package exceptions;

/**
 * Custom exception for trying to add/subtract with non-like units. 
 *  5 / 0 
 *  
 * @author Maxine Payton
 * @version 5/2/22
 */
public class NotLikeUnitsException extends Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public NotLikeUnitsException()
  {
    super();

  }

  public NotLikeUnitsException(final String message)
  {
    super(message);

  }
}