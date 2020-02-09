package edu.ncsu.csc216.packdoption.util;

/**
 * The Class ArrayListQueue will be used has the data structure for an appointment queue.
 * One can only take an element off the top and add an element to the back.
 * 
 *@author Cameron Dutra
 *@author Ian Fright
 * @param <E> the element type
 */
public class ArrayListQueue<E> implements Queue<E> {

	/** The list. */
	private E[] list;
	
	/** The size. */
	private int size;
	
	/**
	 * constructs a new ArrayListQueue with a base capacity of thirty
	 */
	@SuppressWarnings("unchecked")
	public ArrayListQueue() {
		list = (E[]) (new Object[30]);
		size = 0;
	}
	
	/**
	 * Adds to the back of the queue.
	 *
	 * @param e the Element to add to the list
	 * @return true, if successful
	 * @throws NullPointerException if the element is null
	 * @throws IllegalStateException if the capacity is reached
	 */
	@Override
	public boolean add(E e) {
		if(e == null) {
			throw new NullPointerException();
		}
		
		if(size == list.length) {
			throw new IllegalStateException();
		}
		list[size] = e;
		size++;
		
		return true;
	}
	

	/**
	 * Removes from the front of the queue. Then sifts everything over 
	 * once the front is removed
	 *
	 * @return the Element removed
	 * @throws NoSuchListElementException if the list is empty
	 */
	@Override
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchListElementException();
		}
		E e = list[0];
		for (int i = 0; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return e;
	}

	/**
	 * Peek at the Element of the front without removing it
	 *
	 * @return the Element at the front
	 * @throws NoSuchListElementException if the list is empty
	 */
	@Override
	public E element() {
		if (isEmpty()) {
			throw new NoSuchListElementException();
		}
		return list[0];
	}

	/**
	 * Size of the queue at the moment of call.
	 *
	 * @return the size of the queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

}
