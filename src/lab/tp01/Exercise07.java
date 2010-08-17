/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.tp01;

import java.util.Arrays;
import lab.Util;

/**
 *
 * @author Qcho
 */
public class Exercise07 {
    
    public static void main(String[] args) {
//	Integer[] vector = {1,4,5,6,7,8,11,12,13,14,14,14,14,14,14,14};
//	Integer[] vector = {1,4,5,6,7,8,11,12,13,14,14,14,14,14,30,31};
	Integer[] vector = Util.getRandomIntegerArray(100);



	Exercise02.bubbleSortOptimized(vector);
	System.out.println(Arrays.toString(vector));
	System.out.println("existe un entero i tal que Ai = i? " + Exercise06.check(vector));
	System.out.println();
	System.out.println("existe un entero i tal que Ai = i? " + Exercise06.checkOptimized(vector));
    }

    public static int checkOptimized(Integer[] array) {
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

}
