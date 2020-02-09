/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  * Ensures the proper functionality of the NoSuchListElement class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 */
public class NoSuchListElementExceptionTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.NoSuchListElementException#NoSuchListElementException()}.
	 */
	@Test
	public void testNoSuchListElementException() {
		NoSuchListElementException nslee = new NoSuchListElementException();
		assertEquals("No such element in list.", nslee.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.NoSuchListElementException#NoSuchListElementException(java.lang.String)}.
	 */
	@Test
	public void testNoSuchListElementExceptionString() {
		NoSuchListElementException nslee = new NoSuchListElementException("Custom Message");
		assertEquals("Custom Message", nslee.getMessage());
	}

}
