package lists;

import java.util.NoSuchElementException;

import utility.Iterator;
import utility.List;

public class ArrayList<E> implements List<E> {
	/*************************************************************
	 * data fields: size, data
	 *************************************************************/
	private int size; // number of occupied locations in the internal array
	private E[] data; // reference variable for the internal array
	
	/*************************************************************
	 * constant: DEFAULT_CAPACTIY
	 *************************************************************/
	public static final int DEFAULT_CAPACITY = 10;
	
	/*************************************************************
	 * empty constructor: ArrayList()
	 *************************************************************/
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/*************************************************************
	 * full constructor: ArrayList(int)
	 * @param capacity maximum capacity for the array
	 * @throws IllegalArgumentException if capacity is less than zero
	 *************************************************************/
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		if(capacity < 0) throw new IllegalArgumentException("Capacity cannot be less than zero.");
		data = (E[])new Object[capacity];
		size = 0;
	}
	
	/*************************************************************
	 * copy constructor: ArrayList(List<E>)
	 * @param other list being copied
	 *************************************************************/
	@SuppressWarnings("unchecked")
	public ArrayList(List<E> other) {
		this(other.size());
	}
	
	/*************************************************************
	 * appends value at end of list
	 * @param element 	element being added to list
	 * @return  true if element was added to list
	 *************************************************************/
	public boolean add(E element) {
		int oldSize = size;
		ensureCapacity(size + 1);
		data[size] = element;
		size++;
		return size > 0 && size > oldSize;
	}
	
	/*************************************************************
	 * inserts given value just before the given index, shifting 
	 * subsequent values to the right
	 * @param index 	location where element will be appended
	 * @param element 	element being added to list
	 *************************************************************/
	public void add(int index, E element) {
		checkIndex(index);
		ensureCapacity(size + 1);
		for(int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = element;
		size++;
	}
	
	/*************************************************************
	 * checks if the given index is valid
	 * @throws IndexOutOfBoundsException if invalid index
	 *************************************************************/
	private void checkIndex(int index) {
		String message = "index: " + index + ", size: " + size;
		if(index < 0 || index > size) throw new IndexOutOfBoundsException(message);
	}
	
	/*************************************************************
	 * removes all elements of the list
	 *************************************************************/
	public void clear() {
		for(int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}
	
	/*************************************************************
	 * searches for a specific value within the internal array and
	 * returns true if the value is in the list
	 * @param element 	element being searched for
	 * @return true if the value is in the list
	 *************************************************************/
	public boolean contains(E element) {
		int index = indexOf(element);
		return index >= 0 && index < size;
	}
	
	/*************************************************************
	 * resets the capacity of the underlying array to ensure that
	 * it can hold the number of elements specified by the minimum
	 * capacity argument.
	 * @param minCapacity new capacity
	 *************************************************************/
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
		if(minCapacity > data.length) {
			int newCapacity = data.length * 2 + 1;
			if(minCapacity > newCapacity) {
				newCapacity = minCapacity;
			}
			E[] newList = (E[])new Object[newCapacity];
			for(int i = 0; i < size; i++) {
				newList[i] = data[i];
			}
			data = newList;
		}
	}
	
	
	/*************************************************************
	 * return the element at the specified position in the list
	 * @param index 	location where element will be appended
	 * @return element at the specified position in the list
	 * @throws IndexOutOfBoundsException if index is invalid
	 *************************************************************/
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	/*************************************************************
	 * searches for a specific value within the internal array and 
	 * return its index
	 * @param element 	element being searched for
	 * @return index of element being searched for
	 *************************************************************/
	public int indexOf(E element) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	/*************************************************************
	 * returns true if the list is empty
	 * @return true if the list is empty
	 *************************************************************/
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*************************************************************
	 * returns an object used to traverse the elements in the list
	 * @return object used to traverse the elements in the list
	 *************************************************************/
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	
	/*************************************************************
	 * removes the element at the given index in the list and
	 * shifts subsequent elements to the left and returns the 
	 * element removed
	 * @param index 	location where element will be appended
	 * @return element removed from the list
	 *************************************************************/
	public E remove(int index) {
		checkIndex(index);
		E item = data[index];
		for(int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size - 1] = null;
		size--;
		return item;
	}
	
	/*************************************************************
	 * removes the first occurrence of the specified element from 
	 * the list, if present and shifts subsequent elements to the
	 * left and returns true if the element is removed
	 * @param element 	element being added to list
	 * @return true if specified element is removed
	 *************************************************************/
	public boolean remove(E element) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(element)) {
				for(int j = i; j < size - 1; j++) {
					data[j] = data[j + 1];
				}
				data[size - 1] = null;
				size--;
				return true;
			}
		}
		return false;
	}
	
	/*************************************************************
	 * replaces the element at the specified location with the 
	 * element passed
	 * @param index 	location of element being replaced
	 * @param element 	replacement element
	 * @return replaced element
	 *************************************************************/
	public E set(int index, E element) {
		checkIndex(index);
		E item = data[index];
		data[index] = element;
		return item;
	}
	
	/*************************************************************
	 * returns the size of the occupied locations of the array
	 * @return the size of the occupied locations of the array
	 *************************************************************/
	public int size() {
		return size;
	}
	
	/*************************************************************
	 * displays the contents of the list
	 * @return contents of the list
	 *************************************************************/
	public String toString() {
		if(size == 0) {
			return "[]";
		} else {
			String result = "[" + data[0];
			for(int i = 1; i < size; i++) {
				result += ", " + data[i];
			}
			result += "]";
			return result;
		}
	}
	
	public class ArrayIterator implements Iterator<E> {
		/*************************************************************
		 * data fields: index, ableToRemove
		 *************************************************************/
		private int index; // current position in the outer class array
		private boolean ableToRemove; // checks if the method next has been called before calling the remove method
		
		/*************************************************************
		 * constructor: ArrayIterator()
		 *************************************************************/
		public ArrayIterator() {
			index = 0;
			ableToRemove = false;
		}
		
		/*************************************************************
		 * returns true if there are more items left in the list
		 * @return true if there are more items left in the list
		 *************************************************************/
		public boolean hasNext() {
			return index < size();
		}
		
		/*************************************************************
		 * returns the next item in the iteration
		 * @return next item in the iteration
		 * @throws NoSuchElementException if there is no next element
		 *************************************************************/
		public E next() {
			if(!hasNext()) throw new NoSuchElementException("No next element");
			index++;
			return null; // replace!
		}
		
		/*************************************************************
		 * removes the last item returned by the iterator
		 * @throws IllegalStateException if unable to remove element.
		 *************************************************************/
		public void remove() {
			if(!ableToRemove) throw new IllegalStateException("Not able to remove element.");
			ArrayList.this.remove(index - 1);
			index--;
			ableToRemove = false;
		}
	}
}
