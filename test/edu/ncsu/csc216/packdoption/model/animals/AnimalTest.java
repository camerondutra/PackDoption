/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.animals;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Ensures the proper functionality of the Animal class
 * 
 * @author Cameron Dutra
 * @author IanFright2

 *
 */
public class AnimalTest {
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#Animal(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	public void testAnimalStringDateSizeBooleanBooleanSortedLinkedListOfNoteDateBooleanDateString() {
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
		
		try {
			new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2, true, testDate2, "");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		Date testDate3 = new Date(1, 4, 2020);
		try {
			new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate3, true, testDate2, "Cameron");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate3, true, testDate2, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate3, false, testDate2, "Cameron");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#Animal(java.lang.String, edu.ncsu.csc216.packdoption.util.Date, edu.ncsu.csc216.packdoption.model.animals.Animal.Size, boolean, boolean, edu.ncsu.csc216.packdoption.util.SortedLinkedList, edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testAnimalStringDateSizeBooleanBooleanSortedLinkedListOfNoteDate() {
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
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#setAdoptionInfo(boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	public void testSetAdoptionInfo() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDate3 = new Date(1, 4, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		testCat.setAdoptionInfo(true, testDate3, "Cameron");
		assertEquals("Cameron", testCat.getOwner());
		
		try {
			testCat.setAdoptionInfo(false, null, "Cameron");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			testCat.setAdoptionInfo(true, null, "Cameron");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getSize()}.
	 */
	@Test
	public void testGetSize() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals(Size.MEDIUM, testCat.getSize());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#setSize(edu.ncsu.csc216.packdoption.model.animals.Animal.Size)}.
	 */
	@Test
	public void testSetSize() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals(Size.MEDIUM, testCat.getSize());
		testCat.setSize(Size.SMALL);
		assertEquals(Size.SMALL, testCat.getSize());
		
		try {
			testCat.setSize(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getName()}.
	 */
	@Test
	public void testGetName() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals("Cane", testCat.getName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getOwner()}.
	 */
	@Test
	public void testGetOwner() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDate3 = new Date(1, 4, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		testCat.setAdoptionInfo(true, testDate3, "Cameron");
		assertEquals("Cameron", testCat.getOwner());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getNotes()}.
	 */
	@Test
	public void testGetNotes() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals(notes, testCat.getNotes());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getDateEnterRescue()}.
	 */
	@Test
	public void testGetDateEnterRescue() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals(testDate2, testCat.getDateEnterRescue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getBirthday()}.
	 */
	@Test
	public void testGetBirthday() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals(testDate1, testCat.getBirthday());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getDateAdopted()}.
	 */
	@Test
	public void testGetDateAdopted() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDate3 = new Date(1, 4, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		testCat.setAdoptionInfo(true, testDate3, "Cameron");
		assertEquals(testDate3, testCat.getDateAdopted());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#isHouseTrained()}.
	 */
	@Test
	public void testIsHouseTrained() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertTrue(testCat.isHouseTrained());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#isGoodWithKids()}.
	 */
	@Test
	public void testIsGoodWithKids() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertTrue(testCat.isGoodWithKids());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#adopted()}.
	 */
	@Test
	public void testAdopted() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDate3 = new Date(1, 4, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		testCat.setAdoptionInfo(true, testDate3, "Cameron");
		assertTrue(testCat.adopted());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#addNote(edu.ncsu.csc216.packdoption.util.Note)}.
	 */
	@Test
	public void testAddNote() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		Date testDateNote2 = new Date(2, 4, 2020);
		Note note2 = new Note(testDateNote2, "Test message 2");
		testCat.addNote(note2);
		assertEquals(notes, testCat.getNotes());
		
		try {
			testCat.addNote(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#compareTo(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	public void testCompareTo() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		
		Date testDate3 = new Date(11, 3, 2019);
		Date testDate4 = new Date(1, 3, 2020);
		Date testDateNote2 = new Date(1, 5, 2020);
		Note note2 = new Note(testDateNote2, "Test message 2");
		SortedLinkedList<Note> notes2 = new SortedLinkedList<Note>();
		notes.add(note2);
		Cat testCat2 = new Cat("Blake", testDate3, Size.MEDIUM, true, true, notes2, testDate4);
		
		assertEquals(-1, testCat2.compareTo(testCat));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		
		Date testDate3 = new Date(11, 3, 2019);
		Date testDate4 = new Date(1, 3, 2020);
		Date testDateNote2 = new Date(1, 5, 2020);
		Note note2 = new Note(testDateNote2, "Test message 2");
		SortedLinkedList<Note> notes2 = new SortedLinkedList<Note>();
		notes.add(note2);
		Date birthday = new Date("11/5/2019");
		Cat testCat2 = new Cat("Cane", testDate3, Size.MEDIUM, true, true, notes2, testDate4);
		Cat testCat3 = new Cat("Cam", testDate3, Size.MEDIUM, true, true, notes2, testDate4);
		Cat testCat4 = new Cat("Cane", birthday, Size.MEDIUM, true, true, notes2, testDate4);

		assertTrue(testCat2.equals(testCat));
		assertFalse(testCat2.equals(testCat3));
		assertFalse(testCat2.equals(testCat4));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#toString()}.
	 */
	@Test
	public void testToString() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		assertEquals("Cane (11/3/2019)\n" + notes.toString(), testCat.toString());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getAge(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetAge() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		Date today = new Date(11, 14, 2021);
		assertEquals(2, testCat.getAge(today));
		
		try {
			testCat.getAge(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#getDaysAvailableForAdoption(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetDaysAvailableForAdoption() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		Date today = new Date(11, 14, 2021);
		assertEquals(686, testCat.getDaysAvailableForAdoption(today));
		
		try {
			today = new Date(11, 3, 2019);
			Date birthday = new Date(1, 3, 2020);
			Cat testCat2 = new Cat("Cane", birthday, Size.MEDIUM, true, true, notes, testDate2);
			testCat2.getDaysAvailableForAdoption(today);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.animals.Animal#hashCode(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testHashCode() {
		Date testDate1 = new Date(11, 3, 2019);
		Date testDate2 = new Date(1, 3, 2020);
		Date testDateNote = new Date(1, 4, 2020);
		Note note = new Note(testDateNote, "Test message");
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		notes.add(note);
		Cat testCat = new Cat("Cane", testDate1, Size.MEDIUM, true, true, notes, testDate2);
		
		Date testDate3 = new Date(11, 3, 2019);
		Date testDate4 = new Date(1, 3, 2020);
		Date testDateNote2 = new Date(1, 5, 2020);
		Note note2 = new Note(testDateNote2, "Test message 2");
		SortedLinkedList<Note> notes2 = new SortedLinkedList<Note>();
		notes.add(note2);
		Cat testCat2 = new Cat("Cane", testDate3, Size.MEDIUM, true, true, notes2, testDate4);
		
		assertEquals(testCat.hashCode(), testCat2.hashCode());
	}
}
