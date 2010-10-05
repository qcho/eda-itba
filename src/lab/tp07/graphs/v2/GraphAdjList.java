package lab.tp07.graphs.v2;

import java.util.ArrayList;
import java.util.HashMap;
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
public abstract class GraphAdjList<V, E extends ArcGraph> {

	protected class Node {
		public V info;
		public boolean visited;
		// coloreo, etc.
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

	protected class Arc {
		public E info;
		public Node neighbor;

		public Arc(E info, Node neighbor) {
			super();
			this.info = info;
			this.neighbor = neighbor;
		}
	}

	protected HashMap<V, Node> nodes; // Para ubicar los nodos rápidamente
	protected List<Node> nodeList; // Para recorrer la lista de nodos

	public GraphAdjList() {
		this.nodes = new HashMap<V, Node>();
		this.nodeList = new ArrayList<Node>();
	}

	public boolean isEmpty() {
		return nodes.size() == 0;
	}

	public void AddVertex(V vertex) {
		if (!nodes.containsKey(vertex)) {
			Node node = new Node(vertex);
			nodes.put(vertex, node);
			nodeList.add(node);
		}
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
		nodeList.remove(node);
	}

	public void addArc(V v, V w, E e) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null && !origin.equals(dest)) {
			for (Arc arc : origin.adj) {
				if (arc.neighbor.info.equals(w)) {
					return;
				}
			}
			origin.adj.add(new Arc(e, dest));
		}
	}

	public void removeArc(V v, V w) {
		Node origin = nodes.get(v);
		if (origin == null)
			return;

		for (int i = 0; i < origin.adj.size(); i++) {
			if ( origin.adj.get(i).neighbor.info.equals(w)) {
				origin.adj.remove(i);
				return;
			}
		}

	}

	public int arcCount() {
		int count = 0;
		for (Node n : getNodes())
			count += n.adj.size();
		return count;
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

	@SuppressWarnings("unchecked")
	public List<V> neighbors(V v) {
		Node node = nodes.get(v);
		if (node != null) {
			List<V> l = new ArrayList(node.adj.size());
			for (Arc e : node.adj) {
				l.add(e.neighbor.info);
			}
		}
		return null;
	}

	public int vertexCount() {
		return nodes.size();
	}

	protected List<Node> getNodes() {
		return nodeList;
	}

	protected void clearMarks() {
		for (Node n : getNodes()) {
			n.visited = false;
		}

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
			if (!node.visited) {
				l.add(node.info);
				node.visited = true;
			}
			for (Arc e : node.adj) {
				if (!e.neighbor.visited) {
					q.add(e.neighbor);
				}
			}
		}
		return l;
	}

	public boolean isPath(V origin, V dest) {
		List<V> l = DFS(origin);
		if (l == null)
			return false;
		return l.contains(dest);
	}

	/**
	 * Construye una lista donde para cada nodo informa la m�nima distancia al
	 * origen
	 * 
	 * @param origin
	 */
	public HashMap<V, Double> Dijkstra(V origin) {
		Node nodeOrigin = nodes.get(origin);
		if (nodeOrigin == null)
			return null;

		clearMarks();
		// Para cada nodo guardar cu�l es la distancia acumulada
		HashMap<V, Double> distance = new HashMap<V, Double>(nodes.size());

		// Creamos una lista de nodos visitados
		List<Node> visited = new ArrayList<Node>(nodes.size());
		distance.put(origin, 0.0);
		nodeOrigin.visited = true;
		visited.add(nodeOrigin);

		Arc min;
		do {
			// Tomar el nodo sin visitar m�s cercano al origen
			min = null;
			Double minDist = 0.0;
			for (Node node : visited) {
				Double distToNode = distance.get(node.info);
				for (Arc e : node.adj) {
					if (!e.neighbor.visited
							&& (min == null || e.info.getValue() + distToNode < minDist)) {
						min = e;
						minDist = e.info.getValue() + distToNode;
					}
				}
			}
			if (min != null) {
				visited.add(min.neighbor);
				min.neighbor.visited = true;
				distance.put(min.neighbor.info, minDist);
			}
		} while (min != null);

		return distance;
	}

}
