import java.awt.image.BufferedImage;
import java.util.Arrays;
public class BufferedImageStack {

	public BufferedImage[] array; //This array is used to hold the elements of the buffered image stack
	public int i = 0; //index to keep track of how many elements in array
	public BufferedImageStack()
	{
		array = new BufferedImage[2]; //array is given the size of 2 
	}
	
	public void push(BufferedImage someBufferedImage)//T
	{
		if (i == array.length) //checks if num of elements equals the array size
		{
			BufferedImage[] newArray = new BufferedImage[array.length * 2]; //doubles the size of old array
			for (int idx = 0; idx < array.length; idx++) //iterate thru array
			{
				newArray[idx] = array[idx]; //old elements copied to new array
			}
		    array = newArray; //make public array the newArray
		}
		array[i] = someBufferedImage; //sets the BufferedImage at the top of the stack
		i++; //increments i
	}
	
	public BufferedImage pop()//K
	{
		int arrayPositions = array.length; //variable for size
		BufferedImage returnedImage = array[i - 1]; //Takes the last image added into array	
		array[i - 1] = null; //this "pops" the top element of the stack
		i--; //decrement i because an element was popped
		return returnedImage;
	}
	
	public boolean isEmpty() //T
	{
		if (i == 0) //checks if there is no elements in array
		{
			return true;
		}
		return false;
	}
	
	public BufferedImage get(int index)//K
	{
		if(index>array.length-1) //checks if input index is out of bounds
		{
			throw new IndexOutOfBoundsException("Index out of bounds. Could not retrieve.");
		}
		else 
		{
			return array[index]; //returns the element at the input index
		}
	}
	
	public int getSize()//T
	{
		return i; //check line 6
	}
	

	public int getArraySize()//K
	{
		return array.length; //returns the size of the array
	}


}
