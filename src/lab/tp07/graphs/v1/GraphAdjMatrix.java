package lab.tp07.graphs.v1;

/**
 * Primera aproximación, muy rudimentaria y simple, para manejo de grafos
 * 
 *
 */
public class GraphAdjMatrix implements IGraph {

	private int space; // dimensiones de la matriz
	private int order; // cantidad de nodos
	private boolean digraph; // indica si es un grafo dirigido
	private boolean[][] adjacency;

	public GraphAdjMatrix() {
		this(false);
	}

	public GraphAdjMatrix(boolean digraph) {
		space = order = 0;
		this.digraph = digraph;
	}

	@Override
	public void addArc(int v, int w) {
		adjacency[v][w] = true;
		if (!digraph)
			adjacency[w][v] = true;

	}

	@Override
	public void addVertices(int n) {
		if (n > space - order) {
			boolean m[][] = new boolean[order + n][order + n];
			for (int i = 0; i < order; i++)
				for (int j = 0; j < order; j++) {
					m[i][j] = adjacency[i][j];
				}
			adjacency = m;
			space = order + n;
		} else {
			for (int i = 0; i < order + n; i++) {

				for (int j = order; j < order + n; j++) {
					adjacency[i][j] = adjacency[j][i] = false;
				}
			}
		}
		order += n;

	}

	@Override
	public void removeArc(int v, int w) {
		adjacency[v][w] = false;
		if (!digraph)
			adjacency[w][v] = false;

	}

	@Override
	public int arcCount() {
		int arcs = 0;
		for (int i = 0; i < order; i++)
			for (int j = 0; j < order; j++)
				if (adjacency[i][j])
					arcs++;
		if (!digraph)
			arcs /= 2;
		return arcs;
	}

	@Override
	public int inDegree(int v) {
		int degree = 0;
		for (int i = 0; i < order; i++)
			if (adjacency[i][v])
				degree++;
		return degree;
	}

	@Override
	public boolean isArc(int v, int w) {
		return adjacency[v][w];
	}

	@Override
	public int[] neighbors(int v) {
		int[] neighbors = new int[this.outDegree(v)];
		int k = 0;
		for (int i = 0; i < order; i++)
			if (adjacency[v][i])
				neighbors[k++] = i;
		;
		return neighbors;
	}

	@Override
	public int outDegree(int v) {
		int degree = 0;
		for (int i = 0; i < order; i++)
			if (adjacency[v][i])
				degree++;
		return degree;

	}

	@Override
	public void removeVertex(int v) {
		order--;

		int i;
		for (i = 0; i < v; i++)
		{
			for (int j = v; j < order; j++)
			{
				adjacency[i][j] = adjacency[i][j + 1];
			}
		}

		for (i = v; i < order; i++)
		{
			int j;
			for (j = 0; j < v; j++)
			{
				adjacency[i][j] = adjacency[i + 1][j];
			}

			for (j = v; j < order; j++)
			{
				adjacency[i][j] = adjacency[i + 1][j + 1];
			}
		}
	}

	@Override
	public int vertexCount() {
		return order;
	}


}
