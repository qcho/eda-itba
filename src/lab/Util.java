package lab;

import java.util.Random;

public class Util {

    public final static Random randomizer = new Random();

    /**
     * Returns a random Integer(from 0 to size) array of length size.
     * @param size the length of the array.s
     * @return unsorted Integer array
     */
    public static Integer[] getRandomIntegerArray(int size) {
	Integer[] array = new Integer[size];
	for (int i = 0; i < array.length; i++) {
	    array[i] = randomizer.nextInt(size);
	}
	return array;
    }

    /**
     * finds the first ocurrence's index of element in the array. if element not found, -1 is returned instead.
     * @param array
     * @param element
     * @return -1 if element not in array. the index of the element if exists.
     */
    public static <T extends Comparable<? super T>> int find(T[] array, T element) {
	for (int i = 0; i < array.length; i++) {
	    if (element.compareTo(array[i]) == 0) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * Generic swap method. Swaps array[i] with array[j].
     *
     * @param <T>
     * @param array array to be swapped
     * @param i swap index
     * @param j swap index
     */
    public static <T> void swap(T[] array, int i, int j) {
	T aux = array[i];
	array[i] = array[j];
	array[j] = aux;
    }

    /**
     * Checks if an array is sorted or not.
     *
     * @param <T> any Comparable class.
     * @param array the array to be checked if sorted
     * @return true if array is sorted. false if not.
     */
    public static <T extends Comparable<? super T>> boolean isSorted(T[] array) {
	for (int i = 0; i < array.length - 1; i++) {
	    if (array[i].compareTo(array[i + 1]) > 0) {
		return false;
	    }
	}
	return true;
    }

    /**
     * BubbleSort for generic arrays.
     *
     * @param <T> any Comparable class.
     * @param array the array to be sorted.
     * @return the number of comparations made. Useful for Order Calculation.
     */
    public static <T extends Comparable<? super T>> int bubbleSort(T[] array) {
	boolean swapped;
	int comparations = 0;
	do {
	    swapped = false;
	    for (int i = 0; i < array.length - 1; i++) {
		if (array[i].compareTo(array[i + 1]) > 0) {
		    Util.swap(array, i, i + 1);
		    swapped = true;
		    comparations++;
		}
		comparations++;
	    }
	    comparations++;
	} while (swapped);
	//System.out.println(comparations);
	return comparations;
    }
}
