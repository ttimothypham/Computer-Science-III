//Timothy Pham
//Purpose: Create a functioning class for hashing using probing
import java.util.Vector;
import java.util.*;
public class ProbeHash<E> implements Hash<E>
{
    public Vector<E> hashTable; 
    public int size = 0; //size variable
    
    public ProbeHash() //default constructor
    {
    	hashTable = new Vector<E>(10); //sets the hashTable to be able to hold 10 elements
    	for (int i = 0; i < hashTable.capacity(); i++) //loops thru each index and fills with null
    	{
    		hashTable.add(null);
    	}
    }
    
    public ProbeHash(Collection<E> list) //constructor with collection
    {
    	hashTable = new Vector<E>(list.size()); //sets the hashTable to be able to hold num of elements in list
    	E[] arr = (E[]) list.toArray(); //convert the collection to array for convenience
    	for (int i = 0; i < arr.length; i++) //iterate thru array and add each element to the hash table
    	{
    		hashTable.add(arr[i]);
    	}
    	
    }
    
    public ProbeHash(int initialCapacity) //constructor with capacity parameter
    {
    	hashTable = new Vector<E>(initialCapacity); //sets the hashTable to be able to hold initialCapacity amoumt of elements
    	for (int i = 0; i < hashTable.capacity(); i++) //loops thru each index and fills with null
    	{
    		hashTable.add(null);
    	}
    }
    
    public void rehash()
    {
    	Vector<E> old = hashTable;
		hashTable.setSize(hashTable.capacity() * 2); //doubles the size of the hash table
		for (int i = 0; i < old.capacity(); i++)
		{
			hashTable.add(old.get(i));
		}
    }
    
    public int hashFunction(E value)
    {
    	return Math.abs(value.hashCode()) % hashTable.capacity(); //sets index using the hash formula;
    }

	public int length() //returns the length of the hash table
	{
		return hashTable.capacity();
	}

	public int size() //returns the num of elements in hash table
	{
		return size;
	}

	public boolean isEmpty() //checks if hash table is empty
	{
		return (size == 0);
	}

	public boolean add(E value)
	{
		int index = hashFunction(value); //gets the index using the hash function
		if (hashTable.contains(value)) //checks for dupes
		{
			return false;
		}
		else
		{
			double loadFactor = size / hashTable.capacity(); //determine the load factor
			if (loadFactor >= .75) //if load factor is greater than or .75 then rehash
			{
				rehash();
			}
			if (hashTable.get(index) == null) //best case: the index is empty so just add the new element
			{
				hashTable.set(index, value); //sets the index to contain value
				size++; //increment size
				return true;
			}
			else //index already contains a value
			{
				int i = index; //temp variable for index
				if (i + 1 != hashTable.capacity()) //wrapping is not necessary
				{
					while (i != hashTable.capacity())
					{
						if (hashTable.get(i + 1) == null) //checks is next available spot is empty
						{
							hashTable.set(i, value); //sets i to contain value
							size++; //increment size
							return true;
						}
						i++;
					}
				}
				else if (i + 1 == hashTable.capacity()) //check if wrapping around is necessary
				{
					for (i = 0; i != index; i++) //sets i to 0 and loop until it gets back to original index
					{
						if (hashTable.get(i) == null) //checks for next available spot
						{
							hashTable.set(i, value); //sets i to contain value
							size++; //increment size
							return true;
						}
					}
				}
				
			}
		}
		return false;
	}

	public boolean contains(E value)
	{
		int index = hashFunction(value); //gets the index using the hash function
		if (hashTable.get(index) == (value)) //best case the value is in the exact index first try!
		{
			return true;
		}
		else //value is probably probed in nearby index
		{
			int i = index; //temp variable for index
			if (i + 1 != hashTable.capacity()) //wrapping is not necessary
			{
				if (hashTable.get(i + 1) == value) //checks index if it contains value
				{
					return true;
				}
			}
			else if (i + 1 == hashTable.capacity()) //check if wrapping around is necessary 
			{
				for (i = 0; i != index; i++) //sets i to 0 and loop until it gets back to original index 
				{
					if (hashTable.get(i) == value) //checks index if it contains value
					{
						return true;
					}
				}
			}
		}
		return false; //hash table does not contain the value
	}

	public boolean remove(E value)
	{
		int index = hashFunction(value); //gets the index using the hash function
		if (!(hashTable.contains(value))) //if the hash table doesnt contain the element nothing needs to be removed lol
		{
			return true;
		}
		if (hashTable.get(index) == value) //best case: the index contains the value first try
		{
			hashTable.set(index, null); //sets the index to null
			size--; //decrements size
			return true;
		}
		else //index is probably probed in nearby index
		{
			int i = index; //temp variable for index
			if (i + 1 != hashTable.capacity()) //check if wrapping is necessary
			{
				while (i + 1 < hashTable.capacity()) //loop until wrapping may be necessary
				{
					if (hashTable.get(i + 1) == value) //checks if the index contains value
					{
						hashTable.set(i + 1, null); //sets index to null
						size--; //decremnts size
						return true;
					}
					i++;
				}
			}
			else if (i + 1 == hashTable.capacity()) //check if wrapping around is necessary
			{
				for (i = 0; i != index; i++) //sets i to 0 and iterate until it gets back to the original index
				{
					if (hashTable.get(i) == value) //checks if the index contains value
					{
						hashTable.set(i, null); //sets index to null
						size--; //decrements size
						return true;
					}
				}
			}
		}	
		return false; //no element was removed
	}
	
	public String toString()
	{
		String ret = ""; //variable of string to be returned
		for (int i = 0; i < hashTable.capacity(); i++) //iterate thru elements of hash table
		{
			if (hashTable.get(i) != null) //checks if element is not null
			{
				ret += " " + hashTable.get(i); //adds the element value to string
			}
		}
		return ret;
	}
}


