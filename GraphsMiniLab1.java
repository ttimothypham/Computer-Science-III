//Timothy Pham
//Purpose: Create a functional graph class that with a matrix and list method
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

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

public class GraphsMiniLab1
{
	final static int numOfVertices = 10;
		
	public static void main (String[] args) throws FileNotFoundException
	{
		/* 1) Create a scanner and parse through a file named "edgesA.txt" 
		 * 2) Store the edges in a String ArrayList
		 * 3) Pass the list of edges into the 2 methods below
		 */
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("edgesA.txt");
		Scanner keyboard = new Scanner(file);
		while (keyboard.hasNextLine())
		{
			list.add(keyboard.nextLine());
		}
		printAdjMatrix(list);
		System.out.println();
		printAdjList(list);
	}
	
	static void printAdjMatrix(ArrayList<String> edgeList){
		/* Print an adjacency matrix given
		 * 	a list of a Graph's edges.
		 */
		
		int[][] matrix = new int[numOfVertices][numOfVertices];
		for (int r = 0; r < numOfVertices; r++)
		{
			for (int c = 0; c < numOfVertices; c++)
			{
				matrix[r][c] = 0;
			}
		}
		
		for (int i = 0; i < edgeList.size(); i++)
		{
			String currentEdge = edgeList.get(i);
			String row = currentEdge.substring(0,1);
			String col = currentEdge.substring(2,3);
			matrix[Integer.parseInt(row)][Integer.parseInt(col)] = 1;
		}
		
		for (int x = 0; x < matrix.length; x++)
		{
			for (int y = 0; y < matrix[x].length; y++)
			{
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	static void printAdjList(ArrayList<String> edgeList){
		/* Print an adjacency list given
		 * 	a list of a Graph's edges.
		 *	
		 *	-Don't worry about sorting the Linked Lists
		 */
		 
		 LinkedList[] adjList = new LinkedList[numOfVertices];
		 
		//The above way of using the the Java LinkedList class requires
		//us to initialize each index of our array as a new LinkedList, or 
		//else it will consider it to be null.
		for(int x = 0; x < numOfVertices; x++)
		 {
		 	adjList[x] = new LinkedList<Integer>();
		 	for (int z = 0; z < adjList[x].size(); z++)
		 	{
		 		adjList[x].add(z,0);
		 	}
		 }
		
		for (int i = 0; i < edgeList.size(); i++)
		{
			String currentEdge = edgeList.get(i);
			String idx = currentEdge.substring(0,1);
			String val = currentEdge.substring(2,3);
			adjList[Integer.parseInt(idx)].add(Integer.parseInt(val));
		}
		
		for (int index = 0; index < adjList.length; index++)
		{
			System.out.print("[" + index + "] --> ");
			for (int t = 0; t < adjList[index].size(); t++)
			{
				System.out.print(adjList[index].get(t) + " ");
			}
			System.out.println();
		}
		 
	}

}