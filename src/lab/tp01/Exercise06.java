package lab.tp01;

import java.util.Arrays;
import lab.Util;

/**
 * 6. Escribir un algoritmo eficiente para determinar si existe un entero i tal que Ai = i en un vector de enteros {@code A1 < A2 < A3 < ... < An}.
 *
 * ¿Cuál es la complejidad del algoritmo?
 *	Orden: 
 *
 * @author Qcho
 */
public class Exercise06 {

    public static void main(String[] args) {
//	Integer[] vector = {1,4,5,6,7,8,11,12,13,14,14,14,14,14,14,14};
//	Integer[] vector = {1,4,5,6,7,8,11,12,13,14,14,14,14,14,30,31};
	Integer[] vector = Util.getRandomIntegerArray(100, true, 120);



	Exercise02.bubbleSortOptimized(vector);
	System.out.println(Arrays.toString(vector));
	System.out.println("existe un entero i tal que Ai = i? " + Exercise06.check(vector));
	System.out.println();
	System.out.println("existe un entero i tal que Ai = i? " + Exercise06.checkOptimized(vector));
    }

    /**
     * First Aproach, this can be optimized by jumping to the array[array[i]] because it's sorted.
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

    private static int findFirstNonNegative(Integer[] array) {
	for (int i = 0; i < array.length; i++) {
	    Integer element = array[i];
	    if (Integer.signum(element) >= 0) {
		return i;
	    }
	}
	return -1;
    }
    //TODO: preguntar complejidad en este caso. y si es posible mejorarlo.
}
