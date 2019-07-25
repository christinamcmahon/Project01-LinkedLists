package utility;

public interface Iterator<E> {
	/*************************************************************
	 * returns true if there are more items left in the list
	 * @return true if there are more items left in the list
	 *************************************************************/
	public boolean hasNext();
	
	/*************************************************************
	 * returns the next item in the iteration
	 * @return next item in the iteration
	 *************************************************************/
	public E next();
	
	/*************************************************************
	 * removes the last item returned by the iterator
	 *************************************************************/
	public void remove();
}
