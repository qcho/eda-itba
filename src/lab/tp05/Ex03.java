package lab.tp05;


public class Ex03<T> extends Ex02<T> {

	public Ex03(T value, BinaryTree<T> left, BinaryTree<T> right) {
		super(value, left, right);
		// TODO Auto-generated constructor stub
	}

	public static <T> boolean areMirrored(BinaryTree<T> t1, BinaryTree<T> t2) {
		if (t1 == null && t2 == null) {
			return true;
		}

		if (t1 == null || t2 == null) {
			return false;
		}

		return areMirrored(t1.getLeft(), t2.getRight()) && areMirrored(t1.getRight(), t2.getLeft());

	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> left = new Ex01<Integer>(1, null, null);
		BinaryTree<Integer> right = new Ex01<Integer>(4, new Ex01<Integer>(5), new Ex01<Integer>(6));
		BinaryTree<Integer> t1 = new Ex01<Integer>(9, left, right);
		
		BinaryTree<Integer> left2 = new Ex01<Integer>(1, new Ex01<Integer>(2), new Ex01<Integer>(3));
		BinaryTree<Integer> right2 = new Ex01<Integer>(4, null, null);
		BinaryTree<Integer> t2 = new Ex01<Integer>(9, left2, right2);

		System.out.println("mirrored: " + areMirrored(t1, t2));
	}

}
