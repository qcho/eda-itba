package lab.tp01;

import java.util.Arrays;

import lab.Util;

/**
 *  4. Implementar un método que determine si un arreglo está ordenado ascendentemente o no.
 * ¿Cuál es el orden de complejidad temporal?
 *	Orden: {@code n}.
 * ¿Cuál es el peor y el mejor caso?
 *	Peor Caso: {@code array} ordenado.
 *	Mejor Caso: {@code array[1] > array[2]}.
 *
 * @author Qcho
 */
public class Exercise04 {

    public static void main(String[] args) {
	Integer[] array = Util.getRandomIntegerArray(100);
	System.out.println(Exercise04.isSorted(array) + "|" + Arrays.toString(array));
	int comparations = Exercise02.bubbleSort(array);
	System.out.println(Exercise04.isSorted(array) + "|" + Arrays.toString(array));
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
    
}
