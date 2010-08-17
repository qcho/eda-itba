package lab;

import java.util.Random;

public class Util {

    public final static Random randomizer = new Random();

    /**
     * Returns a random Integer(from 0 to size) array of integers.
     * @param size the length of the array.s
     * @return unsorted Integer array
     */
    public static Integer[] getRandomIntegerArray(int size, boolean withNegatives, int maxInt) {
	Integer[] array = new Integer[size];
	for (int i = 0; i < array.length; i++) {
	    array[i] = (withNegatives && i%7==0) ? -randomizer.nextInt(maxInt) : randomizer.nextInt(maxInt);
	}
	return array;
    }

    /**
     * Returns a random Integer(from 0 to size) array of integers.
     * @param size the length of the array.s
     * @return unsorted Integer array
     */
    public static Integer[] getRandomIntegerArray(int size) {
	return getRandomIntegerArray(size, false, size);
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
    //TODO: preguntar porque el SWAP es lo que mas tarda si son sólo asignaciones.
}
