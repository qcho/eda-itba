package lab.tp01;

import lab.util.Util;

public class ArrayUtils {
	
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
	 * BubbleSort for generic arrays.
	 * 
	 * @param <T>
	 *            any Comparable class.
	 * @param array
	 *            the array to be sorted.
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
				}
				comparations++; // if
				comparations++; // for
			}
			comparations++; // salida del for
			comparations++; // while
		} while (swapped);
		// System.out.println(comparations);
		return comparations;
	}

	/**
	 * Optimized BubbleSort for generic arrays.
	 * 
	 * @param <T>
	 *            any Comparable class.
	 * @param array
	 *            the array to be sorted.
	 * @return the number of comparations made. Useful for Order Calculation.
	 */
	public static <T extends Comparable<? super T>> int bubbleSortOptimized(T[] array) {
		int n = array.length;
		int newn;
		int comparations = 0;
		do {
			newn = 0;
			for (int i = 0; i < n - 1; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					Util.swap(array, i, i + 1);
					newn = i + 1;
				}
				comparations++; // if
				comparations++; // for
			}
			n = newn;
			comparations++; // salida del for
			comparations++; // while
		} while (n > 1);
		// System.out.println(comparations);
		return comparations;
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
     * Method that checks if the array has repeated elements (optimized for sorted arrays).
     *
     * @param <T> any comparable class.
     * @param array array to be checked.
     * @param isSorted is the array sorted or not?
     * @return
     */
    public static <T extends Comparable<? super T>> boolean hasRepeated(T[] array, boolean isSorted) {

	if (isSorted) {
	    for (int i = 0; i < array.length - 1; i++) {
		if (array[i].compareTo(array[i + 1]) == 0) {
		    return true;
		}
	    }
	} else {
	    for (int i = 0; i < array.length - 1; i++) {
		for (int j = i + 1; j < array.length - 1; j++) {
		    if (array[i].compareTo(array[j]) == 0) {
			return true;
		    }
		}
	    }

	}
	return false;
    }
    
    /**
	 * First Aproach, this can be optimized by jumping to the array[array[i]]
	 * because it's sorted.
	 * 
	 * @param array
	 * @return
	 */
	public static int check(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			Integer element = array[i];
			System.out.println("checking array[" + i + "] -> " + element);
			if (element.compareTo(i) == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param array
	 * @return
	 */
	public static int checkOptimized(Integer[] array) {
		for (int i = findFirstNonNegative(array); i < array.length && i >= 0; i++) {
			Integer element = array[i];
			System.out.println("checking array[" + i + "] -> " + element);
			int diff = element.compareTo(i);
			if (diff == 0) {
				return i;
			} else if (diff > 0) {
				i = element - 1;
			}
		}
		return -1;
	}
	
	public static int checkOptimized2(Integer[] array) {
		for (int i = 0; i < array.length && i >= 0; i++) {
			Integer element = array[i];
			System.out.println("checking array[" + i + "] -> " + element);
			if (element.compareTo(i) == 0) {
				return i;
			} else {
				i = element - 1;
			}
		}
		return -1;
	}

	private static int findFirstNonNegative(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			Integer element = array[i];
			if (Integer.signum(element) >= 0) {
				return i;
			}
		}
		return -1;
	}
	// TODO: preguntar complejidad en este caso. y si es posible mejorarlo.
	// TODO: hacerlo lineal.
	
	

}
