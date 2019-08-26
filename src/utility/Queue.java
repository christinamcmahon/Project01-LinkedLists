package utility;

public interface Queue<E> {
	public boolean 		add(E element);
	public void 		clear();
	public boolean 		isEmpty();
	public E 			peek();
	public E 			remove();
	public int 			size();
}
