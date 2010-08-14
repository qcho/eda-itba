package lab.tp1;

import java.util.Arrays;

import lab.Util;

public class Exercise04 {

    public static void main(String[] args) {
	Integer[] array = Util.getRandomIntegerArray(100);
	System.out.println(Util.isSorted(array) + "|" + Arrays.toString(array));
	int comparations = Util.bubbleSort(array);
	System.out.println(Util.isSorted(array) + "|" + Arrays.toString(array));
    }

    
}
