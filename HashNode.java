
public class HashNode<E> {
	
	E value;
	HashNode next;
	
	HashNode(E initValue, HashNode initNext)
	{
		value = initValue;
		next = initNext;
	}
	
	public HashNode<E> getNext()
	{
		return next;
	}
	
	public E getValue()
	{
		return value;
	}
	
	public void setNext(HashNode theNewNext)
	{
		next = theNewNext;
	}
	
	public void setValue(E theNewValue)
	{
		value = theNewValue;
	}
	
	public String toString()
	{
		if (next == null)
		{
			return "Value: " + value;
		}
		return "Value: " + value + " " + "Next: " + next;
	}

}
