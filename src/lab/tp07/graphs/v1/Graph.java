package lab.tp07.graphs.v1;

public class Graph<V, E> extends GraphAdjList<V, E> {

	@Override
	protected boolean isDirected() {
		return false;
	}


}
