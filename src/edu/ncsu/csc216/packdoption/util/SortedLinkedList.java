/**
 * 
 */
package edu.ncsu.csc216.packdoption.util;


/**
 * The Class SortedLinkedList is a custom linked list that used nodes and an iterator
 * to easily move through the list. It can be used to store appointments, animals, or anything
 * else.
 *
 * @author IanFright2
 * @author Cameron Dutra
 * @param <E> the element type
 */
public class SortedLinkedList<E extends Comparable<E>> {
	
	/** The head. */
	private Node<E> head;
	/** The size. */
	private int size;
	
	/**
	 * Instantiates a new sorted linked list and sets size to zero.
	 */
	public SortedLinkedList() {
		this.size = 0;
	}
	
	/**
	 * returns the Size of the list.
	 *
	 * @return the size of the list.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Checks if the list is empty.
	 *
	 * @return true, if the list is empty.
	 */
	public boolean isEmpty() {
		if ( head == null || head.value == null || size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see if the list contains a passed in element.
	 * This method uses the iterator to move one by one through the list instead of 
	 * having to use a for loop and such with a normal linked list.
	 *
	 * @param e the element to check for.
	 * @return true, if the method is successful in finding a matching
	 * element.
	 */
	public boolean contains(E e ) {
		if (isEmpty()) {
			return false;
		}
		Cursor it = (SortedLinkedList<E>.Cursor) this.iterator();
		while(it.hasNext()) {
			if(it.current.value.equals(e)) {
				return true;
			}
			it.next();
		}
		return false;
	}
	
	/**
	 * Adds the given element to the list. No index is used because the
	 * list will be sorted rather than based on user given indexes.
	 * 
	 *
	 * @param item the element to add.
	 * @return true, if successful in adding the element.
	 * @throws NullPointerException if the item to add is null
	 */
	public boolean add(E item) {
		if(item == null) {
			throw new NullPointerException();
		}
		if(head == null) {
			head = new Node<E>(null, null);
		}
		
		if(this.contains(item)) {
			throw new IllegalArgumentException();
		}
		
		Node<E> newNode = new Node<E>(item, null);
		
		if(head.value == null) {
			head.value = item;
			size++;
			return true;
			
		} else if (item.compareTo(head.value) < 0) {
			
			newNode.next = head;
			head = newNode;
			
			size++;
			return true;
			
		} else {
			
			Node<E> after = head.next;
			Node<E> before = head;
			while (after != null) {
				if (item.compareTo(after.value) < 0)
					break;
				before = after;
				after = after.next;
			}
			newNode.next = before.next;
			before.next = newNode;
			size++;
			return true;
		}
	}
	
	/**
	 * Gets the element at a user specified index. Uses the iterator.
	 *
	 * @param index the index
	 * @return the element at the index
	 * @throws IndexOutOfBoundsException if the requested index is out of the scope of the list
	 */
	public E get(int index) {
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current.value;
	}
	
	
	/**
	 * Removes the element at a user specified index.
	 *
	 * @param index the index wanted to be removed
	 * @return the e element wanted to be removed.
	 * @throws IndexOutOfBoundsException if the head is null or if the requested index
	 * is outside the scope of the current list
	 */
	public E remove(int index) {
		if(head == null) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		E removed;
		
		// remove from front of list
		if (index == 0) {
			
			removed = head.value;
			head = head.next;
			
		// remove from end of list
		} else if (index == size - 1) {
			Node<E> current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			
			removed = current.next.value;
			current.next = null;
			
		// remove from middle of list
		} else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			removed = current.next.value;
			current.next = current.next.next;
			
		}
		
		size--;
		return removed;
	}
	
	/**
	 * Index of a equal element by iterating through the list until the end
	 * of the list is reached.
	 *
	 * @param e the element wanted to get the index of.
	 * @return the integer index of the given element.
	 */
	public int indexOf(E e) {
		int index = 0;
		if(head == null || head.value == null) {
			return -1;
		}
		Cursor it = (SortedLinkedList<E>.Cursor) this.iterator();
		if(it.current.value == e) {
			return 0;
		}
		while(it.hasNext()) {
			E temp = it.next();
			if(temp == e) {
				return index;
			} 
			index++;
			
		}
		return -1;
	}

	/**
	 * Generates hashCode for this list.
	 * 
	 * @return an integer holding the hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + size;
		return result;
	}

	/**
	 * Determines if two SortedLinkedList objects are equivalent to one another
	 * 
	 * @param obj the object passed in to determine equality with this list
	 * @return true, if the two are equivalent
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortedLinkedList<E> other = (SortedLinkedList<E>) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	/**
	 * To string method that returns a string
	 * that represents this list.
	 *
	 * @return the string generated by putting together
	 * data from fields and constants.
	 */
	public String toString() {
		if(size == 0) {
			return "";
		}
		String toSend = "";
		Cursor it = (SortedLinkedList<E>.Cursor) this.iterator();
		
		for( int i = 0; i < size - 1; i++) {
			toSend = toSend + "-" + it.current.value + "\n";
			it.next();
		}
		toSend = toSend + "-" + it.current.value;
		return toSend;
	}
	
	/**
	 * Iterator method to generate an iterator for the list. Also creates a new cursor.
	 *
	 * @return the simple list iterator.
	 */
	public SimpleListIterator<E> iterator() {
		Cursor bob = new Cursor();
		return bob;
	}
	
	/**
	 * The Class Node that holds a single value and is used in
	 * a chain to create a linked list.
	 * 
	 * @param <E> generic type of list
	 */
	public static class Node<E> {
		
		/** The value. */
		E value;
		Node<E> next;
		
		/**
		 * Instantiates a new node.
		 *
		 * @param e the e
		 * @param next the next node reference
		 */
		public Node(E e, Node<E> next ) {
			value = e;
			this.next = next;
		}

		/**
		 * Generates the hash code for Node.
		 * 
		 * @return the integer holding the hash code
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		/**
		 * Compares this object and another to determine if the are the same in terms of data.
		 * 
		 * @return if the other object is equal to this object
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Node<E> other = (Node<E>) obj;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		

	}
	
	/**
	 * The Class Cursor that holds a single node and uses a list
	 * iterator to move around the list.
	 */
	public class Cursor implements SimpleListIterator<E> {

		/** The current node. */
		private Node<E> current;
		
		/**
		 * Instantiates a new cursor.
		 */
		public Cursor() {
			current = head;	
		}
		
		/**
		 * Checks for if there is a next node in the chain.
		 *
		 * @return true, if successful
		 */
		public boolean hasNext() {
			return current != null;
			
		}
		
		/**
		 * Next method that gets the next element in the chain.
		 *
		 * @return the element in the next slot of the list
		 */
		public E next() {
			if(!this.hasNext()) {
				throw new NoSuchListElementException("No element available with call to next.");
			}
			
			E temp = current.value;
			current = current.next;
			return temp;
			
		}

	}

}
