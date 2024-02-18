package boletinJUnit;

public class NoSuchItemException extends Exception {
	
	private static final long serialVersionUID = 3150476351422572299L;

	public NoSuchItemException(String message) {
		super(message);
	}
	
}