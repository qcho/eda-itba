package lab.tp1;

import java.util.Arrays;
import lab.CombinationGenerator;
import lab.PermutationGenerator;
import lab.SystematicGenerator;

/**
 * 12. Escribir un programa que dado un string en donde no hay caracteres repetidos imprima todas las posibles combinaciones de sus caracteres.
 * Ejemplo: para la entrada “ABC” se debe obtener como salida: ABC, ACB, BAC, BCA, CAB, CBA
 *
 * @author Qcho
 */
public class Exercise12 {

    public static void main(String[] args) {

	//String[] elements = {"A", "B", "C", "D", "E", "F", "G"};
	char[] elements = "ABC".toCharArray();
	char[] elements2 = "ABBA".toCharArray();

	SystematicGenerator combinator = new CombinationGenerator(elements.length, 3);
	SystematicGenerator permutator = new PermutationGenerator(elements.length);
	SystematicGenerator permutator2 = new PermutationGenerator(elements2.length);

	generate(combinator, elements);
	generate(permutator, elements);
	generate(permutator2, elements2);


    }

    public static <T> void generate(SystematicGenerator x, char[] elements) {
	System.out.println("running " + x.getClass().getName());
	int[] indices;
	StringBuilder combination;
	while (x.hasMore()) {
	    combination = new StringBuilder();
	    indices = x.getNext();
	    for (int i = 0; i < indices.length; i++) {
		combination.append(elements[indices[i]]);
	    }
	    System.out.println(Arrays.toString(indices) + " " + combination.toString());
	}
    }
//    public static Collection<String> getPermutations(String source) {
//	Collection<String> permutations = new HashSet<String>();
//	char[] chars = source.toCharArray();
//
//	for (int i = 0; i < chars.length; i++) {
//	    char c = chars[i];
//
//	}
//
//	return permutations;
//    }
//
//    int level = -1;
//    int[] perms;
//
//    /**
//     * Recursive algorithm
//     * The recursive algorithm is short and mysterious. 
//     * It's executed with a call visit(0). 
//     * Global variable level is initialized to -1 whereas every entry of the array Value is initialized to 0.
//     */
//    void visit(int k) {
//	level = level + 1;
//	Value[k] = level;    // = is assignment
//	if (level == N) // == is comparison
//	{
//	    AddItem();     // to the list box
//	} else {
//	    for (int i = 0; i < N; i++) {
//		if (Value[i] == 0) {
//		    visit(i);
//		}
//	    }
//	}
//	level = level - 1;
//	Value[k] = 0;
//    }
//
//    void AddItem() {
//	// Form a string from Value[0], Value[1], ... Value[N-1].
//	// At this point, this array contains one complete permutation.
//	// The string is added to the list box for display.
//	// The function, as such, is inessential to the algorithms.
//    }
//
//    /**
//     * Lexicographic order and finding the next permutation
//     * Permutation f precedes a permutation g in the lexicographic (alphabetic)
//     * order iff for the minimum value of k such that f(k) g(k), we have f(k) < g(k).
//     * Starting with the identical permutation f(i) = i for all i, the second
//     * algorithm generates sequentially permutaions in the lexicographic order.
//     * The algorithm is described in [Dijkstra, p. 71].
//     */
//    void getNext() {
//	int i = N - 1;
//	while (Value[i - 1] >= Value[i]) {
//	    i = i - 1;
//	}
//	int j = N;
//	while (Value[j - 1] <= Value[i - 1]) {
//	    j = j - 1;
//	}
//// swap values at positions (i-1) and (j-1)
//	swap(i - 1, j - 1);
//	i++;
//	j = N;
//	while (i < j) {
//	    swap(i - 1, j - 1);
//	    i++;
//	    j--;
//	}
//    }
//
//    /**
//     * B. Heap's algorithm
//     * Heap's short and elegant algorithm is implemented as a recursive method
//     * HeapPermute [Levitin, p. 179]. It is invoked with HeapPermute(N).
//     */
//    void HeapPermute(int n) {
//	if (n == 1) {
//	    AddItem();
//	} else {
//	    for (int i = 0; i < n; i++) {
//		HeapPermute(n - 1);
//	    }
//
//	    if (n % 2 == 1) // if n is odd
//	    {
//		swap(0, n - 1);
//	    } else // if n is even
//	    {
//		swap(i, n - 1);
//	    }
//	}
//    }
}
