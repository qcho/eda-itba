package lab.tp05;

public class BinaryTree<T> {
	private T value;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree(T value) {
		this(value, null, null);
	}

	public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void add(T value) {
		if (this == null){
			
		}
		
	}

}
