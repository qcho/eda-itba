package lab.eda.src.linearlists;

public class QchoLinearLinkedList<T> implements LinearLinkedList<T> {

	private T head;
	private QchoLinearLinkedList<T> tail;

	public QchoLinearLinkedList() {
		this(null, null);
	}

	private QchoLinearLinkedList(T head, QchoLinearLinkedList<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public LinearLinkedList<T> add(T elem) {
		if (elem == null) {
			throw new NullPointerException("Cannot add a null Element to the list.");
		}
		return new QchoLinearLinkedList<T>(elem, this);
	}

	@Override
	public LinearLinkedList<T> remove(T elem) {
		if (this.contains(elem)) {
			return this.tail;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (this.head == null);
	}

	@Override
	public boolean contains(T elem) {
		// QchoLinearLinkedList<T> list = this;
		if (this.isEmpty()) {
			return false;
		}
		
		while (!this.head.equals(elem)) {
			this.head = this.tail.head;
			this.tail = this.tail.tail;
		}

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
		// TODO Auto-generated method stub
		return 0;
	}

}
