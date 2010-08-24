package lab.eda.src.linearlists;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println("Implementacion recursiva:");
		testList(new RecursiveLinearLinkedList<String>());
		System.out.println();
		System.out.println("Implementacion iterativa:");
		testList(new IterativeLinearLinkedList<String>());
		
	}
	
	public static void testList(LinearLinkedList<String> list) throws Exception {
		
		System.out.println("La lista esta vacia: " + list.isEmpty());
		System.out.println("La lista contiene 'hola': " + list.contains("hola"));
		System.out.println("Cantidad de elementos: " + list.size());
		System.out.println("Agregando 'hola' a la lista...");
		list = list.add("hola");
		System.out.println("La lista esta vacia: " + list.isEmpty());
		System.out.println("La lista esta asi: " + list);
		System.out.println("La lista contiene 'hola': " + list.contains("hola"));
		System.out.println("Agregando 'mundo' a la lista...");
		list = list.add("mundo");
		System.out.println("Agregando 'casa' a la lista...");
		list = list.add("casa");
		System.out.println("La lista esta asi: " + list);
		System.out.println("Eliminando 'casa' de la lista...");
		list = list.remove("casa");
		System.out.println("La lista esta asi: " + list);
		System.out.println("Eliminando 'hola' de la lista...");
		list = list.remove("hola");
		System.out.println("La lista esta asi: " + list);
		System.out.println("Cantidad de elementos: " + list.size());

	}
	
	
}
