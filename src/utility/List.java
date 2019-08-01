package utility;

public interface List<E> {
	/*************************************************************
	 * appends value at end of list
	 * @param element 	element being added to list
	 * @return true if element successfully added
	 *************************************************************/
	public boolean add(E element);
	
	/*************************************************************
	 * inserts given value just before the given index, shifting 
	 * subsequent values to the right
	 * @param index 	location where element will be appended
	 * @param element 	element being added to list
	 *************************************************************/
	public void add(int index, E element);
	
	/*************************************************************
	 * removes all elements of the list
	 *************************************************************/
	public void clear();
	
	/*************************************************************
	 * searches for a specific value within the internal array and
	 * returns true if the value is in the list
	 * @param element 	element being searched for
	 * @return true if the value is in the list
	 *************************************************************/
	public boolean contains(E element);
	
	/*************************************************************
	 * return the element at the specified position in the list
	 * @param index 	location where element will be appended
	 * @return element at the specified position in the list
	 *************************************************************/
	public E get(int index);
	
	/*************************************************************
	 * searches for a specific value within the internal array and 
	 * return its index
	 * @param element 	element being searched for
	 * @return index of element being searched for
	 *************************************************************/
	public int indexOf(E element);
	
	/*************************************************************
	 * returns true if the list is empty
	 * @return true if the list is empty
	 *************************************************************/
	public boolean isEmpty();
	
	/*************************************************************
	 * returns an object used to traverse the elements in the list
	 * @return object used to traverse the elements in the list
	 *************************************************************/
	public Iterator<E> iterator();
	
	/*************************************************************
	 * removes the element at the given index in the list and
	 * shifts subsequent elements to the left and returns the 
	 * element removed
	 * @param index 	location where element will be appended
	 * @return element removed from the list
	 *************************************************************/
	public E remove(int index);
	
	/*************************************************************
	 * removes the first occurrence of the specified element from 
	 * the list, if present and shifts subsequent elements to the
	 * left and returns true if the element is removed
	 * @param element 	element being added to list
	 * @return true if specified element is removed
	 *************************************************************/
	public boolean remove(E element);
	
	/*************************************************************
	 * replaces the element at the specified location with the 
	 * element passed
	 * @param index 	location of element being replaced
	 * @param element 	replacement element
	 *************************************************************/
	public E set(int index, E element);
	
	/*************************************************************
	 * returns the size of the occupied locations of the array
	 * @return the size of the occupied locations of the array
	 *************************************************************/
	public int size();
	
	/*************************************************************
	 * displays the contents of the list
	 * @return contents of the list
	 *************************************************************/
	public String toString();
}
