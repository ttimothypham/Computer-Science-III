package src;
//Tomiwa Sodeinde and Timothy Pham
//Purpose: Create a 20 question game
import java.io.PrintStream;
import java.util.*;


public class QuestionsGame {
    // Your code here
	public QuestionNode root;

	public QuestionsGame(String object)
	{
		root = new QuestionNode(object);
		
	}
	
	public QuestionsGame(Scanner input)
	{
		input.nextLine();
		root = new QuestionNode(input.nextLine());
		createTree(input, root);
	}
	
	private void createTree(Scanner input, QuestionNode node)
	{
		while (input.hasNextLine())
		{
			String temp = input.nextLine();
			if (temp.equals("Q:"))
			{
				if (node.left == null)
				{
					node.left = new QuestionNode(input.nextLine());
					createTree(input, node.left);
				}
				if (node.right == null)
				{
					node.right = new QuestionNode(input.nextLine());
					createTree(input, node.right);
				}
			}
			if (temp.equals("A:"))
			{
				if (node.left == null)
				{
					node.left = new QuestionNode(input.nextLine());
					createTree(input, node);
				}
				else
				{
					node.right = new QuestionNode(input.nextLine());
					createTree(input, root);
				}
			}
		}
	}
	
	public void saveQuestions(PrintStream output) {
	    if (output == null) {
	        throw new IllegalArgumentException();
	    }
	    saveTree(root, output);
	}

	private void saveTree(QuestionNode node, PrintStream output) {
	    if (node != null) {
	        if (node.left != null || node.right != null) {
	            output.println("Q:");
	            output.println(node.data);
	            saveTree(node.left, output);
	            saveTree(node.right, output);
	        } else {
	            output.println("A:");
	            output.println(node.data);
	        }
	    }
	}

	public void play() {
	    QuestionNode temp = root;
	    QuestionNode parent = null; // Pointer to the parent of the current node
	    boolean isLeftChild = false; // Indicates whether the current node is the left child of its parent
	    Scanner keyboard = new Scanner(System.in);
	    String userInput;
	    boolean playing = true;

	    while (playing) {
	        if (temp.left != null && temp.right != null) {
	            System.out.println(temp.data);
	            userInput = keyboard.next();

	            if (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'Y') {
	                parent = temp;
	                isLeftChild = true;
	                temp = temp.left;
	            } else if (userInput.charAt(0) == 'n' || userInput.charAt(0) == 'N') {
	                parent = temp;
	                isLeftChild = false;
	                temp = temp.right;
	            }
	        }

	        if (temp.left == null && temp.right == null) {
	            System.out.println("I guess that your object is " + temp.data);
	            System.out.print("Am I right? (y/n)? ");
	            userInput = keyboard.next();

	            if (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'Y') {
	                System.out.println("Awesome! I win!");
	                playing = false;
	            } else {
	                System.out.print("Aw man, I lost... What was your object? ");
	                userInput = keyboard.next();
	                QuestionNode tempC = new QuestionNode(userInput);

	                System.out.println("Give me a question I can use to differentiate for next time");
	                userInput = keyboard.nextLine();
	                QuestionNode tempS = new QuestionNode(userInput);

	                System.out.println("Is the answer 'yes' for " + tempC.data + "? (y/n)");
	                userInput = keyboard.next();

	                if (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'Y') {
	                    tempS.right = temp;
	                    tempS.left = tempC;
	                } else {
	                    tempS.left = temp;
	                    tempS.right = tempC;
	                }

	                if (parent != null) {
	                    // Update the parent's reference to the new question or answer
	                    if (isLeftChild) {
	                        parent.left = tempS;
	                    } else {
	                        parent.right = tempS;
	                    }
	                } else {
	                    // If there is no parent, update the root
	                    root = tempS;
	                }

	                playing = false;
	            }
	        }
	    }
	}
    public class QuestionNode {
        // Your code here
    	
    	public final String data;
    	public QuestionNode left;
    	public QuestionNode right;
    	
    	public QuestionNode(String data)
    	{
    		this.data = data;
    		left = null;
    		right = null;
    	}
    	
    	public QuestionNode(String data, QuestionNode left, QuestionNode right)
    	{
    		this.data = data;
    		this.left = left;
    		this.right = right;
    	}
    	
    	
    }
   
}
