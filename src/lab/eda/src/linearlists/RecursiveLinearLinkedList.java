package lab.eda.src.linearlists;

public class RecursiveLinearLinkedList<T> implements LinearLinkedList<T> {

	private T head;
	private RecursiveLinearLinkedList<T> tail;
	
	public RecursiveLinearLinkedList() {
		this(null, null);
	}

	private RecursiveLinearLinkedList(T head, RecursiveLinearLinkedList<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public LinearLinkedList<T> add(T elem) {
		if (elem == null) {
			throw new NullPointerException("Cannot add NULL element.");
		}
		return new RecursiveLinearLinkedList<T>(elem, this);
	}
	
	@Override
	public RecursiveLinearLinkedList<T> remove(T elem) {
		if (this.head == null) {
			return this;
		} else if (this.head.equals(elem)) {
			return this.tail;
		}
		this.tail = this.tail.remove(elem);
		return this;
	}
	
	@Override
	public boolean isEmpty() {
		return this.head == null;
	}
	
	@Override
	public boolean contains(T elem) {
		if (this.head == null) {
			return false;
		} else if (this.head.equals(elem)) {
			return true;
		}
		return this.tail.contains(elem);
	}
	
	@Override
	public T getHead() {
		return this.head;
	}
	
	@Override
	public LinearLinkedList<T> getTail() {
		return this.tail;
	}
	
	@Override
	public int size() {
		if (this.head == null) {
			return 0;
		} 
		return 1 + this.tail.size();
	}

	@Override
	public String toString() {
		if (this.head == null) {
			return "";
		}
		return this.head.toString() + " " + this.tail.toString();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof RecursiveLinearLinkedList)) {
			return false;
		}
		RecursiveLinearLinkedList<T> list = (RecursiveLinearLinkedList<T>)obj;
		
		if (this.head == null) {
			return list.head == null;
		}
		return this.head.equals(list.head) && this.tail.equals(list.tail);
	}
	
	@Override
	public int hashCode() {
		if (this.head == null) {
			return 0;
		}
		return this.head.hashCode() + this.tail.hashCode();
	}
}
