/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.animals;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.packdoption.model.animals.Animal.AgeCategory;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Ensures the proper functionality of the Dog class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class DogTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#getAnimalAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAnimalAsArray() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Dog testDog = new Dog("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, Breed.BEAGLE);
		String[] array = new String[7];
		Date today = new Date(11, 14, 2021);
		assertEquals(2, testDog.getAge(today));
		array[0] = "Cane";
		array[1] = "Dog";
		array[2] = "11/3/2019";
		array[3] = "2";
		array[4] = "YOUNG";
		array[5] = "No";
		array[6] = "686";
		assertEquals(array, testDog.getAnimalAsArray(today));
		
		Dog testDog2 = new Dog("Cam", testDate1, Size.MEDIUM, true, true, notes, testDate2, true, testDate2, "Cameron", Breed.BEAGLE);
		array[0] = "Cam";
		array[1] = "Dog";
		array[2] = "11/3/2019";
		array[3] = "2";
		array[4] = "YOUNG";
		array[5] = "Yes";
		array[6] = "";
		assertEquals(array, testDog2.getAnimalAsArray(today));

	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#getAgeCategory(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetAgeCategory() {
		Date testDate1 = new Date(11, 3, 2010);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Dog testDog = new Dog("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, Breed.BEAGLE);
		Date today = new Date(11, 14, 2021);
		assertEquals(AgeCategory.SENIOR, testDog.getAgeCategory(today));
		
		//testDate1 = new Date(11,3,2010);
		Dog testDog2 = new Dog("Cane", testDate1, Size.LARGE, true, true, notes, testDate2, Breed.BEAGLE);
		assertEquals(AgeCategory.SENIOR, testDog2.getAgeCategory(today));
		
		Dog testDog3 = new Dog("Cane", testDate1, Size.SMALL, true, true, notes, testDate2, Breed.BEAGLE);
		assertEquals(AgeCategory.SENIOR, testDog3.getAgeCategory(today));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#Dog(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String, edu.ncsu.csc216.packdoption.model.animals.Dog.Breed)}.
	 */
	@Test
	public void testDogStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBooleanDateStringBreed() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		try {
			Dog testDog = new Dog("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, Breed.BEAGLE);
			assertEquals("Cane", testDog.getName());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#Dog(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Dog.Breed)}.
	 */
	@Test
	public void testDogStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBreed() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		try {
			Dog testDog = new Dog("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, true, testDate2, "Cameron", Breed.BEAGLE);
			assertEquals("Cane", testDog.getName());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Dog#getBreed()}.
	 */
	@Test
	public void testGetBreed() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Dog testDog = new Dog("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, Breed.BEAGLE);
		assertEquals(Breed.BEAGLE, testDog.getBreed());
	}

}
