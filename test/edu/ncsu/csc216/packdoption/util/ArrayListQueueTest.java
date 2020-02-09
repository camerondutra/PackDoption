/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Ensures the proper functionality of the ArrayListQueue class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 *
 */
public class ArrayListQueueTest {
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.ArrayListQueue#ArrayListQueue(java.lang.Object)}.
	 */
	@Test
	public void testArrayListQueue() {
		try {
			ArrayListQueue<String> testQueue = new ArrayListQueue<String>();
			assertEquals(0, testQueue.size());
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.ArrayListQueue#add(java.lang.Object)}.
	 */
	@Test
	public void testAdd() {
		ArrayListQueue<String> testQueue = new ArrayListQueue<String>();
		assertTrue(testQueue.add("Cameron"));
		assertEquals(1, testQueue.size());
		try {
			testQueue.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		assertTrue(testQueue.add("Ian"));
		assertEquals(2, testQueue.size());
		assertEquals("Cameron", testQueue.element());
		assertEquals("Cameron", testQueue.remove());
		assertEquals("Ian", testQueue.remove());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.ArrayListQueue#remove()}.
	 */
	@Test
	public void testRemove() {
		ArrayListQueue<String> testQueue = new ArrayListQueue<String>();
		assertTrue(testQueue.add("Cameron"));
		assertEquals(1, testQueue.size());
		assertEquals("Cameron", testQueue.remove());
		assertEquals(0, testQueue.size());
		try {
			testQueue.remove();
			fail();
		} catch (NoSuchListElementException e) {
			assertEquals("No such element in list.", e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.ArrayListQueue#element()}.
	 */
	@Test
	public void testElement() {
		ArrayListQueue<String> testQueue = new ArrayListQueue<String>();
		assertTrue(testQueue.add("Cameron"));
		assertEquals(1, testQueue.size());
		assertEquals("Cameron", testQueue.element());
		testQueue.remove();
		try {
			testQueue.element();
			fail();
		} catch (NoSuchListElementException e) {
			assertEquals("No such element in list.", e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.ArrayListQueue#size()}.
	 */
	@Test
	public void testSize() {
		ArrayListQueue<String> testQueue = new ArrayListQueue<String>();
		assertTrue(testQueue.add("Cameron"));
		assertEquals(1, testQueue.size());
		assertEquals("Cameron", testQueue.remove());
		assertEquals(0, testQueue.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.ArrayListQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		ArrayListQueue<String> testQueue = new ArrayListQueue<String>();
		assertTrue(testQueue.isEmpty());
	}

}
