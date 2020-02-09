/**
 * 
 */
package edu.ncsu.csc216.packdoption.model.io;

import static org.junit.Assert.*;


import org.junit.Test;


import edu.ncsu.csc216.packdoption.model.rescue.RescueList;


/**
 * Ensures the proper functionality of the PackDoptionWriter class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class PackDoptionWriterTest {
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.model.io.PackDoptionWriter#writeRescueFile(java.lang.String, edu.ncsu.csc216.packdoption.model.rescue.RescueList)}.
	 */
	@Test
	public void testWriteRescueFile() {
		RescueList rescuesOriginal = PackDoptionReader.readRescueListFile("test-files/sample-updated.md");
		assertEquals(3, rescuesOriginal.getRescue(1).getAppointments().size());
		assertEquals("Jack", rescuesOriginal.getRescue(1).getAppointments().element().getName());
		try {
			PackDoptionWriter.writeRescueFile("test-files/writerTest.md", rescuesOriginal);
		} catch (IllegalArgumentException e){
			fail();
		}
		try {
			PackDoptionWriter.writeRescueFile("", rescuesOriginal);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to save file.", e.getMessage());
		}
	}

}
