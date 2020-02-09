/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.rescue;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Ensures the proper functionality of the RescueList class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 */
public class RescueListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#RescueList()}.
	 */
	@Test
	public void testRescueList() {
		
		RescueList temp = new RescueList();
		assertEquals(0, temp.size());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#addRescue(edu.ncsu.csc216.packdoption.model.rescue.Rescue)}.
	 */
	@Test
	public void testAddRescueRescue() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		RescueList temp = new RescueList();
		temp.addRescue(netApp);
		assertEquals(1, temp.size());
		try {
			temp.addRescue(netApp);
			fail();
		} catch ( IllegalArgumentException e) {
			// text
		}
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#addRescue(java.lang.String)}.
	 */
	@Test
	public void testAddRescueString() {
		RescueList temp = new RescueList();
		temp.addRescue("sAs");
		assertEquals(1, temp.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#getRescue(int)}.
	 */
	@Test
	public void testGetRescue() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		RescueList temp = new RescueList();
		temp.addRescue(netApp);
		assertEquals(netApp, temp.getRescue(0));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.RescueList#size()}.
	 */
	@Test
	public void testSize() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		RescueList temp = new RescueList();
		temp.addRescue(netApp);
		assertEquals(1, temp.size());
	}

}
