
public class dNode<T> {
	
	T data;
	dNode<T> next;
	dNode<T> prev;
	
	public dNode(T data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public dNode(dNode<T> prev, T data, dNode<T> next)
	{
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	

}