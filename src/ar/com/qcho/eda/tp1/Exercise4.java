package ar.com.qcho.eda.tp1;

import java.util.Arrays;

import ar.com.qcho.eda.Util;

public class Exercise4 {

	public static void main(String[] args) {
		Integer[] array = Util.getRandomIntegerArray(100);
		System.out.println(isSorted(array) + "|" + Arrays.toString(array));
		Integer[] sortedArray = Exercise2.bubbleSort(array);
		System.out.println(isSorted(array) + "|" + Arrays.toString(sortedArray));
	}

	public static <T extends Comparable<? super T>> boolean isSorted(T[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}
}
