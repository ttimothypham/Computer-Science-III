//SLinkedList.java
//Timothy Pham
//replicate the functions and methods of a LinkedList in a generalized manner to be use by all types
public class SLinkedList<T> {
	
	sNode<T> front; //front node in the list
	
	public SLinkedList() //default constructor that sets front to null and the size to 0
	{
		front = null;
	}
	
	public SLinkedList(T value) //constructor with int parameter and sets front to a new ListNode with value as the data as well as set size to 1
	{
		front = new sNode<T>(value);
	}
	
	public void add(T value) //method to add an int to the list
	{
		sNode<T> node = new sNode<T>(value); //create a node with the value
		if (front == null) //checks if list is empty
		{
			front = node; //sets front to the node
		}
		else
		{
			sNode<T> temp = front; //create temp node for front
			while (temp.next != null) //does the following until it gets to the end of the list
			{
				temp = temp.next; //points temp to temp.next
			}
			temp.next = node; //sets the node at the end of the list
		}
	}
	
	public void add(int index, T value)
	{
		if (index < 0) //checks if index is inbounds
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) //sets front to the value
		{
			front.data = value; 
		}
		else
		{
			sNode<T> temp = front; //temp node for front
			for (int i = 0; i < index - 1; i++) //iterate til pointed to the node before before the index
			{
				temp = temp.next; //points temp to temp.next
			}
			temp.next = new sNode<T>(value, temp.next); //adds a new node at the index with the correct value and sets the next
		}
	}
	
	public T get(int index)
	{
		if (index < 0 ) //checks if index is inbounds
		{
			throw new IndexOutOfBoundsException();
		}
		sNode<T> temp = front; //temp node for front
		for (int i = 0; i < index; i++) //iterate til pointed to the node before the index
		{
			temp = temp.next; //points temp to temp.next
		}
		return temp.data; //gets the data of specified index
	}
	
	public int indexOf(T value)
	{
		int index = 0; //index variable
		sNode<T> temp = front; //temp node for front
		while (temp != null) //iterate thru the list
		{
			if (temp.data == value) //checks if the node's data is equal to the inputted value
			{
				return index; //returns the index
			}
			//if not, temp will be pointed to temp.next and index is incremented
			temp = temp.next; 
			index++;
		}
		return -1; //input value not found in list
	}
	
	public T remove(int index)
	{
		T dataValue; //
		if (index < 0) //checks if index is inbound
		{
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) //checks if index is 0
		{
			front.next = null; //sets front.next to null
			return front.data; //returns the data of front
		}
		else
		{
			sNode<T> temp = front; //temp node for front
			for (int i = 0; i < index - 1; i++) //iterate til pointed to node before before index
			{
				temp = temp.next; //temp points to temp.next
			}
			dataValue = temp.next.data; //gets the data of the targeted node
			temp.next = temp.next.next; //removes the targeted node by setting to null
		}
		return dataValue; //return the data of the removed node
	}
	
	public int size()
	{
		int count = 0; //count variable for num of nodes
		sNode<T> temp = front; //temp node for front
		while (temp != null) //iterate thru list
		{
			count++; //counts each node
			temp = temp.next; //points temp to temp.next
		}
		return count; //returns count
	}
	
	
	public String toString()
	{
		String result = ""; //variable for result to be returned
		sNode<T> temp = front; //temp node for front
		while (temp != null) //iterate thru list
		{
			result = result + temp.data; //adds the current node's data to result
			temp = temp.next; //points temp to temp.next
			if (temp != null) //checks if the node is not the last one
			{
				result = result + ", "; //adds comma
			}
		}
		return result; 
	}
	

}
