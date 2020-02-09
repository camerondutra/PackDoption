package edu.ncsu.csc216.packdoption.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The Class Date is responsible for everything related to time keeping
 * and checking if the date is a valid date. It has year, month, and day. Will have to have
 * a clever way of checking the time between two dates due to changes in the number of days per month and other
 * factors.
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class Date {

	/** The month. */
	private int month;
	
	/** The day. */
	private int day;
	
	/** The year. */
	private int year;
	
	/**
	 * Instantiates a new date.
	 *
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 * @throws IllegalArgumentException if the date is not valid
	 */
	public Date(int month, int day, int year) {
		if(!isValidDate(month, day, year)) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * Instantiates a new date.
	 *
	 * @param date the date to set
	 * @throws IllegalArgumentException if the date is not valid or there is no element
	 */
	public Date(String date) {
		try {
			
			if(!isValidDate(date)) {
				throw new IllegalArgumentException("Invalid date");
			}
		
			Scanner sScan = new Scanner(date);
			sScan.useDelimiter("/");
			this.month = Integer.valueOf(sScan.next());
			this.day = Integer.valueOf(sScan.next());
			this.year = Integer.valueOf(sScan.next());
			sScan.close();
		
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Invalid date");
		}
	}
	
	/**
	 * Gets the month of the date.
	 *
	 * @return the month of the date
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * Gets the day of the date.
	 *
	 * @return the day of the date
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * Gets the year of the date.
	 *
	 * @return the year of the date
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Checks if the date is a valid date.
	 *
	 * @param dateString the string version of date
	 * @return true, if it is a valid date
	 */
	public static boolean isValidDate(String dateString) {
		Scanner sScan = new Scanner(dateString);
		sScan.useDelimiter("/");
		int month;
		int day;
		int year;
		try {
			month = Integer.valueOf(sScan.next());
			day = Integer.valueOf(sScan.next());
			year = Integer.valueOf(sScan.next());
			sScan.close();
		} catch (Exception e) {
			return false;
		}
		return isValidDate(month, day, year);
	}
	
	/**
	 * Checks if is valid date.
	 *
	 * @param month the month of the date to check
	 * @param day the day of the date to check
	 * @param year the year of the date to check
	 * @return true, if is valid date
	 */
	public static boolean isValidDate(int month, int day, int year) {
		
		// Check for valid year
		if(year > 2050 || year < 2000) {
			return false;
		}
		
		// Check for valid month
		if(month < 1 || month > 12) {
			return false;
		}
		
		// Check for the valid day based on each month and leap year
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			if(day > 30 || day < 1) {
				return false;
			}
		} else if (month == 2) {
			if( year % 4 == 0) {
				if( day > 29 || day < 1) {
					return false;
				}
			} else {
				if( day > 28 || day < 1) {
					return false;
				}
			}
		} else {
			if( day > 31 || day < 1) {
				return false;
			}
		}
		return true;		
	}
	
	/**
	 * Compares this date to another date and returns a value for sorting purposes.
	 *
	 * @param date the date to compare to
	 * @return the comparison value
	 */
	public int compareTo(Date date) {
		if (this.year != date.year) {
			if (this.year > date.year) {
				return 1;
			} else if (this.year < date.year) {
				return -1;
			}
		} else if (this.month != date.month) {
			if (this.month > date.month) {
				return 1;
			} else if (this.month < date.month) {
				return -1;
			}
		} else if (this.day != date.day) {
			if (this.day > date.day) {
				return 1;
			} else if (this.day < date.day) {
				return -1;
			}
		} 
		return 0;
	}
	
	/**
	 * To string method to generate a string version of the current Date.
	 *
	 * @return the string generated
	 */
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	/**
	 * Determines the number of days between two dates.
	 *
	 * @param date the date to compare to in order to find the days between the two
	 * @return the days between the two dates
	 */
	public int daysTo(Date date) {
		// Number of days with the known number of years.
		int daysSoFar = 365 * yearsTo(date);
		// Number of months known.
		int monthsSoFar = date.month - this.month;
		// Number of days from known years plus
		// the number of days from known months.
		daysSoFar = daysSoFar + (31 * monthsSoFar);
		// Add in the final days from an incomplete month.
		daysSoFar = daysSoFar + (date.day - this.day);
		return daysSoFar;
	}
	
	/**
	 * Determines the number of years between two dates.
	 *
	 * @param date the date to compare to in order to find the years between the two
	 * @return the years between the two dates
	 */
	public int yearsTo(Date date) {
		// Difference in years
		 int years = date.year - this.year;
		 // Difference in months
		 int months = date.month - this.month;
		 
		 // If there is a transition from one year to another
		 // but not a full year goes by or exactly one year
		 // goes by.
		 // Example: November 2019 -> February 2020
		 if(years > 0 && months <= 0) {
			 
			 // If the months are the same
			 if(months == 0) {
				 
				 // If the final day stops short of reaching
				 // a whole year.
				 if(date.day - this.day < 0) {
					 return years - 1;
				 }
				 
				 // If the days reach each other to complete
				 // a whole year.
				 return years;
				 
			 // If the months do not reach each other then
		     // an entire year is not completed.
			 } else {
				 return years - 1;
			 }
			 
	     // Handles the reversal with negative transitions.
		 } else if ( years < 0 && months >= 0) {
			 
			 // If the months reach each other, add a year.
			 if(months == 0) {
				 if(date.day - this.day > 0) {
					 return years + 1;
				 }
				 return years;
			 } else {
				 return years + 1;
			 }
		 }
		 return years;
	}

	/**
	 * Generates a unique code that is used later for comparison purposes
	 * @return the hashed value of the object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	/**
	 * Determines if two Date objects are the same
	 * @param obj the Date object that the this Date is compared to
	 * @return whether or not the two objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
}
