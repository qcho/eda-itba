package trees;

import java.util.Comparator;

/**
 * NO ADMITE ELEMENTOS NULL.
 * 
 * @author hogomez
 * 
 * @param <T>
 */
public class AVLTree<T> implements Tree<T> {

	Node root;
	private final Comparator<T> comp;

	public AVLTree(Node root, Comparator<T> comp) {
		this.root = root;
		this.comp = comp;
	}

	public AVLTree(Comparator<T> comp) {
		this(null, comp);
	}

	@Override
	public boolean search(T e) {
		return search(e, root);
	}

	private boolean search(T e, Node n) {
		if (n == null) {
			return false;
		}

		if (comp.compare(e, this.root.value) == 0) {
			return true;
		}

		if (comp.compare(e, this.root.value) > 0) {
			return search(e, n.right);
		} else {
			return search(e, n.left);
		}
	}

	@Override
	public void insert(T e) {
		if (root == null) {
			root = new Node(e);
		} else {
			this.insert(e, root);
		}

	}

	private void insert(T e, Node n) {

		if (comp.compare(e, n.value) > 0) {
			if (n.right == null) {
				n.right = new Node(e);
			} else {
				this.insert(e, n.right);
			}
		} else {
			if (n.left == null) {
				n.left = new Node(e);
			} else {
				this.insert(e, n.left);
			}
		}
		
		int leftFactor = (n.left == null) ? -1 : n.left.balanceFactor;
		int rightFactor = (n.right == null) ? -1 : n.right.balanceFactor;
		n.balanceFactor = leftFactor - rightFactor;
		
		if (n.left.balanceFactor == 2) {
			if (n.left.left.balanceFactor >= 0){
				n.left = LL(n.left);
			} else {
				n.left = LR(n.left);
			}
		}
		
		if (n.left.balanceFactor == -2) {
			if (n.left.right.balanceFactor < 0){
				n.left = RR(n.left);
			} else {
				n.left = RL(n.left);
			}
		}
		
		if (n.right.balanceFactor == 2) {
			if (n.right.left.balanceFactor >= 0){
				n.right = LL(n.right);
			} else {
				n.right = LR(n.right);
			}
		}
		
		if (n.right.balanceFactor == -2) {
			if (n.right.right.balanceFactor < 0){
				n.right = RR(n.right);
			} else {
				n.right = RL(n.right);
			}
		}
		
		
	}
	
	

	public Node LL(Node n) {

		Node pivot = n.left;
		Node B = pivot.right;
		Node temp = n;

		n = pivot;
		temp.left = B;
		pivot.right = temp;
		
		int leftFactor = (n.left == null) ? -1 : n.left.balanceFactor;
		int rightFactor = (n.right == null) ? -1 : n.right.balanceFactor;
		n.balanceFactor = leftFactor - rightFactor;
		
		return n;
	}
	
	public Node RR(Node n) {

		Node pivot = n.right;
		Node B = pivot.left;
		Node temp = n;

		n = pivot;
		temp.right = B;
		pivot.left = temp;
		
		int leftFactor = (n.left == null) ? -1 : n.left.balanceFactor;
		int rightFactor = (n.right == null) ? -1 : n.right.balanceFactor;
		n.balanceFactor = leftFactor - rightFactor;

		return n;
	}
	
	public Node LR(Node n){
		n.left = RR(n.left);
		n = LL(n);
		return n;
	}
	
	public Node RL(Node n){
		n.right = LL(n.right);
		n = RR(n);
		return n;
	}
	
	public int balanceFactor(Node n){
		if (n == null){
			return -1;
		}
		
		return 0;
		
	}

	@Override
	public void delete(T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public int height() {
		return height(root);
	}

	public int height(Node n) {
		if (n == null) {
			return -1;
		}
		return 1 + Math.max(height(n.left), height(n.right));
	}

	@Override
	public String toString() {
		if (root == null) {
			return "[ ]";
		}
		return root.toString();
	}

	public class Node {
		private int balanceFactor;
		private T value;
		private Node left;
		private Node right;

		public Node(T value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
			
			int leftFactor = (this.left == null) ? -1 : this.left.balanceFactor;
			int rightFactor = (this.right == null) ? -1 : this.right.balanceFactor;
			this.balanceFactor = leftFactor - rightFactor;
		}

		public Node(T value) {
			this(value, null, null);
		}

		// TODO: equals & hashcode.
		@Override
		public String toString() {

			if (left == null) {
				if (right == null) {
					return "[" + value + "_" + balanceFactor + "]";
				}
				return "[" + value + "_" + balanceFactor  + right + "]";
			}
			if (right == null) {
				return "[" + left + value + "_" + balanceFactor  + "]";
			}
			return "[" + left + value + "_" + balanceFactor  + right + "]";
		}
	}

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		tree.insert(10);
		tree.insert(8); 
		tree.insert(12);
		tree.insert(6);
		tree.insert(4);
		System.out.println(tree);
		//tree.root = tree.RR(tree.root);
		//System.out.println(tree);
	}

}
