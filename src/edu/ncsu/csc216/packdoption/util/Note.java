package edu.ncsu.csc216.packdoption.util;

/**
 * The Class Note that has a date and other information for the purpose of recording information and allowing
 * it to follow a specific object. Rather than just having strings being kept in a large list and being hard
 * to navigate through, each note is its own object and has methods inside of its class to help the programmer use
 * note inside of another class.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class Note implements Comparable<Note> {
	
	/** The message. */
	private String message;
	
	/** The date. */
	private Date date;

	/**
	 * Instantiates a new note.
	 *
	 * @param date the date
	 * @param message the message
	 */
	public Note(Date date, String message) {
		if (date == null || message == null) {
			throw new IllegalArgumentException("Invalid note");
		}
		
		if (message.isBlank() || message.contains("\n") || message.contains(",")) {
			throw new IllegalArgumentException("Invalid note");
		}
		String newMessage = message.trim();
		this.date = date;
		this.message = newMessage;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	
	/**
	 * To string that creates a string that represents the notes by its date and its message
	 * 
	 * @return the string
	 */
	public String toString() {
		return this.date.toString() + " " + this.message;
	}
	
	/**
	 * Generates a unique code that is used later for comparison purposes
	 * 
	 * @return the hashed value of the object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	
	/**
	 * Compare to another note and returns a specific value for sorting purposes.
	 *
	 * @param otherNote the other note to compare this note to
	 * @return the comparison value between the comparison of two notes
	 */
	@Override
	public int compareTo(Note otherNote) {
		if (this.date.equals(otherNote.date)) {
			if (this.message.compareTo(otherNote.message) > 0) {
				return 1;
			} else if (this.message.compareTo(otherNote.message) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
		return this.date.compareTo(otherNote.getDate());
	}

	/**
	 * Equals method to check if the two objects are the same.
	 *
	 * @param obj the note object to compare this one to
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
}
