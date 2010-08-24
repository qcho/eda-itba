/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.util;

import java.util.Arrays;

public class HeapPermute {

    public static void main(String[] args) {
	char[] charString = {' ', 'H', 'O', 'L', 'Y', 'T', 'R', 'I', 'N', 'I', 'T', 'Y'};
	charString = " ABC".toCharArray();
	heapPermute(charString);
    }

    public static void heapPermute(char[] charArray){
	heapPermute(charArray.length -1, charArray);
    }

    private static void heapPermute(int n, char[] charArray) {
	if (n == 1) {
	    print(charArray);
	} else {
	    for (int i = 1; i <= n; i++) {
		heapPermute(n - 1, charArray);

		if ((n % 2) == 1) {
		    swap(1, n, charArray);
		} else {
		    swap(i, n, charArray);
		}
	    }
	}
    }

    private static void swap(int first, int second, char[] array) {
	char temp = array[first];
	array[first] = array[second];
	array[second] = temp;
    }

    private static void print(char[] array) {
	System.out.println("array: " + Arrays.toString(array));
	for (int j = 0; j < array.length; j++) {
	    System.out.print(array[j]);
	}
	System.out.println();
    }
}
