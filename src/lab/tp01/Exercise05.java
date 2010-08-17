package lab.tp01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lab.Util;

/**
 * 5. Implementar un método que determine si un arreglo tiene valores duplicados o no. 
 * ¿Cuál es el orden de complejidad temporal? 
 *	Orden: {@code n^2}. Recorre uno a uno los elementos y los compara con todos los siguientes.
 *	Peor Caso: sin repetidos.
 *	Mejor Caso: {@code array[0] == array[1]}.
 * Si el arreglo estuviera ordenado, ¿se podría implementar con una menor complejidad?
 *	Si. La complejidad estando ordenado es {@code n}. Porque sólo recorre una vez el arreglo. Se compara con el siguiente.
 * 
 * @author Qcho
 */
public class Exercise05 {

    public static void main(String[] args) {
	Integer[] unsortedArray = Util.getRandomIntegerArray(100);
	Integer[] sortedArray = Util.getRandomIntegerArray(100);
	Exercise02.bubbleSortOptimized(sortedArray);

	Set<Integer> set = new HashSet(Arrays.asList(Util.getRandomIntegerArray(100)));
	Integer[] noRepeated = set.toArray(new Integer[0]);

	System.out.println("has repeated? " + Exercise05.hasRepeated(unsortedArray, false) + "|" + Arrays.toString(unsortedArray));
	System.out.println("has repeated? " + Exercise05.hasRepeated(sortedArray, true) + "|" + Arrays.toString(sortedArray));
	System.out.println("has repeated? " + Exercise05.hasRepeated(noRepeated, false) + "|" + Arrays.toString(noRepeated));
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
}
