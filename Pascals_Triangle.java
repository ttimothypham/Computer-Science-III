// Name of file: Pascals_Triangle.java
// Name: Timothy Pham
// Purpose: Create Pascal's Triangle through the form of a jagged matrix and print it out neatly.

import java.util.Arrays;

class Pascals_Triangle {
	public static void main(String[] args) 
	{
		int numOfRows = 10; // Change the amount of rows here to test
		System.out.println(printMethod(pascal(numOfRows)));
	}


	//Returns a jagged matrix that stores Pascal's Triangle
		//with the number of rows specified
	public static int[][] pascal(int rows)
	{
		int[][] jagged = new int[rows][]; // creates a new matrix that is jagged (only rows is instantiated)
		int count = 1; // this variable is set to 1 and will be used as a counter to set the amount of cols for each ascending row
		for (int i = 0; i < rows; i++) // for loop to iterate through each row of matrix
		{
			jagged[i] = new int[count]; // sets each ascending row with an ascending count so the matrix is jagged
			count++; // count goes up by 1 each loop
		}
		
		for (int r = 0; r < jagged.length; r++) // for loop to iterate through each row of the matrix
		{
			for (int c = 0; c < jagged[r].length; c++) // for loop to iterate through each col of the matrix
			{
				if (c == 0 || c == jagged[r].length - 1) // checks if the col index is the first or last of the row
				{
					jagged[r][c] = 1; // sets the current index (first or last) to 1
				}
				if(!(c == 0 || c == jagged[r].length - 1)) // checks if the col index is not the first or last of the row
				{
					jagged[r][c] = jagged[r-1][c-1] + jagged[r-1][c]; // sets the current index by doing addition of the target indexes of the previous row that follow the Pascal Triangle flow
				}
			}
		}
		return jagged;
  	}
	
	public static String printMethod(int[][] mat)
	{
		for (int r = 0; r < mat.length; r++) // for loop to iterate through each row of the matrix
		{
			for (int c = 0; c < mat[r].length; c++) // for loop to iterate through each col of the matrix
			{
				System.out.printf(" %d", mat[r][c]); // prints of the current index of the mat
			}
			System.out.println(); // starts a new line for each row
		}
		return "";	
	}
}
