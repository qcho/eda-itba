/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.tp01;

import java.util.Arrays;

import lab.util.Util;

/**
 * 
 * @author Qcho
 */
public class Ex07 {

	public static void main(String[] args) {
		// Integer[] vector = {1,4,5,6,7,8,11,12,13,14,14,14,14,14,14,14};
		// Integer[] vector = {1,4,5,6,7,8,11,12,13,14,14,14,14,14,30,31};
		Integer[] vector = Util.getRandomIntegerArray(100);

		ArrayUtils.bubbleSortOptimized(vector);
		System.out.println(Arrays.toString(vector));
		System.out.println("existe un entero i tal que Ai = i? " + ArrayUtils.check(vector));
		System.out.println();
		System.out.println("existe un entero i tal que Ai = i? " + ArrayUtils.checkOptimized(vector));
	}

	// TODO: busqueda binaria????
}
