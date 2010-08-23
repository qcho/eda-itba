package lab.tp01;

/**
 * 8. Implementar un algoritmo recursivo que permita calcular potencias de
 * números reales donde el exponente es un número entero, utilizando la
 * propiedad: x^n = x . x^(n-1). ¿Cuál es el orden de complejidad temporal del
 * algoritmo? Orden: {@code n}.
 * 
 * @author Qcho
 */
public class Exercise08 {

	public static void main(String[] args) {
		System.out.println("2^5: " + pow(2, 5));
		System.out.println("2^-5: " + pow(2, -5));
		System.out.println("6^0: " + pow(6, 0));
		System.out.println("-2^0: " + pow(-2, 0));
		System.out.println("-20^6: " + pow(-20, 6));
		System.out.println("-20^5: " + pow(-20, 5));
		System.out.println("0^22: " + pow(0, 22));
		System.out.println("-8^-3: " + pow(-8, -3));

	}

	public static double pow(double n, double exp) {
		if (n == 0) {
			return 0;
		}
		if (exp < 0) {
			n = 1 / n;
			exp = -exp;
		}
		return pow_internal(n, exp);
	}

	private static double pow_internal(double n, double exp) {
		if (exp == 0) {
			return 1;
		} else {
			return n * pow_internal(n, exp - 1);
		}
	}
}
