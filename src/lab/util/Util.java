package lab.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class Util {

	public final static Random randomizer = new Random();

	/**
	 * Returns a random Integer(from 0 to size) array of integers.
	 * 
	 * @param size
	 *            the length of the array.s
	 * @return unsorted Integer array
	 */
	public static Integer[] getRandomIntegerArray(int size, int maxInt, boolean withNegatives, boolean withRepeated) {
		if (!withRepeated && maxInt<size) {
			throw new IllegalArgumentException("can't create a random a");
		}
		
		Collection<Integer> numbers;

		if (withRepeated) {
			numbers = new ArrayList<Integer>();
		} else {
			numbers = new HashSet<Integer>();
		}

		while (numbers.size() < size) {
			numbers.add((withNegatives && numbers.size() % 7 == 0) ? -randomizer.nextInt(maxInt) : randomizer.nextInt(maxInt));
		}
		return numbers.toArray(new Integer[0]);
	}

	/**
	 * Returns a random Integer(from 0 to size) array of integers.
	 * 
	 * @param size
	 *            the length of the array.s
	 * @return unsorted Integer array
	 */
	public static Integer[] getRandomIntegerArray(int size) {
		return getRandomIntegerArray(size, size, false, true);
	}

	/**
	 * Generic swap method. Swaps array[i] with array[j].
	 * 
	 * @param <T>
	 * @param array
	 *            array to be swapped
	 * @param i
	 *            swap index
	 * @param j
	 *            swap index
	 */
	public static <T> void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	// TODO: preguntar porque el SWAP es lo que mas tarda si son sólo
	// asignaciones.
}
