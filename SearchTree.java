//SearchTree.java
//Timothy Pham
//Purpose: Create a class for a generic search tree with supporting functions/methods 
import java.util.Collection;

public class SearchTree<E> implements Comparable<E>{
	
	public SearchTreeNode<E> overallRoot;
	int size = 0;
	
	public SearchTree() 
	{
		overallRoot = null;
	}
	
	public SearchTree(E value) 
	{
		overallRoot = new SearchTreeNode<E>(value, null, null); 
		size++;
	}
	
	public SearchTree(Collection<E> list) 
	{
		for (E i: list) 
		{
			add(i); 
		}
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public void clear() 
	{
		overallRoot = null;
		size = 0;
	}
	
	public E smallest() 
	{
		if (isEmpty()) 
		{
			throw new IllegalStateException();
		}
		SearchTreeNode<E> temp = overallRoot; 
		while (temp.left != null) 
		{
			temp = temp.left;
		}
		return temp.data;
	}

	public E largest() 
	{
		if (isEmpty()) 
		{
			throw new IllegalStateException();
		}
		SearchTreeNode<E> temp = overallRoot; 
		while (temp.right != null) 
		{
			temp = temp.right;
		}
		return temp.data;
		
	}
	
	public int countLeaves()
	{
		return countLeaves(overallRoot); 
	}
	
	private int countLeaves(SearchTreeNode<E> node)
	{
		if (node == null) 
		{
			return 0;
		}
		if (node.left == null && node.right == null) 
		{
			return 1; 
		}
		return countLeaves(node.left) + countLeaves(node.right); 
	}
	
	public boolean isEmpty() //checks if tree is empty
	{
		return (size == 0);
	}
	
	public boolean add(E value) 
	{
		if (contains(value)) 
		{
			return false;
		}
		overallRoot = add(overallRoot, value); 
		return true;
	}
	
	private SearchTreeNode<E> add(SearchTreeNode<E> node, E value) 
	{
		if (node == null) 
		{
			node = new SearchTreeNode<E>(value); 
			size++; 
		}
		int compare = ((Comparable<E>) value).compareTo(node.data);
		if (compare <= 0) 
		{
			node.left = add(node.left, value); 
		}
		else 
		{
			node.right = add(node.right, value);
		}
		return node;
	}
	
	public boolean contains(E value) 
	{
		return contains(overallRoot, value); 
	}
	
	private boolean contains(SearchTreeNode<E> node, E value) 
	{
		if (node == null)
		{
			return false;
		}
		else
		{
			int compare = ((Comparable<E>) value).compareTo(node.data);
			if (compare == 0)
			{
				return true;
			}
			else if (compare < 0)
			{
				return contains(node.left, value);
			}
			else
			{
				return contains(node.right, value);
			}
		}
	}
	
	private SearchTreeNode<E> minNode(SearchTreeNode<E> root) 
	{
		if (root == null) 
		{
			return null;
		}
		SearchTreeNode<E> temp = root; 
		while (temp.left != null) 
		{
			temp = temp.left;
		}
		return temp; 
	}
	
	public boolean remove(E num) 
	{
		int initialSize = size; 
		remove(overallRoot, num); 
		if (initialSize > size) 
		{
			return true; 
		}
		return false;
	}
	
	private SearchTreeNode<E> remove(SearchTreeNode<E> node, E value) 
	{
		if (node == null) 
		{
			return node;
		}
		int compare = ((Comparable<E>) value).compareTo(node.data);
		if (compare < 0) 
		{
			node.left = remove(node.left, value);
			return node;
		}
		else if (compare > 0) 
		{
			node.right = remove(node.right, value);
			return node;
		}
		else 
		{
			if (node.left == null && node.right == null) 
			{
				node = null;  
				size--;
			}
			else if (node.left != null && node.right == null) 
			{
				SearchTreeNode<E> successor = node.left; 
				node.left= null; 
				size--;
				return successor;
			}
			else if (node.left == null && node.right != null) 
			{
				SearchTreeNode<E> successor = node.right; 
				node.right = null; 
				size--;
				return successor;
			}
			else 
			{
				SearchTreeNode<E> successor = minNode(node.right);
				node.data = successor.data; 
				node.right = remove(node.right, successor.data); 
				size--;
				return node;
			}
		}
		return node;
	}
	
	public String toString()
	{
		String returningStr = printInOrder(overallRoot); 
		return returningStr;
	}
	
	private String printInOrder(SearchTreeNode<E> root) 
	{ 
		if (root == null) 
		{
			return "";
		}
		return printInOrder(root.left) + root.data + " " + printInOrder(root.right); //left, root, right
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}
}











