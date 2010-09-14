package lab.tp01;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * @author Qcho
 */
public class Ex10 {

	public static void main(String[] args) {

		Integer[] array1 = { 1, 2, 3, 4, 5 };
		Integer[] array2 = { 3, 5, 6, 7 };
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println("intersec: " + Arrays.toString(arrayIntersec(array1, array2)));
	}

	@SuppressWarnings("unchecked") // because of return (T[]) intersec.toArray();
	public static <T extends Comparable<? super T>> T[] arrayIntersec(T[] array1, T[] array2) {
		Collection<T> intersec = new HashSet<T>();

		for (int i = 0; i < array1.length; i++) {
			T elem1 = array1[i];
			for (int j = 0; j < array2.length; j++) {
				T elem2 = array2[j];
				if (elem1.compareTo(elem2) == 0) {
					intersec.add(array1[i]);
				}
			}
		}
		return (T[]) intersec.toArray();
	}
}
