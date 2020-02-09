package edu.ncsu.csc216.packdoption.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;

import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.model.rescue.Rescue;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * The Class PackDoptionReader that is responsible for reading in a RescueList
 * full of the individual rescues from a particular file. This class functionality is built off of
 * the String class .split() method. Instead of having to call .next all the time .split() allows me
 * to easily grab the information from a file line by line and then compare specific indexes for information
 * I is supposed to be there. If the information in the String array created by the .split() method contains data
 * that is now allowed, the Reader will throw out an exception.
 * 
 * The readrescueListFile checks for an empty or null filename.
 * Uses a try/catch to ensure the filename/file exists and throws an exception if it does not
 * The rest of the code is contained inside the try/catch block
 * FileReader is created and grabs all the data from the file
 * A boolean variable is used to compare with and check if the first line is blank. Is not used after the first loop through
 * A while loop is created and runs until there are no more lines left in the file
 * If the nextLine is not empty then the nextLine is pulled into a string
 * The line is then compared to with three diffren't symbols to determine if it is a Rescue, Animal, Appointment, or other line
 * An if statement is used and delegates how each line needs to be split up and compared to again as there are four possible 
 * animal lines formats, one rescue, and one appointment
 * Inside of the if statement for the animal line there is another if to determine if it is a cat or dog, then if it is adopted or not.
 * Each branch calls a helper method that then takes the passed in information and creates a new animal specific to that format.
 * Rescues are added by using RescueList add method
 * Animals are added by adding to the last created Rescue in the list and using Rescues add method
 * Appointments are added by creating a new Animal and comparing to Animals in the last created Rescue then added to that Rescue
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class PackDoptionReader {
	
	/**
	 * Instantiates a new PackDoption reader.
	 */
	public PackDoptionReader() {
		//Does nothing (used for static referencing)
	}
	
	/**
	 * Read in a RescueList from a specified file and return that
	 * RescueList.
	 * "#" represents a new Rescue
	 * "*" is a new animal
	 * "-" are appointments
	 * Read Class Javadoc for better detail
	 *
	 * @param fileName the filename of the file the user wants to load from.
	 * @return the rescue list found from the file
	 * @throws IllegalArgumentException for incorrectly formated files with the message "Unable to load file.".
	 */
	public static RescueList readRescueListFile(String fileName) {
		if( fileName == null || fileName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Scanner fileReader = null;
		Boolean rescueWithoutASpace = false;
		try {
			fileReader = new Scanner(new FileInputStream(fileName));
			RescueList rescue = new RescueList();
			boolean firstLine = true;
			// While the file has a next line
			while (fileReader.hasNextLine()) {
				String originalLine = fileReader.nextLine();
				if( !originalLine.isEmpty()) {
					firstLine = false;
					char firstSign = originalLine.charAt(0);
					String nextLine = originalLine.substring(2);
					
					// If the line is a rescue
					if(firstSign == '#') {
						if(rescueWithoutASpace) {
							fileReader.close();
							throw new IllegalArgumentException("Unable to load file.");
						}
						rescueWithoutASpace = true;
						rescue.addRescue(getRescue(nextLine));
						
					} else if ( firstSign == '*') {
						if(rescue.size() > 0 ) {
							rescueWithoutASpace = true;
							String[] animalLineData = nextLine.split(",");
							if(!(animalLineData[0].equals("Cat") || animalLineData[0].equals("Dog"))) {
								fileReader.close();
								throw new IllegalArgumentException("Unable to load file.");
							}
							if(animalLineData[7].equals("true")) {
								
								if(isTypeOfBreed(animalLineData[10])) {
									// Call and add animal(Dog Adopted) to last rescue in list
										rescue.getRescue(rescue.size() - 1).addAnimal(getDogAdopted(animalLineData));
									
								} else if(animalLineData[10].equals("NOTES")) {
									// Call and add animal(Cat Adopted) to last rescue in list
									rescue.getRescue(rescue.size() - 1).addAnimal(getCatAdopted(animalLineData));
									
								}
								
							} else if(isTypeOfBreed(animalLineData[7])) { 
								// Call and add animal(Dog Not Adopted) to last rescue in list
								rescue.getRescue(rescue.size() - 1).addAnimal(getDogNotAdopted(animalLineData));
								
							} else if(animalLineData[7].equals("NOTES")) {
								// Call and add animal(Cat Not Adopted) to last rescue in list
								rescue.getRescue(rescue.size() - 1).addAnimal(getCatNotAdopted(animalLineData));
							} else {
								fileReader.close();
								throw new IllegalArgumentException("Unable to load file.");
							}
						} else { 
							fileReader.close();
							throw new IllegalArgumentException("Unable to load file.");
						}
					} else if ( firstSign == '-') {
						if(rescue.size() > 0 ) {
							rescueWithoutASpace = true;
							String[] appointmentlLineData = nextLine.split(",");
							Date temp;
							try {
								temp = new Date(appointmentlLineData[1].trim());
							} catch (Exception e) {
								fileReader.close();
								throw new IllegalArgumentException("Unable to load file.");
							}
							try {
								Animal needsAppointment = rescue.getRescue(rescue.size() - 1).getAnimal(appointmentlLineData[0], temp);
								rescue.getRescue(rescue.size() - 1).addAppointment(needsAppointment);
							} catch ( NullPointerException e) {
								//
							}
						} else {
							fileReader.close();
							throw new IllegalArgumentException("Unable to load file.");
						}
					} else { 
						fileReader.close();
						throw new IllegalArgumentException("Unable to load file.");
					}
				} else {
					if(firstLine) {
						fileReader.close();
						throw new IllegalArgumentException("Unable to load file.");
					}
					rescueWithoutASpace = false;
				}
			}
			
			fileReader.close();
			return rescue;
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Creates and returns a Rescue object based on passed in data.
	 *
	 * @param line the line
	 * @return the rescue
	 */
	private static Rescue getRescue(String line) {
		return new Rescue(line.trim());
	}
	
	/**
	 * Creates and returns a Dog object that is not adopted based on passed in data
	 * Creates a series of variables that are filled with data from known indexes after that
	 * data is checked for being invalid.
	 *
	 * @param line the line of data
	 * @return the dog that is not adopted
	 * @throws IllegalArgumentException for data being passed in that does met the criteria for
	 * appropriate input
	 */
	private static Dog getDogNotAdopted(String[] line) {
		String name = line[1];
		Date birthday;
		try { 
			birthday = new Date(line[2]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		Size size;
		try { 
			size = Size.valueOf(line[3]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		boolean houseTrained;
		boolean goodWithKids;
		if( line[4].contentEquals("true") ) {
			houseTrained = true;
		} else if ( line[4].contentEquals("false")) {
			houseTrained = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		if( line[5].contentEquals("true") ) {
			goodWithKids = true;
		} else if ( line[5].contentEquals("false")) {
			goodWithKids = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		for( int i = 9; i < line.length; i++) {
			notes.add(parseNote(line[i]));
		}
		Date dateEnterRescue;
		try { 
			dateEnterRescue = new Date(line[6]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		Breed breed = Breed.valueOf(line[7].toUpperCase());
		
		
		return new Dog(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, breed);
	}
	
	/**
	 * Creates and returns a Dog object that is adopted based on passed in data.
	 * Creates a series of variables that are filled with data from known indexes after that
	 * data is checked for being invalid.
	 * 
	 * @param line the line of data
	 * @return the dog that is adopted
	 * @throws IllegalArgumentException for data being passed in that does met the criteria for
	 * appropriate input
	 */
	private static Dog getDogAdopted(String[] line) {
		String name = line[1];
		Date birthday;
		try { 
			birthday = new Date(line[2]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		Size size;
		try { 
			size = Size.valueOf(line[3]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		boolean houseTrained;
		boolean goodWithKids;
		if( line[4].contentEquals("true") ) {
			houseTrained = true;
		} else if ( line[4].contentEquals("false")) {
			houseTrained = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		if( line[5].contentEquals("true") ) {
			goodWithKids = true;
		} else if ( line[5].contentEquals("false")) {
			goodWithKids = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		for( int i = 12; i < line.length; i++) {
			notes.add(parseNote(line[i]));
		}
		Date dateEnterRescue;
		try { 
			dateEnterRescue = new Date(line[6]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		boolean adopted = Boolean.parseBoolean(line[7]);
			
		Date dateAdopted;
		try {
			dateAdopted = new Date(line[8]);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		String owner = line[9];
		Breed breed = Breed.valueOf(line[10]);
		
		return new Dog(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, adopted, dateAdopted, owner, breed);
	}
	
	/**
	 * Creates and returns a Cat object that is not adopted based on passed in data.
	 * Creates a series of variables that are filled with data from known indexes after that
	 * data is checked for being invalid.
	 * 
	 * @param line the line of data
	 * @return the cat that is not adopted
	 * @throws IllegalArgumentException for data being passed in that does met the criteria for
	 * appropriate input
	 */
	private static Cat getCatNotAdopted(String[] line) {
		String name = line[1];
		Date birthday;
		try { 
			birthday = new Date(line[2]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		Size size;
		try { 
			size = Size.valueOf(line[3]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		boolean houseTrained;
		boolean goodWithKids;
		if( line[4].contentEquals("true") ) {
			houseTrained = true;
		} else if ( line[4].contentEquals("false")) {
			houseTrained = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		if( line[5].contentEquals("true") ) {
			goodWithKids = true;
		} else if ( line[5].contentEquals("false")) {
			goodWithKids = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		for( int i = 8; i < line.length; i++) {
			notes.add(parseNote(line[i]));
		}
		Date dateEnterRescue;
		try { 
			dateEnterRescue = new Date(line[6]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		return new Cat(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue);
	}
	
	/**
	 * Creates and returns a Cat object that is adopted based on passed in data.
	 * Creates a series of variables that are filled with data from known indexes after that
	 * data is checked for being invalid.
	 * 
	 * @param line the line of data
	 * @return the cat that is adopted
	 * @throws IllegalArgumentException for data being passed in that does met the criteria for
	 * appropriate input
	 */
	private static Cat getCatAdopted(String[] line) {
		String name = line[1];
		Date birthday;
		try { 
			birthday = new Date(line[2]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		Size size;
		try { 
			size = Size.valueOf(line[3]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		boolean houseTrained;
		boolean goodWithKids;
		if( line[4].contentEquals("true") ) {
			houseTrained = true;
		} else if ( line[4].contentEquals("false")) {
			houseTrained = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		if( line[5].contentEquals("true") ) {
			goodWithKids = true;
		} else if ( line[5].contentEquals("false")) {
			goodWithKids = false;
		} else {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		for( int i = 11; i < line.length; i++) {
			notes.add(parseNote(line[i]));
		}
		Date dateEnterRescue;
		try { 
			dateEnterRescue = new Date(line[6]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		// Test for a valid boolean
		boolean adopted = Boolean.parseBoolean(line[7]);
		if(!adopted) {
			throw new IllegalArgumentException();
		}
		//System.out.println(adopted);
		// Test for a valid boolean
		
		Date dateAdopted;
		try {
			dateAdopted = new Date(line[8]);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		String owner = line[9];
		
		return new Cat(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, adopted, dateAdopted, owner);
	}
	
	/**
	 * Checks if is type of breed.
	 *
	 * @param s the String with the input for type of breed
	 * @return true, if is type of breed
	 */
	private static boolean isTypeOfBreed(String s) {
		if( s.equals("BEAGLE") || s.equals("BULLDOG") || s.equals("GERMAN_SHEPHERD") 
				|| s.equals("POINTER_GERMAN_SHORTHAIRED") || s.equals("POODLE") || s.equals("RETRIEVER_GOLDEN") 
				|| s.equals("RETRIEVER_LABRADOR") || s.equals("ROTTWEILER") || s.equals("YORKSHIRE_TERRIER") 
				|| s.equals("MIXED") || s.equals("OTHER") ) {
			return true;
		}
		return false;
	}
	
	/**
	 * Parses the note by trying to create a date for the note and then using the new Note method on the remaining string.
	 *
	 * @param s the String of note information
	 * @return the note to be put into its proper animal
	 * @throws IllegalArgumentException if the date is not a real date
	 */
	private static Note parseNote(String s) {
		String[] noteData = s.split(" ");
		Date dateOfNote;
		try {
			dateOfNote = new Date(noteData[0]);
		} catch ( Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		String noteWords = s.substring(noteData[0].length() + 1);
		Note created = new Note(dateOfNote, noteWords);
		return created;
	}
}
