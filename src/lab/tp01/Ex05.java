package lab.tp01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lab.util.Util;

/**
 * 5. Implementar un método que determine si un arreglo tiene valores duplicados o no. 
 * ¿Cuál es el orden de complejidad temporal? 
 *	Orden: {@code n^2}. Recorre uno a uno los elementos y los compara con todos los siguientes.
 *	Peor Caso: sin repetidos.
 *	Mejor Caso: {@code array[0] == array[1]}.
 * Si el arreglo estuviera ordenado, ¿se podría implementar con una menor complejidad?
 *	Si. La complejidad estando ordenado es {@code n}. Porque sólo recorre una vez el arreglo. Se compara con el siguiente.
 * 
 * @author Qcho
 */
public class Ex05 {

    public static void main(String[] args) {
	Integer[] unsortedArray = Util.getRandomIntegerArray(100);
	Integer[] sortedArray = Util.getRandomIntegerArray(100);
	ArrayUtils.bubbleSortOptimized(sortedArray);

	Set<Integer> set = new HashSet(Arrays.asList(Util.getRandomIntegerArray(100)));
	Integer[] noRepeated = set.toArray(new Integer[0]);

	System.out.println("has repeated? " + ArrayUtils.hasRepeated(unsortedArray, false) + "|" + Arrays.toString(unsortedArray));
	System.out.println("has repeated? " + ArrayUtils.hasRepeated(sortedArray, true) + "|" + Arrays.toString(sortedArray));
	System.out.println("has repeated? " + ArrayUtils.hasRepeated(noRepeated, false) + "|" + Arrays.toString(noRepeated));
    }

    
}
