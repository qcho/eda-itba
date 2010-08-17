package lab.tp1;

import java.util.List;

/**
 *	3. Considerar las siguientes implementaciones de un método para encontrar el máximo elemento de
 *	una lista. ¿Cuál es el orden de complejidad temporal en cada caso?
 * @author Qcho
 */
public class Exercise03 {

    /**
     * Orden: depende de la implementación de list; del orden de .get(i)
     */
    public static <T extends Comparable<? super T>> T max1(List<? extends T> list) {
	T max = null;
	for (int i = 0; i < list.size(); i++) {
	    if (max == null || list.get(i).compareTo(max) > 0) {
		max = list.get(i);
	    }
	}
	return max;
    }

    /**
     * Orden:
     */
    public static <T extends Comparable<? super T>> T max2(List<? extends T> list) {
	T max = null;
	for (T elem : list) {
	    if (max == null || elem.compareTo(max) > 0) {
		max = elem;
	    }
	}
	return max;
    }

}
