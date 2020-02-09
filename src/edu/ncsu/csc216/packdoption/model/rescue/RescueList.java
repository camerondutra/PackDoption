package edu.ncsu.csc216.packdoption.model.rescue;

import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * The Class RescueList is responsible for holding a SortedLinkedList of all the current
 * rescues that are held within the system and has methods that allow for a rescue to be
 * added, retrieved for use somewhere else and finally returns the total number of rescues
 * that are in the list.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class RescueList {

	/** The list of rescues */
	private SortedLinkedList<Rescue> rescues;
	
	/**
	 * Instantiates a new rescue list.
	 */
	public RescueList() {
		rescues = new SortedLinkedList<Rescue>();
	}
	
	/**
	 * Adds a rescue to the list with a specified Rescue that is passed in.
	 *
	 * @param rescue the rescue that is to be added
	 * @throws IllegalArgumentException if rescue is null or if the rescue is already in the list
	 */
	public void addRescue(Rescue rescue) {
		if( rescue == null ||  rescues.contains(rescue)) {
			throw new IllegalArgumentException();
		}
		rescues.add(rescue);
	}
	
	/**
	 * Adds a rescue to the list with a specified name of a rescue that is passed in.
	 *
	 * @param rescueName the name of the rescue being added
	 * @throws IllegalArgumentException if rescueName is null or rescueName is only whitespace
	 */
	public void addRescue(String rescueName) {
		if( rescueName == null || rescueName.isEmpty() ) {
			throw new IllegalArgumentException();
		}
		Rescue temp = new Rescue(rescueName);
		this.addRescue(temp);
	}
	
	/**
	 * Gets the rescue at a particular index of the list.
	 *
	 * @param idx the index of the rescue in the list
	 * @return the rescue at the specified index
	 * @throws IndexOutOfBoundsException if the index is less than 0
	 */
	public Rescue getRescue(int idx) {
		if( idx < 0 ) {
			throw new IndexOutOfBoundsException();
		}
		return rescues.get(idx);
	}
	
	/**
	 * Returns the total number of rescues in the list
	 *
	 * @return the total number of rescues in the list
	 */
	public int size() {
		return this.rescues.size();
	}	
}