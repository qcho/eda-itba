package trees.btree;

/***********************************************************************
* B-Tree 
*
*	by L.Horisberger & G.Schweizer
* last change: 26.02.1998 by horil
**/


/**
* Class KeyNode
* An Container were an object with a given key is stored.
**/
class KeyNode<T> {
	private T data;

	KeyNode(T data) {
		this.data=data;
	}
	
	Object getData() {
		return data;
	}

}
