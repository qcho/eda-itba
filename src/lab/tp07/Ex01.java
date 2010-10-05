package lab.tp07;

import lab.tp07.graphs.v2.Graph;
import lab.tp07.graphs.v2.MyArc;

public class Ex01 {
	
	public static void main(String[] args) {
		Graph<String, MyArc> g = new Graph<String, MyArc>();
		g.AddVertex("1");
		g.AddVertex("2");
		g.AddVertex("3");
		g.AddVertex("4");
		g.AddVertex("5");
		g.AddVertex("6");
		
		g.addArc("1", "2", new MyArc(null));
		g.addArc("1", "3", new MyArc(null));
		g.addArc("1", "4", new MyArc(null));
		g.addArc("2", "5", new MyArc(null));
		g.addArc("2", "6", new MyArc(null));
		
		System.out.println(g.BFS("1"));
		
	}
	
	

}
