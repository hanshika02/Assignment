package test2;

public class RentalUnavailableException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8420294522409043847L;
	public RentalUnavailableException(){
		super();
	}
	public RentalUnavailableException(String message) { super(message); }
	public RentalUnavailableException(String message, Throwable cause) { super(message, cause); }
	public RentalUnavailableException(Throwable cause) { super(cause); }
}
