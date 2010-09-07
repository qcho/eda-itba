package lab.tp05;


/**
 * Implementar un algoritmo que dado un árbol binario de tipo T y una función f:
 * T → S, construya un nuevo árbol de tipo S con la misma estructura que el
 * original, resultado de aplicarle la función a cada uno de los nodos.
 * 
 * @author hogomez
 * 
 */
public class Ex02<T> extends Ex01<T> {

	public Ex02(T value, BinaryTree<T> left, BinaryTree<T> right) {
		super(value, left, right);
	}

	public static <S, T> BinaryTree<S> reMap(BinaryTree<T> tree, Mapper<T, S> mapFn) {
		if (tree == null){
			return null;
		}
		return new BinaryTree<S>((mapFn.map(tree.getValue())),
				reMap(tree.getLeft(), mapFn), 
				reMap(tree.getRight(), mapFn));
	}

	public interface Mapper<T, S> {
		public S map(T value);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> left = new Ex01<Integer>(1, new Ex01<Integer>(2), new Ex01<Integer>(3));
		BinaryTree<Integer> right = new Ex01<Integer>(4, new Ex01<Integer>(5), new Ex01<Integer>(6));
		BinaryTree<Integer> tree = new Ex01<Integer>(9, left, right);

		BinaryTree<String> sTree = reMap(tree, new Mapper<Integer, String>(){
			@Override
			public String map(Integer value) {
				return value.toString();
			}});
		System.out.println("class tree1: " + tree.getValue().getClass());
		System.out.println("class tree2: " + sTree.getValue().getClass());
	}
}
