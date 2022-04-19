package exceptions;

/**
 * Custom exception for incomplete units. 
 * @author Maxine Payton
 * @version 4/19/22
 *
 */
public class IncompleteUnitsException extends Exception

{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public IncompleteUnitsException()
  {
    super();

  }

  public IncompleteUnitsException(final String message)
  {
    super(message);

  }
}
