package lab.tp01;

import java.util.Arrays;

import lab.util.Util;

/**
 *  4. Implementar un método que determine si un arreglo está ordenado ascendentemente o no.
 * ¿Cuál es el orden de complejidad temporal?
 *	Orden: {@code n}.
 * ¿Cuál es el peor y el mejor caso?
 *	Peor Caso: {@code array} ordenado.
 *	Mejor Caso: {@code array[1] > array[2]}.
 *
 * @author Qcho
 */
public class Ex04 {

    public static void main(String[] args) {
	Integer[] array = Util.getRandomIntegerArray(100);
	System.out.println(ArrayUtils.isSorted(array) + "|" + Arrays.toString(array));
	int comparations = ArrayUtils.bubbleSort(array);
	System.out.println(ArrayUtils.isSorted(array) + "|" + Arrays.toString(array));
    }
    
}
