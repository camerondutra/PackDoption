package edu.ncsu.csc216.packdoption.model.manager;

import edu.ncsu.csc216.packdoption.model.io.PackDoptionReader;
import edu.ncsu.csc216.packdoption.model.io.PackDoptionWriter;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;


/**
 * The purpose of the PackDoptionManager class is to interact with the GUI of the
 * program and provide the information that is necessary for the user to see. Some of
 * the functionality that PackDoptionManager includes is ability to get the instance
 * of itself in order to see what information is held in the current file. The class
 * also has the ability to export and import files for use by the system.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class PackDoptionManager {
	
	/** The filename of the file where information is stored */
	private String filename;
	
	/** Whether or not the manager was changed */
	private boolean changed;
	
	/** The list of rescues for the manager to utilize */
	private RescueList rescues;
	
	/** The instance of the PackDoptionManager*/
	private static PackDoptionManager instance;
	
	/**
	 * Creates a new list of rescues and changes changed field to false
	 */
	public PackDoptionManager() {
		newList();
		this.changed = false;
	}
	/**
	 * Gets the single instance of PackDoptionManager.
	 *
	 * @return single instance of PackDoptionManager
	 */
	public static PackDoptionManager getInstance() {
		if (instance == null) {
			instance = new PackDoptionManager();
		}
		return instance;
	}
	
	/**
	 * Constructs a new RescueList
	 */
	public void newList() {
		rescues = new RescueList();
	}
	
	/**
	 * Checks if the field of changed is true or false
	 *
	 * @return whether or not the changed field is true
	 */
	public boolean isChanged() {
		return changed;
	}
	
	/**
	 * Gets the filename field.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Sets the changed field.
	 *
	 * @param changed the new changed field
	 */
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	/**
	 * Sets the filename to based on the specified filename with whitespace removed.
	 *
	 * @param filename the new filename to set the current filename to
	 * @throws IllegalArgumentException if filename is only whitespace or null
	 */
	public void setFilename(String filename) {
		if (filename == null || filename.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.filename = filename.trim();
	}
	
	/**
	 * Loads information into the system from the specified file with help from IO classes
	 * for the program.
	 *
	 * @param filename the filename to load information from
	 */
	public void loadFile(String filename) {
		this.setFilename(filename);
		try {
			rescues = PackDoptionReader.readRescueListFile(filename);
			this.changed = false;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	}
	
	/**
	 * Saves information from the system to the specified file with help from IO classes
	 * for the program.
	 *
	 * @param filename the filename to save to
	 * @throws IllegalArgumentException if there is an issue writing to the file
	 */
	public void saveFile(String filename) {
		try {
			PackDoptionWriter.writeRescueFile(filename, rescues);
			this.changed = false;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Gets the rescue list.
	 *
	 * @return the rescue list
	 */
	public RescueList getRescueList() {
		return rescues;
	}
}