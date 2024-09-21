///////////////////////////////////////////////////////////////////////////
//
//    		Write a program that implements a Queue data structure.
//          Given an initial myQueue, create two new queues, 
//          oddQueue and evenQueue, so that oddQueue contains the odd
//          elements of myQueue and evenQueue contains the even elements.
//
//  e.g.
//      as in dealing a deck of cards
//
//  e.g.
//      myQueue   -->   43 92 41 39 10 32 62 17 29 51 35 44 24 15 73 66
//
//      oddQueue  -->   43 41 39 17 29 51 35 15 73
//      evenQueue -->   92 10 32 62 44 24 66
//      
//
///////////////////////////////////////////////////////////////////////////
//Timothy Pham
//4th
import java.util.*;
public class Queue1
{
	public static void main(String[] args)
	{
		int[] cards = {43,92,41,39,10,32,62,17,29,51,35,44,24,15,73,66};
		Queue<Integer> myQueue = new LinkedList<Integer>();
		for (int i : cards)
		{
			myQueue.offer(i);
		}
		System.out.println(myQueue);
		System.out.println(oddQueue(myQueue));
		System.out.println(evenQueue(myQueue));
	}
	
	public static Queue<Integer> oddQueue(Queue<Integer> q)
	{
		Queue<Integer> oddQueue = new LinkedList<Integer>(); //creating new queue for the odd elements
		int size = q.size(); //size variable for the input queue (necessary so the loop only goes thru each element in the queue once)
		for (int i = 0; i < size; i++) //loop to iterate thru the input q size 
		{
			if (q.peek() % 2 == 1) //checks if the head element is odd
			{
				oddQueue.offer(q.peek()); //adds the head element to oddQueue
			}
			q.remove(q.peek()); //removes the element from q so a new element is the head
			q.offer(q.peek()); //adds the element back so the q can be reused again
		}
		return oddQueue;
	}
	
	public static Queue<Integer> evenQueue(Queue<Integer> q)
	{
		Queue<Integer> evenQueue = new LinkedList<Integer>(); //creating new queue for the even elements
		int size = q.size(); //size variable for the input queue (necessary so the loop only goes thru each element in the queue once)
		for (int i = 0; i < size; i++) //loop to iterate thru the input q size
		{
			if (q.peek() % 2 == 0) //checks if the head element is even
			{
				evenQueue.offer(q.peek()); //adds the head element to evenQueue
			}
			q.remove(q.peek()); //removes the element from q so a new element is the head
			q.offer(q.peek()); //adds the element back so the q can be reused again
		}
		return evenQueue;
	}
}




