package  ar.com.qcho.eda;

import java.util.Random;

public class Util {

    public final static Random randomizer = new Random();

    public static Integer[] getRandomIntegerArray(int size) {
	Integer[] array = new Integer[size];
	for (int i = 0; i < array.length; i++) {
	    array[i] = randomizer.nextInt(1024);
	}
	return array;
    }

    public static <T> void swap(T[] array, int i, int j) {
	T aux = array[i];
	array[i] = array[j];
	array[j] = aux;
    }
}
