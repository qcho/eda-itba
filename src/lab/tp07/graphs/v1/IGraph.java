package lab.tp07.graphs.v1;

/**
 * 
 * Interface para grafos o digrafos. Cada nodo est� identificado con un n�mero entero, no hay peso en los ejes
 *
 */
public interface IGraph {
	public void addVertices(int n);
	
	public void removeVertex(int v);
	
	public int vertexCount();
	
	public void addArc(int v, int w);
	
	public void removeArc(int v, int w);
	
	public boolean isArc(int v, int w);
	
	public int arcCount();
	
	public int inDegree(int v);
	
	public int outDegree(int v);
	
	public int[] neighbors(int v);
}
