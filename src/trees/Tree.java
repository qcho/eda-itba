package trees;

public interface Tree<T> {
	
	public boolean search(T e);
	public void insert(T e);
	public void delete(T e);
	public int height();
	//public int width(int height);
	

}
