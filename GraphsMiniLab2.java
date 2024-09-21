import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

/*************************************
 * Java Built-in Linked List Class:
 *
 *	-Constructor Examples
 *		LinkedList<String> list = new LinkedList<String>();
 *		LinkedList list2 = new LinkedList();
 *	
 *	-Add Example:
 *		list.add("red");
 *	
 *	-Some Relevant Methods:
 *		add(E e)
 *		add(int index, E element)
 *		addFirst()
 *		addLast()
 *		removeFirst()
 *		removeLast()
 *
 *		element() - Retrieves, but does not remove, the head (first element) of this list.
 *		getFirst() - Returns the first element in this list.
 *		getLast() - Returns the last element in this list.
 *		get(int index) - Returns the element at the specified position in this list.
 *
 *		set(int index, E element) - Replaces the element at the specified position in this list with the specified element.
 *
 *		size() - Returns the number of elements in this list
 *
 *************************************/

public class GraphsMiniLab2
{
	static final int numOfVertices = 10;
	static LinkedList[] adjList;
		
	public static void main (String[] args) throws FileNotFoundException
	{
		adjList = new LinkedList[numOfVertices];
		
		//The above way of using the the Java LinkedList class requires
		//us to itialize each index of our array as a new LinkedList, or 
		//else it will consider it to be null.
		for(int x = 0; x<numOfVertices; x++)
		 {
		 	adjList[x] = new LinkedList<Integer>();
		 }
		 
		/* 1) CREATE A Scanner using the file named "edgesB.txt" or "edgesC.txt"
		 *		-edgesB - the small Practice Traversal graph
		 *		-edgesC - the large Practice Traversal graph
		 * 2) USE the Scanner to fill in an Adjacency List or Matrix.
		 *		-Keep in mind that the order we travel matters.
		 *		-It would be best to have your list of connected/adjacent
		 *			vertices sorted.
		 * 3) PRINT the order of your list using DFT and BFT
		 */
		File fileB = new File("edgesB.txt");
		File fileC = new File("edgesC.txt");
		Scanner keyboard = new Scanner(fileB);
		ArrayList<String> list = new ArrayList<String>();
		while (keyboard.hasNextLine())
		{
			list.add(keyboard.nextLine());
		}
		
		for (int i = 0; i < list.size(); i++)
		{
			String currentEdge = list.get(i);
			String idx = currentEdge.substring(0,1);
			String val = currentEdge.substring(2,3);
			adjList[Integer.parseInt(idx)].add(Integer.parseInt(val));
		}
		//Print out adjList
		for (int index = 0; index < adjList.length; index++)
		{
			System.out.print("[" + index + "] --> ");
			for (int t = 0; t < adjList[index].size(); t++)
			{
				System.out.print(adjList[index].get(t) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.print("DFT : ");
		depthFirstTraversal();
		System.out.println();
		System.out.print("BFT : ");
		breadthFirstTraversal();

	}
	
	public static void depthFirstTraversal(){
		/* Print out the order of your graph in 
		 * Depth First Traversal.
		 *
		 * CHOOSE one development method: 
		 *		a) Recursive
		 *		b) Using a Stack - You can use the built-in class.
		 */
		
		boolean[] visited = new boolean[numOfVertices];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		while (!stack.isEmpty())
		{
			int current = stack.pop();
			if (!visited[current])
			{
				visited[current] = true;
				System.out.print(current + " ");
				for (Object adjacent : adjList[current])
				{
					int vertex = (int) adjacent;
					if (!visited[vertex])
					{
						stack.push(vertex);
					}
				}
			}
		}
		
	}
		
	
	private static void dft(int vertex, Boolean visited[]){
		/* If you choose to implement dft recursively, initiate the 
		 * search using the above method, but make this method do all the heavy lifting.
		 */
	}
	public static void breadthFirstTraversal(){
		/* Print out the order of your graph in
		 * Breadth First Traversal.
		 *	
		 *	-Be sure to use a queue to manage the order in which you visit the vertices.
		 */
		
		boolean[] visited = new boolean[numOfVertices]; 
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(0);
        visited[0] = true; 

        while (!queue.isEmpty())
        {
            int current = queue.remove(); 
            System.out.print(current + " "); 
            for (Object adjacent : adjList[current])
            {
                if (!visited[(int) adjacent])
                {
                    queue.add((Integer) adjacent);
                    visited[(int) adjacent] = true; 
                }
            }
        }
    }
}

