package edu.ncsu.csc216.packdoption.model.animals;

import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * The Class Cat will extend the animal class and is responsible for holding information
 * that is specific to cats and not any other animal that might be within the rescue. There
 * is also functionality implemented to get information from the Cat Class.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class Cat extends Animal {

	/**
	 * Instantiates a new cat.
	 *
	 * @param name the name of the cat
	 * @param birthday the birthday of the cat
	 * @param size the size of the cat
	 * @param houseTrained whether or not the cat is house trained
	 * @param goodWithKids whether or not the cat is good with kids
	 * @param notes the notes for the cat
	 * @param dateEnterRescue the date that the cat entered the rescue
	 */
	public Cat(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids, SortedLinkedList<Note> notes,
			Date dateEnterRescue) {
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue);
	}
	
	/**
	 * Instantiates a new cat.
	 *
	 * @param name the name of the cat
	 * @param birthday the birthday of the cat
	 * @param size the size of the cat
	 * @param houseTrained whether or not the cat is house trained
	 * @param goodWithKids whether or not the cat is good with kids
	 * @param notes the notes for the cat
	 * @param dateEnterRescue the date that the cat entered the rescue
	 * @param adopted whether or not the cat has been adopted
	 * @param dateAdopted the date adopted
	 * @param owner the owner info
	 */
	public Cat(String name, Date birthday, Size size, boolean houseTrained, boolean goodWithKids, SortedLinkedList<Note> notes,
			Date dateEnterRescue, boolean adopted, Date dateAdopted, String owner) {
		super(name, birthday, size, houseTrained, goodWithKids, notes, dateEnterRescue, adopted, dateAdopted, owner);
	}

	/**
	 * Gets the cat as an array of Strings.
	 *
	 * @param today today's date
	 * @return the cat as an array of Strings
	 */
	@Override
	public String[] getAnimalAsArray(Date today) {
		if (today == null || today.compareTo(getBirthday()) < 0) {
			throw new IllegalArgumentException();
		} else {
			String[] animal = new String[7];
			animal[0] = getName();
			animal[1] = "Cat";
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
	 * Gets the age category of the cat.
	 *
	 * @param today today's date
	 * @return the age category
	 */
	@Override
	public AgeCategory getAgeCategory(Date today) {
		if (today == null || today.compareTo(getBirthday()) < 0) {
			throw new IllegalArgumentException();
		} 
		if (getAge(today) < 4) {
			return AgeCategory.YOUNG;
		} else if (getAge(today) >= 4 && getAge(today) < 9) {
			return AgeCategory.ADULT;
		} else if (getAge(today) >= 9) {
			return AgeCategory.SENIOR;
		}
		return null;
	}
	
	/**
	 * helper method to generate all of the information that is held within the Cat object
	 * 
	 * @return the String generated that represents all of the Cat's current info
	 */
	public String toStringAll() {
		String animalString = "";
		if (!adopted()) {
			animalString += "Cat," + getName() + "," + getBirthday().toString() + "," + getSize().toString() + "," + isHouseTrained() + 
					"," + isGoodWithKids() + "," + getDateEnterRescue().toString() + ",NOTES";
		} else {
			animalString += "Cat," + getName() + "," + getBirthday().toString() + "," + getSize().toString() + "," + isHouseTrained() + 
					"," + isGoodWithKids() + "," + getDateEnterRescue().toString() + "," + adopted() + "," +
					getDateAdopted().toString() + "," + getOwner() + ",NOTES";
		}
		for (int i = 0; i < getNotes().size(); i++) {
			animalString += "," + getNotes().get(i).toString();
		}
		return animalString;
	}

}
