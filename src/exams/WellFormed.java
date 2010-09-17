package exams;

public class WellFormed {
	
	public static int indexOf(char e, char[] array) {
		for (int i = 0; i < array.length; i++) {
			if (e == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public static boolean wellFormed(char[] str) {
		int[] stack = new int[str.length];
		int i = 0;

		char[] begin = { '{', '(', '[' };
		char[] end = { '}', ')', ']' };

		for (char c : str) {
			int beginIndex;
			int endIndex;

			if ((beginIndex = indexOf(c, begin)) >= 0) {
				stack[i++] = beginIndex;
			} else if ((endIndex = indexOf(c, end)) >= 0) {
				if (i == 0 || stack[--i] != endIndex) {
					return false;
				}
			}
		}

		if (i == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		//char[] str = { '{', '[', '(', ')', ']', '}' };
		char[] str = { '(', '(', '{', ')', '}', ')' };
		
		System.out.println("is well formed? " + wellFormed(str));
	}

}
