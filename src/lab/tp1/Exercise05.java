package lab.tp1;

import java.util.Arrays;

import lab.Util;

public class Exercise05 {
	
	public static void main(String[] args) {
		Integer[] array = Util.getRandomIntegerArray(100);
		System.out.println(hasRepeated(array) + "|" + Arrays.toString(array));
	}

	public static <T extends Comparable<? super T>> boolean hasRepeated(T[] array) {

		for (int i = 0 ; i < array.length; i++){
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					return true;
				}
			}
		}
		return false;
	}

}
