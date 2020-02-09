/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.animals;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.packdoption.model.animals.Animal.AgeCategory;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Ensures the proper functionality of the Cat class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class CatTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Cat#getAnimalAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
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
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		String[] array = new String[7];
		Date today = new Date(11, 14, 2021);
		assertEquals(2, testCat.getAge(today));
		array[0] = "Cane";
		array[1] = "Cat";
		array[2] = "11/3/2019";
		array[3] = "2";
		array[4] = "YOUNG";
		array[5] = "No";
		array[6] = "686";
		assertEquals(array, testCat.getAnimalAsArray(today));
		
		Cat testCat2 = new Cat("Cam", testDate1, Size.MEDIUM, true, true, notes, testDate2, true, testDate2, "Cameron");
		assertTrue(testCat2.adopted());
		array[0] = "Cam";
		array[1] = "Cat";
		array[2] = "11/3/2019";
		array[3] = "2";
		array[4] = "YOUNG";
		array[5] = "Yes";
		array[6] = "";
		assertEquals(array, testCat2.getAnimalAsArray(today));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Cat#getAgeCategory(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetAgeCategory() {
		Date testDate1 = new Date(11, 3, 2010);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		Date today = new Date(11, 14, 2021);
		assertEquals(AgeCategory.SENIOR, testCat.getAgeCategory(today));
		
		testDate1 = new Date(11, 3, 2017);
		Cat testCat2 = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals(AgeCategory.ADULT, testCat2.getAgeCategory(today));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Cat#Cat(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testCatStringDateSizeBooleanBooleanSortedLinkedListOfNoteDate() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		try {
			Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
			assertEquals("Cane", testCat.getName());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Cat#Cat(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	public void testCatStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBooleanDateString() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		try {
			Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, true, testDate2, "Cameron");
			assertEquals("Cane", testCat.getName());
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

}
