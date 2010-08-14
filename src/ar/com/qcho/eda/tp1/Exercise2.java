package ar.com.qcho.eda.tp1;

import java.util.ArrayList;
import java.util.List;

import ar.com.qcho.eda.Util;

public class Exercise2 {

    public static void main(String[] args) {

	List<Long> times = new ArrayList<Long>();

	for (int i = 0; i < 1000; i++) {
	    Integer[] array = Util.getRandomIntegerArray(i);
	    long startTime = System.currentTimeMillis();
	    array = bubbleSort(array);
	    long endTime = System.currentTimeMillis();
	    times.add(i, endTime - startTime);
	}
	System.out.println(times);
    }

    public static Integer[] bubbleSort(Integer[] array) {
	boolean swapped;
	int comparations = 0;
	do {
	    swapped = false;
	    for (int i = 0; i < array.length - 1; i++) {
		if (array[i] > array[i + 1]) {
		    Util.swap(array, i, i + 1);
		    swapped = true;
		    comparations++;
		}
		comparations++;
	    }
	    comparations++;
	} while (swapped);
	//System.out.println(comparations);
	return array;
    }
}
