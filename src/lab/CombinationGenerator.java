/*****************************************
 * Systematically generate combinations.
 *****************************************/
package lab;

import java.math.BigInteger;

public class CombinationGenerator implements SystematicGenerator {

    private int[] a;
    private int n;
    private int r;
    private BigInteger numLeft;
    private BigInteger total;

    /**
     * Systematically generates all combinations of n elements, taken r at a time
     * @param n number of elements.
     * @param r size of combinations.
     */
    public CombinationGenerator(int n, int r) {
	if (r > n) {
	    throw new IllegalArgumentException();
	}
	if (n < 1) {
	    throw new IllegalArgumentException();
	}
	this.n = n;
	this.r = r;
	a = new int[r];
	BigInteger nFact = getFactorial(n);
	BigInteger rFact = getFactorial(r);
	BigInteger nminusrFact = getFactorial(n - r);
	total = nFact.divide(rFact.multiply(nminusrFact));
	reset();
    }

    /**
     * Resets the generation.
     */
    public final void reset() {
	for (int i = 0; i < a.length; i++) {
	    a[i] = i;
	}
	numLeft = new BigInteger(total.toString());
    }

    /**
     * @return number of combinations not yet generated
     */
    public BigInteger getNumLeft() {
	return numLeft;
    }

    /**
     * @return true if there are more combinations to generate.
     */
    public boolean hasMore() {
	return numLeft.compareTo(BigInteger.ZERO) == 1;
    }

    /**
     * @return total number of combinations
     */
    public BigInteger getTotal() {
	return total;
    }

    /**
     * Compute factorial
     *
     * @param n number to get factorial.
     * @return n!
     */
    private static BigInteger getFactorial(int n) {
	BigInteger fact = BigInteger.ONE;
	for (int i = n; i > 1; i--) {
	    fact = fact.multiply(new BigInteger(Integer.toString(i)));
	}
	return fact;
    }

    /**
     * Generate next combination (algorithm from Rosen p. 286)
     * @return combination indexes
     */
    public int[] getNext() {

	if (numLeft.equals(total)) {
	    numLeft = numLeft.subtract(BigInteger.ONE);
	    return a;
	}

	int i = r - 1;
	while (a[i] == n - r + i) {
	    i--;
	}
	a[i] = a[i] + 1;
	for (int j = i + 1; j < r; j++) {
	    a[j] = a[i] + j - i;
	}

	numLeft = numLeft.subtract(BigInteger.ONE);
	return a;

    }
}
