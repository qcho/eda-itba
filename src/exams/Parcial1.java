package exams;

import java.util.ArrayList;
import java.util.List;

import trees.AVLTree.Node;

public class Parcial1 {

	public class BTree<T> {

		private final int order;
		private List<Node> list;

		public BTree(int order) {
			this.order = order;
			this.list = new ArrayList<Node>(this.order);
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
		
		
		
		
		
		
		public List<T> range(T low, T upp) {
			List<T> list = new ArrayList<T>();
			
			
			return list;
		}

	}

}
