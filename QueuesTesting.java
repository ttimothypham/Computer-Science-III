//QueuesTesting.java
//Timothy Pham
//Create a runner file for Queues that use a Doubly-Linked List
public class QueuesTesting {
	
	public static void main(String[] args)
	{
		Queue<Integer> intQ = new Queue<Integer>();
		for (int i = 1; i <= 10; i++)
		{
			intQ.enqueue(i);
		}
		System.out.println("intQ = " + intQ.toString());
		int item = intQ.dequeue();
		System.out.print("dequeue(): " + intQ.toString());
		System.out.print("\nItem dequeued: " + item);
		System.out.print("\nsendToBack(): ");
		intQ.sendToBack();
		System.out.println(intQ.toString());
		System.out.println("Size: " + intQ.size());
		System.out.println("isEmpty(): " + intQ.isEmpty());
		
		System.out.println();
		
		Queue<String> strQ = new Queue<String>("Java");
		strQ.enqueue("Mr.Watson");
		strQ.enqueue("Computer Science");
		strQ.enqueue("Win");
		strQ.enqueue("The");
		strQ.enqueue("Day!");
		System.out.println("strQ = " + strQ.toString());
		String mrW = strQ.dequeue();
		System.out.println("dequeue() = " + strQ.toString());
		System.out.println("Item dequeued: " + mrW);
		System.out.print("sendToBack(): ");
		strQ.sendToBack();
		System.out.println(strQ.toString());
		System.out.println("Size: " + strQ.size());
		System.out.println("isEmpty(): " + strQ.isEmpty());
		String cS = strQ.dequeue();
		System.out.println("dequeue() = " + strQ.toString());
		System.out.println("Item dequeued: " + cS);

	}

}
