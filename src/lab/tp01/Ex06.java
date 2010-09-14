package lab.tp01;

import java.util.Arrays;

import lab.util.Util;

/**
 * 6. Escribir un algoritmo eficiente para determinar si existe un entero i tal
 * que Ai = i en un vector de enteros {@code A1 < A2 < A3 < ... < An}.
 * 
 * ¿Cuál es la complejidad del algoritmo?
 * 
 * Orden:
 * 
 * @author Qcho
 */
public class Ex06 {

	public static void main(String[] args) {
		Integer[] vector = Util.getRandomIntegerArray(100, 51, true, false);

		ArrayUtils.bubbleSortOptimized(vector);
		System.out.println(Arrays.toString(vector));
		System.out.println("existe un entero i tal que Ai = i? " + ArrayUtils.check(vector));
		System.out.println();
		System.out.println("existe un entero i tal que Ai = i? " + ArrayUtils.checkOptimized(vector));
	}
}
