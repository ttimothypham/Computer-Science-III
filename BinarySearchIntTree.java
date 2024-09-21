//BinarySearchIntTree.java
//Timothy Pham
//Purpose: Create a class for an integer binary search tree with supporting functions/methods 
import java.util.Collection;

public class BinarySearchIntTree {
	
	public IntTreeNode overallRoot;
	int size = 0;
	
	public BinarySearchIntTree() //default constructor, sets overallRoot to null
	{
		overallRoot = null;
	}
	
	public BinarySearchIntTree(int value) //constructor that takes in int and establishes the overallRoot
	{
		overallRoot = new IntTreeNode(value, null, null); //establish overall root with null pointers
		size++;
	}
	
	public BinarySearchIntTree(Collection<Integer> list) //constructor that takes in a list
	{
		for (int i: list) //iterate thru list
		{
			add(i); //creates node for each int
		}
	}
	
	public int getSize() //method to get the size
	{
		return size;
	}
	
	public void clear() //method that clears the whole tree
	{
		overallRoot = null;
	}
	
	public int smallest() //method to get the smallest int in the tree
	{
		if (isEmpty()) //checks if tree is empty
		{
			throw new IllegalStateException();
		}
		IntTreeNode temp = overallRoot; //temp node of the overallRoot
		while (temp.left != null) //traverse to the farthest left node of tree bc thats the smallest one
		{
			temp = temp.left;
		}
		return temp.data;
	}

	public int largest() //method to get the smallest int in the tree
	{
		if (isEmpty()) //checks if tree is empty
		{
			throw new IllegalStateException();
		}
		IntTreeNode temp = overallRoot; //temp node of the overallRoot
		while (temp.right != null) //traverse to the farthest right node bc thats the largest one
		{
			temp = temp.right;
		}
		return temp.data;
		
	}
	
	public int countLeaves()
	{
		return countLeaves(overallRoot); //calls the recursive private method
	}
	
	private int countLeaves(IntTreeNode node)
	{
		if (node == null) //base case
		{
			return 0;
		}
		if (node.left == null && node.right == null) //checks to make sure it has no children
		{
			return 1; //increments count of leaves
		}
		return countLeaves(node.left) + countLeaves(node.right); //recursively traverses thru tree until reaches leaves while adding sum
	}
	
	public boolean isEmpty() //checks if tree is empty
	{
		return (size == 0);
	}
	
	public boolean add(int value) //add method that takes in int parameter
	{
		if (contains(value)) //checks for dupes
		{
			return false;
		}
		overallRoot = add(overallRoot, value); //calls the private add method to add the new node with corresponding value
		return true;
	}
	
	private IntTreeNode add(IntTreeNode node, int value) //private add method to use recursion
	{
		if (node == null) //reached designated spot
		{
			node = new IntTreeNode(value); //creates the new node with value
			size++; //increment size
			return node;
		}
		else if (node.data > value) //recursively traverse left bc value less than node's data
		{
			node.left = add(node.left, value); 
		}
		else if (node.data < value) //recursively traverse right bc value greater than node's data
		{
			node.right = add(node.right, value);
		}
		return node;
	}
	
	public boolean contains(int value) //method to check if a node with value is already in the tree
	{
		return contains(overallRoot, value); //calls private contains method in order to recursively traverse
	}
	
	private boolean contains(IntTreeNode node, int value) //use this method to recursively traverse thru tree
	{
		if (node == null) //check if it is a valid node
		{
			return false;
		}
		if (value == node.data) //checks if node is the same therefore pre-existing
		{
			return true;
		}
		else if (value < node.data) //recurs with the node to the left bc the value is less than current node's
		{
			return contains(node.left, value);
		}
		else //recurs with the node to the right bc the value is greater than current node's
		{
			return contains(node.right, value);
		}
	}
	
	private static IntTreeNode minNode(IntTreeNode root) //method to recursively traverse and find the smallest node from a certain point (starting node)
	{
		if (root == null) //checks if root is valid
		{
			return null;
		}
		IntTreeNode temp = root; //temp node for root
		while (temp.left != null) //traverse all the way to the left (smallest value node)
		{
			temp = temp.left;
		}
		return temp; //returns the smallest node
	}
	
	public boolean remove(int num) //method to remove a node with corresponding num
	{
		int initialSize = size; //keep track of the initial size
		remove(overallRoot, num); //calls the private remove method
		if (initialSize > size) //sees if the size decreased from the initial size
		{
			return true; //returns true bc the size decrease which means a node was removed
		}
		return false;
	}
	
	private IntTreeNode remove(IntTreeNode node, int value) //private remove method to recursively traverse
	{
		if (node == null) //checks if node is valid
		{
			return node;
		}
		else if (value < node.data) //recursively traverse left since the node is greater than target value
		{
			node.left = remove(node.left, value);
			return node;
		}
		else if (value > node.data) //recursively traverse right since the node is less than target value
		{
			node.right = remove(node.right, value);
			return node;
		}
		else //reached designated node to remove
		{
			if (node.left == null && node.right == null) //case: node is a leaf
			{
				node = null; //set the leaf to null 
				size--;
			}
			else if (node.left != null && node.right == null) //case: node with left child only
			{
				IntTreeNode successor = node.left; //replaced with left child
				node.left= null; //remove the left child since it is replacing the target node
				size--;
				return successor;
			}
			else if (node.left == null && node.right != null) //case: node with right child only
			{
				IntTreeNode successor = node.right; //replaced with right child
				node.right = null; //remove the right child since it is replacing the target node
				size--;
				return successor;
			}
			else //case: node has both children
			{
				IntTreeNode successor = minNode(node.right); //finds the successor (minNode of the right side)
				node.data = successor.data; //replace the target node with the successor
				node.right = remove(node.right, successor.data); //remove the successor node since it replaced the target node
				size--;
				return node;
			}
		}
		return node;
	}
	
	public String toString()
	{
		String returningStr = printInOrder(overallRoot); //calls the private method so that it can take in a root
		return returningStr;
	}
	
	private static String printInOrder(IntTreeNode root) //private method that takes in root to print in order
	{ 
		if (root == null) //base case
		{
			return "";
		}
		return printInOrder(root.left) + root.data + " " + printInOrder(root.right); //left, root, right
	}
}










