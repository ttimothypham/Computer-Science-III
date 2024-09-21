//Queue.java
//Timothy Pham
//Create an actual class for Queues using a circular Doubly-Linked List
public class Queue<T> {
	
	public dNode<T> head; //front node
	public dNode<T> tail; //last node
	public int size; //size variable
	
	public Queue() //default constructor
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public Queue(T value)
	{
		dNode<T> node = new dNode<T>(value); //creates new node using the input value and sets it as the head
		head = node;
		tail = node;
		size = 1; //sets size to 1 because node was added
	}
	
	public void enqueue(T value)
	{
		dNode<T> node = new dNode<T>(value); //create new node for input value
		if (head == null) //checks if head is null
		{
			head = node; //sets head as the new node
			tail = node;
			head.prev = tail;
			tail.prev = head;
			size++; //increment size
		}
		else
		{
			dNode<T> temp = head; //temp node for the head
			while (temp.next != null) //iterate til the end of the queue
			{
				temp = temp.next;
			}
			tail = node; //sets the tail to node
			temp.next = tail; //sets tail to the target position
			tail.prev = temp; //sets node's previous to temp
			head.prev = tail; //sets head's prev to point at tail
			size++; //increment size
		}
	}
	
	public T dequeue()
	{
		if (head == null) //if the queue is empty return null
		{
			return null;
		}
		else
		{
			dNode<T> temp = head.next; //temp node for the seco nd node
			dNode<T> dqNode = head; //temp node for the head
			head = temp; //sets the second node as the head
			tail = temp.prev; //sets tail as the node before head
			tail.next = head; //points tail to head to keep queue circular
			head.prev = tail; //sets the new head's previous to point to tail
			size--; //decrement size
			return dqNode.data; //returned the former head
		}
	}
	
	public boolean isEmpty()
	{
		return (size == 0); //returns if size is 0 or not
	}
	
	public void sendToBack()
	{
		dNode<T> temp = new dNode<T>(dequeue());
		dNode<T> prevTail = head;
		enqueue(temp.data); //sends the front to the back by enqueueing it
		tail = temp; //updates the tail
		tail.next = head; //sets tail.next to head
		for (int i = 0; i < size - 1; i++) //iterate thru queue to get to node before tail
		{
			prevTail = prevTail.next;
		}
		tail.prev = prevTail; //sets tail.prev to prevTail
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		String result = ""; //string variable to be added on
		dNode<T> temp = head; //temp node for head
		while (temp != null) //iterate thru the queue
		{
			result = result + temp.data; //adds each node to result
			temp = temp.next; //points temp to temp.next
			if (temp!= null) //checks if its not on the last node
			{
				result = result + " | "; 
			}
		}
		return result;
	}
	
	

}
