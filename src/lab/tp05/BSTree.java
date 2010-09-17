package lab.tp05;

import java.util.Comparator;

import trees.Tree;

/**
 * NO ADMITE ELEMENTOS NULL.
 * 
 * @author hogomez
 * 
 * @param <T>
 */
public class BSTree<T> implements Tree<T> {

	Node root;
	private final Comparator<T> comp;

	public BSTree(Node root, Comparator<T> comp) {
		this.root = root;
		this.comp = comp;
	}

	public BSTree(Comparator<T> comp) {
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
		private T value;
		private Node left;
		private Node right;

		public Node(T value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public Node(T value) {
			this(value, null, null);
		}

		// TODO: equals & hashcode.
		@Override
		public String toString() {

			if (left == null) {
				if (right == null) {
					return "[" + value + "]";
				}
				return "[" + value + right + "]";
			}
			if (right == null) {
				return "[" + left + value + "]";
			}
			return "[" + left + value + right + "]";
		}
	}
	

	public static void main(String[] args) {
		BSTree<Integer> tree = new BSTree<Integer>(new Comparator<Integer>() {
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
