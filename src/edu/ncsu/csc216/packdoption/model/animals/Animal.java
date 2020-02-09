package edu.ncsu.csc216.packdoption.model.animals;

import java.util.Objects;

import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;


/**
 * The Class Animal is responsible for holding all the information necessary for the specific animal.
 * This includes things like name, birthday, etc that will be needed for the proper functionality of
 * the program. Also implemented are getters and setters for all necessary information fields to have easy
 * access to them as well as equals, hash code, and to string methods that will allow for easy comparison and
 * display of the animals.   
 * 
 * @author Cameron Dutra
 * @author Ian Fright 
 */
public abstract class Animal implements Comparable<Animal> {
	
	/** The name of the animal */
	private String name;
	
	/** Whether or not the animal is house trained */
	private boolean houseTrained;
	
	/** Whether or not the animal is good with kids. */
	private boolean goodWithKids;
	
	/** Whether or not the animal is adopted */
	private boolean adopted;
	
	/** The owner's info */
	private String owner;
	
	/** The notes for the animal */
	private SortedLinkedList<Note> notes;
	
	/** The size of the animal */
	private Size size;
	
	/** The date the animal entered the rescue. */
	private Date dateEnterRescue;
	
	/** The birthday of the animal. */
	private Date birthday;
	
	/** The date adopted. */
	private Date dateAdopted;
	
	/**
	 * The Enum AgeCategory that holds the different age categories for the animals
	 */
	public enum AgeCategory { YOUNG, ADULT, SENIOR }

	/**
	 * The Enum Size for different sizes of animals
	 */
	public enum Size { SMALL, MEDIUM, LARGE }
	
	/**
	 * Instantiates a new animal.
	 *
	 * @param name the name of the animal
	 * @param birthday the birthday of the animal
	 * @param size the size of the animal
	 * @param houseTrained whether or not the animal is house trained
	 * @param goodWithKids whether or not the animal is good with kids
	 * @param notes the notes for the animal
	 * @param dateEnterRescue the date the animal entered the rescue
	 * @param adopted whether or not the animal was adopted
	 * @param dateAdopted the date adopted
	 * @param owner the owner
	 */
	// Constructor 1
	public Animal(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids, SortedLinkedList<Note> notes, Date dateEnterRescue, 
	       boolean adopted, Date dateAdopted, String owner) {
		this(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue);
		if (!adopted && (dateAdopted != null || owner != null)) {
			throw new IllegalArgumentException();
		}
		
		if (adopted && (dateAdopted == null || owner == null)) {
			throw new IllegalArgumentException();
		}
		
		if (dateAdopted != null && dateAdopted.compareTo(dateEnterRescue) < 0) {
			throw new IllegalArgumentException();
		}

		if (owner != null && (owner.isBlank() || owner.contains("\n") || owner.contains(","))) {
			throw new IllegalArgumentException();
		}

		
		this.adopted = adopted;
		if (dateAdopted != null) {
			this.dateAdopted = dateAdopted;
		}
		if (owner != null) {
			this.owner = owner.trim();
		}
	}
	

	/**
	 * Instantiates a new animal.
	 *
	 * @param name the name of the animal
	 * @param birthday the birthday of the animal
	 * @param size the size of the animal
	 * @param houseTrained whether or not the animal is house trained
	 * @param goodWithKids whether or not the animal is good with kids
	 * @param notes the notes for the animal
	 * @param dateEnterRescue the date the animal entered the rescue
	 */
	// Constructor 2
	public Animal(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids, SortedLinkedList<Note> notes, Date dateEnterRescue) {
		if (name == null || name.isBlank() || name.contains("\n") || name.contains(",")) {
			throw new IllegalArgumentException();
		}
		
		if (birthday == null) {
			throw new IllegalArgumentException();
		}
		
		if (size == null) {
			throw new IllegalArgumentException();
		}
		
		if (notes == null) {
			throw new IllegalArgumentException();
		}
		
		if (dateEnterRescue == null) {
			throw new IllegalArgumentException();
		}
		
		if (dateEnterRescue.compareTo(birthday) < 0) {
			throw new IllegalArgumentException();
		}
		
				
		this.name = name;
		this.birthday = birthday;
		this.size = size;
		this.houseTrained = houseTrained;
		this.goodWithKids = goodWithKids;
		this.notes = notes;
		this.dateEnterRescue = dateEnterRescue;
		this.adopted = false;
		this.dateAdopted = null;
		this.owner = null;
	}
	
