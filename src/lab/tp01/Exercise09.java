package lab.tp01;

/**
 * 9. Implementar un algoritmo recursivo que permita calcular potencias de
 * números reales donde el exponente es un número entero, utilizando la
 * propiedad: x^(2n) = x^n . x^n. ¿Cuál es el orden de complejidad temporal del
 * algoritmo? 
 * 
 * Orden Mejor Caso: {@code log(n)}.
 * Orden Peor Caso: {@code }
 * 
 * @author Qcho
 */
public class Exercise09 {

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

	public static double pow(double n, int exp) {
		if (n == 0) {
			return 0;
		}
		if (exp == 0) {
			return 1;
		} else if (exp < 0) {
			n = 1 / n;
			exp = -exp;
		}
		return (exp % 2 == 0) ? pow_internal(n, exp) : n * pow_internal(n, exp - 1);
	}

	private static double pow_internal(double n, int exp) {
		if (exp == 1) {
			return n;
		} else {
			double pow = pow(n, exp / 2);
			return pow * pow;
		}
	}
}
