/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.rescue;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Animal.Size;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog.Breed;
import edu.ncsu.csc216.packdoption.util.Date;
import edu.ncsu.csc216.packdoption.util.Note;
import edu.ncsu.csc216.packdoption.util.SortedLinkedList;

/**
 * Ensures the proper functionality of the Rescue class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class RescueTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#Rescue(java.lang.String)}.
	 */
	@Test
	public void testRescue() {
		Rescue netApp = new Rescue("netapp");
		assertTrue(netApp.getName().equals("netapp"));
		try {
			new Rescue(" ");
			fail();
		} catch ( IllegalArgumentException e) {
			//
		}
		try {
			new Rescue(null);
			fail();
		} catch ( IllegalArgumentException e) {
			//
		}
		
		try {
			new Rescue("help\n");
			fail();
		} catch ( IllegalArgumentException e) {
			//
		}
	
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getName()}.
	 */
	@Test
	public void testGetName() {
		Rescue netApp = new Rescue("netapp");
		assertTrue(netApp.getName().equals("netapp"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#addAnimal(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	public void testAddAnimal() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		
		assertEquals(bob, netApp.getAnimal(0));
		assertFalse(netApp.addAnimal(bob));
		try {
			netApp.addAnimal(null);
			fail();
		} catch (IllegalArgumentException e) {
			//
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAnimal(int)}.
	 */
	@Test
	public void testGetAnimalInt() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		assertEquals(bob, netApp.getAnimal(0));
		
		try {
			netApp.getAnimal(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//
		}
		
		try {
			netApp.getAnimal(3);
		} catch (IndexOutOfBoundsException e) {
			//
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#contains(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	public void testContains() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		assertTrue(netApp.contains(bob));	
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#addNote(edu.ncsu.csc216.packdoption.model.animals.Animal, edu.ncsu.csc216.packdoption.util.Note)}.
	 */
	@Test
	public void testAddNote() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		Dog bob2 = new Dog("Bob2", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		Note topNote = new Note(dateEnterRescue, "Animal has been entered into rescue");
		netApp.addNote(bob, topNote);
		
		assertTrue(bob.getNotes().contains(topNote));
		assertFalse(netApp.addNote(bob2, topNote));
		
		try {
			netApp.addNote(null, topNote);
		} catch (IllegalArgumentException e) {
			//
		}
		
		try {
			netApp.addNote(bob, null);
		} catch (IllegalArgumentException e) {
			//
		}
		
		try {
			netApp.addNote(bob, topNote);
		} catch (IllegalArgumentException e) {
			//
		}
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#setAdoptionInfo(edu.ncsu.csc216.packdoption.model.animals.Animal, boolean, edu.ncsu.csc216.packdoption.util.Date, java.lang.String)}.
	 */
	@Test
	public void testSetAdoptionInfo() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		Date dateAdopted = new Date(12, 25, 2020);
		
		netApp.setAdoptionInfo(bob, true, dateAdopted, "Ian");
		assertEquals("Ian", bob.getOwner());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#numAnimals()}.
	 */
	@Test
	public void testNumAnimals() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		assertEquals(bob, netApp.getAnimal(0));
		assertEquals(1, netApp.numAnimals()); 
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#numAnimalsAvailable()}.
	 */
	@Test
	public void testNumAnimalsAvailable() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		assertEquals(1, netApp.numAnimalsAvailable());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#numAnimalsAdopted()}.
	 */
	@Test
	public void testNumAnimalsAdopted() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		Date dateAdopted = new Date(12, 25, 2020);
		
		netApp.setAdoptionInfo(bob, true, dateAdopted, "Ian");
		assertEquals(1, netApp.numAnimalsAdopted());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#animalsAvailable()}.
	 */
	@Test
	public void testAnimalsAvailable() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		
		assertTrue(netApp.animalsAvailable().contains(bob));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableCats()}.
	 */
	@Test
	public void testAvailableCats() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Cat bob = new Cat("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue);
		
		netApp.addAnimal(bob);
		
		assertTrue(netApp.availableCats().contains(bob));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableDogs()}.
	 */
	@Test
	public void testAvailableDogs() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		
		assertTrue(netApp.availableDogs().contains(bob));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#animalsAdopted()}.
	 */
	@Test
	public void testAnimalsAdopted() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		Dog bob2 = new Dog("Bob2", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		netApp.addAnimal(bob2);
		Date dateAdopted = new Date(12, 25, 2020);
		netApp.setAdoptionInfo(bob, true, dateAdopted, "Ian");
		
		assertEquals(bob, netApp.animalsAdopted().get(0));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableAnimalsDayRange(edu.ncsu.csc216.packdoption.util.Date, int, int)}.
	 */
	@Test
	public void testAvailableAnimalsDayRange() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date birthday2 = new Date(11, 5, 2019);
		Date dateEnterRescue = new Date(1, 3, 2020);		
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		Dog bob2 = new Dog("Bob2", birthday2, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		netApp.addAnimal(bob);
		netApp.addAnimal(bob2);
		Date today = new Date(2, 20, 2020);
		assertEquals(dateEnterRescue, bob.getDateEnterRescue());
		assertEquals(48, bob.getDaysAvailableForAdoption(today));
		assertEquals(48, bob2.getDaysAvailableForAdoption(today));
		SortedLinkedList<Animal> animals = new SortedLinkedList<Animal>();
		animals.add(bob);
		animals.add(bob2);
		assertEquals(animals, netApp.availableAnimalsDayRange(today, 0, 60));

	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#availableAnimalsAge(edu.ncsu.csc216.packdoption.util.Date, int, int)}.
	 */
	@Test
	public void testAvailableAnimalsAge() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2010);
		Date birthday2 = new Date(11, 5, 2019);
		Date dateEnterRescue = new Date(1, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		Dog bob2 = new Dog("Bob2", birthday2, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		netApp.addAnimal(bob);
		netApp.addAnimal(bob2);
		Date today = new Date(2, 20, 2020);
		assertEquals(dateEnterRescue, bob.getDateEnterRescue());
		assertEquals(48, bob.getDaysAvailableForAdoption(today));
		assertEquals(48, bob2.getDaysAvailableForAdoption(today));
		SortedLinkedList<Animal> animals = new SortedLinkedList<Animal>();
		animals.add(bob2);
		assertEquals(animals, netApp.availableAnimalsAge(today, 0, 3));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#compareTo(edu.ncsu.csc216.packdoption.model.rescue.Rescue)}.
	 */
	@Test
	public void testCompareTo() {
		Rescue netApp = new Rescue("netapp");
		Rescue sAs = new Rescue("sas");
		Rescue apple = new Rescue("apple");
		assertEquals(-1, netApp.compareTo(sAs));
		assertEquals(1, netApp.compareTo(apple));
		assertEquals(0, netApp.compareTo(netApp));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#toString()}.
	 */
	@Test
	public void testToString() {
		Rescue netApp = new Rescue("netapp");
		Rescue sAs = new Rescue("sas");
		assertEquals("netapp", netApp.toString());
		assertEquals("sas", sAs.toString());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAnimalsAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetAnimalsAsArray() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date birthday2 = new Date(11, 5, 2019);
		Date dateEnterRescue = new Date(12, 5, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog aob = new Dog("Aob", birthday2, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		Dog bob2 = new Dog("Bob2", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		netApp.addAnimal(aob);
		netApp.addAnimal(bob2);
		
		Date today = new Date(12, 31, 2019);
		
		String[][] array = netApp.getAnimalsAsArray(today);
		assertEquals("Aob", array[0][0]);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAppointmentsAsArray(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetAppointmentsAsArray() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2019);
		Date birthday2 = new Date(11, 5, 2019);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog simon = new Dog("Simon", birthday2, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		Dog bear = new Dog("Bear", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bear);
		netApp.addAnimal(simon);
		
		netApp.addAppointment(simon);
		netApp.addAppointment(bear);
		
		
		Date today = new Date(12, 31, 2020);
		
		String[][] array = netApp.getAppointmentsAsArray(today);
		assertEquals("Bear", array[1][0]);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#addAppointment(edu.ncsu.csc216.packdoption.model.animals.Animal)}.
	 */
	@Test
	public void testAddAppointment() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		netApp.addAppointment(bob);
		
		assertEquals(1, netApp.getAppointments().size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAppointments()}.
	 */
	@Test
	public void testGetAppointments() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		netApp.addAppointment(bob);
		
		assertEquals(1, netApp.getAppointments().size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.rescue.Rescue#getAnimal(java.lang.String, edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testGetAnimalStringDate() {
		Rescue netApp = new Rescue("netapp");
		Date birthday = new Date(12, 3, 2019);
		Date dateEnterRescue = new Date(12, 3, 2020);
		boolean houseTrained = true;
		boolean goodWithKids = true;
		SortedLinkedList<Note> notes = new SortedLinkedList<Note>();
		Dog bob = new Dog("Bob", birthday, Size.MEDIUM, houseTrained, goodWithKids, notes,
				dateEnterRescue, Breed.OTHER);
		
		netApp.addAnimal(bob);
		
		assertEquals(bob, netApp.getAnimal("Bob", birthday));
	}

}
