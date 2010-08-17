package lab;

//------------------------------------------------------
// This class uses different algorithms to compute the
// greatest common divisor of two non-negative integers.
//------------------------------------------------------
import java.math.BigInteger;
import java.util.Random;

public abstract class GreatestCommonDivisor {

    //------------------------------------
    // Euclid algorithm, Elements, Book 7,
    // Propositions 1-2 (circa 300 BC)
    //------------------------------------
    public static long euclidAlgorithmIterative(long u, long v) {

	trace("Euclid algorithm,  iterative");
	long gcd = 0;
	long r = 0;

	u = Math.abs(u);
	v = Math.abs(v);

	while (true) {
	    if (v == 0) {
		gcd = u;
		break;
	    } else {
		r = u % v;
		trace("u " + u + ", v " + v + ", u % v " + r);
		u = v;
		v = r;
	    }
	}

	trace("GCD " + gcd);
	return gcd;

    }

    public static long euclidAlgorithmRecursive(long u, long v) {

	trace("Euclid algorithm,  recursive: u  " + u + ", v " + v);
	long gcd = 0;
	long r = 0;

	u = Math.abs(u);
	v = Math.abs(v);

	if (v == 0) {
	    gcd = u;
	    trace("GCD " + gcd);
	} else {
	    gcd = euclidAlgorithmRecursive(v, u % v);
	}

	return gcd;

    }

    //--------------------------------------------------------
    // Is number even or odd? We have to do this without
    // resorting to division, no matter how inefficient it is.
    //--------------------------------------------------------
    private static boolean isEven(long n) {
	String s = Long.toBinaryString(n);
	int length = s.length();
	String last = s.substring(length - 1, length);
	return last.equals("0");
    }

    private static boolean isOdd(long n) {
	return !isEven(n);
    }

    //-------------------------------------
    // Binary algorithm (uses no division),
    // invented by Josef Stein in 1961.
    // See J. Comp. Phys. 1 (1967) 397-405
    //-------------------------------------
    private static long binaryAlgorithm(long u, long v) {

	trace("Binary algorithm, u " + u + ", v " + v);
	long gcd = 0;
	long k = 0;
	long t = 0;

	u = Math.abs(u);
	v = Math.abs(v);

	// Find power of 2

	while (true) {

	    if (isOdd(u)) {
		break;
	    }

	    if (isOdd(v)) {
		break;
	    }

	    k++;
	    u = u >> 1;
	    v = v >> 1;

	}

	trace("k " + k);

	// Initialize

	if (isOdd(u)) {
	    t = -v;
	} else {
	    t = u >> 1;
	}

	while (true) {

	    trace("u " + u + ", v " + v + ", t " + t);

	    // Make t even

	    if (isEven(t)) {
		t = t >> 1;
	    } else {

		// Reset max (u, v)

		if (t > 0) {
		    u = t;
		} else {
		    v = -t;
		}

		// Subtract and check for completion

		t = u - v;
		if (t == 0) {
		    gcd = u * (long) Math.pow(2, k);
		    break;
		}
	    }
	}

	trace("GCD " + gcd);
	return gcd;

    }

    //---------------------------
    // Use Java's built in method
    //---------------------------
    public static long builtInMethod(long u, long v, boolean traceFlag) {
	BigInteger bigU = new BigInteger(Long.toString(u));
	BigInteger bigV = new BigInteger(Long.toString(v));
	long gcd = bigU.gcd(bigV).longValue();
	if (traceFlag) {
	    trace("GCD (" + u + ", " + v + ") = " + gcd);
	}
	return gcd;
    }

    //------
    // Trace
    //------
    private static void trace(String s) {
	System.out.println(s);
    }

    //-----
    // Test
    //-----
    public static void main(String[] args) {

	// These numbers are from Knuth

	long u = 40902;
	long v = 24140;
	long gcd = 0;

	gcd = GreatestCommonDivisor.euclidAlgorithmIterative(u, v);
	gcd = GreatestCommonDivisor.euclidAlgorithmRecursive(u, v);
	gcd = GreatestCommonDivisor.binaryAlgorithm(u, v);
	gcd = GreatestCommonDivisor.builtInMethod(u, v, true);

	// Dirichlet's theorem

	double total = 1000;
	double relativelyPrime = 0;
	Random generator = new Random(System.currentTimeMillis());
	for (int i = 0; i < (int) total; i++) {
	    u = generator.nextLong();
	    v = generator.nextLong();
	    gcd = GreatestCommonDivisor.builtInMethod(u, v, false);
	    if (gcd == 1) {
		relativelyPrime++;
	    }
	}
	System.out.println("Dirichlet's theorem, actual "
		+ relativelyPrime / total
		+ ", expected 0.608");

    }
}
