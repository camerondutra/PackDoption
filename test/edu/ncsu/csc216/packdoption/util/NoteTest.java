/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ensures the proper functionality of the Note class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 */
public class NoteTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#Note(edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	public void testNote() {
		Date testDate1 = new Date(11, 3, 2019);
		try {
			new Note(testDate1, "test message.");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Note(testDate1, "    ");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid note", e.getMessage());
		}
		
		try {
			new Note(null, "test message.");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid note", e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		Date testDate1 = new Date(11, 3, 2019);
		Note testNote = new Note(testDate1, "test message.");
		assertEquals("test message.", testNote.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#getDate()}.
	 */
	@Test
	public void testGetDate() {
		Date testDate1 = new Date(11, 3, 2019);
		Note testNote = new Note(testDate1, "test message.");
		assertEquals(testDate1, testNote.getDate());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#toString()}.
	 */
	@Test
	public void testToString() {
		Date testDate1 = new Date(11, 3, 2019);
		Note testNote = new Note(testDate1, "test message.");
		assertEquals("11/3/2019 test message.", testNote.toString());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals() {
		Date testDate1 = new Date(11, 3, 2019);
		Note testNote = new Note(testDate1, "test message.");
		Date testDate2 = new Date("11/3/2019");
		Note testNote2 = new Note(testDate2, "test message.");
		assertTrue(testNote.equals(testNote2));
		assertFalse(testNote.equals(new Note(testDate1, "message.")));
		assertFalse(testNote == null);
		assertFalse(testNote.equals(new Note(new Date("11/4/2019"), "test message.")));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#compareTo(edu.ncsu.csc216.packdoption.util.Note)}.
	 */
	@Test
	public void testCompareTo() {
		Date testDate1 = new Date(11, 3, 2019);
		Note testNote = new Note(testDate1, "test message.");
		Date testDate2 = new Date("11/6/2019");
		Note testNote2 = new Note(testDate2, "test message.");
		assertEquals(-1, testNote.compareTo(testNote2));
		Note testNote3 = new Note(testDate2, "abc");
		assertEquals(1, testNote2.compareTo(testNote3));
		assertEquals(-1, testNote3.compareTo(testNote2));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Note#hashCode(edu.ncsu.csc216.packdoption.util.Note)}.
	 */
	@Test
	public void testHashCode() {
		Date testDate1 = new Date(11, 3, 2019);
		Note testNote = new Note(testDate1, "test message.");
		Date testDate2 = new Date("11/3/2019");
		Note testNote2 = new Note(testDate2, "test message.");
		assertEquals(testNote.hashCode(), testNote2.hashCode());
	}
}
