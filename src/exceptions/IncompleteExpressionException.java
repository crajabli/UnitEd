package exceptions;

/**
 * Custom exception for an incomplete expression. 
 *  5 / =
 *  -5 * 5
 * @author Maxine Payton
 * @version 4/19/22
 */
public class IncompleteExpressionException extends Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public IncompleteExpressionException()
  {
    super();

  }

  public IncompleteExpressionException(final String message)
  {
    super(message);

  }
}
