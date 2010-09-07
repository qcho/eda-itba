package lab.eda.src.linearlists;

public class QchoLinearLinkedList<T> implements LinearLinkedList<T> {

	private T head;
	private QchoLinearLinkedList<T> tail;
	
	public QchoLinearLinkedList() {
		this(null, null);
	}
	
	private QchoLinearLinkedList(T head, QchoLinearLinkedList<T> tail){
		this.head = head;
		this.tail = tail;
	}
	
	@Override
	public LinearLinkedList<T> add(T elem) {
		if (elem == null) {
			throw new NullPointerException("Cannot add NULL element.");
		}
		return new QchoLinearLinkedList<T>(elem, this.tail);
	}
	
	@Override
	public QchoLinearLinkedList<T> remove(T elem) {
		if (this.isEmpty()) {
			return this;
		} else if (this.head.equals(elem)) {
			return this.tail;
		}
		this.tail = this.tail.remove(elem);
		return this;
	}
	
	@Override
	public boolean isEmpty() {
		return (this.head == null);
	}
	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T getHead() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LinearLinkedList<T> getTail() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
