package compress;

/**
 * Thrown if the BufferedImage is to small, to save all given informations into
 * it.
 */
public class NotEnoughSpaceException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEnoughSpaceException() {
		super();
	}

	public NotEnoughSpaceException(String arg0) {
		super(arg0);
	}

	public NotEnoughSpaceException(Throwable arg0) {
		super(arg0);
	}

	public NotEnoughSpaceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}