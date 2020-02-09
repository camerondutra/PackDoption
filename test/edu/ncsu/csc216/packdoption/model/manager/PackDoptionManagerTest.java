/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ensures the proper functionality of the PackDoptionManager class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class PackDoptionManagerTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		assertTrue(manager instanceof PackDoptionManager);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#newList()}.
	 */
	@Test
	public void testNewList() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.newList();
		assertTrue(manager.getRescueList().size() == 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#isChanged()}.
	 */
	@Test
	public void testIsChanged() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setChanged(true);
		assertTrue(manager.isChanged());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#getFilename()}.
	 */
	@Test
	public void testGetFilename() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setFilename("ianfright.txt");
		assertEquals("ianfright.txt", manager.getFilename());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#setChanged(boolean)}.
	 */
	@Test
	public void testSetChanged() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setChanged(true);
		assertTrue(manager.isChanged());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#setFilename(java.lang.String)}.
	 */
	@Test
	public void testSetFilename() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setFilename("ianfright.txt");
		assertEquals("ianfright.txt", manager.getFilename());
		try {
			manager.setFilename(null);
			fail();
		} catch ( IllegalArgumentException e) {
			//
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#loadFile(java.lang.String)}.
	 */
	@Test
	public void testLoadFile() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setFilename("test-files/sample-updated.md");
		manager.loadFile("test-files/sample-updated.md");
		assertEquals("Ms. Wuf's Rescue", manager.getRescueList().getRescue(0).toString());
		try {
			manager.loadFile(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#saveFile(java.lang.String)}.
	 */
	@Test
	public void testSaveFile() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setFilename("test-files/sample-updated.md");
		manager.saveFile("test-files/saveFile.md");
		assertEquals("Ms. Wuf's Rescue", manager.getRescueList().getRescue(0).toString());
		try {
			manager.saveFile(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(null, e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.manager.PackDoptionManager#getRescueList()}.
	 */
	@Test
	public void testGetRescueList() {
		PackDoptionManager manager = PackDoptionManager.getInstance();
		manager.setFilename("test-files/sample-updated.md");
		manager.loadFile("test-files/sample-updated.md");
		assertEquals("Ms. Wuf's Rescue", manager.getRescueList().getRescue(0).toString());
	}

}
