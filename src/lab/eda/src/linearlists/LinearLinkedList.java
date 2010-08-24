package lab.eda.src.linearlists;

public interface LinearLinkedList<T> {

	public LinearLinkedList<T> add(T elem);
	
	public LinearLinkedList<T> remove(T elem);
	
	public boolean isEmpty();

	public boolean contains(T elem);

	public T getHead();

	public LinearLinkedList<T> getTail();
	
	public int size();

}
