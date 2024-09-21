
import java.util.Collection;
import java.util.Vector;

public class ChainingHash <E> implements Hash<E>
{
	public Vector<HashNode<E>> hashTable;
    int size = 0;
    
    public ChainingHash() //default constructor
    {
    	hashTable = new Vector<HashNode<E>>(10); //sets the hashTable to be able to hold 10 elements
    	for (int i = 0; i < hashTable.capacity(); i++) //loops thru each index and fills with null
    	{
    		hashTable.add(null);
    	}
    }
    
    public ChainingHash(int initialCapacity) //constructor with capacity parameter
    {
    	hashTable = new Vector<HashNode<E>>(initialCapacity); //sets the hashTable to be able to hold initialCapacity amoumt of elements
    	for (int i = 0; i < hashTable.capacity(); i++) //loops thru each index and fills with null
    	{
    		hashTable.add(null);
    	}
    }

	public int length()
	{
		return hashTable.capacity();
	}

	public int size()
	{
		return size;
	}
	
	public int hashFunction(E value)
    {
    	return Math.abs(value.hashCode()) % hashTable.capacity(); //sets index using the hash formula;
    }
	
	public void rehash()
	{
		Vector<HashNode<E>> old = hashTable;
		hashTable.setSize(hashTable.capacity() * 2); //doubles the size of the hash table
		for (int i = 0; i < old.capacity(); i++) //hashes all the old elements
		{
			hashTable.add(old.get(i));
		}
	}

	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	public boolean checkChainLength(int index) //helper method to count chain length and return boolean if rehash needed
	{
		int count = 0;
		HashNode<E> temp = hashTable.get(index); //temp variable to traverse
		while (temp != null)
		{
			count++; //increment count as long as temp not null
			temp = temp.next;
		}
		if (count > 2) //checks count if greater than 2
		{
			return true; //return true bc rehash necessary
		}
		return false; //rehash not necessary
	}

	public boolean add(E value)
	{
		int index = hashFunction(value); //calls hashfunction to get index
		if (contains(value)) //checks if table already contains
		{
			return false;
		}
		if (checkChainLength(index)) //checks if rehash necessary
		{
			rehash();
		}
		else
		{
			if (hashTable.get(index) == null) //best case, index is null 
			{
				hashTable.set(index, new HashNode(value, null)); //adds node in index position
				size++;
				return true;
			}
			else if (hashTable.get(index) != null) //collision occured, need to chain
			{
				HashNode<E> temp = hashTable.get(index); //temp  variable for node in index
				HashNode<E> newNode = new HashNode(value, null);
				while (temp.next != null) //traverse til next empty spot
				{
					temp = temp.next;
				}
				newNode.next = temp; //points the next of the new node to the node already in index
				hashTable.set(index, newNode); //sets new node as head of chain and chains preexisting
				size++;
				return true;
			}
		}
		return false;
	}

	public boolean contains(E value)
	{
		int index = hashFunction(value); //use hash function to get index
		if (hashTable.get(index) == null) //checks index if its empty
		{
			return false;
		}
		if (hashTable.get(index).value == value) //best case, node in the index
		{
			return true;
		}
		else //node is chained 
		{
			HashNode temp = hashTable.get(index); //temp node of index
			while (temp != null) //traverse til node matches specified value
			{
				if (temp.value == value) //checks if value matches
				{
					return true;
				}
				temp = temp.next; //else points to next
			}
		}
		return false;
	}

	public boolean remove(E value)
	{
		int index = hashFunction(value); //calls hash function to get index
		if (hashTable.get(index).value == value) //best case node in index
		{
			hashTable.set(index, null); //set to null
			size--;
			return true;
		}
		else //node is chained
		{
			HashNode temp = hashTable.get(index); //temp node to traverse
			while (temp != null) //traverse until node matches value
			{
				if (temp.value == value)
				{
					hashTable.set(index, null); //sets node to null
					size--;
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}
	
	public String toString()
	{
		String ret = ""; //variable of string to be returned
		for (int i = 0; i < hashTable.capacity(); i++) //iterate thru elements of hash table
		{
			HashNode<E> current = hashTable.get(i); //temp node of current node
			while (current != null) //traverse thru chain 
			{
				ret += current.value + " "; //adds node to return string
				current = current.next; //points to next
			}
		}
		return ret;
	}
    
  
}



