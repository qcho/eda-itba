package lab.tp07.graphs.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Clase abstracta para Grafos (no multigrafos). No soporta multigrafos ni lazos
 * 
 * @param <V>
 * @param <E>
 */
public abstract class GraphAdjList<V, E> {

	private class Node {
		public V info;
		public boolean visited; 
		public List<Arc> adj;

		public Node(V info) {
			this.info = info;
			this.visited = false;
			this.adj = new ArrayList<Arc>();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((info == null) ? 0 : info.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Node other = (Node) obj;
			if (info == null) {
				if (other.info != null)
					return false;
			} else if (!info.equals(other.info))
				return false;
			return true;
		}
	}

	private class Arc {
		public E info;
		public Node neighbor;

		public Arc(E info, Node neighbor) {
			super();
			this.info = info;
			this.neighbor = neighbor;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((neighbor == null) ? 0 : neighbor.hashCode());
			return result;
		}

		// Considero que son iguales si "apuntan" al mismo nodo (para no agregar
		// dos ejes al mismo nodo)
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Arc other = (Arc) obj;
			if (neighbor == null) {
				if (other.neighbor != null)
					return false;
			} else if (!neighbor.equals(other.neighbor))
				return false;
			return true;
		}

	}

	private HashMap<V, Node> nodes;

	protected abstract boolean isDirected();

	public GraphAdjList() {
		this.nodes = new HashMap<V, Node>();
	}

	public boolean isEmpty() {
		return nodes.size() == 0;
	}


	public void addVertex(V vertex) {
		if (!nodes.containsKey(vertex)) {
			nodes.put(vertex, new Node(vertex));
		}
	}

	public void addArc(V v, V w, E e) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null && !origin.equals(dest)) { 
			Arc arc = new Arc(e, dest);
			if (!origin.adj.contains(arc)) {
				origin.adj.add(arc);
				if (!isDirected()) {
					dest.adj.add(new Arc(e, origin));
				}
			}
		}
	}

	public int arcCount() {
		int count = 0;
		for (Node n : getNodes())
			count += n.adj.size();
		if (!isDirected())
			count /= 2;
		return count;
	}


	public void RemoveArc(V v, V w) {
		Node origin = nodes.get(v);
		if (origin == null)
			return;
		Node dest = nodes.get(w);
		if (dest == null)
			return;
		origin.adj.remove(new Arc(null, dest)); 
		if (!isDirected())
			dest.adj.remove(new Arc(null, origin)); 
	}


	public E isArc(V v, V w) {
		Node origin = nodes.get(v);
		if (origin == null)
			return null;

		for (Arc e : origin.adj) {
			if (e.neighbor.info.equals(w)) {
				return e.info;
			}
		}
		return null;

	}

	public int outDegree(V v) {
		Node node = nodes.get(v);
		if (node != null) {
			return node.adj.size();
		}
		return 0;
	}


	public int inDegree(V v) {
		if (!isDirected())
			return outDegree(v);
		int count = 0;
		Node node = nodes.get(v);
		for (Node n : getNodes()) { // Recorremos lista de nodos
			if (!n.equals(node)) {
				for (Arc adj : n.adj)
					// Recorremos lista de adyacencia
					if (adj.neighbor.equals(node))
						count++;
			}
		}
		return count;
	}


	public List<V> neighbors(V v) {
		Node node = nodes.get(v);
		if (node != null) {
			List<V> l = new ArrayList<V>(node.adj.size());
			for (Arc e : node.adj) {
				l.add(e.neighbor.info);
			}
		}
		return null;
	}


	public void removeVertex(V v) {
		Node node = nodes.get(v);
		if (node == null)
			return;

		// Primero removerlo de la lista de adyacencia de sus vecinos
		Arc e = new Arc(null, node);
		for (Node n : getNodes()) {
			if (!n.equals(node))
				n.adj.remove(e);
		}

		// Eliminar el nodo
		nodes.remove(v);
	}

	public int vertexCount() {
		return nodes.size();
	}

	private List<Node> getNodes() {
		List<Node> l = new ArrayList<Node>(vertexCount());
		Iterator<V> it = nodes.keySet().iterator();
		while (it.hasNext()) {
			l.add(nodes.get(it.next()));
		}
		return l;
	}

	public List<V> DFS(V origin) {
		Node node = nodes.get(origin);
		if (node == null)
			return null;
		clearMarks();
		List<V> l = new ArrayList<V>();
		this.DFS(node, l);
		return l;
	}

	protected void clearMarks() {
		for (Node n : getNodes()) {
			n.visited = false;
		}

	}


	protected void DFS(Node origin, List<V> l) {
		if (origin.visited)
			return;
		l.add(origin.info);
		origin.visited = true;
		for (Arc e : origin.adj)
			DFS(e.neighbor, l);
	}


	public List<V> BFS(V origin) {
		Node node = nodes.get(origin);
		if (node == null)
			return null;
		clearMarks();
		List<V> l = new ArrayList<V>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			l.add(node.info);
			node.visited = true;
			for (Arc e : node.adj) {
				if (!e.neighbor.visited) {
					q.add(e.neighbor);
				}
			}
		}
		return l;
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

}
