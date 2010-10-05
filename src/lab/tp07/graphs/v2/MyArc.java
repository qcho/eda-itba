package lab.tp07.graphs.v2;

public class MyArc implements ArcGraph {

	private Integer value;
	
	public MyArc(Integer value) {
		this.value = value;
	}
	
	@Override
	public Double getValue() {
		return value.doubleValue();
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
