//LinkedList.java
//Timothy Pham
//replicate the functions and methods of a LinkedList
public class LinkedIntList {
	
	ListNode front; //front node in the list
	
	public LinkedIntList() //default constructor that sets front to null and the size to 0
	{
		front = null;
	}
	
	public LinkedIntList(int value) //constructor with int parameter and sets front to a new ListNode with value as the data as well as set size to 1
	{
		front = new ListNode(value);
	}
	
	public void add(int value) //method to add an int to the list
	{
		ListNode node = new ListNode(value); //create a node with the value
		if (front == null) //checks if list is empty
		{
			front = node; //sets front to the node
		}
		else
		{
			ListNode temp = front; //create temp node for front
			while (temp.next != null) //does the following until it gets to the end of the list
			{
				temp = temp.next; //points temp to temp.next
			}
			temp.next = node; //sets the node at the end of the list
		}
	}
	
	public void add(int index, int value)
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
			ListNode temp = front; //temp node for front
			for (int i = 0; i < index - 1; i++) //iterate til pointed to the node before before the index
			{
				temp = temp.next; //points temp to temp.next
			}
			temp.next = new ListNode(value, temp.next); //adds a new node at the index with the correct value and sets the next
		}
	}
	
	public int get(int index)
	{
		if (index < 0 ) //checks if index is inbounds
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode temp = front; //temp node for front
		for (int i = 0; i < index; i++) //iterate til pointed to the node before the index
		{
			temp = temp.next; //points temp to temp.next
		}
		return temp.data; //gets the data of specified index
	}
	
	public int indexOf(int value)
	{
		int index = 0; //index variable
		ListNode temp = front; //temp node for front
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
	
	public int remove(int index)
	{
		int dataValue; //
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
			ListNode temp = front; //temp node for front
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
		ListNode temp = front; //temp node for front
		while (temp != null) //iterate thru list
		{
			count++; //counts each node
			temp = temp.next; //points temp to temp.next
		}
		return count; //returns count
	}
	
	public void clear() //BONUS
	{
		front = null;
	}
	
	public void sort() //BONUS
	{
		ListNode temp = front; //temp node for front
		int greater; //int variable for greater int when data is compared
		while (temp != null) //iterate thru the list
		{
			ListNode nextNode = temp.next; //node for temp.next
			while (nextNode != null) //iterate thru other list
			{
				if (temp.data > nextNode.data) //compares the data between temp and the next node
				{
					//sorts the list increasingly by swapping temp's data with nextNode's
					greater = temp.data; 
					temp.data = nextNode.data; //so now the lesser data is before
					nextNode.data = greater; //and the greater data is after
				}
				nextNode = nextNode.next; //points nextNode to nextNode.next
			}
			temp = temp.next; //points temp to temp.next
		}
	}
	
	public String toString()
	{
		String result = ""; //variable for result to be returned
		ListNode temp = front; //temp node for front
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
