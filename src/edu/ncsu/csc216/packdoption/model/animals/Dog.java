package edu.ncsu.csc216.packdoption.model.animals;

import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * The Class Dog will extend the animal class and is responsible for holding information
 * that is specific to dogs and not any other animal that might be within the rescue. There
 * is also functionality implemented to get information from the Dog Class.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class Dog extends Animal {
	
	/**
	 * The Enum Breed.
	 */
	public enum Breed { /** The beagle. */
 BEAGLE, /** The bulldog. */
 BULLDOG, /** The french bulldog. */
 FRENCH_BULLDOG, /** The german shepherd. */
 GERMAN_SHEPHERD, /** The pointer german shorthaired. */
 POINTER_GERMAN_SHORTHAIRED, /** The poodle. */
 POODLE, /** The retriever golden. */
 RETRIEVER_GOLDEN, /** The retriever labrador. */
 RETRIEVER_LABRADOR, /** The rottweiler. */
 ROTTWEILER, /** The yorkshire terrier. */
 YORKSHIRE_TERRIER, /** The mixed. */
 MIXED, /** The other. */
 OTHER }
	
	private Breed breed;

	/**
	 * Instantiates a new dog.
	 *
	 * @param name the name of the dog
	 * @param birthday the birthday of the dog
	 * @param size the size of the dog
	 * @param houseTrained whether or not the dog is house trained
	 * @param goodWithKids whether or not the dog is good with kids
	 * @param notes the notes for the dog
	 * @param dateEnterRescue the date the dog entered the rescue
	 * @param adopted whether or not the dog is adopted
	 * @param dateAdopted the date adopted
	 * @param owner the owner info
	 * @param breed the dog's breed
	 */
	public Dog(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids, SortedLinkedList<Note> notes,
			Date dateEnterRescue, boolean adopted, Date dateAdopted, String owner, Breed breed) {
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, adopted, dateAdopted, owner);
		if (breed == null) {
			throw new IllegalArgumentException();
		}
		this.breed = breed;
	}

	/**
	 * Instantiates a new dog.
	 *
	 * @param name the name of the dog
	 * @param birthday the birthday of the dog
	 * @param size the size of the dog
	 * @param houseTrained whether or not the dog is house trained
	 * @param goodWithKids whether or not the dog is good with kids
	 * @param notes the notes for the dog
	 * @param dateEnterRescue the date the dog entered the rescue
	 * @param breed the breed that the dog is
	 */
	public Dog(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids, SortedLinkedList<Note> notes,
			Date dateEnterRescue, Breed breed) {
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue);
		this.breed = breed;
	}
	
	/**
	 * Gets the animal as array of Strings.
	 *
	 * @param today today's date
	 * @return the animal as array of Strings
	 */
	@Override
	public String[] getAnimalAsArray(Date today) {
		if (today == null || today.compareTo(getBirthday()) < 0) {
			throw new IllegalArgumentException();
		} else {
			String[] animal = new String[7];
			animal[0] = getName();
			animal[1] = "Dog";
			animal[2] = getBirthday().toString();
			animal[3] = Integer.toString(getAge(today));
			animal[4] = getAgeCategory(today).toString();
			if (adopted()) {
				animal[5] = "Yes";
			} else {
				animal[5] = "No";
			}
			if (adopted()) {
				animal[6] = "";
			} else {
				animal[6] = Integer.toString(getDateEnterRescue().daysTo(today));
			}
			return animal;
		}
	}

	/**
	 * Gets the age category of the dog.
	 *
	 * @param today today's date
	 * @return the age category of the dog
	 */
	@Override
	public AgeCategory getAgeCategory(Date today) {
		if (today == null || today.compareTo(getBirthday()) < 0) {
			throw new IllegalArgumentException();
		} 
		if (getSize().equals(Size.SMALL)) {
			if (getAge(today) < 4) {
				return AgeCategory.YOUNG;
			} else if (getAge(today) >= 4 && getAge(today) < 9) {
				return AgeCategory.ADULT;
			} else if (getAge(today) >= 9) {
				return AgeCategory.SENIOR;
			}
		} else if (getSize().equals(Size.MEDIUM)) {
			if (getAge(today) < 3) {
				return AgeCategory.YOUNG;
			} else if (getAge(today) >= 3 && getAge(today) < 9) {
				return AgeCategory.ADULT;
			} else if (getAge(today) >= 9) {
				return AgeCategory.SENIOR;
			}
		} else if (getSize().equals(Size.LARGE)) {
			if (getAge(today) < 3) {
				return AgeCategory.YOUNG;
			} else if (getAge(today) >= 3 && getAge(today) < 6) {
				return AgeCategory.ADULT;
			} else if (getAge(today) >= 6) {
				return AgeCategory.SENIOR;
			}
		}

		return null;
	}

	/**
	 * Gets the breed.
	 *
	 * @return the breed
	 */
	public Breed getBreed() {
		return breed;
	}
	
	/**
	 * helper method to generate all of the information that is held within the Dog object
	 * 
	 * @return the String generated that represents all of the Dog's current info
	 */
	public String toStringAll() {
		String animalString = "";
		Breed dogBreed = getBreed();
		
		if (!adopted()) {
			animalString += "Dog," + getName() + "," + getBirthday().toString() + "," + getSize().toString() + "," + isHouseTrained() + 
					"," + isGoodWithKids() + "," + getDateEnterRescue().toString() + "," + dogBreed.toString() + ",NOTES";
		} else {
			animalString += "Dog," + getName() + "," + getBirthday().toString() + "," + getSize().toString() + "," + isHouseTrained() + 
					"," + isGoodWithKids() + "," + getDateEnterRescue().toString() + "," + adopted() + "," +
					getDateAdopted().toString() + "," + getOwner() + "," + dogBreed.toString() + ",NOTES";
		}
		for (int i = 0; i < getNotes().size(); i++) {
			animalString += "," + getNotes().get(i).toString();
		}
		return animalString;
	}
	
}
