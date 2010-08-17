package lab.tp1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Qcho
 */
public class Exercise11 {

    public static void main(String[] args) {

	Integer[] array1 = {1,2,3,4,5};
	Integer[] array2 = {3,5,6,7};
	System.out.println(Arrays.toString(array1));
	System.out.println(Arrays.toString(array2));
	System.out.println("intersec: " + Arrays.toString(arrayIntersec(array1, array2)));
    }

    public static <T extends Comparable<? super T>> T[] arrayIntersec(T[] array1, T[] array2) {
	Collection<T> intersec = new HashSet<T>();
	Arrays.sort(array1);
	Arrays.sort(array2);
	int i = 0;
	int j = 0;

	do {
	    T elem1 = array1[i];
	    T elem2 = array2[j];
	    int diff = elem1.compareTo(elem2);

	    if (diff < 0) {
		i++;
	    } else if (diff == 0) {
		intersec.add(array1[i]);
		i++;
		j++;
	    } else if (diff > 0) {
		j++;
	    }
	} while (i < array1.length && j < array2.length);
	return (T[]) intersec.toArray(new Comparable[0]);

	//TODO: preguntar sobre arrays genericos.
    }
}