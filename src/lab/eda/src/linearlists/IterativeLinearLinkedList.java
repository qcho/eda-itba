package lab.eda.src.linearlists;


/**
 * Lista lineal simplemente encadenada, implementada de manera iterativa.
 */
public class IterativeLinearLinkedList<T> implements LinearLinkedList<T> {

	private T head;
	private IterativeLinearLinkedList<T> tail;

	public IterativeLinearLinkedList() {
		this(null, null);
	}
	
	private IterativeLinearLinkedList(T head, IterativeLinearLinkedList<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public LinearLinkedList<T> add(T elem) {
		if (elem == null) {
			throw new NullPointerException("Cannot add NULL element.");
		}
		return new IterativeLinearLinkedList<T>(elem, this);
	}

	@Override
	public LinearLinkedList<T> remove(T elem) {
		IterativeLinearLinkedList<T> list = this;
		
		if (this.head == null) {
			return this;
		} else if (this.head.equals(elem)) {
			return this.tail;
		}
		
		while (list.head != null) {
			if (list.tail.head != null && list.tail.head.equals(elem)) {
				list.tail = list.tail.tail;
				return this;
			}
			list = list.tail;
		}
		
		return this;
	}
	

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public boolean contains(T elem) {
		IterativeLinearLinkedList<T> list = this;
		
		while (list.head != null) {
			if (list.head.equals(elem)) {
				return true;
			}
			list = list.tail;
		}
		return false;
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
		IterativeLinearLinkedList<T> list = this;
		int count = 0;
		while (list.head != null) {
			count++;
			list = list.tail;
		}
		return count;
	}
	
	
	@Override
	public String toString() {
		IterativeLinearLinkedList<T> list = this;
		StringBuilder result = new StringBuilder();
		
		while (list.head != null) {
			result.append(list.head.toString());
			result.append(" ");
			list = list.tail;
		}
		
		return result.toString();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof IterativeLinearLinkedList)) {
			return false;
		}
		IterativeLinearLinkedList<T> list1 = this;
		IterativeLinearLinkedList<T> list2 = (IterativeLinearLinkedList<T>)obj;
		
		while (!list1.isEmpty() && !list2.isEmpty()) {
			if (! list1.head.equals(list2.head)) {
				return false;
			}
			list1 = list1.tail;
			list2 = list2.tail;
		}
		return list1.isEmpty() && list2.isEmpty();
	}
	
	@Override
	public int hashCode() {
		IterativeLinearLinkedList<T> list = this;
		int hash = 0;
		
		while (list.head != null) {
			hash += this.head.hashCode();
			list = list.tail;
		}
		return hash;
	}
	
	
}
