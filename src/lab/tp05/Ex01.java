package lab.tp05;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementar métodos que resuelvan las siguientes operaciones:
 * a. Calcular la altura del árbol (el árbol vacío tiene altura -1).
 * b. Calcular la cantidad de nodos.
 * c. Calcular cuántas veces aparece un determinado valor en el árbol.
 * d. Calcular el ancho de un determinado nivel (cantidad real de nodos en dicho nivel).
 * e. Buscar el mayor elemento.
 *
 * @param <T>
 */
public class Ex01<T> extends BinaryTree<T> {

	public Ex01(T value) {
		this(value, null, null);
	}

	public Ex01(T value, BinaryTree<T> left, BinaryTree<T> right) {
		super(value, left, right);
	}

	public static <T> int height(BinaryTree<T> tree) {
		if (tree == null) {
			return -1;
		}
		if (tree.getLeft() == null && tree.getRight() == null) {
			return 0;
		}
		return 1 + Math.max(height(tree.getLeft()), height(tree.getRight()));
	}

	public static <T> int nodeCount(BinaryTree<T> tree) {
		if (tree == null) {
			return 0;
		}
		return 1 + nodeCount(tree.getLeft()) + nodeCount(tree.getRight());
	}
	
	public static <T> int valueCount(BinaryTree<T> tree, T value){
		if (tree == null) {
			return 0;
		}
		return (value.equals(tree.getValue()) ? 1 : 0) + valueCount(tree.getLeft(), value) + valueCount(tree.getRight(), value);
	}
	
	public static <T> int levelWidth(BinaryTree<T> tree, int level){
		if (tree == null){
			return 0;
		}
		if (level==0){
			return 1;
		}
		
		return levelWidth(tree.getLeft(), level-1) + levelWidth(tree.getRight(), level -1);
	}
	
	public static <T> T max(BinaryTree<T> tree, Comparator<T> comp){
		if (tree == null){
			return null;
		}
		
		T max = tree.getValue();
		T maxLeft = max(tree.getLeft(), comp);
		T maxRight = max(tree.getRight(), comp);
		
		if (maxLeft != null){
			max = (comp.compare(max, maxLeft) > 0) ? max : maxLeft;
		}
		if (maxRight != null){
			max = (comp.compare(max, maxRight) > 0) ? max : maxRight;
		}
		
		return max;
		
	}
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		Queue<BinaryTree<T>> q = new LinkedList<BinaryTree<T>>();
		q.add(this);
		
		while (!q.isEmpty()){
			BinaryTree<T> subTree = q.remove();
			s.append(subTree.getValue() + " ");
			if (subTree.getLeft() != null){
				q.add(subTree.getLeft());
			}
			if (subTree.getRight() != null){
				q.add(subTree.getRight());
				s.append('\n');
			}
		}
		
		return s.toString();
		
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> left = new Ex01<Integer>(1, new Ex01<Integer>(2), new Ex01<Integer>(3));
		BinaryTree<Integer> right = new Ex01<Integer>(4, new Ex01<Integer>(5), new Ex01<Integer>(6));
		BinaryTree<Integer> tree = new Ex01<Integer>(9, left, right);

		System.out.println("height: " + height(tree));
		System.out.println("nodes: " + nodeCount(tree));
		System.out.println("4 in tree: " + valueCount(tree, 4));
		System.out.println("width lvl 2: " + levelWidth(tree, 1));
		System.out.println("max value: " + max(tree, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}));
		
		System.out.println(tree);
	}

}
//                    9
//         1                     4
//    2         3           5         6
//null null null null   null null null null