	/**
	 * Sets the adoption info.
	 *
	 * @param adopted whether or not the animal has been adopted
	 * @param dateAdopted the date that the animal was adopted
	 * @param owner the owner's information
	 */
	public void setAdoptionInfo( boolean adopted, Date dateAdopted, String owner) {
		if (!adopted && (dateAdopted != null || owner != null)) {
			throw new IllegalArgumentException();
		}
		
		if (adopted && (dateAdopted == null || owner == null)) {
			throw new IllegalArgumentException();
		}
		
		if (dateAdopted.compareTo(dateEnterRescue) < 0) {
			throw new IllegalArgumentException();
		}
		
		if (owner.isBlank() || owner.contains("\n") || owner.contains(",")) {
			throw new IllegalArgumentException();
		}
		
		this.adopted = adopted;
		this.dateAdopted = dateAdopted;
		this.owner = owner;
	}

	/**
	 * Gets the size of the animal.
	 *
	 * @return the size of the animal
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Sets the size of the animal.
	 *
	 * @param size the size to set
	 */
	public void setSize(Size size) {
		if (size == null) {
			throw new IllegalArgumentException();
		}
		this.size = size;
	}

	/**
	 * Gets the name of the animal.
	 *
	 * @return the name of the animal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the owner's info.
	 *
	 * @return the owner info
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public SortedLinkedList<Note> getNotes() {
		return notes;
	}

	/**
	 * Gets the date the animal entered the rescue.
	 *
	 * @return the date the animal entered the rescue
	 */
	public Date getDateEnterRescue() {
		return dateEnterRescue;
	}

	/**
	 * Gets the animal's birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Gets the date the animal was adopted.
	 *
	 * @return the dateAdopted
	 */
	public Date getDateAdopted() {
		return dateAdopted;
	}
	
	/**
	 * Checks if is the animal is house trained.
	 *
	 * @return true, if the animal is house trained
	 */
	public boolean isHouseTrained() {
		return houseTrained;
	}
	
	/**
	 * Checks if is the animal is good with kids.
	 *
	 * @return true, if the animal is good with kids
	 */
	public boolean isGoodWithKids() {
		return goodWithKids;
	}
	
	/**
	 * Command called when the animal has been adopted.
	 *
	 * @return true, if successful
	 */
	public boolean adopted() {
		return adopted;
	}
	
	/**
	 * Adds a note to the list of notes.
	 *
	 * @param note the note
	 * @return true, if successful
	 */
	public boolean addNote(Note note) {
		if (note != null && !notes.contains(note)) {
			notes.add(note);
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Compares two animals to one another for sorting purposes.
	 *
	 * @param other the animal
	 * @return how the two animals compare to one another
	 */
	public int compareTo(Animal other) {
		if (this.birthday.compareTo(other.birthday) != 0) {
			return this.birthday.compareTo(other.birthday);
		} else {
			return this.name.compareTo(other.name);
		}
	}
	
	/**
	 * Creates a String representation of the current Animal object.
	 *
	 * @return the string representation
	 */
	public String toString() {
		return name + " (" + birthday.toString() + ")\n" + notes.toString();
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(birthday, name);
	}

	/**
	 * Gets the age of the animal.
	 *
	 * @param today today's date
	 * @return the age of the animal
	 */
	public int getAge(Date today) {
		if (today == null || today.compareTo(birthday) < 0) {
			throw new IllegalArgumentException();
		} else {
			return birthday.yearsTo(today);
		}
	}

	/**
	 * Gets the days available for adoption.
	 *
	 * @param today today's date
	 * @return the days available for adoption
	 */
	public int getDaysAvailableForAdoption(Date today) {
		if (today == null || today.compareTo(dateEnterRescue) < 0) {
			throw new IllegalArgumentException();
		} else if (adopted) {
			return -1;
		} else {
			return dateEnterRescue.daysTo(today);
		}
	}
	
	/**
	 * Determines if two Animal objects are the same as one another
	 *
	 * @param obj the Animal passed in to determine equality
	 * @return true, if equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(name, other.name);
	}


	/**
	 * Gets the animal as an array of Strings.
	 *
	 * @param d the date
	 * @return the animal as array of Strings
	 */
	public abstract String[] getAnimalAsArray(Date d);

	/**
	 * Gets the age category of the animal.
	 *
	 * @param d the date
	 * @return the age category of the animal
	 */
	public abstract AgeCategory getAgeCategory(Date d);
	
}