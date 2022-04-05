package utilities;

/**
 * Operation Format Exception class.
 * 
 * @author Team 22
 * @version 04-06-2022
 *
 */
public class OperationFormatException extends Exception {
  
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @param error for the error message
	 */
	public OperationFormatException(final String error)
	{
		super(error);
	}

}
