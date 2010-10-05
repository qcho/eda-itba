package lab.tp07.graphs.v1;

public class DiGraph<V,E> extends GraphAdjList<V,E> {

	@Override
	protected boolean isDirected() {
		return true;
	}

}
