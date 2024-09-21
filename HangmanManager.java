//Timothy Pham
//Period 4
import java.util.*;

public class HangmanManager
{
	public int targetLength;
	public int maxGuesses;
	public TreeSet<String> validWords;
	public Map<String, TreeSet<String>> families;
	public Set<Character> listOfGuesses = new TreeSet<Character>();;
	public String pattern = "";
	
	public HangmanManager( List<String> dictionary, int length, int max )
	{
		validWords = new TreeSet<String>(); //create TreeSet for the words that are valid
		targetLength = length;
		maxGuesses = max;
		if (length < 1 || max < 0)
		{
			throw new IllegalArgumentException("Length is less than one, or Max is negative");
		}
		for (int i = 0; i < dictionary.size(); i++) //loop to iterate through dictionary
		{
			if (dictionary.get(i).length() == targetLength) //checks if the word from the dictionary is the valid length
			{
				validWords.add(dictionary.get(i)); //adds the word to the validWords set
			}
		}
		for (int x = 0; x < length; x++) //loop to create the pattern using the valid length
		{
			pattern = pattern + "-";
		}
		
	}
	
	public Set<String> words()
	{
		return validWords;
	}
	
	public int guessesLeft()
	{
		return maxGuesses;
	}
		
	public Set<Character> guesses()
	{
		return listOfGuesses;
	}
	
	public String pattern()
	{
		if (guesses() == null)
		{
			throw new IllegalStateException("No guesses have been made");
		}
		return pattern;
	}

	public int record(char guess)
	{
		int count = 0; //count variable to count occurrences of the guess in the word
		if (maxGuesses < 1 || validWords == null)
		{
			throw new IllegalStateException("No guesses left or the list of words is empty.");
		}

		if (listOfGuesses.contains(guess))
		{
			throw new IllegalArgumentException("You've already guessed that letter");
		}

		listOfGuesses.add(guess); //adds the guessed letter to set of guessed letters
		int maxFam = 0; //variable for whatever family has the most values

		families = new TreeMap<String, TreeSet<String>>(); //map for the families. Pattern is the key, set of words from pattern is the value
    
		for (String word : validWords) //loop to iterate thru set of valid words
		{
			String pat = pattern; 
			for (int i = 0; i < word.length(); i++) //loop to iterate thru the word from the valid words set
			{
				if (word.charAt(i) == guess) //if the letter in the word is the guess char
				{
					pat = pat.substring(0, i) + guess + pat.substring(i + 1); //update the pattern
				}
			}
		
			if (!families.containsKey(pat)) //checks if the pattern is already a key
			{
				families.put(pat, new TreeSet<>()); //creates a new set for this pattern because the key doesn't exist yet
			}
			families.get(pat).add(word); //add the word to the corresponding pattern set
			if (families.get(pat).size() > maxFam) //checks which pattern has the most values
			{
				maxFam = families.get(pat).size(); //sets the variable to the size of the pattern with the most values
			}
		}
		String finalPat = "";
		for (String key: families.keySet()) //iterate thru the keys of families map
		{
			if (families.get(key).size() == maxFam) //finds the key with the same size of values as maxFam
			{
				finalPat = key; //sets finalPat to the key
			}
		}
		pattern = finalPat; //sets the pattern to the corresponding key
		for (int index = 0; index < pattern.length(); index++) //loop to iterate thru each char of pattern
		{
			if (pattern.charAt(index) == guess) //checks if the char is the same as the guessed letter
			{
				count++; //increments count
			}
		}
		validWords = families.get(pattern); //updates validWords with the new set of words
		maxGuesses--; //decreases the amount of guesses left
    	return count;
		}
}



