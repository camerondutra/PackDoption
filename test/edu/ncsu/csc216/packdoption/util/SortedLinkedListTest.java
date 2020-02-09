/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.packdoption.util.SortedLinkedList.Node;


/**
 * Ensures the proper functionality of the SortedLinkedList class
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class SortedLinkedListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("a");
		temp.add("c");
		temp.add("d");
		int hash = temp.hashCode();
		
		SortedLinkedList<String> temp1 = new SortedLinkedList<String>();
		temp1.add("a");
		temp1.add("c");
		temp1.add("d");
		int hash1 = temp1.hashCode();
		
		assertTrue(hash == hash1);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#SortedLinkedList()}.
	 */
	@Test
	public void testSortedLinkedList() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		assertTrue(temp != null);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#size()}.
	 */
	@Test
	public void testSize() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("a");
		temp.add("c");
		temp.add("d");
		assertTrue(temp.size() == 3);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		assertTrue(temp.isEmpty());
		temp.add("a");
		assertFalse(temp.isEmpty());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#contains(java.lang.Comparable)}.
	 */
	@Test
	public void testContains() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("d");
		assertTrue(temp.contains("d"));
		temp.add("a");
		temp.add("c");
		assertTrue(temp.contains("c"));
		assertFalse(temp.contains("z"));
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("d");
		temp.add("a");
		temp.add("hello");
		temp.add("b");
		temp.add("c");
		assertEquals("a", temp.get(0));
		assertEquals("c", temp.get(2));
		assertEquals("b", temp.get(1));
		assertEquals("d", temp.get(3));
		assertEquals("hello", temp.get(4));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("d");
		temp.add("a");
		temp.add("b");
		temp.add("c");
		temp.remove(3);
		assertEquals("a", temp.get(0));
		assertEquals("c", temp.get(2));
		assertEquals("b", temp.get(1));
		assertEquals(3, temp.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#indexOf(java.lang.Comparable)}.
	 */
	@Test
	public void testIndexOf() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("d");
		temp.add("a");
		temp.add("hello");
		temp.add("sup");
		temp.add("zop");
		assertEquals(0, temp.indexOf("a"));
		assertEquals(1, temp.indexOf("d"));
		assertEquals(2, temp.indexOf("hello"));
		assertEquals(3, temp.indexOf("sup"));
		assertEquals(4, temp.indexOf("zop"));
		assertEquals(-1, temp.indexOf("yellow"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("a");
		temp.add("c");
		temp.add("d");
		
		
		SortedLinkedList<String> temp1 = new SortedLinkedList<String>();
		temp1.add("a");
		temp1.add("c");
		temp1.add("d");
		
		assertTrue(temp.equals(temp1));
		
		SortedLinkedList<String> temp2 = new SortedLinkedList<String>();
		temp2.add("a");
		temp2.add("c");
		temp2.add("e");
		
		assertFalse(temp.equals(temp2));
		
		Node<String> node1 = new Node<String>("cam", null);
		Node<String> node2 = new Node<String>(null, null);
		assertFalse(node2.equals(node1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#toString()}.
	 */
	@Test
	public void testToString() {
		SortedLinkedList<String> temp = new SortedLinkedList<String>();
		temp.add("a");
		temp.add("c");
		String me = temp.toString();
		assertTrue(me.charAt(0) == '-');
		assertTrue(me.charAt(1) == 'a');
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.SortedLinkedList#iterator()}.
	 */
	@Test
	public void testIterator() {
		SortedLinkedList<String> itt = new SortedLinkedList<String>();
		SimpleListIterator<String> it = itt.iterator();
		assertTrue(it != null);
		itt.add("a");
		itt.add("b");
		itt.add("c");
	}
	
	

}
