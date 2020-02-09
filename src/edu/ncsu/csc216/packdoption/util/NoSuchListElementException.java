package edu.ncsu.csc216.packdoption.util;

/**
 * The Class NoSuchListElementException extends an Exception and is thrown 
 * in another class to show that an element that is being searched for does
 * not exist in the given list.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class NoSuchListElementException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new no such list element exception with a default message.
	 */
	public NoSuchListElementException() {
		super("No such element in list.");
	}
	
	/**
	 * Instantiates a new no such list element exception with a custom message.
	 *
	 * @param message the message
	 */
	public NoSuchListElementException(String message) {
		super(message);
	}
}
