package lists;

import java.util.NoSuchElementException;

import utility.Iterator;
import utility.List;
import utility.Queue;

public class LinkedList<E> implements List<E>, Queue<E> {

	/*************************************************************
	 * data fields: start, size
	 *************************************************************/
	public Node start; // location of starting node in the list
	public int size; // tracks number of nodes in the list
	
	/*************************************************************
	 * default constructor: LinkedList()
	 * constructs an empty list
	 *************************************************************/
	public LinkedList() {
		start = null;
		size = 0;
	}
	
	/*************************************************************
	 * copy constructor: LinkedList(List<E>)
	 *************************************************************/
	public LinkedList(List<E> other) {
		start = null;
		size = 0;
		for(int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}
	
	/*************************************************************
	 * appends value at end of list
	 * @param element 	element being added to list
	 * @return true if element successfully added
	 *************************************************************/
	@Override
	public boolean add(E element) {
		int oldSize = size;
		if (isEmpty()) {
			start = new Node(start, start, element);
			start.next = start.prev = start;
		} else {
			Node newNode = new Node(start.prev, start, element);
			Node current = start.prev;
			current.next = newNode;
			start.prev = newNode;
		}
		size++;
		return size == oldSize + 1; 
	}

	/*************************************************************
	 * inserts given value just before the given index, shifting 
	 * subsequent values to the right
	 * @param index 	location where element will be appended
	 * @param element 	element being added to list
	 *************************************************************/
	@Override
	public void add(int index, E element) {
		checkIndex(index);
		if (isEmpty()) {
			start = new Node(start, start, element);
			start.next = start.prev = start;
		} else if (index == 0) {
			start = new Node(start.prev, start, element);
			Node current = start.next;
			current.prev = start;
			current = start.prev;
			current.next = start;
		} else {
			Node current = start;
			for(int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = new Node(current, current.next, element);
			start.prev = current.next;
		}
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
	@Override
	public void clear() {
		start = null;
		size = 0;
	}

	/*************************************************************
	 * searches for a specific value within the internal array and
	 * returns true if the value is in the list
	 * @param element 	element being searched for
	 * @return true if the value is in the list
	 *************************************************************/
	@Override
	public boolean contains(E element) {
		return indexOf(element) != -1;
	}

	/*************************************************************
	 * return the element at the specified position in the list
	 * @param index 	location where element will be appended
	 * @return element at the specified position in the list
	 *************************************************************/
	@Override
	public E get(int index) {
		return nodeAt(index).data;
	}
	
	/*************************************************************
	 * returns the next node at the given index
	 * @param index 	index of current node 
	 * @return next node at index
	 *************************************************************/
	public Node getNextNode(int index) {
		return nodeAt(index).next;
	}
	
	/*************************************************************
	 * returns the node at the given index
	 * @param index 	index of node 
	 * @return node at index
	 *************************************************************/
	public Node getNode(int index) {
		return nodeAt(index);
	}
	
	/*************************************************************
	 * returns the previous node at the given index
	 * @param index 	index of current node 
	 * @return previous node at index
	 *************************************************************/
	public Node getPrevNode(int index) {
		return nodeAt(index).prev;
	}

	/*************************************************************
	 * searches for a specific value within the internal array and 
	 * return its index
	 * @param element 	element being searched for
	 * @return index of element being searched for
	 *************************************************************/
	@Override
	public int indexOf(E element) {
		if(start == null) {
			return -1;
		}
		int index = 0;
		Node current = start;
		do {
			if(current.data.equals(element)) {
				return index;
			}
			index++;
			current = current.next;
		} while (current != start);
		return -1;
	}

	/*************************************************************
	 * returns true if the list is empty
	 * @return true if the list is empty
	 *************************************************************/
	@Override
	public boolean isEmpty() {
		return size == 0 || start == null;
	}
	
	/*************************************************************
	 * returns an object used to traverse the elements in the list
	 * @return object used to traverse the elements in the list
	 *************************************************************/
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}
	
	/*************************************************************
	 * returns a reference to the node at the given position in 
	 * the list
	 * @return node at the given index
	 *************************************************************/
	private Node nodeAt(int index) {
		checkIndex(index);
		Node current = start;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	/*************************************************************
	 * retrieves, but does not remove, the first element (start) 
	 * of the list
	 * @return first element or null if the list is empty
	 *************************************************************/
	public E peek() {
		if(isEmpty()) {
			return null;
		}
		return start.data;
	}
	
	/*************************************************************
	 * retrieves and removes the first element of the list
	 * @return first element
	 * @throws NoSuchElementException if the list is empty
	 *************************************************************/
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException("The list is empty");
		E oldStart = start.data;
		start.next.prev = start.prev;
		start = start.next;
		Node last = start.prev;
		last.next = start;
		size--;
		return oldStart;
	}
	
	/*************************************************************
	 * removes the element at the given index in the list and
	 * shifts subsequent elements to the left and returns the 
	 * element removed
	 * @param index 	location where element will be appended
	 * @return element removed from the list
	 *************************************************************/
	@Override
	public E remove(int index) {
		checkIndex(index);
		E element = nodeAt(index).data;
		if(index == 0) {
			start.next.prev = start.prev;
			start = start.next;
			Node last = start.prev;
			last.next = start;
		} else {
			Node current = nodeAt(index - 1);
			current.next = current.next.next;
			current.next.prev = current;
		}
		size--;
		//start.prev = nodeAt(size - 1);
		return element;
	}

	/*************************************************************
	 * removes the first occurrence of the specified element from 
	 * the list, if present and shifts subsequent elements to the
	 * left and returns true if the element is removed
	 * @param element 	element being added to list
	 * @return true if specified element is removed
	 *************************************************************/
	@Override
	public boolean remove(E element) {
		Node current = start;
		if(size == 1) {
			if(current.data.equals(element)) {
				start = null;
				size = 0;
				return true;
			}
		}
		if(start.data.equals(element)) {
			start.next.prev = start.prev;
			start = start.next;
			Node last = start.prev;
			last.next = start;
			size--;
			return true;
		}
		do {
			if(current.next.data.equals(element)) {
				current.next = current.next.next;
				current.next.prev = current;
				size--;
				return true;
			}
			current = current.next;
		}
		while (current != start);
		return false;
	}

	/*************************************************************
	 * replaces the element at the specified location with the 
	 * element passed
	 * @param index 	location of element being replaced
	 * @param element 	replacement element
	 *************************************************************/
	@Override
	public E set(int index, E element) {
		checkIndex(index);
		Node current = start;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		E oldData = current.data;
		current.data = element;
		return oldData;
	}

	/*************************************************************
	 * returns the size of the occupied locations of the array
	 * @return the size of the occupied locations of the array
	 *************************************************************/
	@Override
	public int size() {
		return size;
	}
	
	/*************************************************************
	 * displays the contents of the list
	 * @return contents of the list
	 *************************************************************/
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		} else {
			String result = "[ " + start.data;
			Node current = start.next;
			while(current != start) {
				result += ", " + current.data;
				current = current.next;
			}
			return result + " ]";
		}
	}
	
