package edu.ncsu.csc216.packdoption.model.rescue;

import java.util.Objects;

import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.util.ArrayListQueue;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * The Class Rescue is responsible for holding all information about
 * a rescue that is used throughout the program. It holds all of the current
 * animals that are in the rescue, a queue of their appointments, and the name
 * of the rescue. Methods that are included allow for manipulation of the
 * animals that are in the rescue as well as the ability to filter the results desired
 * from getting information that is stored. Also included are toString methods and compareTo
 * methods that help with displaying information and determining order.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class Rescue implements Comparable<Rescue> {

	/** The name of the rescue */
	private String name;
	
	/** The ArrayListQueue of veterinary appointments */
	private ArrayListQueue<Animal> vetAppointments;
	
	/** The SortedLinkedList of animals  */
	private SortedLinkedList<Animal> animals;
	
	/**
	 * Instantiates a new rescue.
	 *
	 * @param name the name of the new rescue
	 * @throws IllegalArgumentException if name is null or name is whitespace or 
	 * name contains a new line of text
	 */
	public Rescue(String name) {
		if( name == null || name.isBlank() || name.contains("\n")) {
			throw new IllegalArgumentException();
		}
		this.name = name.trim();
		animals = new SortedLinkedList<Animal>();
		vetAppointments = new ArrayListQueue<Animal>();
		
	}
	
	/**
	 * Gets the name of the rescue.
	 * 
	 * @return the name of the rescue
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Adds an animal to the rescue.
	 *
	 * @param animal the animal to add
	 * @return true, if successful
	 * @throws IllegalArgumentException if the animal is null
	 */
	public boolean addAnimal(Animal animal) {
		if(animal == null) {
			throw new IllegalArgumentException();
		}
		if(animals.contains(animal)) {
			return false;
		}
		animals.add(animal);
		return true;
		
	} 
	
	/**
	 * Gets a specific animal in the rescue.
	 *
	 * @param index the index of the animal in the list
	 * @return the animal at the specified index
	 * @throws IndexOutOfBoundsException if the index is less than zero or is greater than the
	 * largest index in the list of animals
	 */
	public Animal getAnimal(int index) {
		if(index < 0 || index > animals.size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		return animals.get(index);
	}
	
	/**
	 * Determines if an animal is in the current rescue.
	 *
	 * @param animal the animal specified to be found
	 * @return true, if animal does exist in current rescue
	 * @throws IllegalArgumentException if the animal passed in is null
	 */
	public boolean contains(Animal animal) {
		if (animal == null) {
			throw new IllegalArgumentException();
		}
		if (animals.contains(animal)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adds a note to a specified animal.
	 *
	 * @param animal the animal to add the note to
	 * @param note the note to add
	 * @return true, if successful
	 * @throws IllegalArgumentException if the animal passed is null or the note passed in is null
	 */
	public boolean addNote(Animal animal, Note note) {
		if( animal == null || note == null) {
			throw new IllegalArgumentException();
		}

		for( int i = 0; i < animals.size(); i++) {
			if(animals.get(i).equals(animal)) {
				animals.get(i).addNote(note);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sets the adoption info as long as the information passed in is valid.
	 *
	 * @param animal the animal being added
	 * @param adopted whether or not the animal has been adopted
	 * @param dateAdopted the date the animal was adopted
	 * @param owner the owners information
	 * @throws IllegalArgumentException if the animal passed in is null
	 */
	public void setAdoptionInfo(Animal animal, boolean adopted, Date dateAdopted, String owner) {
		if (animal == null) {
			throw new IllegalArgumentException();
		}
		if (this.animals.contains(animal)) {
			animal.setAdoptionInfo(adopted, dateAdopted, owner);
		}
	}
	
	/**
	 * Returns the number of animals in the rescue.
	 *
	 * @return the number of animals in the rescue
	 */
	public int numAnimals() {
		return animals.size();
	}
	
	/**
	 * Returns the number of available animals in the rescue.
	 *
	 * @return the number of available animals in the rescue
	 */
	public int numAnimalsAvailable() {
		int counter = 0;
		for (int i = 0; i < numAnimals(); i++) {
			if (!animals.get(i).adopted()) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Returns the number of animals that are adopted from the rescue.
	 *
	 * @return the number of animals that are adopted from the rescue
	 */
	public int numAnimalsAdopted() {
		int counter = 0;
		for (int i = 0; i < numAnimals(); i++) {
			if (animals.get(i).adopted()) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Returns the animals that are available as a SortedLinkedList.
	 *
	 * @return the sorted linked list of available animals
	 */
	public SortedLinkedList<Animal> animalsAvailable() {
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		for (int i = 0; i < numAnimals(); i++) {
			if (!animals.get(i).adopted()) {
				list.add(animals.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Returns the cats that are available as a SortedLinkedList.
	 *
	 * @return the sorted linked list of available cats
	 */
	public SortedLinkedList<Animal> availableCats() {
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		for (int i = 0; i < numAnimals(); i++) {
			if (!animals.get(i).adopted() && animals.get(i) instanceof Cat) {
				list.add(animals.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Returns the dogs that are available as a SortedLinkedList.
	 *
	 * @return the sorted linked list of available dogs
	 */
	public SortedLinkedList<Animal> availableDogs() {
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		for (int i = 0; i < numAnimals(); i++) {
			if (!animals.get(i).adopted() && animals.get(i) instanceof Dog) {
				list.add(animals.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Returns the animals that were adopted from the rescue as a SortedLinkedList.
	 *
	 * @return the sorted linked list of adopted animals in the rescue
	 */
	public SortedLinkedList<Animal> animalsAdopted() {
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		for (int i = 0; i < numAnimals(); i++) {
			if (animals.get(i).adopted()) {
				list.add(animals.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Returns available animals by a given time frame.
	 *
	 * @param today the current date
	 * @param min the minimum number of days to include
	 * @param max the maximum number of days to include
	 * @return the sorted linked list of available animals
	 * @throws IllegalArgumentException if today is null, max is less than min, min is less than
	 * zero, and if today is before the date the animal entered the rescue
	 */
	public SortedLinkedList<Animal> availableAnimalsDayRange(Date today, int min, int max) {
		if (today == null || max < min || min < 0) {
			throw new IllegalArgumentException();
		}
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		for (int i = 0; i < numAnimals(); i++) {
			if (today.compareTo(animals.get(i).getDateEnterRescue()) < 0) {
				throw new IllegalArgumentException();
			}
			if (!animals.get(i).adopted() && animals.get(i).getDaysAvailableForAdoption(today) >= min && 
					animals.get(i).getDaysAvailableForAdoption(today) <= max) {
				list.add(animals.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Returns available animals by a given age.
	 *
	 * @param today the current date
	 * @param min the minimum age to include
	 * @param max the the maximum age to include
	 * @return the sorted linked list of available animals
	 * @throws IllegalArgumentException if today is null, max is less than min, min is less than
	 * zero, and if today is before the animal's birthday
	 */
	public SortedLinkedList<Animal> availableAnimalsAge(Date today, int min, int max) {
		if (today == null || max < min || min < 0) {
			throw new IllegalArgumentException();
		}
		SortedLinkedList<Animal> list = new SortedLinkedList<Animal>();
		for (int i = 0; i < numAnimals(); i++) {
			if (today.compareTo(animals.get(i).getBirthday()) < 0) {
				throw new IllegalArgumentException();
			}
			if (!animals.get(i).adopted() && animals.get(i).getAge(today) >= min && 
					animals.get(i).getAge(today) <= max) {
				list.add(animals.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Compares two rescues to one another based on their name for sorting purposes.
	 *
	 * @param rescue the rescue to check against
	 * @return the a designated number used for sorting purposes
	 */
	public int compareTo(Rescue rescue) {
		if (this.equals(rescue)) {
			return 0;
		}
		int comparison = this.name.compareTo(rescue.name);
		if(comparison < 0) {
			return -1;
		} else if (comparison > 0) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Generates a String version of the current rescue (the name).
	 *
	 * @return the string version of the current rescue
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * Gets the animals in the rescue as a 2D array of Strings.
	 *
	 * @param today the current date
	 * @return the animals as 2D array of Strings
	 */
	public String[][] getAnimalsAsArray(Date today) {
		String[][] animalsArray = new String[numAnimals()][7];
		for (int i = 0; i < numAnimals(); i++) {
			animalsArray[i][0] = this.animals.get(i).getName();
			if (this.animals.get(i) instanceof Cat) {
				animalsArray[i][1] = "Cat";
			} else if (this.animals.get(i) instanceof Dog) {
				animalsArray[i][1] = "Dog";
			}
			animalsArray[i][2] = this.animals.get(i).getBirthday().toString();
			animalsArray[i][3] = Integer.toString(this.animals.get(i).getAge(today));
			animalsArray[i][4] = this.animals.get(i).getAgeCategory(today).toString();
			if (this.animals.get(i).adopted()) {
				animalsArray[i][5] = "Yes";
				animalsArray[i][6] = "";
			} else {
				animalsArray[i][5] = "No";
				animalsArray[i][6] = Integer.toString(this.animals.get(i).getDaysAvailableForAdoption(today));
			}
		}
		return animalsArray;
	}
	
	/**
	 * Gets the appointments in the rescue as 2D array of Strings.
	 *
	 * @param today today's date
	 * @return the appointments as 2D array of Strings
	 */
	public String[][] getAppointmentsAsArray(Date today) {
		String[][] animalsArray = new String[vetAppointments.size()][7];
		for (int i = 0; i < vetAppointments.size(); i++) {
			animalsArray[i][0] = this.vetAppointments.element().getName();
			if (this.vetAppointments.element() instanceof Cat) {
				animalsArray[i][1] = "Cat";
			} else if (this.vetAppointments.element() instanceof Dog) {
				animalsArray[i][1] = "Dog";
			}
			animalsArray[i][2] = this.vetAppointments.element().getBirthday().toString();
			animalsArray[i][3] = Integer.toString(this.vetAppointments.element().getAge(today));
			animalsArray[i][4] = this.vetAppointments.element().getAgeCategory(today).toString();
			if (this.vetAppointments.element().adopted()) {
				animalsArray[i][5] = "Yes";
				animalsArray[i][6] = "";
			} else {
				animalsArray[i][5] = "No";
				animalsArray[i][6] = Integer.toString(this.vetAppointments.element().getDaysAvailableForAdoption(today));
			}
			this.vetAppointments.add(this.vetAppointments.remove());
		}
		return animalsArray;
	}
	
	/**
	 * Adds an appointment to the queue of appointments.
	 *
	 * @param animal the animal that has an appointment
	 * @return true, if successful
	 * @throws NullPointerException if the animal passed in is null
	 */
	public boolean addAppointment(Animal animal) {
		if( animal == null) {
			throw new NullPointerException();
		}
		
		if(!animals.contains(animal)) {
			return false;
		}
		
		boolean duplicate = false;
		
		for( int i = 0; i < vetAppointments.size(); i++) {
			if (vetAppointments.element().equals(animal)) {
				duplicate = true;
			}
			vetAppointments.add(vetAppointments.remove());
		}
		
		if(duplicate) {
			return false;
		}
		
		int beforeAdd = vetAppointments.size();
		this.vetAppointments.add(animal);
		if(vetAppointments.size() == beforeAdd + 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the appointments for all animals.
	 *
	 * @return the appointments as an ArrayListQueue
	 */
	public ArrayListQueue<Animal> getAppointments() {
		return this.vetAppointments;
	}
	
	/**
	 * Gets a specific animal in the rescue.
	 *
	 * @param name the name of the animal
	 * @param birthDay the animal's birthday
	 * @return the animal found
	 * @throws IllegalArgumentException if name is null or birthday is null
	 */
	public Animal getAnimal(String name, Date birthDay) {
		if( name == null || birthDay == null) {
			throw new IllegalArgumentException();
		}
		for( int i = 0; i < animals.size(); i++) {
			if(animals.get(i).getName().equals(name) && animals.get(i).getBirthday().equals(birthDay)) {
				return animals.get(i);
			}
		}
		return null;
	}

	/**
	 * Generates a unique code based on the object in order to keep track
	 * of the specific instance of the object
	 * 
	 * @return the code that correlates with the object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	/**
	 * Determines if two rescues are equivalent to one another based on their name
	 * 
	 * @param obj the object to compare the current rescue to
	 * @return true, if the two objects are equivalent.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rescue))
			return false;
		Rescue other = (Rescue) obj;
		return Objects.equals(name, other.name);
	}
}
