package lab.tp01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lab.util.Util;

/**
 *  1. Determinar el orden de complejidad temporal requerido para realizar las siguientes operaciones:
 *	a. Buscar un elemento en un arreglo desordenado.
 *	    Orden: {@code n}. Voy de a uno.
 *	    Peor Caso: {@code i=n}}.
 *
 *	b. Acceder al i-ésimo elemento de un arreglo.
 *	    Orden: {@code 1}. Se accede directamente.
 *	    Peor Caso: no presenta.
 *
 *	c. Acceder al i-ésimo elemento de una lista lineal simplemente encadenada.
 *	    Orden: {@code n}. Recorrer uno a uno los elementos hasta acceder al elemento n.
 *	    Peor Caso: {@code i=n}.
 *
 *	d. Insertar un elemento en la i-ésima posición de un arreglo, manteniéndolo ordenado.
 *	    Orden: {@code n}. Insertar el elemento en la posicion {@code i} es directo. Pero primero hay que mover todos los demas elementos una posición.
 *	    Peor Caso: {@code i=0}.
 *
 *	e. Insertar un elemento en la i-ésima posición de una lista lineal simplemente encadenada.
 *	    Orden: {@code n}.
 *	    Peor Caso: {@code i=n}.
 *
 *	f. Búsqueda binaria sobre un arreglo ordenado.
 *	    Orden: {@code log(n)}.
 *	    Peor Caso: no presenta.
 *
 *	g. Eliminar el último elemento de una lista lineal simplemente encadenada.
 *	    Orden: {@code n}. Moverme hasta el final y borrarlo.
 *	    Peor Caso: no presenta.
 *
 *	h. Determinar la cantidad de elementos en una lista lineal simplemente encadenada.
 *	    Orden: {@code n}. Contar uno a uno los elementos.
 *	    Peor Caso: no presenta.
 *
 *	i. Multiplicar dos matrices (cuadradas).
 *	    Orden: {@code n^3}. multiplicar uno a uno los elementos de cada matriz y luego esos resultados sumarlos.
 *	    Peor Caso: no presenta.
 *
 * @author Qcho
 */
public class Ex01 {

    public static void main(String[] args) {

	Integer[] unsortedArray = Util.getRandomIntegerArray(10);
	System.out.println("array: " + Arrays.toString(unsortedArray));
	int index = ArrayUtils.find(unsortedArray, 9);
	System.out.println("Buscar un elemento en un arreglo desordenado. index of element '9': " + index);

	System.out.println("array[" + index + "] -> " + unsortedArray[index]);

	List<Integer> list = new LinkedList<Integer>();
    }
}
