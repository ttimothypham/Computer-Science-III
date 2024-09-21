///////////////////////////////////////////////////////////////////////////
//
//         Write a Java program to determine that a given expression 
//          contains a set of correctly nested brackets of various 
//          kinds ( {,} [,] (,) ). That is, we want to check that:
//            - There are an equal number of right and left parentheses, 
//              curly brackets, and square brackets.
//            - Every right bracket is preceded by a corresponding 
//              left bracket.
//
//          Read a string expression using an input dialog interface.
//
//          For example, your program should print
//              true for [()]{}{[()()]()} and
//              false for [(]).
//
///////////////////////////////////////////////////////////////////////////
//
//          This checker must implement the following algorithm:
//
//          1. Make an empty stack.
//
//          2. Read symbols until the end of the source code file.
//                a.  If the symbol is an opening symbol,
//                      push it onto the stack.
//                b.  If it is a closing symbol, do the following:
//                    i.  If the stack is empty, report an error.
//                    ii. Otherwise, pop the stack.
//                          If the symbol popped is not the
//                          corresponding opening symbol,
//                          report an error.
//
//          3. At the end of the string, if the stack is not empty,
//             report an error.
//
///////////////////////////////////////////////////////////////////////////

/*

SAMPLE DATA
[()]{}{[()()]()} 
[(])
[]
((())

SAMPLE OUTPUT
GOOD
BAD
GOOD
BAD

*/
//Timothy Pham
//4th
import java.util.*;
public class Stack1
{
	public static void main(String[] args)
	{
		String ex1 = "[()]{}{[()()]()}";
		String ex2 = "[(])";
		String ex3 = "[]";
		String ex4 = "((())";
		System.out.println(checker(ex1));
		System.out.println(checker(ex2));
		System.out.println(checker(ex3));
		System.out.println(checker(ex4));
	}
	
	public static String checker(String s)
	{
		Stack<String> stack = new Stack<String>();
		boolean status = false;
		String[] closed = {")","]","}"};
		for(int i = 0; i < s.length(); i++)
		{
			String symbol = "";
			symbol = symbol + s.charAt(i);
			if (symbol.equals("(") || symbol.equals("[") || symbol.equals("{"))
			{
				stack.push(symbol);
			}
			else if (symbol.equals(")") || symbol.equals("]") || symbol.equals("}"))
			{
				if (stack.isEmpty())
				{
					throw new IllegalStateException("Stack is currently empty.");
				}
				if (symbol.equals(")"))
				{
					if (stack.pop().equals("("))
					{
						status = true;
					}
					else
					{
						status = false;
					}
				}
				if (symbol.equals("]"))
				{
					if (stack.pop().equals("["))
					{
						status = true;
					}
					else
					{
						status = false;
					}
				}
				if (symbol.equals("}"))
				{
					if (stack.pop().equals("{"))
					{
						status = true;
					}
					else
					{
						status = false;
					}
				}
			}
		}
		if (!stack.isEmpty())
		{
			status = false;
		}
		if (status)
		{
			return "GOOD";
		}
		return "BAD";
	}
}

