//Timothy Pham
//Period 4
import java.util.*;
import java.util.Scanner;
public class findDups {
	
	public static void main (String[] args) {

		HashSet <String> hashSet = new HashSet<>(); //creating a HashSet
		findDups(hashSet); //calls the findDups method
	
	}
	
	public static void findDups(HashSet<String> words) //findDups method takes HashSet as parameter to use
	{
		Scanner scanner = new Scanner(System.in); //create scanner for user input
		System.out.print("Enter a word: "); 
		String inputWord = scanner.next(); //takes user input and assigns it to inputWord
		if (inputWord.equals("exit")) //checks if the inputWord is exit and then pursues the procedures for exit
		{
			System.out.println();
			System.out.println("Size: " + words.size());
			System.out.println(words);
		}
		else if (words.add(inputWord) == false) //checks if the inputWord is a duplicate then pursueRs the procedures for duplicate
		{
			System.out.println("Duplicate detected: " + inputWord);
			findDups(words);
		}
		else if (!(inputWord.equals("exit"))) //recalls the method again if the inputWord is not exit nor a duplicate
		{
			words.add(inputWord);
			findDups(words);
		}
			
}
}	


