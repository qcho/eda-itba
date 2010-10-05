package lab.tp07.graphs.v2;

import java.util.ArrayList;
import java.util.List;

public class Graph<V, E extends ArcGraph> extends GraphAdjList<V, E> {

	@Override
	public void addArc(V v, V w, E e) {
		super.addArc(v, w, e);
		super.addArc(w, v, e);
	}
	
	@Override
	public void removeArc(V v, V w) {
		super.removeArc(v, w);
		super.removeArc(w, v);
	}
	
	public int degree(V v) {
		Node node = nodes.get(v);
		if (node != null) {
			return node.adj.size();
		}
		return 0;
	}

	public boolean isConnected() {
		if (isEmpty()) {
			return true;
		}
		clearMarks();
		List<Node> l = getNodes();
		List<V> laux = new ArrayList<V>();
		DFS(l.get(0), laux);
		for (Node node : l) {
			if (!node.visited) {
				return false;
			}
		}
		return true;
	}
	
	public int connectedComponents() {
		clearMarks();
		return pathCount();
	}
	
	private int pathCount() {
		int count = 0;
		Node node;
		while ((node = unvisited()) != null) {
			count++;
			DFS(node, new ArrayList<V>());
		}
		return count;
	}

	private Node unvisited() {
		for(Node node : getNodes()) {
			if (! node.visited )
				return node;
		}
		return null;
	}
	
	public boolean cutVertex(V vertex) {
		Node node = nodes.get(vertex);
		if (node == null || node.adj.size() == 0)
			return false;
		clearMarks();
		int components = pathCount();
		clearMarks();
		node.visited = true;
		return components != pathCount();
	}
	
	public boolean isBridge(V v, V w) {
		E e = isArc(v,w);
		if ( e == null)
			return false;
		int components = connectedComponents();
		removeArc(v, w);
		int newComponents = connectedComponents();
		addArc(v, w, e);
		return components != newComponents;
		
	}

}
