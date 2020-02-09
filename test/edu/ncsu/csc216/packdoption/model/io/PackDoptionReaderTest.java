/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.io;

import static org.junit.Assert.*;


import org.junit.Test;

import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Ensures the proper functionality of the PackDoptionReader class
 *
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class PackDoptionReaderTest {
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.io.PackDoptionReader#readRescueListFile(java.lang.String)}.
	 */
	@Test
	public void testReadRescueListFile() {
		RescueList rscList = new RescueList();
		try {
			 rscList = PackDoptionReader.readRescueListFile("test-files/sample-updated.md");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(2, rscList.size());
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Animal testCat = new Cat("Loki", new Date("3/14/2004"), Size.SMALL, false, true, notes, new Date("4/8/2004"), true, new Date("5/13/2004"), "Ethan and Family");
		assertTrue(rscList.getRescue(0).getAnimal(0).equals(testCat));
		
		assertEquals(3, rscList.getRescue(1).getAppointments().size());
		assertEquals("Jack", rscList.getRescue(1).getAppointments().remove().getName());
		assertEquals("George", rscList.getRescue(1).getAppointments().remove().getName());
		assertEquals("Duke", rscList.getRescue(1).getAppointments().remove().getName());
		
		try {
			PackDoptionReader.readRescueListFile(null);
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-animal.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-rescuesWithoutBlankLine.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-date.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-date2.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-date3.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/dateDog.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/dateDog2.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-boolean.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-boolean2.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-boolean3.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-boolean4.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-boolean5.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-boolean6.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-noRescue.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-noRescue2.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}

		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-booleanAdopt");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		
		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-blankAtFirst.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
		}
		

		try {
			PackDoptionReader.readRescueListFile("test-files/invalid-size.md");
			fail();
		} catch ( IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}

		
	}
}
