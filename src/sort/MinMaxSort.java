package sort;

import java.util.Arrays;

public class MinMaxSort {

	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int from, int to) {
		if (to > from) {
			int minIndex = findMinIndex(array, from, to);
			swap(array, from, minIndex);

			int maxIndex = findMaxIndex(array, from, to);
			swap(array, to, maxIndex);

			sort(array, from + 1, to - 1);
		}
	}

	public static int findMinIndex(int[] array, int from, int to) {
		int minIndex = from;
		for (int i = from; i <= to; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static int findMaxIndex(int[] array, int from, int to) {
		int maxIndex = from;
		for (int i = from; i <= to; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private static void swap(int x[], int a, int b) {
		int t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	public static void main(String[] args) {
		//int[] array = { 7, 3, 6, 2, 5, 9, 4, 8, 1, 0, -1 };
		// int[] array = { 9, 1, 8, 2, 3 };
		 int[] array = { 9, 8, 3, 2, 1 };
		// int[] array = {7, 5};
		System.out.println(Arrays.toString(array));
		MinMaxSort.sort(array);
		System.out.println(Arrays.toString(array));

	}

}