	private class Node {
		/*************************************************************
		 * data fields: data, next, prev
		 *************************************************************/
		E data; // holds data stored in each node
		Node next; // location of the next node in the list
		Node prev; // location of the previous node in the list
		
		/*************************************************************
		 * constructor: Node(Node, Node, E)
		 *************************************************************/
		public Node(Node prev, Node next, E data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}
	
	public class LinkedIterator implements Iterator<E> {

		/*************************************************************
		 * data fields: current, ableToRemove
		 *************************************************************/
		private Node current; // tracks current position in the linked structure
		private int index; // location of node in list
		private boolean ableToRemove; // checks if method next has been called before calling the remove method
		
		/*************************************************************
		 * constructor: LinkedIterator()
		 *************************************************************/
		public LinkedIterator() {
			index = 0;
			current = start;
			ableToRemove = false;
		}
		
		/*************************************************************
		 * returns true if there are more items left in the list
		 * @return true if there are more items left in the list
		 *************************************************************/
		@Override
		public boolean hasNext() {
			return index < size() || current != start;
		}

		/*************************************************************
		 * returns the next item in the iteration
		 * @return next item in the iteration
		 * @throws NoSuchElementException if there is no next item
		 *************************************************************/
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException("There is no next item");
			}
			E result = current.data;
			current = current.next;
			index++;
			ableToRemove = true;
			return result;
		}

		/*************************************************************
		 * removes the last item returned by the iterator
		 *************************************************************/
		@Override
		public void remove() {
			if(!ableToRemove) {
				throw new IllegalArgumentException("Unable to remove");
			}
			Node prev = current.prev.prev;
			prev.next = current;
			current.prev = prev;
			index--;
			ableToRemove = false;
		}
	}
}
