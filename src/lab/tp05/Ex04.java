package lab.tp05;

import java.util.Arrays;
import java.util.Comparator;

import trees.AVLTree;
import trees.Tree;

public class Ex04<T> {

	public static int[] array = { 1, 2, 3, 4, 5, 6, 8, 15, 20 };

	public static Tree<Integer> arrayToTree(int[] sortedArray) {
		Tree<Integer> tree = new BSTree<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		arrayToTree(tree, sortedArray, 0, sortedArray.length - 1);

		return tree;
	}

	private static void arrayToTree(Tree<Integer> tree, int[] sortedArray, int from, int to) {
		if (from < to) {
			int mid = (to + from) / 2;
			tree.insert(sortedArray[mid]); // donde??
			arrayToTree(tree, sortedArray, from, mid);
			arrayToTree(tree, sortedArray, mid + 1, to);
		}
	}

	public static void main(String[] args) {
		System.out.println(arrayToTree(array));
	}

}
