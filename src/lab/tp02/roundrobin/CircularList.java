package lab.tp02.roundrobin;

/**
 * 
 * @author hogomez
 * 
 * @param <T>
 *            Se acepta null como valor
 */
public class CircularList<T> {

	private Node prev;

	public CircularList() {
		this.prev = null;
	}

	public boolean isEmpty() {
		return (this.prev == null);
	}

	public void add(T e) {
		if (this.isEmpty()) {
			this.prev = new Node(e);
		} else {
			Node newNode = new Node(e, this.current());
			this.prev.setNext(newNode);
		}
	}

	public T next() {
		this.roll();
		Node curr = this.current();
		return (curr == null) ? null : curr.getValue();
	}

	public T remove() {
		Node curr = this.current();
		if (this.prev == this.current()) {
			this.prev = null;
		} else {
			this.prev.setNext(this.current().getNext());
		}
		return (curr == null) ? null : curr.getValue();
	}

	private void roll() {
		if (!this.isEmpty()) {
			this.prev = this.prev.getNext();
		}
	}

	private Node current() {
		if (this.isEmpty()) {
			return null;
		}
		return this.prev.getNext();
	}

	@Override
	public String toString() {

		if (this.isEmpty()) {
			return "[ ]";
		}

		Node last = this.prev;
		Node curr = this.current();

		String s = "[ " + curr.getValue();
		while (curr != last) {
			curr = curr.getNext();
			s += ", " + curr.getValue();
		}
		return s + " ]";
	}

	public class Node {
		private T value;
		private Node next;

		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Node(T value) {
			this.value = value;
			this.next = this;
		}

		public T getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		// TODO: equals & hashcode.
	}
	
	public static void main(String[] args) {
		CircularList<Integer> list = new CircularList<Integer>();
		
		System.out.println(list);
		list.add(3);
		System.out.println(list);
		list.add(9);
		System.out.println(list);
		list.add(1);
		System.out.println(list);
		list.add(2);
		System.out.println(list);
		list.add(9);
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
	}
}
