package exceptions;

/**
 * Custom exception for no values inputed. 
 * 
 * @author Maxine Payton
 * @version 4/19/22
 */
public class NoValueEnteredException extends Exception

{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public NoValueEnteredException()
  {
    super();

  }

  public NoValueEnteredException(final String message)
  {
    super(message);

  }
}
