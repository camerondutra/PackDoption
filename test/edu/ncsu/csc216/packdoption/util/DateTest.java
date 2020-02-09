/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * Ensures the proper functionality of the Date class
 * 
 * @author Cameron Dutra
 * @author IanFright2
 */
public class DateTest {
	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#Date(int, int, int)}.
	 */
	@Test
	public void testDateIntIntInt() {
		try {
			Date testDate = new Date(01, 3, 2019);
			assertEquals(1, testDate.getMonth());
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Date(13, 2, 2020);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date", e.getMessage());
		}
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#Date(java.lang.String)}.
	 */
	@Test
	public void testDateString() {
		try {
			new Date("10/8/2019");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Date("13/3/2020");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date", e.getMessage());
		}
		
		try {
			new Date("11/23");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date", e.getMessage());
		}
		
		try {
			new Date("Hello");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date", e.getMessage());
		}
		
		try {
			new Date("10/18/2019");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Date("9/7/2020");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Date("9/21/2020");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Date("02/29/2020");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		try {
			new Date("2/29/2019");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid date", e.getMessage());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#getMonth()}.
	 */
	@Test
	public void testGetMonth() {
		Date testDate = new Date(11, 3, 2020);
		assertEquals(11, testDate.getMonth());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#getDay()}.
	 */
	@Test
	public void testGetDay() {
		Date testDate = new Date(11, 3, 2020);
		assertEquals(3, testDate.getDay());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#getYear()}.
	 */
	@Test
	public void testGetYear() {
		Date testDate = new Date(11, 3, 2020);
		assertEquals(2020, testDate.getYear());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#isValidDate(java.lang.String)}.
	 */
	@Test
	public void testIsValidDateString() {
		assertTrue(Date.isValidDate("11/3/2019"));
		assertFalse(Date.isValidDate("1/42/2020"));
		assertFalse(Date.isValidDate(""));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#isValidDate(int, int, int)}.
	 */
	@Test
	public void testIsValidDateIntIntInt() {
		assertTrue(Date.isValidDate(11, 30, 2020));
		assertFalse(Date.isValidDate(11, 7, 2051));
		assertTrue(Date.isValidDate(2, 29, 2020));
		assertFalse(Date.isValidDate(2, 29, 2019));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#compareTo(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testCompareTo() {
		Date testDate1 = new Date("11/8/2019");
		Date testDate2 = new Date("11/20/2019");
		Date testDate3 = new Date("4/20/2020");
		assertEquals(-1, testDate1.compareTo(testDate2));
		assertEquals(-1, testDate1.compareTo(testDate3));
		assertEquals(0, testDate1.compareTo(new Date(11, 8, 2019)));
		assertEquals(1, testDate2.compareTo(testDate1));
		assertEquals(1, testDate1.compareTo(new Date(10, 8, 2019)));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#toString()}.
	 */
	@Test
	public void testToString() {
		Date testDate = new Date("11/8/2020");
		assertEquals("11/8/2020", testDate.toString());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Date testDate = new Date("12/25/2020");
		Date testDate2 = new Date(12, 25, 2020);
		assertTrue(testDate.equals(testDate2));
		Date tsetDate3 = new Date(11, 25, 2020);
		assertFalse(testDate.equals(tsetDate3));
		assertFalse(testDate == null);
		assertFalse(testDate.equals(new Date(12, 25, 2019)));
		assertFalse(testDate.equals(new Date(12, 24, 2019)));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#daysTo(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testDaysTo() {
		
		Date first = new Date(11, 7, 2019);
		Date second = new Date(11, 7, 2020);
		assertEquals(365, first.daysTo(second));
		
		Date first1 = new Date(11, 7, 2019);
		Date second1 = new Date(11, 6, 2020);
		assertEquals(-1, first1.daysTo(second1));
		
		Date first2 = new Date(11, 7, 2019);
		Date second2 = new Date(11, 6, 2040);
		assertEquals(7299, first2.daysTo(second2));
		
		Date first3 = new Date(11, 7, 2019);
		Date second3 = new Date(11, 6, 2019);
		assertEquals(-1, first3.daysTo(second3));
		
		Date first4 = new Date(2, 28, 2020);
		Date second4 = new Date(3, 1, 2020);
		assertEquals(4, first4.daysTo(second4));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.packdoption.util.Date#yearsTo(edu.ncsu.csc216.packdoption.util.Date)}.
	 */
	@Test
	public void testYearsTo() {
		Date first = new Date(11, 7, 2019);
		Date second = new Date(11, 7, 2020);
		assertEquals(1, first.yearsTo(second));
		
		Date first1 = new Date(11, 7, 2019);
		Date second1 = new Date(11, 6, 2020);
		assertEquals(0, first1.yearsTo(second1));
		
		Date first2 = new Date(11, 7, 2019);
		Date second2 = new Date(11, 6, 2040);
		assertEquals(20, first2.yearsTo(second2));
	}
}
