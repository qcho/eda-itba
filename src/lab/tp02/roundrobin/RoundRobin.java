package lab.tp02.roundrobin;

public class RoundRobin {
	private int quantum;
	
	public static void main(String[] args) {
		CircularList<Integer> list = new CircularList<Integer>();
		
		System.out.println(list);
		list.add(3);
		System.out.println(list);
		list.add(9);
		System.out.println(list);
		list.add(1);
		System.out.println(list);
		list.add(2);
		System.out.println(list);
		list.add(9);
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.remove();
		System.out.println(list);
	}
}
